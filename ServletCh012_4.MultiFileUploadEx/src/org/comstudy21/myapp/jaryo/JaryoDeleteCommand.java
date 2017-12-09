package org.comstudy21.myapp.jaryo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.command.Command;
import org.comstudy21.myapp.controller.ActionForward;
import org.comstudy21.myapp.service.Service;

public class JaryoDeleteCommand extends Command {
	Service service = new JaryoServiceImpl();
	@Override
	public ActionForward action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward actionForward =  new ActionForward();
		service.delete(Integer.valueOf(req.getParameter("index")));
		String viewName = "moveList.do";
		actionForward.setViewName(viewName);
		
		
		
		
	return actionForward;
	}

}
