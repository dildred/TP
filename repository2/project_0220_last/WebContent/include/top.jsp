<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
</head>
<body>

<!-- Header -->
<header id="header">
	<nav class="left">
		<a href="#menu"><span>Menu</span></a>
	</nav>
	
	<a href="${pageContext.request.contextPath}/index.jsp" class="logo">reftycon</a>

	<nav class="right">
		<c:if test="${sessionScope.email == null }">
			<a href="${pageContext.request.contextPath}/member/sign_up.jsp" class="button alt">Sign up</a> 
			<a href="${pageContext.request.contextPath}/member/login.jsp" class="button alt">Log in</a>
		</c:if>
		<c:if test="${sessionScope.email != null }">
			<a href="mypage.mem?email=${sessionScope.email}" class="button alt">mypage</a>
			<a href="${pageContext.request.contextPath}/member/logout.jsp" class="button alt">Logout</a>
		</c:if>
	</nav>
</header>

<!-- Menu -->
<nav id="menu">
	<ul class="links">
		<li><a href="index.jsp">Home</a></li>
	</ul>
	
	<ul class="links">
		<li><a href="generic.html">Introduce</a></li>
	</ul>
	
	<ul class="links">
		<li id="m1"><a href="elements.html">Auction</a></li>
		<div id="hover_menu">
			<ul id="hm1">
				<li class="inner"><a href="articleList.bo?pageNum=1">Ongoing auction</a></li>
				<li class="inner"><a href="articleModify.bo?email=${sessionScope.email}">Item registration</a></li>
			</ul>
		</div>
	</ul>
	
	<ul class="links">
		<li id="m2"><a href="elements.html">Report & Inquiry</a></li>
		<div id="hover_menu1">
			<ul id="hm1">
				<li class="inner"><a href="${pageContext.request.contextPath}/dboardList.brd">Report</a></li>
				<li class="inner"><a href="${pageContext.request.contextPath}/questionList.do">Inquire</a></li>
			</ul>
		</div>
	</ul>
	
	<ul class="links">
		<li id="m3"><a href="#">mypage</a></li>
		<div id="hover_menu2">
			<ul id="hm1">
				<li class="inner"><a href="mypage.mem?email=${sessionScope.email}">Edit information</a></li>
				<li class="inner"><a href="articleSelllistAction.bo?email=${sessionScope.email}">Sell List</a></li>
				<li class="inner"><a href="#">Purchase list</a></li>
				<li class="inner"><a href="#">Report & Inquiry History</a></li>
			</ul>
		</div>
	</ul>
</nav>
	
</body>
</html>