<%@page import="org.comstudy21.myapp.jaryo.JaryoServiceImpl"%>
<%@page import="org.comstudy21.myapp.service.Service"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>���ڡٷ�ٽǡ�</h1>
<hr>
�ݰ����ϴ�.<br>
�ѹ湮�ڼ� :<br>
<%Service service = new JaryoServiceImpl();



%>
<ul>
<li><a href="jaryosil/moveUpload.do">���ε� �ϱ�</a></li>
<li><a href="jaryosil/moveList.do">���� ��ȸ</a></li>
</ul>

</body>
</html>