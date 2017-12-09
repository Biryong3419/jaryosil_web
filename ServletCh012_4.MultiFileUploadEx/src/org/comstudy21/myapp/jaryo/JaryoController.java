package org.comstudy21.myapp.jaryo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.command.Command;
import org.comstudy21.myapp.controller.ActionForward;
import org.comstudy21.myapp.controller.Controller;

public class JaryoController extends Controller {

	@Override
	public ActionForward handleRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//String ctxPath = req.getContextPath()+"/jaryosil";
		String reqUri = req.getRequestURI();
		String cmd = reqUri.substring(reqUri.lastIndexOf("/"), reqUri.lastIndexOf("."));
		
		System.out.println("handleRequest - JaryoController");
		System.out.println("cmd => " + cmd);
		
		ActionForward actionForward =  null;
		
		JaryoCommandFactory factory = JaryoCommandFactory.getInstance();
		Command command = (Command)factory.getCommand(cmd);
		
		actionForward = command.action(req, resp);
		return actionForward;
	}
}
