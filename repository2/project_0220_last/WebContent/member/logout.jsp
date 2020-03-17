<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//Session내장객체 메모리에 저장된 값 제거
	session.invalidate();


	//response.sendRedirect("../index.jsp");

	//"로그아웃"메세지창
	//index.jsp 재요청해서 이동
	
%> 
<script>
	window.alert("로그아웃");
	location.href = "../index.jsp";
</script>     
    
    
    
    
    
    
    