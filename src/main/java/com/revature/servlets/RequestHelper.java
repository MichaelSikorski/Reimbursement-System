package com.revature.servlets;

import javax.servlet.http.*;
import com.revature.service.*;

public class RequestHelper {

	public static Object process(HttpServletRequest req, HttpServletResponse res) {
		String uri = req.getRequestURI();
		switch (uri) {
		case "/Project_1/loginEmployee.msp1":
			return new LoginEmployeeService().userOnDb(req.getParameter("email"), req.getParameter("password"));
		case "/Project_1/loginManager.msp1":
			return new LoginManagerService().userOnDb(req.getParameter("email"), req.getParameter("password"));
		case "/Project_1/getAllEmployees.msp1":
			return EmployeeService.getEmployeeService().getAllEmployees();
		case "/Project_1/viewAllResolved.msp1":
			return RequestService.getRequestService().getAllResolvedRequests();
		case "/Project_1/viewAllPending.msp1":
			return RequestService.getRequestService().getAllPendingRequests();
		case "/Project_1/submitRequest.msp1":
			return RequestService.getRequestService().submitRequest(req.getParameter("requester"),
					Integer.parseInt(req.getParameter("amount")),req.getParameter("purpose"));
		case "/Project_1/employeeViewPending.msp1":
			return RequestService.getRequestService().getEmployeesPendingRequests(req.getParameter("email"));
		case "/Project_1/employeeViewPast.msp1":
			return RequestService.getRequestService().getEmployeesResolvedRequests(req.getParameter("email"));
		case "/Project_1/employeeViewInfo.msp1":
			return EmployeeService.getEmployeeService().getEmployee(req.getParameter("email"));
		case "/Project_1/employeeUpdateInfo.msp1":
			String email = req.getParameter("email");
			String newUsername = req.getParameter("newUsername");
			String newFirst = req.getParameter("newFirst");
			String newLast = req.getParameter("newLast");
			return EmployeeService.getEmployeeService().updateEmployee(email, newUsername, newFirst, newLast);
		default:
			return null;
		}
	}

}
