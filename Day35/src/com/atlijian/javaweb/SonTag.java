package com.atlijian.javaweb;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SonTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		//1.�õ�����ǩ������
		JspTag parent =  getParent();
		//2.��ȡ����ǩ��name����
		ParentTag parentTag = (ParentTag) parent;
		String name = parentTag.getName();
		//3.��nameֵ��ӡ��JSPҳ����
		
		getJspContext().getOut().print("�ӱ�ǩ���name��" + name);
	}
}
