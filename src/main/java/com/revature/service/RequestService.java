package com.revature.service;

import java.util.List;

import com.revature.dao.RequestDAOImplement;
import com.revature.model.Request;

public class RequestService {

	private static RequestService requestService;

	private RequestService() {
	}
	
	public static RequestService getRequestService() {
		if (requestService == null) {
			requestService = new RequestService();
		}
		return requestService;
	}
	
	public boolean submitRequest(String requester, double amount, String purpose) {
		return RequestDAOImplement.getInstance().createNewRequest(requester, amount, purpose);
	}
	
	public List<Request> getAllResolvedRequests() {
		return RequestDAOImplement.getInstance().getAllResolvedRequests();
	}
	
	public List<Request> getAllPendingRequests() {
		return RequestDAOImplement.getInstance().getAllPendingRequests();
	}
	
	public List<Request> getEmployeesPendingRequests(String email) {
		return RequestDAOImplement.getInstance().getEmployeesPendingRequests(email);
	}
	
	public List<Request> getEmployeesResolvedRequests(String email) {
		return RequestDAOImplement.getInstance().getEmployeesResolvedRequests(email);
	}
	
}
