<%@ page import = "vo.QuestionBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% QuestionBean article = (QuestionBean)request.getAttribute("article"); %>
<% String Email = (String)session.getAttribute("Email"); %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/declare/css/dwriting.css">
</head>
<body>

	<!-- JSP INCLUDE -->
	<jsp:include page="../include/top.jsp"/>

	<article>
		<div class="post_block">
		<%if(article.getRe_lev() == 0){ %>
			<h1 align="center">문의글</h1>
		<%} else{ %>
			<h1 align="center">답글</h1>
		<%} %>
			<input id="question_num" type="hidden" value="<%=article.getQuestion_num() %>">		
			<input id="re_ref" type="hidden" value="<%=article.getRe_ref() %>">
			<input id="re_lev" type="hidden" value="<%=article.getRe_lev() %>">
			<input id="re_step" type="hidden" value="<%=article.getRe_step() %>">
			<table>
				<tr>
					<th>작성자</th>
					<td id="writer"><%=article.getQuestion_Email() %></td>
					<th>작성일</th>
					<td id="date"><%=article.getQuestion_date() %></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><%=article.getQuestion_title() %></td>
				</tr>
				<tr style="height:340px;">
					<th>문의 내용</th>
					<td valign="top" style="padding-top: 8px; padding-bottom:8px;" colspan="3"><%=article.getQuestion_comment() %></td>
				</tr>
			</table>
			<div class="post_btn_block">
				<input class="post_btn" type="button" value="목록" />
				<input class="post_btn" type="button" value="답글" />
				<input class="post_btn" type="button" value="수정" />
				<input class="post_btn" type="button" value="삭제" />
			</div>
		</div>
	</article>
	
	<!-- JSP INCLUDE -->
	<jsp:include page="../include/bottom.jsp"/>

<script src="${pageContext.request.contextPath }/question/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath }/question/js/post.js"></script>

</body>
</html>