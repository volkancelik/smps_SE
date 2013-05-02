package admin.users.model;

import java.util.ArrayList;

import dao.EmployeeDAO;

import model.MainModel;
import model.Role;
import model.Employee;

public class AdminUsersModel {

	EmployeeDAO dao;
	
	public AdminUsersModel() {
		dao = new EmployeeDAO();
	}
	
	public ArrayList<Employee> getUserList() {
		ArrayList<Employee> users = null;
		Employee user = MainModel.getUser();
		
		if(user.getClassification() == Role.ADMIN) {
			users = dao.getUsers();
		} else {
			users = new ArrayList<>();
		}
		return users;
	}
}
