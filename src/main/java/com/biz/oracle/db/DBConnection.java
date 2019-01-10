package com.biz.oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static private Connection dbConn;
	
	static {
		
		String driver="oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="mybts";
			String password="1234";
			
			dbConn=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance() {
		return dbConn;
	}

}
