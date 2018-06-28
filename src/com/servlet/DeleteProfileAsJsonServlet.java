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

@WebServlet("/dprofile")
public class DeleteProfileAsJsonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String email=req.getParameter("email");
		   List<Profile> profilesList=new ArrayList<Profile>();
			//   ServletContext sc=super.getServletContext();
				Connection conn= (Connection)super.getServletContext().getAttribute(AppConstant.DB_CONN);
				String sql="delete  from profiles_tbl where email=?";
				//compiling the query
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, email);
				int row=pstmt.executeUpdate();
				resp.setContentType("application/json"); //MIME -I am sending json as response = Mutlipurpose Internet & Mail Extension
				ApplicationMessage applicationMessage=new ApplicationMessage();
				if(row==0) {
					applicationMessage.setStatus("fail");
					applicationMessage.setMessage("Sorry ! profile is not deleted for email id "+email);
				}
				else {
					applicationMessage.setStatus("success");
					applicationMessage.setMessage("Hey ! profile is  deleted for email id "+email);
				}		
				
				Gson gson=new Gson();
				String jsonData=gson.toJson(applicationMessage);
				resp.getWriter().print(jsonData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	
}
