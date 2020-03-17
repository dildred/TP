<%@page import="vo.PageInfo"%>
<%@page import="vo.ArticleBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% ArrayList<ArticleBean> articleList = (ArrayList<ArticleBean>)request.getAttribute("articleList"); %>
<% PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New index</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<script type="text/javascript"
	src="${pageCSntext.request.contextPath}/assets/js/jquery-3.1.1.js"></script>
</head>
<body>
	<jsp:include page="/include/top.jsp" />
	<article>
		<h1 align="center" style="font-size: 45px;">진행중인 경매</h1>
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
						<%int f=0;
						for(int i=0; i<articleList.size(); i++){
						f++;
							if(!(f%3==0)){ 
						%>
						<td
							onclick="location.href='${pageContext.request.contextPath}/articleDetail.bo?article_num=<%=articleList.get(i).getArticle_num()%>'">
							<img src="${pageContext.request.contextPath}/<%=articleList.get(i).getArticle_img()%>" width="300"
							height="300"> 
							<b><%=articleList.get(i).getNow_price() %></b>
							<b><%=articleList.get(i).getAuction_time() %></b>
						</td>

						<%  }else{//if문 종료 %>


						<td	onclick="location.href='${pageContext.request.contextPath}/articleDetail.bo?article_num=<%=articleList.get(i).getArticle_num()%>'">
							<img src="${pageContext.request.contextPath}/<%=articleList.get(i).getArticle_img()%>" width="300"
							height="300"> 
							<b><%=articleList.get(i).getNow_price() %></b>
							<b><%=articleList.get(i).getAuction_time() %></b>
						</td>
					</tr>
					<tr>
						<%
						}
						}//for문 종료%>
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
	<div class="writing">
		<input type="button" value="글쓰기">
	</div>

					</article>

<jsp:include page="/include/bottom.jsp" />

</body>
</html>