package com.revature.servlets;

import java.io.IOException;
import javax.servlet.http.*;
import com.revature.service.*;

public class RequestHelper {

	public static Object process(HttpServletRequest req, HttpServletResponse res) {
		String uri = req.getRequestURI();
		switch (uri) {
		case "/Reimbursement-System/loginEmployee.msp1":
			System.out.println("Request helper received a request to login an employee");
			return new LoginEmployeeService().userOnDb(req.getParameter("email"), req.getParameter("password"));
		case "/Reimbursement-System/loginManager.msp1":
			System.out.println("Request helper received a request to login a manager");
			return new LoginManagerService().userOnDb(req.getParameter("email"), req.getParameter("password"));
		case "/Reimbursement-System/getAllEmployees.msp1":
			System.out.println("Request helper received a request to get all employees");
			return EmployeeService.getEmployeeService().getAllEmployees();
		case "/Reimbursement-System/viewAllResolved.msp1":
			System.out.println("Request helper received a request to view all resolved requests");
			return RequestService.getRequestService().getAllResolvedRequests();
		case "/Reimbursement-System/viewAllPending.msp1":
			System.out.println("Request helper received a request to view all pending requests");
			return RequestService.getRequestService().getAllPendingRequests();
		case "/Reimbursement-System/submitRequest.msp1":
			System.out.println("Request helper received a request to submit a request");
			return RequestService.getRequestService().submitRequest(req.getParameter("requester"),
					Integer.parseInt(req.getParameter("amount")),req.getParameter("purpose"));
		case "/Reimbursement-System/employeeViewPending.msp1":
			System.out.println("Request helper received a request to view a specific employee's pending requests");
			return RequestService.getRequestService().getEmployeesPendingRequests(req.getParameter("email"));
		case "/Reimbursement-System/employeeViewPast.msp1":
			System.out.println("Request helper received a request to view a specific employee's past requests");
			return RequestService.getRequestService().getEmployeesResolvedRequests(req.getParameter("email"));
		case "/Reimbursement-System/employeeViewInfo.msp1":
			System.out.println("Request helper received a request to view a specific employee's information");
			return EmployeeService.getEmployeeService().getEmployee(req.getParameter("email"));
		case "/Reimbursement-System/employeeUpdateInfo.msp1":
			System.out.println("Request helper received a request to update an employee's information");
			String email = req.getParameter("email");
			String newUsername = req.getParameter("newUsername");
			String newFirst = req.getParameter("newFirst");
			String newLast = req.getParameter("newLast");
			return EmployeeService.getEmployeeService().updateEmployee(email, newUsername, newFirst, newLast);
		default:
			System.out.println("Request helper received a request that it can't handle");
			try {
				res.getWriter().write("Something is wrong!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

}
