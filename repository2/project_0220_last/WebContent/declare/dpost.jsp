<%@page import="vo.BoardDeclaBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% BoardDeclaBean declare = (BoardDeclaBean)request.getAttribute("declare"); %>
<% String suspect_Email = (String)session.getAttribute("suspect_Email"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dPost</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/templated-intensify/assets/css/main.css">
</head>
<body>
	<!-- JSP INCLUDE -->
	<jsp:include page="../include/top.jsp"/>
	
	<article>
	<div class="post_block">
	<%if(declare.getDecla_re_lev() == 0){ %>
		<h1 align="center">게시글</h1>
	<%} else{%>
		<h1 align="center">답글</h1>
	<%} %>
		<input id="decla_Num" type="hidden" value="<%=declare.getDecla_Num() %>">
		<input id="decla_re_ref" type="hidden" value="<%=declare.getDecla_re_ref() %>">
		<input id="decla_re_lev" type="hidden" value="<%=declare.getDecla_re_lev() %>">
		<input id="decla_re_seq" type="hidden" value="<%=declare.getDecla_re_seq() %>">
		<table>
			<tr>
				<th><b>신고자</b></th>
				<td id="suspect"><%=declare.getSuspect_Email() %></td>
				<th><b>가해자</b></th>
				<td id="attacker"><%=declare.getAttacker_Email() %></td>
			</tr>
			<tr>	
				<th><b>기프티콘 등록번호</b></th>
				<td id="item"><%=declare.getDecla_Item() %></td>
				<th><b>작성일</b></th>
				<td id="date"><%=declare.getDecla_writeDate() %></td>
			</tr>
			<tr>
				<th><b>제목</b></th>
				<td colspan="4"><%=declare.getDecla_Title() %></td>
			</tr>
			<tr style="height: 340px;">
				<th><b>내용</b></th>
				<td valign="top" style="padding-top: 8px; padding-bottom: 8px;" colspan="3"><%=declare.getDecla_Content() %></td>
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

<script src="${pageContext.request.contextPath }/declare/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath }/declare/js/dpost.js"></script>
</body>
</html>