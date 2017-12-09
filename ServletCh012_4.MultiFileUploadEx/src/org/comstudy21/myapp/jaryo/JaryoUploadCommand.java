package org.comstudy21.myapp.jaryo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.command.Command;
import org.comstudy21.myapp.controller.ActionForward;
import org.comstudy21.myapp.service.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class JaryoUploadCommand extends Command {
	Service service = new JaryoServiceImpl();
	@Override
	public ActionForward action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward actionForward =  new ActionForward();
		String viewName = "jaryosil/moveList.do";
		actionForward.setViewName(viewName);
		String saveDirectory = req.getServletContext().getRealPath("/upload");
		int maxPostSize= 5000000;
		
		System.out.println(saveDirectory+"@@@@@@@@@@@");

		MultipartRequest multi = new MultipartRequest(req,saveDirectory,
				maxPostSize,"EUC-KR",new DefaultFileRenamePolicy());

		Enumeration en = multi.getFileNames();
		while(en.hasMoreElements()){
			String paramName=(String)en.nextElement();
			String originFileName=multi.getOriginalFileName(paramName);
			String realFileName=multi.getFilesystemName(paramName);
			
			System.out.println("paramname!!!!=>"+paramName+",,,,,,,"+originFileName+" : "+ realFileName + "<br>");
			System.out.println(multi.getParameter("password"));
		JaryoDto jaryodto = new JaryoDto(multi.getParameter("password"),
		realFileName);
	
		service.insert(jaryodto);
		}
		
		return actionForward;
	}
		

}
