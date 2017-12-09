<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String saveDirectory = getServletContext().getRealPath("/upload");
int maxPostSize= 5000000;

out.println(saveDirectory);

MultipartRequest multi = new MultipartRequest(request,saveDirectory,
		maxPostSize,"EUC-KR",new DefaultFileRenamePolicy());
Enumeration en = multi.getFileNames();
int cnt=0;
while(en.hasMoreElements()){
	
	String paramName=(String)en.nextElement();
	String originFileName=multi.getOriginalFileName(paramName);
	String realFileName=multi.getFilesystemName(paramName);
	
	out.println("paramname!!!!=>"+paramName+",,,,,,,"+originFileName+" : "+ realFileName + "<br>");
	session.setAttribute("path","upload");
	session.setAttribute("fileName"+cnt,realFileName);
	session.setAttribute("orgfilename"+cnt,originFileName);
%>
<!-- 여기는 HTML 영역 -->
<a href="download.jsp?rownum=<%=cnt%>"><%=originFileName%></a>
<hr>
<%
cnt++;
}
%>
</body>
</html>