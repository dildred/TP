<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>writing</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/declare/css/dwriting.css">
</head>
<body>

<article>
	<div class="writing_wrap">
		<div class="writing_input">
			<h1 align="center">신고글 작성</h1>
			<form action="${pageContext.request.contextPath}/boardDeclaWrite.brd" 
				  method="post" id="writer_form">
				<table>
					<tr>
						<th>신고자</th>
						<td>
							<input type="text" id="suspect_Email" name="suspect_Email">
						</td> 
					</tr>
					<tr>
						<th>가해자</th>
						<td>
							<input type="text" id="attacker_Email" name="attacker_Email">
						</td> 
					</tr>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" id="decla_Title" name="decla_Title">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea rows="20" cols="10" id="decla_Content" name="decla_Content"></textarea>
						</td>
					</tr>
					<tr>
						<th>기프티콘 등록번호</th>
						<td>
							<input type="text" id="decla_Item" name="decla_Item">
						</td>
					</tr>
				</table>
				<div class="writing_button">
					<input class="button" id="writing_submit" type="button" value="확인">
					<input class="button" type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</article>

<script src="${pageContext.request.contextPath}/declare/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/declare/js/dwriting.js"></script>
</body>
</html>