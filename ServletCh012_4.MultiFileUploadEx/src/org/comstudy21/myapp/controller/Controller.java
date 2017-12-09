package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {
	//��� ��Ʈ�ѷ���  Super
	//ActionForward ��ü�� �����ش�.
	
	public abstract ActionForward handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
