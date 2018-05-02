package com.revature.application;

import java.util.List;

import com.revature.model.*;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;
import com.revature.util.LogUtil;

public class project1 {

	public static void main(String[] args) {
		//LogUtil.logger.info("TEST");
		/*for (Employee e : ManagerService.getManagerService().viewAllEmployees()) {
			for (Request r : ManagerService.getManagerService().viewPendingSingle(e)) {
				System.out.println(r.toString());
			}
		}*/
		/*for (Request r : ManagerService.getManagerService().viewPendingAll()) {
			System.out.println(r.toString());
			ManagerService.getManagerService().approveDenyRequest(r, "TESTING APPROVE/DENY");
		}*/
		
		/*for (Employee e : ManagerService.getManagerService().viewAllEmployees()) {
			System.out.println("Viewing Info: ");
			for (String s : EmployeeService.getEmployeeService().viewInfo(e)) {
				System.out.println(s);
			}
			System.out.println();
			System.out.println("Viewing Pending: ");
			for (Request r : EmployeeService.getEmployeeService().viewPending(e)) {
				System.out.println(r.toString());
			}
			System.out.println();
			System.out.println("Viewing Resolved: ");
			for (Request r : EmployeeService.getEmployeeService().viewResolved(e)) {
				System.out.println(r.toString());
			}
		}*/
	}
}
