<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.PageInfo"%>
<%@page import="vo.ArticleBean"%>
<%@page import="java.util.ArrayList"%>
<%-- JSTL 라이브러리 사용을 위한 선언 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% ArrayList<ArticleBean> articleList = (ArrayList<ArticleBean>)request.getAttribute("articlebean"); %> 
<% PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sign_up</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/member/css/sign_up.css">
<style type="text/css">
#check{ margin: 0; width: 300px; }
#join{ width: 300px; }
</style>



</head>
<body>
<c:if test="${sessionScope.email == null }">
	<script>
	 		alert("로그인후 이용해 주세요.")
	 		history.back();//이전 페이지로 이동
	 	
	</script>
</c:if>



<!-- JSP INCLUDE -->
<jsp:include page="../include/top.jsp"/>

<article>
		<h1 align="center" style="font-size: 45px;">내 판매 목록</h1>
		<div class="count_search_block">
			<div class="count">
				<%if(pageInfo != null){ %>
				<input type="hidden" value="<%=pageInfo.getMaxPage() %>"> <span
					style="font-size: 18px;">[ 총 게시글 수 : <b><%=pageInfo.getListCount() %></b>
					]
				</span>
				<%} %>
			</div>
		</div>
		<article id="arti">
			<table id="notice2">

				<tbody>
					<%if(articleList != null){%>
					<tr>
						<%
						for(int i=0; i<articleList.size(); i++){
						 
						%>
						<td
							onclick="location.href='${pageContext.request.contextPath}/article_detail.jsp?num=<%=articleList.get(i).getArticle_num()%>&pageNum=<%=pageInfo.getPage()%>">
							<img src="${pageContext.request.contextPath}/<%=articleList.get(i).getArticle_img()%>" width="100"
							height="100"> 
							<b><%=articleList.get(i).getNow_price() %></b>
							<b><%=articleList.get(i).getAuction_time() %></b> 
						</td>
						<tr></tr>
						
						<%
						}//for문 종료
						%>
					<% 
					}else{//존재하지 않으면
					%>
						<tr>
							<td colspan="5">게시판 글 없음</td>	
						</tr>
					<%
					}
					%>
					
					
			</table>
	</article>

	<div class="page">
		<div class="pagebtn">
	<%if(articleList != null){
			
	%>
						<%-- <%if(pageInfo.getPage() > 1){ %> --%>
			<input name="<%=pageInfo.getPage() %>" type="button" value="<">
		<%-- <%}%> --%>
		<%for(int i=0; i<pageInfo.getMaxPage(); i++){%>	
			<input name="<%=pageInfo.getPage() %>" type="button"
							value="<%=i+1 %>">
		<%}%>
		<%-- <%if(pageInfo.getPage() != pageInfo.getMaxPage()){ %> --%>
			<input name="<%=pageInfo.getPage() %>" type="button" value=">">
		<%-- <%}%> --%>
	<%}%>
		</div>
	</div>
	

</article>
      

      

<!-- Footer -->
<jsp:include page="../include/bottom.jsp" />

</body>
</html>