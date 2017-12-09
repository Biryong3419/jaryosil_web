package org.comstudy21.myapp.controller;

public class ViewResolver {
	//접두사, 접미사를 저장한다.
	//접두사와 접미사를 이용해서 완성된 viewName을 만든다.
	
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
