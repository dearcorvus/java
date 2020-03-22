package com.atlijian.javaweb;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport{

	private Collection<?> items;
	
	public void setItems(Collection<?> items) {
		this.items = items;
	}
	
	private String var;
	
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
//		*����items��Ӧ�ļ��ϣ�
		if(items != null) {
			for (Object obj:items) {
//				*�����ڱ����Ķ������pageContext�У�����var,ֵ;���ڱ����Ķ���
				getJspContext().setAttribute(var, obj);
//				*�ѱ�ǩ�������ֱ�������ҳ����
				getJspBody().invoke(null);
			}
		}
	}
}
