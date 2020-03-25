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
 * �Զ����HttpFilter��ʵ����Filter�ӿ�
 * @author Administrator
 *
 */
public abstract class HttpFilter implements Filter {

	/**
	 * ���ڱ���filterConfig����
	 */
	
	private FilterConfig filterConfig;
	
	/**
	 * �յ�destroy()����
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	/**
	 * ֱ�ӷ���init(ServletConfig)��FilterConfig����
	 * @return
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	/**
	 * ԭ����doFilter�������ڷ����ڲ���ServletRequest �� ServletResponse
	 * תΪ HttpServletRequest �� HttpServletResponse��������
	 *  doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain)
	 *  ����дFilter �Ĺ��˷���������ֱ�Ӽ̳и÷�����������̳�
	 *  doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain)����
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest arg0 = (HttpServletRequest) req;
		HttpServletResponse arg1 =  (HttpServletResponse) resp;
		
		doFilter(arg0, arg1, arg2);
	}
	/**
	 * ���󷽷���ΪHttp�����ƣ�����ʵ�ֵķ���
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) throws IOException, ServletException;
	
	/**
	 * ������ֱ�Ӹ��ǣ���ֱ�Ӹ��ǿ��ܻᵼ��fILTERConfig��Ա������ʼ��ʧ��
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}
	
	/**
	 * ������̳еĳ�ʼ������������ͨ��getFilterConfig()��ȡFilterConfig����
	 */
	private void init() {}

}
