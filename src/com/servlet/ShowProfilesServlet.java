package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.constant.AppConstant;
import com.servlet.model.Profile;

@WebServlet("/profiles")
public class ShowProfilesServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
					   List<Profile> profilesList=new ArrayList<Profile>();
					//   ServletContext sc=super.getServletContext();
						Connection conn= (Connection)super.getServletContext().getAttribute(AppConstant.DB_CONN);
						String sql="select  pid,name,email,mobile,gender,address,image from profiles_tbl";
						//compiling the query
						PreparedStatement pstmt=conn.prepareStatement(sql);
						ResultSet rs=pstmt.executeQuery();
						while(rs.next()){
							Profile profile=new Profile(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
							profilesList.add(profile);
						}
						req.setAttribute("profilesList", profilesList);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("profiles.jsp");
		dispatcher.forward(req, resp);
		
	}

}