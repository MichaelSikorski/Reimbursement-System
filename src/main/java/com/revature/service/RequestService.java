package com.revature.service;

import java.util.List;

import com.revature.dao.RequestDAOImplement;
import com.revature.model.Request;

public class RequestService {

	private static RequestService requestService;

	private RequestService() {
	}
	
	public static RequestService getRequestService() {
		System.out.println("An instance of the RequestService class has been requested");
		if (requestService == null) {
			requestService = new RequestService();
		}
		return requestService;
	}
	
	public boolean submitRequest(String requester, double amount, String purpose) {
		System.out.println("The RequestService method submitRequest has been requested");
		return RequestDAOImplement.getInstance().createNewRequest(requester, amount, purpose);
	}
	
	public List<Request> getAllResolvedRequests() {
		System.out.println("The RequestService method getAllResolvedRequests has been requested");
		return RequestDAOImplement.getInstance().getAllResolvedRequests();
	}
	
	public List<Request> getAllPendingRequests() {
		System.out.println("The RequestService method getAllPendingRequests has been requested");
		return RequestDAOImplement.getInstance().getAllPendingRequests();
	}
	
	public List<Request> getEmployeesPendingRequests(String email) {
		System.out.println("The RequestService method getEmployeesPendingRequests has been requested");
		return RequestDAOImplement.getInstance().getEmployeesPendingRequests(email);
	}
	
	public List<Request> getEmployeesResolvedRequests(String email) {
		System.out.println("The RequestService method getEmployeesResolvedRequests has been requested");
		return RequestDAOImplement.getInstance().getEmployeesResolvedRequests(email);
	}
	
}
