package com.lms.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	
	public static Connection makeConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "");
		return connect;
	}
}
