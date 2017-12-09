<%@page import="java.util.ArrayList"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
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
/* String path = request.getParameter("path");
String savePath = getServletContext().getRealPath("/"+path);
String fileName = request.getParameter("filename");
String orgfilename = request.getParameter("orgfilename"); */
//String rowNum = request.getParameter("rownum");
//String path = (String)session.getAttribute("path");
String savePath = getServletContext().getRealPath("/upload");
//String filename = (String)session.getAttribute("fileName"+rowNum);
ArrayList<String[]> filename = (ArrayList<String[]>)request.getAttribute("list");
//String orgfilename = (String)session.getAttribute("orgfilename"+rowNum);

for(String[] a:filename){
	%>
	<%=a[0]%>
	<a href="download.doo?index=<%=a[0]%>"><%=a[2]%></a> <a href="moveDelete.do?index=<%=a[0]%>">삭제하기</a><br>
	
<%
}
%>
<hr>
<form>
<input type="text" name="search">
<input type="submit" value="검색하기">
</form>
<%-- <%

%>
 --%>

</body>
</html>