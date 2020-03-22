package com.atguigu.javaweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
//import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MaxTag extends SimpleTagSupport {
	//public class MaxTag implements SimpleTag {

	private String num1;
	private String num2;
	
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		int a = 0;
		int b = 0;
		
		PageContext pageContext = (PageContext) getJspContext();
		
		JspWriter out =pageContext.getOut();
		
		try {
			a = Integer.parseInt(num1);
			b = Integer.parseInt(num2);
			out.print( a > b ? a : b);
		} catch (Exception e) {
			out.print("输入的属性格式不正确！");;
		}
		
	}

//	@Override
//	public JspTag getParent() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setJspBody(JspFragment jspBody) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	private PageContext pageContext ;
//	
//	@Override
//	public void setJspContext(JspContext pc) {
//		// TODO Auto-generated method stub
//		this.pageContext = (PageContext) pc;
//	}
//
//	@Override
//	public void setParent(JspTag parent) {
//		// TODO Auto-generated method stub
//		
//	}

}
