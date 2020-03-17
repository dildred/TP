<%@page import="vo.ArticleBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	ArticleBean article = (ArticleBean) request.getAttribute("article");
%>
<%
	String email = (String) session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
</head>
<body>

	<jsp:include page="../include/top.jsp" />

	<article>
		<div class="content_wrap">
				<h1 align="center">게시글</h1>
				<table border="1" align="center">
					<tr>
						<td rowspan="7">상품 이미지</td>
						<td rowspan="7"><img src="${pageContext.request.contextPath}/<%=article.getArticle_img()%>" width="300" height="300"></td>
						<td>판매자ID</td>
						<td id="writer"><%=article.getArticle_writer()%></td>
						<td>작성일</td>
						<td id="date"><%=article.getRegistration_date()%></td>
					</tr>
					<tr>
						<td>상품명</td>
						<td colspan="3"><%=article.getArticle_subject()%></td>
					</tr>
					<tr>
						<td>경매시작가</td>
						<td colspan="3"><%=article.getLimit_price()%></td>
					</tr>
					<tr>
						<td>유통기한</td>
						<td colspan="3"><%=article.getExpiration_date()%></td>
					</tr>
					<tr>
						<td>분류</td>
						<td colspan="3"><%=article.getClassification()%></td>
					</tr>
					<tr>
						<td>경매시간</td>
						<td colspan="3"><%=article.getAuction_time()%></td>
					</tr>
					<tr>
						<td>현재입찰가</td>
						<td colspan="3"><%=article.getNow_price()%></td>
					</tr>
				</table>
				<div class="writing_button">
					<a href="${pageContext.request.contextPath}/articleList.bo"><input class="post_btn" type="button" value="목록" /></a>
				</div>
		</div>
	</article>

	<jsp:include page="../include/bottom.jsp" />

</body>
</html>