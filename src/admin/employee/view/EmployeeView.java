package admin.employee.view;

import java.awt.GridLayout;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class EmployeeView extends JPanel {
	private JTable tableEmployee = null;
	private EmployeeModel employeeModel;

	public EmployeeView() {
		employeeModel = new EmployeeModel();
		initConponents();
		update();
	}
	
	public void update(){
		updateView();
	}

	private void updateView() {
		ResultSet rs = null;
		rs = employeeModel.employeeDao.getEmployeeResultSet();
		if(rs != null){
			tableEmployee.setModel(DbUtils.resultSetToTableModel(rs));
		}else { JOptionPane.showMessageDialog(null, "EmployeeView rs fault"); }		
	}

	private void initConponents() {
		JPanel buttonPanel = new JPanel();
		add(buttonPanel);
		JButton btnNewButton = new JButton("New button");
		buttonPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		buttonPanel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		buttonPanel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		buttonPanel.add(btnNewButton_3);
		buttonPanel.setLayout(new GridLayout(4, 1));
		
		JPanel tablePanel = new JPanel();
		add(tablePanel);
		JScrollPane scrollPane = new JScrollPane();
		tablePanel.add(scrollPane);
		tableEmployee = new JTable();
		tablePanel.add(tableEmployee);
		/*
		tableEmployee.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
								 { null, null, null, null }, 
								 { null, null, null, null },
								 { null, null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));*/
		
	}

}
