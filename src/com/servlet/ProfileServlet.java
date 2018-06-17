package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-profile")
public class ProfileServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//This tells browser that we are sending html contents from the server
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		try {
			   //mysql-connector-java-5.1.6.jar
						//above jar contains the driver for the database
						//loading the driver inside the memory
						/*Class.forName("com.mysql.jdbc.Driver");
						Connection conn = null;
						//conn is pointing the database
						//connecting to the database
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gps_pvt_db","root", "mysql@1234");
						String sql="insert into profiles_tbl(name,email,mobile,gender,address) values(?,?,?,?,?)";
						//compiling the query
						PreparedStatement pstmt=conn.prepareStatement(sql);
						//setting values inside compiled query
						pstmt.setString(1,name);
						pstmt.setString(2,email);
						pstmt.setString(3,mobile);
						pstmt.setString(4,gender);
						pstmt.setString(5,address);
						
						//fire the query
						int p=pstmt.executeUpdate();*/
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		/*resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("<h1 style=\"color:blue\">Profile Detail is ................. <h1>");
			
		pw.println("<h1 color=\"red\">Name =  "+name+" <h1>");
		pw.println("<h1 color=\"red\">Email =  "+email+" <h1>");
		pw.println("<h1 color=\"red\">Mobile =  "+mobile+" <h1>");
		pw.println("<h1 color=\"red\">Gender =  "+gender+" <h1>");
		pw.println("<h1 color=\"red\">Address =  "+address+" <h1>");*/
		//adding values into the request scope
		req.setAttribute("pname", name);
		req.setAttribute("pemail", email);
		req.setAttribute("paddress", address);
		req.setAttribute("pgender", gender);
		req.setAttribute("pmobile", mobile);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("profile-summary.jsp");
		dispatcher.forward(req, resp);
		
	}

}