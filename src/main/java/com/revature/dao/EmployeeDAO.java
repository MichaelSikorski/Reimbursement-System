package com.revature.dao;

import java.util.List;

import com.revature.model.*;

/**
 * The EmployeeDAO interface defines the standard operations that will be
 * performed on the Employee model object
 */
public interface EmployeeDAO {
	
	/*Employee getEmployee(String email);
	void requestReimbursement(String requester, double amount);
	List<Request> viewPending(Employee e);
	List<Request> viewResolved(Employee e);
	List<String> viewInfo(Employee e);
	void updateInfo(String email, String username, String first, String last);*/

	boolean createNewEmployee(String email, String username, String password, String first, String last);
	Employee getEmployee(String email);
	List<Employee> getAllEmployees();
	boolean updateEmployee(String email, String newUsername, String newFirst, String newLast);
	
	/*-An Employee can login
	-An Employee can view the Employee Homepage
	-An Employee can logout
	-An Employee can submit a reimbursement request
	-An Employee can upload an image of his/her receipt as part of the reimbursement request (hard / do last) (optional?)
	-An Employee can view their pending reimbursement requests
	-An Employee can view their resolved reimbursement requests
	-An Employee can view their information
	-An Employee can update their information
	-An Employee receives an email when one of their reimbursement requests is resolved (optional)*/
}
