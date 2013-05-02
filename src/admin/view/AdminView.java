package admin.view;

import javax.swing.JFrame;

import admin.employee.view.EmployeeView;

public class AdminView extends JFrame {

	/**
	 * Create the panel.
	 */
	public AdminView() {
		initComponents();
	}
	
	private void initComponents(){
		EmployeeView employeePanel = new EmployeeView(); 
		add(employeePanel);
		setSize(450, 600); 
		setLocationRelativeTo(null);//set frame location to center on screen
	}

}
