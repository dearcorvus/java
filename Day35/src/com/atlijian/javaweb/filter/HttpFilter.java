package com.atlijian.javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 自定义的HttpFilter，实现自Filter接口
 * @author Administrator
 *
 */
public abstract class HttpFilter implements Filter {

	/**
	 * 用于保存filterConfig对象
	 */
	
	private FilterConfig filterConfig;
	
	/**
	 * 空的destroy()方法
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	/**
	 * 直接返回init(ServletConfig)的FilterConfig对象
	 * @return
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	/**
	 * 原生的doFilter方法，在方法内部把ServletRequest 和 ServletResponse
	 * 转为 HttpServletRequest 和 HttpServletResponse，并调用
	 *  doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain)
	 *  若编写Filter 的过滤方法不建议直接继承该方法。而建议继承
	 *  doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain)方法
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest arg0 = (HttpServletRequest) req;
		HttpServletResponse arg1 =  (HttpServletResponse) resp;
		
		doFilter(arg0, arg1, arg2);
	}
	/**
	 * 抽象方法，为Http请求定制，必须实现的方法
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) throws IOException, ServletException;
	
	/**
	 * 不建议直接覆盖，若直接覆盖可能会导致fILTERConfig成员变量初始化失败
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}
	
	/**
	 * 供子类继承的初始化方法。可以通过getFilterConfig()获取FilterConfig对象
	 */
	private void init() {}

}
