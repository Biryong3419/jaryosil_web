<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>multiFileUploadClient.jsp</title>
</head>
<body>
<h1>���ε��ϱ�</h1>
<fieldset>
	<legend>���� ���� ���ε�</legend>
	<form>
	���Ϻ�й�ȣ: <input type="text" name="password">
		<br>
		����:
			<input type="button" value="�����߰�" id="addFileBtn">
			<input type="button" value="��������" id="delFileBtn">
			<hr>
			<div id="fileArea">
			<input type="file" name="upfile1">
			</div>
			<hr>
			<br>
	<input type="submit" value="�����ϱ�">
	</form>

</fieldset>
<script>
var form=document.forms[0];
var addFileBtn = document.getElementById("addFileBtn");
var delFileBtn= document.getElementById("delFileBtn");
var fileArea = document.getElementById("fileArea");
var cnt=1;

form.onsubmit = function(){
	event.preventDefault();//�ϴ� ����
	
	//���� ���� ���� - ��ȿ�� �˻�
	var inputs = fileArea.getElementsByTagName('input');
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].value==""){
			alert('������ �����ϼ���!');
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
		alert("������ 10������ �߰� �����ϴ�.");
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
		alert("������ �ּ� 1���� ���ε� �ٶ��ϴ�.");
	}
};


</script>
</body>
</html>