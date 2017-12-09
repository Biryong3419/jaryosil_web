package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {
	//모든 콘트롤러의  Super
	//ActionForward 객체를 돌려준다.
	
	public abstract ActionForward handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
