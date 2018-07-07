package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.servlet.constant.AppConstant;

@WebServlet("/jadd-profile")
public class JProfileServlet  extends HttpServlet{
	
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
		String image=req.getParameter("image");
		
		try {
		          	Connection conn= (Connection)super.getServletContext().getAttribute(AppConstant.DB_CONN);
						String sql="insert into profiles_tbl(name,email,mobile,gender,address,image) values(?,?,?,?,?,?)";
						//compiling the query
						PreparedStatement pstmt=conn.prepareStatement(sql);
						//setting values inside compiled query
						pstmt.setString(1,name);
						pstmt.setString(2,email);
						pstmt.setString(3,mobile);
						pstmt.setString(4,gender);
						pstmt.setString(5,address);
						pstmt.setString(6,image);
						//fire the query
						int p=pstmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		resp.setContentType("application/json"); //MIME -I am sending json as response = Mutlipurpose Internet & Mail Extension
		ApplicationMessage applicationMessage=new ApplicationMessage();
		applicationMessage.setStatus("successs");
		applicationMessage.setMessage(" profile has been uploaded successfully ");
		Gson gson=new Gson();
		String jsonData=gson.toJson(applicationMessage);
		resp.getWriter().print(jsonData);
	}

}