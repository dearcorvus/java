package com.atlijian.javaweb;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintUpperTag extends SimpleTagSupport {

	private String time;
	
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		//1.�õ���ǩ�������
		JspFragment bodyContent = getJspBody();
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		String content =sw.toString();
		
		//2.��Ϊ��д
		content = content.toUpperCase()	;
		//3.�õ�out��������
		
		//4.ѭ�����
		
		int count = 1;
		
		try {
			count = Integer.parseInt(time);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < count; i++) {
			getJspContext().getOut().print(content+"<br>");
		}
		
	}
}
