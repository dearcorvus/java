package com.atlijian.javaweb.login;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atlijian.javaweb.filter.HttpFilter;

public class LoginFilter extends HttpFilter{

	//1.获取web.xml内信息
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String requestUrl = request.getRequestURI();
		String requestURL = request.getRequestURI().toString();
		
		String servletPath = request.getServletPath();
		
		System.out.println(requestUrl);
		System.out.println(requestURL);
		System.out.println(servletPath);
		
		
	}

	
	
	
}
