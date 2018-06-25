package com.filter;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class SiteBlockerFilter  implements Filter{
	
	private long fixTime=17*60*60*1000+11*60*1000;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		String requestUrl=request.getRequestURI();
		if(requestUrl.endsWith("download.png")){
			arg2.doFilter(arg0, arg1);
		}else {
						System.out.println("Request is coming at "+new Date()+" - " +requestUrl);	
						
						   Calendar now = Calendar.getInstance();
						   int hrs=now.get(Calendar.HOUR_OF_DAY); 
						   int mins=now.get(Calendar.MINUTE);
						   int secs=now.get(Calendar.SECOND);
						   long currentTime=hrs*60*60*1000+mins*60*1000+secs*1000;
						if(currentTime<fixTime) {
							System.out.println("_@_@_@_@@_@_@_");
							System.out.println("currentTime = "+currentTime);
							System.out.println("fixTime = "+fixTime);
							arg2.doFilter(arg0, arg1);
						}else{
							System.out.println("_$%%%%%%%%%%%%%_");
							System.out.println("currentTime = "+currentTime);
							System.out.println("fixTime = "+fixTime);
							RequestDispatcher rd=request.getRequestDispatcher("block.jsp");
							rd.forward(arg0, arg1);
						}
		
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
