<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>multiFileUploadClient.jsp</title>
</head>
<body>
<h1>업로드하기</h1>
<fieldset>
	<legend>다중 파일 업로드</legend>
	<form>
	파일비밀번호: <input type="text" name="password">
		<br>
		파일:
			<input type="button" value="파일추가" id="addFileBtn">
			<input type="button" value="파일제거" id="delFileBtn">
			<hr>
			<div id="fileArea">
			<input type="file" name="upfile1">
			</div>
			<hr>
			<br>
	<input type="submit" value="전송하기">
	</form>

</fieldset>
<script>
var form=document.forms[0];
var addFileBtn = document.getElementById("addFileBtn");
var delFileBtn= document.getElementById("delFileBtn");
var fileArea = document.getElementById("fileArea");
var cnt=1;

form.onsubmit = function(){
	event.preventDefault();//일단 멈춤
	
	//파일 선택 여부 - 유효성 검사
	var inputs = fileArea.getElementsByTagName('input');
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].value==""){
			alert('파일을 선택하세요!');
			inputs[i].focus();
			return;
		}
	}
	
	this.action="upload.do";
	this.method="post";
	this.enctype="multipart/form-data";
	this.submit();
}

addFileBtn.onclick = function(){
	if(cnt<10){
		cnt++;
		var element = document.createElement("input");
		element.type="file";
		element.name="upfile"+cnt;
		
		fileArea.appendChild(element);
		fileArea.appendChild(document.createElement("br"));
	}else{
		alert("파일은 10개까지 추가 가능하다.");
	}
};

delFileBtn.onclick=function(){
	if(cnt>1){
		cnt--;
		var inputs = fileArea.getElementsByTagName('input');
		var brArr = fileArea.getElementsByTagName('br');
		console.dir(inputs[cnt]);
		//fileArea.removeChild(inputs[cnt].nextElementSibling);
		fileArea.removeChild(brArr[brArr.length-1]);
		fileArea.removeChild(inputs[inputs.length-1]);
	}else{
		alert("파일을 최소 1개는 업로드 바랍니다.");
	}
};


</script>
</body>
</html>