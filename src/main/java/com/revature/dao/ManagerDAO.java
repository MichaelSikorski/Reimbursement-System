package com.revature.dao;

import java.util.List;
import com.revature.model.*;

/**
 * The ManagerDAO interface defines the standard operations that will be
 * performed on the Manager model object
 */
public interface ManagerDAO {

	//Request getRequest(String email, double amount);
	//Request getRequest(int requestID);
	//void approveDenyRequest(int requestID, String status);
	//List<Request> viewPendingAll();
	//List<Request> viewPendingSingle(Employee e);
	//List<Request> viewResolved();
	//List<Employee> viewAllEmployees();
	//List<Request> viewSingleEmployeesRequests(Employee e);
	
	boolean createNewManager(String email, String username, String password, String first, String last);
	Manager getManager(String email);

	/*-A Manager can login
	-A Manager can view the Manager Homepage
	-A Manager can logout
	-A Manager can approve/deny pending reimbursement requests
	-A Manager can view all pending requests from all employees
	-A Manager can view images of the receipts from reimbursement requests (hard /do last) (optional?)
	-A Manager can view all resolved requests from all employees and see which manager resolved it
	-A Manager can view all Employees
	-A Manager can view reimbursement requests from a single Employee*/

}
