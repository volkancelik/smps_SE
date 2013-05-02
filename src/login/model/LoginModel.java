package login.model;

import java.util.ArrayList;

import model.MainModel;
import model.Employee;
import dao.EmployeeDAO;

public class LoginModel {

	EmployeeDAO employeeDao;
	
	
	public LoginModel() {
		this.employeeDao = new EmployeeDAO();
	}
	
	public boolean authenticateUser(String username, String password) {
		boolean result;
		// check params: empty?
		Employee myUser = employeeDao.getUser(username, password);
		if(myUser != null) {
			MainModel.setUser(myUser);
			result = true;
		} else {
			MainModel.setUser(null);
			result = false;
		}
		
		return result;
	}

}
