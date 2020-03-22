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
		//JspFragment.invoke(Witer):Write ��Ϊ��ǩ��������ַ�������Ϊnull�������getJspContext().getOut();�������ҳ����		
		//bodyContent.invoke(null);
		
		
		//1.ʹ��StringWriter�õ���ǩ�������
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		//2.�ѱ�ǩ������ݶ���ɴ�д
		String content = sw.toString().toUpperCase();
		//3.��ȡҳ����������out�������������ҳ����
		//System.out.println(sw.toString());
		getJspContext().getOut().print(content);
		
	}
}
