package org.comstudy21.myapp.jaryo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.command.Command;
import org.comstudy21.myapp.controller.ActionForward;
import org.comstudy21.myapp.service.Service;

public class JaryoMoveListCommand extends Command {

	Service service = new JaryoServiceImpl();
	
	@Override
	public ActionForward action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward actionForward =  new ActionForward();
		String viewName = "list.jsp";
		actionForward.setViewName(viewName);
		
		ArrayList<String[]> list = service.selectAll();
		//Object[] arr = new Object[list.size()];
		//list.toArray(arr);
		
		req.setAttribute("list", list);
		
		return actionForward;
	}

}
