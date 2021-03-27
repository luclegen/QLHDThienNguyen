package com.hoatdong.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=QL_HD_THIEN_NGUYEN";
	private static String USER_NAME = "luc";
	private static String PASSWORD = "1234";
    
	public static Connection getConnectDB() {
		Connection conn = null;
		try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (Exception e) {
        	System.out.println("Connect failure!");
			e.printStackTrace();
        }
        return conn;
    }
}
