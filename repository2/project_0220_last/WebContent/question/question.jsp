<%@page import="vo.PageInfo"%>
<%@page import="vo.QuestionBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% ArrayList<QuestionBean> articleList = (ArrayList<QuestionBean>)request.getAttribute("articleList"); %>
<% PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>service center</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/question/css/question.css">
</head>
<body>

	<!-- JSP INCLUDE -->
	<jsp:include page="../include/top.jsp"/>

	<article>
		<h1 align="center" style="font-size: 45px;">무엇을 도와 드릴까요?</h1>
	
	<nav id="sub_menu">
		<ul>
			<li><a href="${pageContext.request.contextPath}/questionList.do">고객센터</a></li>
			<li><a href="${pageContext.request.contextPath}/questionWrite.do">1:1문의하기</a></li>
			<li><a href="${pageContext.request.contextPath}/dboardList.brd">신고하기</a></li>
			<li><a href="${pageContext.request.contextPath}/questionList.do">내 문의 내역</a></li>
			<li><a href="#">내 신고 내역?</a></li>
		</ul>
	</nav>
	<div class="count_search_block">
		<div class="count">
		<%if(pageInfo != null){ %>
			<input type="hidden" value="<%=pageInfo.getMaxPage() %>">
			<span style="font-size: 18px;">[ 총 게시글 수 : <b><%=pageInfo.getListCount() %></b> ]</span>
		<%} %>
		</div>
	</div>
	<table>
		<thead> 
			<tr>
				<th align="center" class="num">번호</th>
				<th align="center" class="title">제목</th>
				<th align="center" class="Email">작성자</th>
				<th align="center" class="date">작성일</th>
			</tr>
		</thead>
		<tbody>
			<%if(articleList != null) {%>
			<%for(int i = 0; i < articleList.size(); i++) {%>
			<tr id="row">
				<td align="center" class="num"><%=articleList.get(i).getQuestion_num()%></td>
				<td align="left" class="title">
			<%if (articleList.get(i).getRe_lev() > 0) {%>
				<%for (int j = 1; j < articleList.get(i).getRe_lev(); j++) { %>		
					<img src="${pageContext.request.contextPath}/images/reply/blank.gif" alt="화살표이미지"> 
					<%} %> 		
					<img src="${pageContext.request.contextPath}/images/reply/arrow.png" alt="화살표이미지"> 
					<%} %>
					<%=articleList.get(i).getQuestion_title()%></td>
				<td align="left" class="Email"><%=articleList.get(i).getQuestion_Email()%></td>
				<td align="center" class="date"><%=articleList.get(i).getQuestion_date()%></td>
			</tr>
			<%}%>
	<%}else{%>
<tr>
	<td align="center" colspan="5">등록된 게시글이 없습니다.</td>
</tr>
<%}%>
	</tbody>
</table>
<div class="page">
	<div class="pagebtn">
		<%if (articleList != null) {%>
		<%-- <%if(pageInfo.getPage() > 1){ %> --%>
			<input name="<%=pageInfo.getPage()%>" type="button" value="<">
		<%-- <%}%> --%>
		<%for (int i = 0; i < pageInfo.getMaxPage(); i++) {	%>
			<input name="<%=pageInfo.getPage()%>" type="button" value="<%=i + 1%>">
		<%}	%>
		<%-- <%if(pageInfo.getPage() != pageInfo.getMaxPage()){ %> --%>
			<input name="<%=pageInfo.getPage()%>" type="button" value=">">
		<%-- <%}%> --%>
		<%}	%>
	</div>
</div>
	<div class="writing">
		<input type="button" value="글쓰기" >
	</div>
</article>

<!-- JSP INCLUDE -->
<jsp:include page="../include/bottom.jsp"/>

<script
	src="${pageContext.request.contextPath }/question/js/jquery-3.4.1.min.js"></script>
<script
	src="${pageContext.request.contextPath }/question/js/question.js"></script>

</body>
</html>