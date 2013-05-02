package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import admin.view.AdminView;

import login.model.LoginModel;
import login.view.LoginView;
import model.MainModel;
import model.Role;
import model.Employee;

public class MainView extends JFrame {

	private final String LOGIN = "LOGIN";
	private final String LOGOUT = "LOGOUT";
	private final String ORDER= "ORDER";
	private final String ADMIN = "ADMIN";
	private final String SMPS = "SMPS";
	private static MainView instance = null;

	static {
		if (instance == null) {
			instance = new MainView();
		}
	}

	public JPanel mainPanel;
	public JLabel mainLogoL;
	public JButton mainLoginB;
	public JButton mainLogoutB;
	public JButton mainOrderB;
	public JButton mainAdminB;
	public JButton mainSmpsB;
	private ButtonActionListener buttonListener;

	static Employee userEmp;

	private MainView() {
		buttonListener = new ButtonActionListener();
		initComponent();
	}

	private void initComponent() {
		mainPanel = new JPanel();
		mainLogoL = new JLabel("Welcome                         ");

		mainLoginB = new JButton(LOGIN);
		mainLoginB.setMnemonic(KeyEvent.VK_L);
		mainLoginB.setActionCommand(LOGIN);
		mainLoginB.addActionListener(buttonListener);

		mainLogoutB = new JButton(LOGOUT);
		mainLogoutB.setMnemonic(KeyEvent.VK_T);
		mainLogoutB.setActionCommand(LOGOUT);
		mainLogoutB.addActionListener(buttonListener);
		mainLogoutB.setVisible(false);

		mainOrderB = new JButton(ORDER);
		mainOrderB.setMnemonic(KeyEvent.VK_O);
		mainOrderB.setActionCommand(ORDER);
		mainOrderB.addActionListener(buttonListener);
		mainOrderB.setEnabled(false);

		mainAdminB = new JButton(ADMIN);
		mainAdminB.setMnemonic(KeyEvent.VK_A);
		mainAdminB.setActionCommand(ADMIN);
		mainAdminB.addActionListener(buttonListener);
		mainAdminB.setEnabled(false);

		mainSmpsB = new JButton(SMPS);
		mainSmpsB.setMnemonic(KeyEvent.VK_S);
		mainSmpsB.setActionCommand(SMPS);
		mainSmpsB.addActionListener(buttonListener);
		mainSmpsB.setEnabled(false);

		mainPanel.add(mainLogoL);
		mainPanel.add(mainLoginB);
		mainPanel.add(mainLogoutB);
		mainPanel.add(mainOrderB);
		mainPanel.add(mainAdminB);
		mainPanel.add(mainSmpsB);
		// mainPanel.setSize(600, 200);
		mainPanel.setOpaque(true);

		this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setSize(600, 150);

	}
	
	public static void start() {
		instance.showView();
	}
	
	private void showView() {
		this.pack();
		this.setVisible(true);
	}

	public static void update() {
		instance.updateView();
	}

	public void updateView() {
		userEmp = MainModel.getUser();
		if (userEmp != null) {
			mainLoginB.setVisible(false);// login not visible
			mainLogoutB.setVisible(true);// logout visible
			mainOrderB.setEnabled(true);
			mainSmpsB.setEnabled(true);
			mainLogoL.setText("Welcome " + userEmp.getName());
			// if employee classification = 1, normal user
			if (userEmp.getClassification() == Role.ADMIN) 
				mainAdminB.setEnabled(true);
		}else{
			mainLoginB.setVisible(true);// login visible
			mainLogoutB.setVisible(false);// logout not visible
			mainOrderB.setEnabled(false);
			mainSmpsB.setEnabled(false);
			mainLogoL.setText("Welcome               ");
			mainAdminB.setEnabled(false);
		}
		
	}
	
	class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case LOGIN:
				System.out.println("LOGIN");
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
				break;
			case LOGOUT:
				System.out.println("LOGOUT");
				MainModel.setUser(null);
				MainView.update();
				break;
			case ORDER:
				System.out.println("ORDER");
				
				break;
			case ADMIN:
				System.out.println("ADMIN");
				AdminView adminView = new AdminView();
				adminView.setVisible(true);
				break;
			case SMPS:
				System.out.println("SMPS");
				
				break;
			default:
				System.out.println("mainView, default");
				break;
			}
			
		}
		
	}
}
