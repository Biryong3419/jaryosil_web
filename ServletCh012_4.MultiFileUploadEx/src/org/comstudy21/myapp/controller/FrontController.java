package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.jaryo.JaryoController;

public class FrontController extends HttpServlet {
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public FrontController() {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
	    viewResolver.setPrefix("/jaryosil/");
		//viewResolver.setSuffix(".jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ctxPath = req.getContextPath()+"/";
		String reqUri = req.getRequestURI();
		String view="";
		int begin = ctxPath.length();
		String pattern = reqUri.substring(begin);
		System.out.println("%%%%%%"+pattern);
		String cmd = "/" + pattern.substring(0, pattern.indexOf("/"));
		System.out.println("@!!!!!@"+cmd);
		Controller ctrl = handlerMapping.getController(cmd);
	
		ActionForward actionForward = ctrl.handleRequest(req, resp);
		if(!actionForward.isRedirect()) {
			//if(reqUri.substring(reqUri.lastIndexOf("."), reqUri.length()).equals(".do")) {
			//	view=actionForward.getViewName();
				view = viewResolver.getView(actionForward.getViewName());
			actionForward.setViewName(view);
		}
		actionForward.forward(req, resp);
	}
}





