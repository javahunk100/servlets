package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fact")
public class FactorialServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//This tells browser that we are sending html contents from the server
		String temp=req.getParameter("num");
		int pnum=Integer.parseInt(temp);
		int sum=1;
		for(int x=2;x<=pnum;x++){
			sum=sum*x;
		}
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("<h1 color=blue>Factorial of number "+pnum+" is "+sum+" <h1>");
		
	}

}