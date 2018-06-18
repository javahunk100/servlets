package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() throws Exception{
		//mysql-connector-java-5.1.6.jar
		//above jar contains the driver for the database
		//loading the driver inside the memory
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		//conn is pointing the database
		//connecting to the database
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gps_pvt_db","root", "mysql@1234");
		return conn;
	}
}
