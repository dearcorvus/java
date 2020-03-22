package com.atlijian.javaweb;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ParentTag extends SimpleTagSupport {

	private String name = "ATGUIGU";
	
	public String getName() {
		return name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.print("父标签处理器类 NAME:"+name);
		getJspBody().invoke(null);
	}
}
