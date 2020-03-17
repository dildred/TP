<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	src="${pageContext.request.contextPath}/assets/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#limit_price').on('change', function() {
			var n = $(this).val();
			if (n % 100 != 0) {
				alert("100원 단위로 입력해주세요");
				n = Math.floor(n / 100) * 1000;
				$(this).val(n);
			}
		});
	});

	function loadImg(value) {
		if (value.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#" + value.name + "_img").attr('src', e.target.result);
				$("#" + value.name + "_img").show();
			}
			reader.readAsDataURL(value.files[0]);
		}
	}
</script>
</head>
<body>
<c:if test="${sessionScope.email == null }">
	<script>
	 		alert("로그인후 이용해 주세요.")
	 		history.back();//이전 페이지로 이동
	 	
	</script>
</c:if>

	<jsp:include page="/include/top.jsp" />


	<FORM name="writeForm" class="mp-form-insert"
		action="${pageContext.request.contextPath}/articleWrite.bo" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="email" value="${sessionScope.email }" />

		<DIV class="mp-content content-insert-page" style="margin-left: 0;">
			<DIV class="content_header">
				<DIV class="mp-title-insert-myitem mp-hidetext">경매 상품 등록</DIV>
			</DIV>

			<DIV class="mp-block">

				<H1 class="section_title">1. 물품 사진 등록</H1>
				<DIV class="mp-block">
					<P>
						<SPAN class="mp-important">*</SPAN> 판매하실 물품의 대표 사진을 등록해주세요.
					</P>
					<DIV class="mp-imagefile-upload">
						<IMG class="preview"
							style="display: none; width: 400px; height: 400px;"
							alt="your image" src="" id="thumnail1_img">
						<DIV class="mp-no-image">
							<img src="${pageContext.request.contextPath}/images/camera.png"
								style="width: 50px" class="ca" />
						</DIV>
						<INPUT name="thumnail1" class="insertImage" type="file" size="1"
							onchange="loadImg(this)">
					</DIV>
					<DIV class="mp-clearfix"></DIV>
				</DIV>
				<DIV class="mp-clearfix"></DIV>
			</DIV>
			<DIV class="mp-block">
				<H1 class="section_title">2. 경매 정보 등록</H1>
				<DIV class="mp-block">
					<SECTION class="mp-section">
						<LABEL class="mp-label" for="title">경매 글 제목</LABEL> <INPUT
							name="subject" title="제목" class="mp-input input-full" id="subject"
							type="text">
						<P class="description">상품명만 입력하시기 바랍니다. (예. 아이패드 셀룰러 16GB, 캐논
							60D)</P>
					</SECTION>


					<SECTION class="mp-section">
						<LABEL class="mp-label" for="limit_price">경매시작가</LABEL> <INPUT
							name="limit_price" class="mp-input number" id="limit_price"
							type="number" maxLength="12" step="100"> 원 <SPAN id="item_price_ko"></SPAN>
					</SECTION>
					<SECTION class="mp-section">
						<LABEL class="mp-label" for="exp_date">유통 기한</LABEL><INPUT
							name="exp_date" class="mp-input number" id="exp_date"
							type="date">
					</SECTION>
					<DIV class="mp-block">
						<SECTION class="mp-section">
							<select name="class_" class="mp-input" id="class_">
								<option value="">분류 선택</option>
								<option value="식품">식 품</option>
								<option value="뷰티">뷰 티</option>
								<option value="문화">문 화</option>
								<option value="기타">기 타</option>
							</select>
						</SECTION>

						<SECTION class="mp-section">
							<LABEL class="mp-label" for="item_used_month">경매 시간</LABEL> <SELECT
								name="act_time" class="mp-input" id="act_time">
								<OPTION value="1">1시간</OPTION>
								<OPTION value="2">2시간</OPTION>
								<OPTION value="3">3시간</OPTION>
								<OPTION value="6">6시간</OPTION>
								<OPTION value="12">12시간</OPTION>
								<OPTION value="24">24시간</OPTION>
							</SELECT>
						</SECTION>
					</DIV>
				</DIV>
			</DIV>
			<DIV class="mp-block"></DIV>
		</DIV>
		<DIV class="write_footer">
			<DIV class="btnArea">
				<INPUT class="btn" type="submit" value="등록">

			</DIV>
		</DIV>
	</FORM>

	<jsp:include page="/include/bottom.jsp" />
</body>
</html>