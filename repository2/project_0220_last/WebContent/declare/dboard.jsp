<%@page import="vo.BoardPageInfo"%>
<%@page import="vo.BoardDeclaBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<BoardDeclaBean> declaList = (ArrayList<BoardDeclaBean>)request.getAttribute("declaList"); %>
<% BoardPageInfo bpageInfo = (BoardPageInfo)request.getAttribute("bpageInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DeclareBoard</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/templated-intensify/assets/css/main.css">
</head>
<body>
	<article>
		<h1 align="center" style="font-size: 45px;">신고 게시판</h1>
		<div class="count_search_block">
			<div class="count">
			<%if(bpageInfo != null){ %>
				<input type="hidden" value="<%=bpageInfo.getMaxPage() %>">
				<span style="font-size: 18px;">[ 총 게시글 수 : <b><%=bpageInfo.getListCount() %></b> ]</span>
			<%} %>
			</div>
		</div>
		<table>
			<thead>
				<tr>
					<td class="num" align="center"><b>번호</b></td>
					<td class="title" align="left"><b>제목</b></td>
					<td class="suspect" align="center"><b>신고자</b></td>
					<td class="attacker" align="center"><b>가해자</b></td>
					<td class="date" align="center"><b>작성일</b></td>
					<td class="views" align="center"><b>조회수</b></td>
				</tr>
			</thead>
			<tbody>
			<%if(declaList != null){%>
				<%for(int i=0; i<declaList.size(); i++){%>
				<tr id="row">
					<td class="num" align="center"><%=declaList.get(i).getDecla_Num() %></td>
					<td class="title" align="left">
				<%if(declaList.get(i).getDecla_re_lev() > 0){ %>
					<%for(int j=1; j<declaList.get(i).getDecla_re_lev(); j++){ %>
						<img src="${pageContext.request.contextPath}/images/reply/blank.gif" alt="화살표이미지">
					<%} %>
						<img src="${pageContext.request.contextPath}/images/reply/arrow.png" alt="화살표이미지">
				<%} %>
					<%=declaList.get(i).getDecla_Title() %></td>
					<td class="suspect" align="center"><%=declaList.get(i).getSuspect_Email() %></td>
					<td class="attacker" align="center"><%=declaList.get(i).getAttacker_Email() %></td>	
					<td class="date" align="center"><%=declaList.get(i).getDecla_writeDate() %></td>
					<td class="views" align="center"><%=declaList.get(i).getDecla_readCount() %></td>
				</tr>
				<%}%>
			<%}else{%>
				<tr>
					<td align="center" colspan="6">등록된 게시글이 없습니다.</td>
				</tr>
			<%}%>
			
			</tbody>
		</table>
		<div class="page">
			<div class="pagebtn">
		<%if(declaList != null){%>
			<%-- <%if(pageInfo.getPage() > 1){ %> --%>
				<input name="<%=bpageInfo.getPage() %>" type="button" value="<">
			<%-- <%}%> --%>
			<%for(int i=0; i<bpageInfo.getMaxPage(); i++){%>	
				<input name="<%=bpageInfo.getPage() %>" type="button" value="<%=i+1 %>">
			<%}%>
			<%-- <%if(pageInfo.getPage() != pageInfo.getMaxPage()){ %> --%>
				<input name="<%=bpageInfo.getPage() %>" type="button" value=">">
			<%-- <%}%> --%>
		<%}%>
			</div>
		</div>
		<div align="right" class="writing">
			<input type="button" value="글쓰기">
		</div>
	</article>
	<script src="${pageContext.request.contextPath }/declare/js/jquery-3.4.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/declare/js/dboard.js"></script>
</body>
</html>