package org.comstudy21.myapp.jaryo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.command.Command;
import org.comstudy21.myapp.controller.ActionForward;
import org.comstudy21.myapp.service.Service;

public class JaryoMoveUploadCommand extends Command {
	

	@Override
	public ActionForward action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward actionForward =  new ActionForward();
		String viewName = "multiFileUploadClient.jsp";
		actionForward.setViewName(viewName);
		
	
		
		return actionForward;
	}

}
