
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>inquiry 문의</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/declare/css/dwriting.css">
</head>
<body>

	<!-- JSP INCLUDE -->
	<jsp:include page="../include/top.jsp"/>


	<article>
		<div class="writing_wrap">
			<div class="writing_input">
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
<!-- 							<th scope="row">상담분류</th>
							 <td>
								<select style="width:280px; height:30px" title="문의분야 선택" class="select_st">
									<option value="">계정 관련</option>
									<option value="">사기 관련</option>
									<option value="">?</option>
									<option value="">!</option>
								</select>
							</td>  -->
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
						<tr>
							<th>비밀번호</th>
						<td>
							<input type="text" id="passwd" name="passwd">
						</td>
					</tr>
					</table>
					<div class="writing_button">
						<input class="button" id="writing_submit" type="submit" value="등록">
						<input class="button" type="reset" value="다시쓰기">
						<input class="button" type="button" value="목록" onclick="javascript:history.go(-1)">
					</div>
					
				</form>
			</div>
		</div>
	</article>
	
		<!-- JSP INCLUDE -->
		<jsp:include page="../include/bottom.jsp"/>
	
		<script src="${pageContext.request.contextPath}/question/js/jquery-3.4.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/question/js/writing.js"></script>

</body>
</html>