$(function() {
	var URL = window.location.protocol+"//"+window.location.host+"/project3/";
	
	$('.post_btn_block').on('click','input',function(){
		
		var button = $(this).val(); //누른 버튼 value값
		var question_num = $('#question_num').val(); //게시글 번호
		var re_ref = $('#re_ref').val();
		var re_lev = $('#re_lev').val();
		var re_step = $('#re_step').val();
		
		var postdata = "?question_num="+question_num+
					   "&re_ref="+re_ref+
					   "&re_lev="+re_lev+
					   "&re_step="+re_step;
		
		if(button == '목록'){
			
			var fullurl = URL+"questionList.do";
			window.location.href = fullurl;
			
		}else if(button == '답글'){
			
			var fullurl = URL+"question/reply.jsp"+postdata;
			window.location.href = fullurl;
			
		}else if(button == '수정'){
			console.log("수정이에오1");
			var fullurl = URL+"questionModify.do?question_num="+question_num;
			console.log("수정이에오2");
			window.location.href = fullurl;
			console.log("수정이에오3");
			
		}else if(button == '삭제'){
			console.log("포스트에요1");
			var input = prompt('비밀번호를 입력하세요');
			console.log("포스트에요2");
			var fullurl = URL+"questionDelete.do";
			console.log("포스트에요3");
			var Info = "&question_num="+question_num+"&input="+input;
			console.log("포스트에요4");
			$.question(fullurl,Info);
			console.log("포스트에요5");
			
			
		}
		
		
	});
	
	$.question = function(fullurl,Info) {
		
		$.ajax({
			type: "get",
			async: true,
			url: fullurl+"?Handler=ajax"+Info,
			dataType: "text",
			success: function(data) {
			
				var jsonInfo = JSON.parse(data);
				console.log(jsonInfo);
				var output = jsonInfo.result;
				console.log(output);
				if(output == "fail") alert("비밀번호가 다릅니다.");
				if(output == "success"){
					console.log(jsonInfo);
					console.log(output);
					alert('삭제 되었습니다.');
					var fullurl = URL+"questionList.do";
					window.location.href = fullurl;
				}
			
			}
			
		});
		
	}
	
	
	
	
});