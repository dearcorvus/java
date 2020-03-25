package com.atlijian.javaweb.encoding;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atlijian.javaweb.filter.HttpFilter;

public class EncodeFilter extends HttpFilter{

	private String encoding;
	
	public void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
	}
	
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.print(encoding);
		request.setCharacterEncoding("UTF-8");
		filterChain.doFilter(request, response);
		
	}
	
}
