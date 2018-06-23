package com.servlet.listener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.servlet.constant.AppConstant;

@WebListener
public class DBConnectionListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("************************WELCOME!!!!!!!!!!!!!!!!!!!!!!******************************************");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = null;
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gps_pvt_db","root", "mysql@1234");
					ServletContext applicationScope=arg0.getServletContext();
					applicationScope.setAttribute(AppConstant.DB_CONN, conn);
					//adding connection into application scope
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

}
