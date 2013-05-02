package admin.employee.view;

import dao.EmployeeDAO;

public class EmployeeModel {
	EmployeeDAO employeeDao;
	
	//constructor
	public EmployeeModel(){
		this.employeeDao = new EmployeeDAO();
	}
}
