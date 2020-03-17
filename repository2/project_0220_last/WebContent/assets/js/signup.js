$(function() {

	var URL = window.location.protocol+"//"+window.location.host+"/GifticonAuction/";
	
	//이메일 정규식 체크
	$('#email_check').click(function() {
		
		var email = $('#email').val();
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if (email.match(regExp) == null) {
		    alert('이메일 형식에 맞게 입력해주세요.');
		    return;
		}
		
		//이메일 유효성 검사 ajax
		$.ajax({
			type: "post",
			async: true,
			url: URL+"emailcheck.mem",
			data: {"email" : email},
			dataType: "text",
			success: function(data) {
				
				var json = JSON.parse(data);
				if("notavailable" == json.result){
					alert("이미있는 이메일 입니다.");
					return;
				}else if("available" == json.result){
					$.sendEmail(json.id);
				}
			}
		});
		
		$.sendEmail = function(email) {
			var width = 450;
			var height = 200;
			var winL = (screen.width - width) / 2;
			var winT = (screen.height - height) / 2;
			var property = "width=" + width + "," + "height=" + height + "," 
							+ "left=" + winL + "," + "top=" + winT + " menubar=no";
			
			window.open("authMail.jsp?to=" + email, "인증 페이지", property);
		}

	});
	

	
	
	$('#form').submit(function() {

		var email = $('#email').val();
		var email_check = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
		if (email.match(email_check) == null) {
		    alert('이메일 형식에 맞게 입력해주세요.');
		}
	
		var pw = $('#pw').val();
		var pw_check = $('#pw_check').val();
		if(pw != pw_check){
			alert('비밀번호가 일치하지 않습니다.');
			return false;
		}
		
		var phone = $('#phone').val();
		var phone_check = /^\d{3}\d{3,4}\d{4}$/;
		
		if (phone.match(phone_check) == null) {
		    alert('휴대폰 번호 형식에 맞게 입력해주세요.');
		    return false;
		}
		
		var emailCertification = $('#check').val();
		if(emailCertification == "no"){
			alert("이메일 인증을 해주세요.");
			return false;
		}
		
	});
	
});
