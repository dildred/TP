<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL 라이브러리 사용을 위한 선언 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">
	
	function changePw() {
		//패스워드 입력하지 않았을 때
		if(document.getElementById("pw").value==""){
			alert("암호를 입력하세요.");
			return false;
		//패스워드가 맞지 않다면
		}else if($('#pw').val() != "${member.pw}"){
			alert("비밀번호가 서로 일치하지 않아요.");
			return false;
		//패스워드 맞다면
		}else {
			//popup -> 비밀번호 변경 페이지 이동
			//페이지 이동 말고 
			 $("div").show();
		}
	}
function pwupdate(){
	if($('#pw1').val() != $('#pw2').val()){
	
		alert("비밀번호가 서로 일치하지 않습니다.");
		
		return false;
	}else{
		
		alert("비밀번호가 서로 일치합니다.");
		$("div").hide();
		document.getElementById("pw").value = document.getElementById("pw1").value;
	}
	
	
}

</script>


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

<!-- JSP INCLUDE -->
<jsp:include page="../include/top.jsp"/>


      
	<!-- 회원정보수정 -->
	<form action="${pageContext.request.contextPath}/memberupdate.mem" method="post" id="regform">
		<table class="boardList" width="800px" height="300px" style="margin: auto;">
			<tr >
				<td  width="150" rowspan="7" id="profileImg"></td>
				<!--id값 가져오기 -->
				<td  width="100" class="info_title">아이디 </td>
				<td  width="400">${member.email}</td>
				<input type="hidden" name="email" id="email" value="${member.email}"/>
			</tr>
			<tr >
				<!-- date값 가져오기 -->
				<td  width="100" class="info_title">가입날짜 </td>
				<td  width="400">${member.date}</td>
			</tr>
			<tr >
				<!-- pw값 가져오기 -->
				<td  width="100" class="info_title">비밀번호 </td>
				<td  width="300">
					<input type="password" name="pw" id="pw" required="required" style="margin-left: 98px;"/>
					<input type="button" value="비밀번호변경"  onclick="changePw();" id="show" class="info_btn"/><br/>
					
					<div style="display: none;">
					새로운 비밀번호 <input type="password" id="pw1" name="pw1" /><br/>
					새로운 비밀번호(확인) <input type="password" id="pw2" name="pw2" />
					<input type="button" id="" onclick="pwupdate()" value="변경완료" class="info_btn">
					</div>
					
				</td>
			</tr>
			<tr >
				<!-- name값 가져오기 -->
				<td  width="100" class="info_title">이 름 </td>
				<td  width="400">
					<input type="text" name="name" id="name" required="required" value="${member.name}" />
				</td>
			</tr>
			<tr >
				<!-- phone값 가져오기 -->
				<td  width="100" class="info_title">전화번호 </td>
				<td  width="400">
					<input type="text" name="phone" id="phone" required="required" value="${member.phone}"/>
				</td>
			</tr>
			<tr>
				<!-- 업데이트 버튼 -->
				<td colspan="2" align="left" id="modify_btns">
					<input type="submit" value="UPDATE" onclick="" class="info_btn"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="RESET" onclick=""  class="info_btn" style="margin-right: 140px;"/>
				</td>
			</tr>
		</table> 
	</form>
      
      

<!-- JSP INCLUDE -->
<jsp:include page="../include/bottom.jsp"/>


</body>
</html>