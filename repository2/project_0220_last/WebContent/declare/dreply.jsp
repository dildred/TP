<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String decla_Num = request.getParameter("decla_Num"); %>
<% String decla_re_ref = request.getParameter("decla_re_ref"); %>
<% String decla_re_lev = request.getParameter("decla_re_lev"); %>
<% String decla_re_seq = request.getParameter("decla_re_seq"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>writing</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/declare/css/dwriting.css">
</head>
<body>

	<!-- JSP INCLUDE -->
	<jsp:include page="../include/top.jsp"/>
	
<article>
	<div class="writing_wrap">
		<div class="writing_input">
			<h1 align="center">답글 달기</h1>
			<form action="${pageContext.request.contextPath}/boardDeclaReply.brd" method="post" id="reply_form">
				<input type="hidden" value="<%=decla_Num %>" name="decla_Num">
				<input type="hidden" value="<%=decla_re_ref %>" name="decla_re_ref">
				<input type="hidden" value="<%=decla_re_lev %>" name="decla_re_lev">
				<input type="hidden" value="<%=decla_re_seq %>" name="decla_re_seq">
				<table>
					<tr>
						<th>작성자</th>
						<td>
							<input type="text" id="writer" name="writer">
						</td> 
					</tr>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" id="title" name="title">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea rows="20" cols="10" id="content" name="content"></textarea>
						</td>
					</tr>
				</table>
				<div class="writing_button">
					<input class="button" id="reply_submit" type="button" value="확인">
					<input class="button" type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</article>

<!-- JSP INCLUDE -->
<jsp:include page="../include/bottom.jsp"/>

<script src="${pageContext.request.contextPath}/declare/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/declare/js/dwriting.js"></script>
</body>
</html>