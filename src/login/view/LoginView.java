package login.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.MainView;

import login.model.LoginModel;

public class LoginView extends JFrame {
	private static final long serialVersionUID = -5851110750028564479L;
    private final String LOGIN = "Login";
    private final String CANCEL = "Cancel";
    
	private JTextField userNameTF = null;
    private JTextField passwordTF = null;
	private ButtonActionListener buttonActionListener;
	
	private LoginModel loginModel;
    
    public LoginView() {
        buttonActionListener = new ButtonActionListener();
        this.loginModel = new LoginModel();
    	initComponent();
    }

    private void initComponent() {
        JPanel loginPanel = new JPanel();
        
        JLabel label = new JLabel("User Name :");
        loginPanel.add(label);
        userNameTF = new JTextField(10);
        loginPanel.add(userNameTF);
        
        label = new JLabel("Password :");
        loginPanel.add(label);
        passwordTF = new JTextField(10);       
        loginPanel.add(passwordTF);
        

        JButton btn = new JButton(LOGIN);
        btn.setActionCommand(LOGIN);
        btn.addActionListener(buttonActionListener);
        loginPanel.add(btn);
        
        btn = new JButton(CANCEL);
        btn.setActionCommand(CANCEL);
        btn.addActionListener(buttonActionListener);
        loginPanel.add(btn);

        
        loginPanel.setLayout(new GridLayout(3, 2));
        this.add(loginPanel);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(400, 120);
        this.setLocationRelativeTo(null);//set frame location to center on screen
        this.setVisible(true);       
    }
    
    void closeView() {
    	this.setVisible(false);
		this.dispose();
		
		MainView.update();
	}
    
    class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case LOGIN:
				String username = userNameTF.getText();
				String password = passwordTF.getText();
				
				if(loginModel.authenticateUser(username, password)) {
					closeView();
				} else {
					JOptionPane.showMessageDialog(null, "Wrong username and password!");
				}
				
				break;
				
			case CANCEL:
				
				break;

			default:
				break;
			}
		}
    	
    }
}
