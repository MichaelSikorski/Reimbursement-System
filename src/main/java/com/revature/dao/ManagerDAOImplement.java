package com.revature.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.*;
import com.revature.util.ConnectionWithProperties;
import com.revature.util.LogUtil;

public class ManagerDAOImplement implements ManagerDAO {

	private static ManagerDAOImplement instance;

	private ManagerDAOImplement() {
	}

	public static ManagerDAOImplement getInstance() {
		if (instance == null) {
			instance = new ManagerDAOImplement();
		}
		return instance;
	}

	@Override
	public boolean createNewManager(String email, String username, String password, String first, String last) {
		boolean created = false;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call insert_manager(?,?,?,?,?)}");
			stmt.setString(1, email);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.setString(4, first);
			stmt.setString(5, last);
			if (stmt.executeUpdate() > 0) {
				created = true;
				LogUtil.logger
						.info("A new Manager has been registered with the following email address: " + email);
			} else {
				LogUtil.logger.error("There was an issue registering a new Manager with the following email address: " + email);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return created;
	}

	@Override
	public Manager getManager(String email) {
		Manager manager = null;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MANAGER WHERE m_email=?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				manager = new Manager(email, rs.getString("m_username"), rs.getString("m_first_name"), rs.getString("m_last_name"));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return manager;
	}

	
	/**
	 * The getRequest method returns the reimbursement request with the given ID
	 *//*
	public Request getRequest(int requestID) {
		Request r = null;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_id=?");
			stmt.setInt(1, requestID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				r = new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date"));
			} else {
				LogUtil.logger.error("There was an issue getting the request with ID #" + requestID);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return r;
	}

	*//**
	 * The getRequest method returns the Request made by the given requester for the
	 * given amount
	 *//*
	public Request getRequest(String email, double amount) {
		Request r = null;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_requester=? AND r_amount=?");
			stmt.setString(1, email);
			stmt.setDouble(2, amount);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				r = new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date"));
			} else {
				LogUtil.logger.error("There was an issue getting a request made by " + email + " for $" + amount);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return r;
	}

	*//**
	 * The approveDenyRequest method is used to change the status of a reimbursement
	 * request. The first parameter is the ID of the request to be changed and the
	 * second is the new status.
	 *//*
	@Override
	public void approveDenyRequest(int requestID, String status) {
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call resolve_request(?,?)}");
			stmt.setInt(1, requestID);
			stmt.setString(2, status);
			if (stmt.executeUpdate() > 0) {
				LogUtil.logger
						.info("Request with ID of " + requestID + " has been resolved. Its new status is: " + status);
			} else {
				LogUtil.logger.error("There was an issue updating the request with ID #" + requestID);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
	}

	*//**
	 * The viewPendingAll method returns a list of all pending reimbursement
	 * requests for all Employees (requests with a status of 'Pending Approval')
	 *//*
	@Override
	public List<Request> viewPendingAll() {
		List<Request> allPending = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_status=?");
			stmt.setString(1, "Pending Approval");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				allPending.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return allPending;
	}

	*//**
	 * The viewPendingSingle method returns a list of all pending reimbursement
	 * requests for the single employee specified in the parameter list.
	 *//*
	@Override
	public List<Request> viewPendingSingle(Employee e) {
		List<Request> allPendingForThisEmployee = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_status=? AND r_requester=?");
			stmt.setString(1, "Pending Approval");
			stmt.setString(2, e.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				allPendingForThisEmployee.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"),
						rs.getString("r_requester"), rs.getString("r_reviewed_by"), rs.getString("r_status"),
						rs.getString("r_purpose"), rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return allPendingForThisEmployee;
	}

	*//**
	 * The viewResolved method returns a list of all reimbursement requests from all
	 * Employees that have been resolved (their status is not 'Pending Approval')
	 *//*
	@Override
	public List<Request> viewResolved() {
		List<Request> allResolved = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_status <> ?");
			stmt.setString(1, "Pending Approval");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				allResolved.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return allResolved;
	}

	*//**
	 * The viewAllEmployees method returns a list of all Employees
	 *//*
	@Override
	public List<Employee> viewAllEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				allEmployees.add(new Employee(rs.getString("e_email"), rs.getString("e_username"),
						rs.getString("e_first_name"), rs.getString("e_last_name")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return allEmployees;
	}

	*//**
	 * The viewSingleEmployeesRequests method returns all the requests of a specific
	 * Employee (as specified in the parameter list)
	 *//*
	@Override
	public List<Request> viewSingleEmployeesRequests(Employee e) {
		List<Request> thisEmployeesRequests = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_requester=?");
			stmt.setString(1, e.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				thisEmployeesRequests.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"),
						rs.getString("r_requester"), rs.getString("r_reviewed_by"), rs.getString("r_status"),
						rs.getString("r_purpose"), rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return thisEmployeesRequests;
	}*/
}
