package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionWithProperties {

	private ConnectionWithProperties() { }

	public static void main(String[] args) {
		System.out.println(ConnectionWithProperties.getConnection());
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LogUtil.logger.warn("Exception thrown while adding oracle driver.",e);
		}
	}
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			//in = in.getClass().getClassLoader().getResourceAsStream("db.properties");
			//Properties props = new Properties();
			//ResourceBundle props = ResourceBundle.getBundle("db");
			//in = new FileInputStream("src/main/resources/db.properties");
			//System.out.println(ConnectionWithProperties.class.getProtectionDomain().getCodeSource().getLocation().getFile());
			//in = new FileInputStream("C:\\Users\\Michael\\Documents\\workspace-sts-3.9.3.RELEASE\\Project_1\\src\\main\\resources\\db.properties");
			//in = new FileInputStream("src\\main\\resources\\db.properties");
			//props.load(in);
			//props.load(Properties.class.getResourceAsStream("/db.properties"));
			//props.load(in);
			return DriverManager.getConnection(
					//props.getProperty("jdbc.url"),
					//props.getProperty("jdbc.username"),
					//props.getProperty("jdbc.password"));
					//props.getString("jdbc.url"),
					//props.getString("jdbc.username"),
					//props.getString("jdbc.password"));
					"jdbc:oracle:thin:@jta1804-sikorski.cdj7nu7q0uns.us-east-1.rds.amazonaws.com:1521:ORCL",
					"project1",
					"project1");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		//} //catch (FileNotFoundException fnfe) {
			//System.err.println(fnfe.getMessage());
		//} catch (IOException ioe) {
		//	System.err.println(ioe.getMessage());
		//} catch (Exception e) {
		//	System.out.println(e.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException ioe) {
				System.err.println(ioe.getMessage());
			}
		}
		return null;
	}
}
