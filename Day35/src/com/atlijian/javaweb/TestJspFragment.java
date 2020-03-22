package com.atlijian.javaweb;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFragment extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment bodyContent = getJspBody();
		//JspFragment.invoke(Witer):Write 即为标签体输出的字符流，若为null则输出到getJspContext().getOut();即输出到页面上		
		//bodyContent.invoke(null);
		
		
		//1.使用StringWriter得到标签体的内容
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		//2.把标签体的内容都变成大写
		String content = sw.toString().toUpperCase();
		//3.获取页面上隐含的out隐含对象输出到页面上
		//System.out.println(sw.toString());
		getJspContext().getOut().print(content);
		
	}
}
