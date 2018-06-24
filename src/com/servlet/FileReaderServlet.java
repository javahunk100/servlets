package com.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileReaderServlet  extends HttpServlet{
	
    private 	String fileName;
	private String color;
	
	@Override
	public void init(){
		   ServletConfig config=getServletConfig();	
	       fileName=config.getInitParameter("fileName");
	       color=config.getInitParameter("color");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//This tells browser that we are sending html contents from the server
	     String afileName=getServletContext().getRealPath("/files/"+fileName);
	     resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		File file=new File(afileName);
		BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
		String line=null;
		 String email=getServletContext().getInitParameter("email");	
		pw.println("<html><body style=\"background-color:"+color+"\">");
		pw.println("Hey your email is = "+email);
		while((line=bufferedReader.readLine())!=null){
			pw.println(line);
		}
		pw.println("</body></html>");
	}
	
	@Override
	public void destroy(){
		  //file close , connection close
	}

}