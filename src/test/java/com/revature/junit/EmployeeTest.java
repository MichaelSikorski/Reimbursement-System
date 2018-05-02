package com.revature.junit;

import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.revature.model.*;
import com.revature.service.*;

public class EmployeeTest {

	/*-An Employee can login
	-An Employee can view the Employee Homepage
	-An Employee can logout
	-An Employee can submit a reimbursement request
	-An Employee can upload an image of his/her receipt as part of the reimbursement request (hard / do last) (optional)
	-An Employee can view their pending reimbursement requests
	-An Employee can view their resolved reimbursement requests
	-An Employee can view their information
	-An Employee can update their information*/

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// create a request, submit and validate below
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	@Test
	public void testSubmitRequest() {
		double amount = ((Calendar.getInstance().getTimeInMillis())/1000000000);
		EmployeeService.getEmployeeService().requestReimbursement("test requester", amount);
		Request test = ManagerService.getManagerService().getRequest("test requester", amount);
		Assert.assertEquals("test requester", test.getRequester());
		Assert.assertEquals(amount, test.getRequestAmount(), 0);
	}

	@Test
	public void validatePendingArePending() {
		List<Request> pending = ManagerService.getManagerService().viewPendingAll();
		for (Request r : pending) {
			Assert.assertEquals("Pending Approval", r.getStatus());
		}
	}

	@Test
	@Ignore
	public void validateRequestResolved() {
		Request r1 = ManagerService.getManagerService().getRequest(12); // retrieve specific request from database for
																		// testing request resolution
		ManagerService.getManagerService().approveDenyRequest(12, "has been validated"); // simulate a Manager resolving the request
		Request r2 = ManagerService.getManagerService().getRequest(12);
		Assert.assertNotEquals(r1.getStatus(), r2.getStatus());
		ManagerService.getManagerService().approveDenyRequest(12, "validate");
		Request r3 = ManagerService.getManagerService().getRequest(12);
		Assert.assertEquals(r1.getStatus(), r3.getStatus());
	}

	@Test
	@Ignore
	public void validateEmployeeInfo() {
		Employee e = EmployeeService.getEmployeeService().getEmployee("test_get_info");
		Assert.assertEquals("test_get_info", e.getEmail());
		Assert.assertEquals("getUserName", e.getUsername());
		Assert.assertEquals("getLast", e.getLastName());
		Assert.assertEquals("getFirst", e.getFirstName());
	}

	@Test
	@Ignore
	public void validateEmployeeInfoWasUpdated() {
		Employee previous = EmployeeService.getEmployeeService().getEmployee("test requester");
		String previousUsername = previous.getUsername();
		String previousFirstName = previous.getFirstName();
		String previousLastName = previous.getLastName();
		String previousEmail = previous.getEmail();
		String time = "" + Calendar.getInstance().getTimeInMillis();
		EmployeeService.getEmployeeService().updateInfo("test requester", "user" + " " + time, "first" + " " + time,
				"last" + " " + time);
		Employee updated = EmployeeService.getEmployeeService().getEmployee("test requester");
		Assert.assertNotEquals(previousUsername, updated.getUsername());
		Assert.assertNotEquals(previousFirstName, updated.getFirstName());
		Assert.assertNotEquals(previousLastName, updated.getLastName());
		Assert.assertEquals(previousEmail, updated.getEmail());
	}*/
}
