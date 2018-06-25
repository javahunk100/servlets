package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.servlet.constant.AppConstant;
import com.servlet.model.Profile;

@WebServlet("/jprofile")
public class ProfileAsJsonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String email=req.getParameter("email");
		   List<Profile> profilesList=new ArrayList<Profile>();
			//   ServletContext sc=super.getServletContext();
				Connection conn= (Connection)super.getServletContext().getAttribute(AppConstant.DB_CONN);
				String sql="select  pid,name,email,mobile,gender,address,image from profiles_tbl where email=?";
				//compiling the query
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, email);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()){
					Profile profile=new Profile(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					resp.setContentType("application/json"); //MIME -I am sending json as response = Mutlipurpose Internet & Mail Extension
					Gson gson=new Gson();
					String jsonData=gson.toJson(profile);
					resp.getWriter().print(jsonData);
				}else{
					ApplicationMessage applicationMessage=new ApplicationMessage();
					applicationMessage.setStatus("fail");
					applicationMessage.setMessage("Sorry ! profile does not exist for email id "+email);
					Gson gson=new Gson();
					String jsonData=gson.toJson(applicationMessage);
					resp.getWriter().print(jsonData);
				}
		
		}catch(Exception e){
			e.printStackTrace();
		}
}	
	
}
