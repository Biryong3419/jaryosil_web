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
String pass =(String)request.getAttribute("password");
String index=(String)request.getAttribute("index");
%>
<%=pass %>
<form>
비밀번호입력하세요<input type="text" name="delCheckPass" id="pass_input">
<input type="submit" value="삭제하기">
</form>
<script>

var form=document.forms[0];

form.onsubmit=function(){
	event.preventDefault();
	if(document.getElementById('pass_input').value!=<%=pass%>){
		alert("비밀번호가 틀렸어");
		return;
	}
	this.action="delete.do?index=<%=index%>";
	this.method="post";
	this.submit();
}
</script>
</body>
</html>