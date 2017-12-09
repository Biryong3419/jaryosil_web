package org.comstudy21.myapp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.jaryo.JaryoDto;
import org.comstudy21.myapp.jaryo.JaryoServiceImpl;

public class DownloadService extends HttpServlet {
	Service service = new JaryoServiceImpl();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String savePath = getServletContext().getRealPath("/upload");
//String filename=(String)request.getParameter("filename");
String filename=service.search(Integer.valueOf(request.getParameter("index"))).getFilename();

InputStream in = null;
OutputStream os = null;
File file = null;
boolean skip = false;
String client ="";
System.out.println("filename =>"+filename);
//��Ʈ���� ��ü�� �غ� �Ѵ�.
//File ��ü ���� -> InputStream ��ü ����
try{
	file = new File(savePath,filename);
	in=new FileInputStream(file);
	
}catch(FileNotFoundException fne){
	skip = true;
}
//Ŭ���̾�Ʈ(������)����
client = request.getHeader("User-Agent");
//out.println(client+"<br>");

//response ������ ���� �غ�
response.reset();
response.setContentType("application/octet-stream");
response.setHeader("Content-Description", "JSP Generated Data");

//skip!=true
if(!skip){
	if(client.indexOf("MSIE")!=-1){
		//IE �� �ƴҶ�
		String newName = new String(filename.getBytes("KSC5601"),"ISO8859_1");
		response.setHeader("Content-Disposition","attachment;filename="+newName);
	}
	else{
		String newName = new String(filename.getBytes("utf-8"),"iso-8859-1");
		response.setHeader("Content-Disposition","attachment;filename="+newName);
		response.setHeader("Content-Type","application/octet-stream;charset=utf-8");
	}

	response.setHeader("Content-Length",""+file.length());
	//response���� FileOutputStream�� �޾ƿ´�.
	os = response.getOutputStream();
	byte[] by = new byte[(int)file.length()];
	int len=0;
	
	while((len=in.read(by))>0){
		os.write(by);
	}

}else{
	//���࿡ skip�̶�� --- ������ ���ٸ�
	response.setContentType("text/html;charset=EUC-KR");
	//out.println("<h1>File not found!!</h1>");
}
os.flush();
in.close();
os.close(); 
}
}
