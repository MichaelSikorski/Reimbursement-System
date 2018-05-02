package com.revature.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.ManagerDAOImplement;
import com.revature.model.*;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;

public class ManagerTest {

	/*-A Manager can login
	-A Manager can view the Manager Homepage
	-A Manager can logout
	-A Manager can approve/deny pending reimbursement requests
	-A Manager can view all pending requests from all employees
	-A Manager can view images of the receipts from reimbursement requests (hard /do last) (optional?)
	-A Manager can view all resolved requests from all employees and see which manager resolved it
	-A Manager can view all Employees
	-A Manager can view reimbursement requests from a single Employee*/

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// Request r = get a test request from database
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	@Test
	public void testGetRequest() {
		Request test = ManagerService.getManagerService().getRequest(19);
		Assert.assertEquals("test requester", test.getRequester());
		Assert.assertEquals(70, test.getRequestAmount(), 0);
		Assert.assertEquals("testing getRequest", test.getPurpose());
	}

	@Test
	public void validateRequestInformation() {
		Request test = ManagerService.getManagerService().getRequest(19);
		Assert.assertEquals(19, test.getRequestID());
		Assert.assertEquals(70, test.getRequestAmount(), 0);
		Assert.assertEquals("test requester", test.getRequester());
		Assert.assertEquals("Pending Approval", test.getStatus());
		Assert.assertEquals("testing getRequest", test.getPurpose());
	}

	@Test
	public void testRequestApproval() {
		Request r1 = ManagerService.getManagerService().getRequest(12); // retrieve specific request from database for
		// testing request resolution
		ManagerService.getManagerService().approveDenyRequest(12, "approved"); // simulate a Manager resolving
																							// the request
		Request r2 = ManagerService.getManagerService().getRequest(12);
		Assert.assertNotEquals(r1.getStatus(), r2.getStatus());
		ManagerService.getManagerService().approveDenyRequest(12, "validate");
		Request r3 = ManagerService.getManagerService().getRequest(12);
		Assert.assertEquals(r1.getStatus(), r3.getStatus());
	}

	@Test
	public void testRequestDenial() {
		Assert.assertEquals("Denied", "Denied");
		// create a new method for returning "Denied" requests
	}

	@Test
	public void validateResolvedRequests() {
		for (int i = 0; i < 5; i++) {
			Assert.assertNotEquals("Pending", "Resolved or other");
		}
	}

	@Test
	public void validateSingleEmployeesRequestReturnsCorrectInformation() {
		Employee e = new Employee("singleEmployee","singleEmployee","singleFirst","singleLast");
		Request r1 = ManagerService.getManagerService().viewSingleEmployeesRequests(e).get(0);
		Assert.assertEquals(r1.getStatus(), "test single employee request");
		Assert.assertEquals(r1.getPurpose(), "testing single employee");
		Assert.assertEquals(r1.getRequestAmount(), 55, 0);
	}*/

}
