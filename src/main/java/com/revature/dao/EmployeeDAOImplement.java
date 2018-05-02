package com.revature.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.*;
import com.revature.util.ConnectionWithProperties;
import com.revature.util.LogUtil;

public class EmployeeDAOImplement implements EmployeeDAO {

	private static EmployeeDAOImplement instance;

	private EmployeeDAOImplement() {
	}

	public static EmployeeDAOImplement getInstance() {
		if (instance == null) {
			instance = new EmployeeDAOImplement();
		}
		return instance;
	}

	@Override
	public boolean createNewEmployee(String email, String username, String password, String first, String last) {
		boolean created = false;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call insert_employee(?,?,?,?,?)}");
			stmt.setString(1, email);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.setString(4, first);
			stmt.setString(5, last);
			if (stmt.executeUpdate() > 0) {
				created = true;
				LogUtil.logger
						.info("A new Employee has been registered with the following email address: " + email);
			} else {
				LogUtil.logger.error("There was an issue registering a new Employee with the following email address: " + email);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return created;
	}

	@Override
	public Employee getEmployee(String email) {
		Employee employee = null;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE e_email=?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				employee = new Employee(email, rs.getString("e_username"), rs.getString("e_first_name"), rs.getString("e_last_name"));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return employee;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> all = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE");
			ResultSet rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					all.add(new Employee(rs.getString("e_email"), rs.getString("e_username"), rs.getString("e_first_name"), rs.getString("e_last_name")));
				}
			} else {
				all.add(new Employee("","","There are no employees in the system",""));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return all;
	}

	@Override
	public boolean updateEmployee(String email, String newUsername, String newFirst, String newLast) {
		boolean updated = false;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call update_employee(?,?,?,?)}");
			stmt.setString(1, email);
			stmt.setString(2, newUsername);
			stmt.setString(3, newFirst);
			stmt.setString(4, newLast);
			if (stmt.executeUpdate() > 0) {
				updated = true;
				LogUtil.logger
						.info("The Employee with email address " + email + " has successfully updated their info");
			} else {
				LogUtil.logger.error("There was an issue updating the information of the Employee with email address of : " + email);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return updated;
	}

	/*
	*//**
	 * The getEmployee method returns the Employee with the given email address.
	 *//*
	@Override
	public Employee getEmployee(String email) {
		Employee get = null;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE e_email=?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				get = new Employee(rs.getString("e_email"), rs.getString("e_username"), 
						rs.getString("e_first_name"), rs.getString("e_last_name"));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return get;
	}

	*//**
	 * The requestReimbursement method creates a new reimbursement on behalf of the
	 * requester for the specified amount.
	 *//*
	@Override
	public void requestReimbursement(String requester, double amount) {
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call insert_request(?,?)}");
			stmt.setDouble(1, amount);
			stmt.setString(2, requester);
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
	}

	*//**
	 * The viewPending method returns a list of all pending reimbursement requests
	 * for a given Employee
	 *//*
	@Override
	public List<Request> viewPending(Employee e) {
		List<Request> pending = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_status=? AND r_requester=?");
			stmt.setString(1, "Pending Approval");
			stmt.setString(2, e.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pending.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return pending;

	}

	*//**
	 * The viewResolved method returns a list of past reimbursement requests for a
	 * given Employee.
	 *//*
	@Override
	public List<Request> viewResolved(Employee e) {
		List<Request> resolved = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM REQUEST WHERE r_status <> ? AND r_requester=?");
			stmt.setString(1, "Pending Approval");
			stmt.setString(2, e.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resolved.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return resolved;
	}

	*//**
	 * The viewInfo method returns the personal information associated with a given
	 * Employee.
	 *//*
	@Override
	public List<String> viewInfo(Employee e) {
		List<String> info = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE e_email=?");
			stmt.setString(1, e.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				info.add("Email: " + rs.getString("e_email") + " Username: " + rs.getString("e_username"));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return info;
	}

	*//**
	 * The updateInfo method updates an Employee's personal information with the
	 * passed in values.
	 *//*
	@Override
	public void updateInfo(String email, String username, String first, String last) {
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call update_employee(?,?,?,?)}");
			stmt.setString(1, email);
			stmt.setString(2, username);
			stmt.setString(3, first);
			stmt.setString(4, last);
			if (stmt.executeUpdate() > 0) {
				LogUtil.logger
						.info("Employee with email address " + email + " has successfully updated their information");
			} else {
				LogUtil.logger.info(
						"There was a problem updating the information of the Employee with email address " + email);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
	}*/

}
