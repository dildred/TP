<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String question_num = request.getParameter("question_num"); %>
<% String re_ref = request.getParameter("re_ref"); %>
<% String re_lev = request.getParameter("re_lev"); %>
<% String re_step = request.getParameter("re_step"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>writing</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/declare/css/dwriting.css">ss">
</head>
<body>

<article>
	<div class="writing_wrap">
		<div class="writing_input">
			<h1 align="center">답글 달기</h1>
			<form action="${pageContext.request.contextPath}/questionReply.do" method="post" id="writer_form">
				<input type="hidden" value="<%=question_num %>" name="question_num">
				<input type="hidden" value="<%=re_ref %>" name="re_ref">
				<input type="hidden" value="<%=re_lev %>" name="re_lev">
				<input type="hidden" value="<%=re_step %>" name="re_step">
				<table>
					<tr>
						<th>작성자</th>
						<td>
							<input type="text" id="Email" name="Email">
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
							<textarea rows="30" cols="10" id="comment" name="comment"></textarea>
						</td>
					</tr>
				 	<tr>
						<th>비밀번호</th>
						<td>
							<input type="text" id="passwd" name="passwd">
						</td>
					</tr>
				</table>
				<div class="writing_button">
					<input class="button" id="writing_submit" type="button" value="등록">
					<input class="button" type="reset" value="다시쓰기">
				</div>
			</form>
		</div>
	</div>
</article>

<script src="${pageContext.request.contextPath}/question/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/question/js/writing.js"></script>
</body>
</html>