package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ActionForward {
	//�̵��ϴ� ���� �Ѵ�.
	//��� - viewName
	//Redirect���� Forward�� ����?
	
	private String viewName = "";
	private boolean isRedirect = false;
	
	public ActionForward() { }
	public ActionForward(String viewName, boolean isRedirect) {
		super();
		this.viewName = viewName;
		this.isRedirect = isRedirect;
	}


	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isRedirect) {
			resp.sendRedirect(viewName);
		} else {
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
	}
	public void forward(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.viewName = viewName;
		System.out.println(this.viewName);
		forward(req, resp);
	}
	public void forward(String viewName, boolean isRedirect, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.viewName = viewName;
		this.isRedirect = isRedirect;
		forward(req, resp);
	}
}
