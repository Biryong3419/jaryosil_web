package org.comstudy21.myapp.jaryo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.command.Command;
import org.comstudy21.myapp.controller.ActionForward;
import org.comstudy21.myapp.service.Service;

public class JaryoMoveDeleteCommand extends Command {
	Service service = new JaryoServiceImpl();

	@Override
	public ActionForward action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward actionForward =  new ActionForward();
		req.setAttribute("password",service.search(Integer.valueOf(req.getParameter("index"))).getPassword());
		req.setAttribute("index",req.getParameter("index"));
		String viewName = "checkDelete.jsp";
		actionForward.setViewName(viewName);
		
		
		return actionForward;
	}
}
