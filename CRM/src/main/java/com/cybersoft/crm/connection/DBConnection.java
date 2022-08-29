package com.cybersoft.crm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String url = "jdbc:mysql://localhost:3306/crm";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,"root","admin");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cant connection driver !!");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Cant connection database !!!");
			e.printStackTrace();
		}
		return null;
	}
}
