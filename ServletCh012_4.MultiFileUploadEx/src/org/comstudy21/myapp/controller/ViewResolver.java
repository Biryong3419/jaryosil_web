package org.comstudy21.myapp.controller;

public class ViewResolver {
	//���λ�, ���̻縦 �����Ѵ�.
	//���λ�� ���̻縦 �̿��ؼ� �ϼ��� viewName�� �����.
	
	private String prefix;
//	private String suffix;
	
	private String viewName;
	
	public ViewResolver() {
		// TODO Auto-generated constructor stub
	}
	public ViewResolver(String viewName) {
		this.viewName = viewName;
	}
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
//	public String getSuffix() {
//		return suffix;
//	}
//	public void setSuffix(String suffix) {
//		this.suffix = suffix;
//	}
//	
	public String getView(String viewName) {
		return prefix + viewName;
				//+ suffix;
	}
	
	@Override
	public String toString() {
		return prefix + viewName;
				//+ suffix;
	}
}
