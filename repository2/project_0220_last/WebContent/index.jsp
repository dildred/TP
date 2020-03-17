<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New index</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<style type="text/css">
#main_menu, #main_menu ul, #main_menu ul li{
	padding: 0;
	margin: 0;
	box-sizing: boder-box;
}

#main_menu{
	width: 100%;
	/* border: 1px solid black; */
	border-bottom: 1px solid #e9e9e9;
}

#main_menu ul{
	display: table;
	margin-left: auto;
	margin-right: auto;
}

#main_menu ul li{
	/* border: 1px solid black; */
	font-size: 20px;
	list-style: none;
	display: inline-block;
	width: 200px;
	text-align: center;
	line-height: 50px;
	vertical-align: middle;
}

#main_menu ul li a{
	text-decoration: none;
}

</style>
</head>
<body>
	
<jsp:include page="/include/top.jsp"/>

<div id="main_menu">
	<ul>
		<li><a href="#">홈</a></li>
		<li><a href="#">소개</a></li>
		<li><a href="#">경매</a></li>
		<li><a href="${pageContext.request.contextPath}/questionList.do">고객센터</a></li>
	</ul>
</div>

<!-- Banner -->
<section class="banner full">
	<article>
		<img src="${pageContext.request.contextPath}/images/banner1.jpg"
			alt="" />
		<div class="inner">
			<header>
				<p>현명한 소비의 시작</p>
				<h2>Wellcome to REFTYCON</h2>
			</header>
		</div>
	</article>
	<article>
		<img src="${pageContext.request.contextPath}/images/banner2.jpg"
			alt="" />
		<div class="inner">
			<header>
				<p>현명한 소비의 시작</p>
				<h3>Wellcome to REFTYCON</h3>
			</header>
		</div>
	</article>
	<article>
		<img src="${pageContext.request.contextPath}/images/banner3.jpg"
			alt="" />
		<div class="inner">
			<header>
				<p>현명한 소비의 시작</p>
				<h3>Wellcome to REFTYCON</h3>
			</header>
		</div>
	</article>
	<article>
		<img src="${pageContext.request.contextPath}/images/banner4.jpg"
			alt="" />
		<div class="inner">
			<header>
				<p>현명한 소비의 시작</p>
				<h3>Wellcome to REFTYCON</h3>
			</header>
		</div>
	</article>
	<article>
		<img src="${pageContext.request.contextPath}/images/banner5.jpg"
			alt="" />
		<div class="inner">
			<header>
				<p>현명한 소비의 시작</p>
				<h3>Wellcome to REFTYCON</h3>
			</header>
		</div>
	</article>
</section>

<article id="arti">
	<table id="notice2">
		<c:if test="${requestScope.autionsList == null }">
				<tr>
					<td colspan="5">등록된 경매가 없습니다.</td>
				</tr>
		</c:if>
		<c:if test="${requestScpoe.autionsList != null}">
				<c:set var="i" value="0" />
				<c:set var="j" value="3" />
				<c:forEach var="aution" items="${requestScpoe.autionsList}">
					<c:if test="${i%j == 0 }">
						<tr align="center">
					</c:if>

					<td
						onclick="location.href='${pageContext.request.contextPath}/aution.jsp?num=${aution.Num}'">
						<img src="/upload/${aution.image}>" width="300" height="300">
						<b>${aution.nowprice}</b>
					</td>

					<c:if test="${i%j==j-1}">
						</tr>
					</c:if>
					<c:set var="i" value="${i+1}" />
				</c:forEach>
			</c:if>
	</table>
</article>

<jsp:include page="/include/bottom.jsp"/>



</body>
</html>