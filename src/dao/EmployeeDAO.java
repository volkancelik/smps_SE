package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Employee;

public class EmployeeDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	// constructor
	public EmployeeDAO() {
		conn = DatabaseConnect.ConnectDb();
	}

	public Employee getUser(String userName, String password) {
		// Open Connection; Convert row to domain object; return user object;
		// return new Employee
		Employee result = null;
		String sql = "select * from Employee where Username=? and Password=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, password);

			rs = pst.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null,
						"Username and Password is correct");
				result = new Employee(rs.getInt("SSN"), rs.getString("Name"),
						rs.getInt("Age"), rs.getString("Gender"),
						rs.getInt("Classification"));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "LoginDao fault!!");
			return result;
		}
		return result;

	}

	public ArrayList<Employee> getUsers() {
		// Open Connection

		// GET User rows
		// convert rows to domain objects
		// Return users object list
		return null;
	}

	public ResultSet getEmployeeResultSet() {
		ResultSet rs = null;
		String sql = "select * from Employee";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			// table_employee.setModel(DbUtils.resultSetToTableModel(rs));
			return rs;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "EmployeeDao empty resultset");
		}
		return rs;
	}
	
	

}
