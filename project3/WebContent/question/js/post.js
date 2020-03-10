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

			var fullurl = URL+"questionModify.do?question_num="+question_num;
			window.location.href = fullurl;
			
		}else if(button == '삭제'){
			
			//var input = prompt('비밀번호를 입력하세요');
			var fullurl = URL+"questionDelete.do";
			var Info = "&question_num="+question_num+"&input="+input;
			$.question(fullurl,Info);
			
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
				var output = jsonInfo.result;
				if(output == "fail") alert("비밀번호가 다릅니다.");
				if(output == "success"){
					alert('삭제 되었습니다.');
					var fullurl = URL+"questionList.do";
					window.location.href = fullurl;
				}
			
			}
			
		});
		
	}
	
	
	
	
});