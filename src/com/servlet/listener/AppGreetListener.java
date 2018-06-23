package com.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppGreetListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		System.out.println("************************Application is up and running******************************************");
		System.out.println("************************Application is up and running******************************************");
		System.out.println("************************WELCOME!!!!!!!!!!!!!!!!!!!!!!******************************************");
		System.out.println("************************Application is up and running******************************************");
		System.out.println("************************Application is up and running******************************************");
		
	}

}
