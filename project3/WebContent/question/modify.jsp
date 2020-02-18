<%@page import="vo.QuestionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% QuestionBean article = (QuestionBean)request.getAttribute("article"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/question/css/writing.css">
</head>
<body>

<article>
	<div class="writing_wrap">
		<div class="writing_input">
			<h1 align="center">게시글 수정</h1>
			<form action="${pageContext.request.contextPath}/QuestionModifyPro.bo" method="post" id="modify_form">
				<input type="hidden" value="<%=article.getQuestion_num() %>" name="Question_num">
				<table>
					<tr>
						<th>작성자</th>
						<td>
							<input type="text" id="writer" name="writer" value="<%=article.getQuestion_Email() %>">
						</td> 
					</tr>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" id="subject" name="subject" value="<%=article.getQuestion_title() %>">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea rows="30" cols="10" id="content" name="content"><%=article.getQuestion_comment() %></textarea>
						</td>
					</tr>
					<%-- <tr>
						<th>비밀번호</th>
						<td>
							<input type="text" id="password" name="password" value="<%=article.getQuestion_pass() %>">
						</td>
					</tr> --%>
				</table>
				<div class="writing_button">
					<input class="button" id="modify_submit" type="button" value="수정하기">
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