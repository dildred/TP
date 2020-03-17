<%@page import="email.SendEmail"%>
<%@page import="email.ImforEmail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
String to = request.getParameter("to"); //인증번호 보낼 이메일

ImforEmail emailInfo = new ImforEmail(); 
SendEmail sendEmail = new SendEmail();

String authNum = sendEmail.randomNum();

int check = sendEmail.sendEmail(to, authNum);

if(check == 1){
%>
<script>
	alert('인증 메일 발송!');
</script>
<%	
}else{
%>
<script>
	alert('인증 메일 발송 실패!');
	window.close();
</script>
<%		
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<style type="text/css">
.btn{ width: 100px; float: right; margin-top: 10px; }
</style>
</head>
<body>

<form id="reg_form" onsubmit="return check();">
	<label for="code">인증번호</label>
	<input id="code" type="text" id="code" class="textWithBtn" />
	<input type="submit" class="btn" value="확인"/>
</form>

<script type="text/javascript">
function check() {
	var code = document.getElementById("code").value;
	var authNum = <%=authNum %>;
	
	if(!code) {
		alert("인증번호를 입력하세요.");
		return false;
	}
	
	if(authNum == code) {
		alert("인증 성공!");
		opener.check.value = "ok";
		window.close();
	} else {
		alert("인증번호가 틀립니다. 다시 입력해 주세요.");
		return false;
	}
}
</script>

</body>
</html>