package org.comstudy21.myapp.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.controller.ActionForward;

public abstract class Command {
	
	public abstract ActionForward action(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
	
}
