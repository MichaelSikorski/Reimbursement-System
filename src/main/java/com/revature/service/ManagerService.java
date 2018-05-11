package com.revature.service;

import java.util.List;

import com.revature.dao.*;
import com.revature.model.*;

public class ManagerService {

	private static ManagerService managerService;

	private ManagerService() {
	}
	
	public static ManagerService getManagerService() {
		System.out.println("An instance of the ManagerService class has been requested");
		if (managerService == null) {
			managerService = new ManagerService();
		}
		return managerService;
	}
	
	/*public Request getRequest(int requestID) {
		return ManagerDAOImplement.getInstance().getRequest(requestID);
	}

	public Request getRequest(String email, double amount) {
		return ManagerDAOImplement.getInstance().getRequest(email,amount);
	}
	
	

	public void approveDenyRequest(int requestID, String status) {
		ManagerDAOImplement.getInstance().approveDenyRequest(requestID, status);
	}

	public List<Request> viewPendingAll() {
		return ManagerDAOImplement.getInstance().viewPendingAll();
	}

	public List<Request> viewPendingSingle(Employee e) {
		return ManagerDAOImplement.getInstance().viewPendingSingle(e);
	}

	public List<Request> viewResolved() {
		return ManagerDAOImplement.getInstance().viewResolved();
	}

	public List<Employee> viewAllEmployees() {
		return ManagerDAOImplement.getInstance().viewAllEmployees();
	}

	public List<Request> viewSingleEmployeesRequests(Employee e) {
		return ManagerDAOImplement.getInstance().viewSingleEmployeesRequests(e);
	}*/
}
