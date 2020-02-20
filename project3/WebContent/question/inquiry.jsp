<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>inquiry 문의</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/question/css/inquiry.css">
</head>
<body>
	<nav id="sub_menu">
		<ul>
			<li><a href="${pageContext.request.contextPath}/question.do">고객센터</a></li>
			<li><a href="${pageContext.request.contextPath}/inquiry.do">1:1문의하기</a></li>
			<li><a href="#">신고하기</a></li>
			<li><a href="${pageContext.request.contextPath}/myquestion.do">내 문의 내역</a></li>
			<li><a href="#">내 신고 내역?</a></li>
		</ul>
	</nav>
	<article>
		<div class="inquiry_wrap">
			<div class="inquiry_input">
				<h1 align="center">1:1 문의하기</h1>
				<form action="${pageContext.request.contextPath}/questionWritePro.do" method="post" id="questionWrite_form">
					<table>
						<tr>
							<th>작성자</th>
							<td>
								<input type="text" id="Email" name="Email">
							</td>
						</tr>
						<tr>
							<th scope="row">상담분류</th>
							 <td>
								<select style="width:280px; height:30px" title="문의분야 선택" class="select_st">
									<option value="">뭐</option>
									<option value="">하</option>
									<option value="">지</option>
									<option value="">?</option>
								</select>
							</td> 
						</tr>
						<tr>
							<th>문의제목</th>
							<td>
								<input type="text" id="title" name="title">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>
								<textarea rows="30" cols="10" id="comment" name="comment"></textarea>
							</td>
						</tr>
					</table>
					<div class="inquiry_button">
						<input class="button" id="inquiry_submit" type="submit" value="등록">
						<input class="button" type="reset" value="다시쓰기">
						<input class="button" type="button" value="목록" onclick="javascript:history.go(-1)">
					</div>
					
				</form>
			</div>
		</div>
	</article>
		<script src="${pageContext.request.contextPath}/question/js/jquery-3.4.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/question/js/writing.js"></script>

</body>
</html>