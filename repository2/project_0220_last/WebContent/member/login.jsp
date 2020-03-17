<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL 라이브러리 사용을 위한 선언 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String result = (String)request.getAttribute("email"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/member/css/login.css">
</head>
<body>
<!-- JSP INCLUDE -->
<jsp:include page="../include/top.jsp"/>

<% if("err".equals(result)){ %>
<script> alert('아이디 또는 비밀번호가 다릅니다.'); </script>
<% } %>
    <section id ="loginFormArea">
	<h1>로그인</h1>
	<form action="${pageContext.request.contextPath}/login.mem" method="POST">
		<fieldset>
			<table>
				<tr>
					<td class="td_left">
					<label for="id">이메일 : </label>
					</td>
					<td class="td_right">
					<input type="text" name="email" id="email"/>
					</td>
				</tr>
				<tr>
					<td class = "td_left">
					<label for = "passwd">비밀번호 : </label>
					</td>
					<td class = "td_right">
					<input type = "password" name = "pw" id = "passwd"/>
					</td>
				</tr>
			</table>
			
			<input type = "submit" value = "로그인" id = "selectButton"/>
		</fieldset>
	</form>
	</section>
</body>
</html>
<!-- JSP INCLUDE -->
<jsp:include page="../include/bottom.jsp"/>
</body>
</html>