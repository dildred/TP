<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sign_up</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/member/css/sign_up.css">
</head>
<body>

<!-- JSP INCLUDE -->
<jsp:include page="../include/top.jsp"/>

<article>
	<div class="sign_up_block">
		<h1 align="center">회원가입</h1>
		<form action="${pageContext.request.contextPath}/signup.mem" method="post" id="form">
			<input type="hidden" id="check" name="check" value="no" required >
			<section>
				<label for="email" id="email_label">이메일</label>
				<input id="email" type="email" name="email" required />
				<input id="email_check" type="button" value="이메일 인증" />
			</section>
			<div class="clear"></div>
			<section>
				<label for="password">비밀번호</label>
				<input id="pw" type="password" name="pw" required />
				<span>&nbsp;</span>
			</section>
			<section>
				<label for="password_check">비밀번호 확인</label>
				<input id="pw_check" type="password" name="pw_check" required />
				<span>&nbsp;</span>
			</section>
			<section>
				<label for="name">이름</label>
				<input id="name" type="text" name="name" required />
				<span>&nbsp;</span>
			</section>
			<section>
				<label for="phone">휴대폰 번호</label>
				<input id="phone" type="tel" name="phone" required />
				<span>'-'를 빼고 입력해주세요.</span>
			</section>
			<input id="join" type="submit" value="가입하기" />
		</form>
	</div>
</article>

<!-- JSP INCLUDE -->
<jsp:include page="../include/bottom.jsp"/>

<script src="${pageContext.request.contextPath}/member/js/signup.js"></script>

</body>
</html>