package com.revature.service;
import com.revature.model.*;
import com.revature.util.ConnectionWithProperties;
import com.revature.util.LogUtil;

import java.sql.*;

public class LoginManagerService {
	
	public Login userOnDb(String email, String password) {
		System.out.println("The LoginManagerService has been requested");
		Login status = new Login("","unregistered");
		try (Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MANAGER WHERE m_email=?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {	// Manager with the given email exists in the database
				if (rs.getString("m_password").equals(password)) {
					return new Login(email,"manager");
				} else {
					return new Login("","badlogin");
				}
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
			System.out.println(sqle.getMessage());
			System.out.println("SQL State: " + sqle.getSQLState());
			System.out.println("Error Code: " + sqle.getErrorCode());
		}
		return status;
	}
}
