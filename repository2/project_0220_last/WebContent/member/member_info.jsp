<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL 라이브러리 사용을 위한 선언 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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


      
      <form action="${pageContext.request.contextPath}/membermodify.mem" method="post" id="regform" style="width: 30%; margin: 0 auto;">
      
      
     <table class="boardList">
         
         <tr align="center">
            <!--email값 가져오기 -->
            <td class="info_title" align="center" width="100">이메일 :</td>
            <td align="center" width="400">${member.email}</td>
            <input type="hidden" name="email" id="email" value="${member.email}"/>
         </tr>
         
         
         <tr align="center">
            <!-- date값 가져오기 -->
            <td class="info_title" align="center" width="100">가입날짜 : </td>
            <td align="center" width="400">${member.date}</td>
         </tr>
         
         <tr align="center">
            <!-- name값 가져오기 -->
            <td class="info_title" align="center" width="100">이 름 :</td>
            <td align="center" width="400">${member.name}</td>
         </tr>
         
         <tr align="center">
            <!-- phone값 가져오기 -->
            <td class="info_title" align="center" width="100">전화번호 :</td>
            <td align="center" width="400">${member.phone}</td>
         </tr>
            
         <tr>        
            <td colspan="2" align="right">
            	<c:if test="${sessionScope.email != null }">
               <input type="submit" value="수정" onclick="" class="info_btn"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               </c:if>
            </td> 
         </tr>
      </table> 
   </form>
      
      

<!-- Footer -->
<jsp:include page="../include/bottom.jsp" />

</body>
</html>