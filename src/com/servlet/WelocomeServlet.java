package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelocomeServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//This tells browser that we are sending html contents from the server
		String pname=req.getParameter("pname");
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("<header style=\"height: 45px;background-color: #befff5;\">");
		pw.println("<h2>Learning Servlets</h2>"); 	
				pw.println("	</header>");
		pw.println("<h1 style=\"background-color:yellow\">Hello Mr. "+pname+" servlet welcomes you<h1>");
		
		
		
		
	}

}