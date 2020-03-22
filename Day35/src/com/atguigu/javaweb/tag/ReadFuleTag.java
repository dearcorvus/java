package com.atguigu.javaweb.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ReadFuleTag extends SimpleTagSupport{
	
	//相对与当前WEB应用的根路径的文件名
	private String src;
	
	public void setSrc(String src) {
		this.src = src;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		InputStream in = pageContext.getServletContext().getResourceAsStream(src);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String str = null;
		
		while((str = reader.readLine()) != null) {
			Pattern.compile("<").matcher(str).replaceAll("&lt");
			Pattern.compile(">").matcher(str).replaceAll("&gt");
			pageContext.getOut().write(str);
			pageContext.getOut().write("<br>");
		}
	}
}
