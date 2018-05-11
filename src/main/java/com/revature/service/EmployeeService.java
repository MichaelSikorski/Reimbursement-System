package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDAOImplement;
import com.revature.model.*;

public class EmployeeService {

	private static EmployeeService employeeService;

	private EmployeeService() {
	}

	public static EmployeeService getEmployeeService() {
		System.out.println("An instance of the EmployeeService class has been requested");
		if (employeeService == null) {
			employeeService = new EmployeeService();
		}
		return employeeService;
	}
	
	public Employee getEmployee(String email) {
		System.out.println("EmployeeService method getEmployee has been requested");
		return EmployeeDAOImplement.getInstance().getEmployee(email);
	}
	
	public List<Employee> getAllEmployees() {
		System.out.println("EmployeeService method getAllEmployees has been requested");
		return EmployeeDAOImplement.getInstance().getAllEmployees();
	}
	
	public boolean updateEmployee(String email, String newUsername, String newFirst, String newLast) {
		System.out.println("EmployeeService method updateEmployee has been requested");
		return EmployeeDAOImplement.getInstance().updateEmployee(email, newUsername, newFirst, newLast);
	}
	/*
	public void requestReimbursement(String requester, double amount) {
		EmployeeDAOImplement.getInstance().requestReimbursement(requester, amount);
	}

	public List<Request> viewPending(Employee e) {
		return EmployeeDAOImplement.getInstance().viewPending(e);
	}

	public List<Request> viewResolved(Employee e) {
		return EmployeeDAOImplement.getInstance().viewResolved(e);
	}

	public List<String> viewInfo(Employee e) {
		return EmployeeDAOImplement.getInstance().viewInfo(e);
	}

	public void updateInfo(String email, String username, String first, String last) {
		EmployeeDAOImplement.getInstance().updateInfo(email, username, first, last);
	}*/

}
