$(function() {
	var URL = window.location.protocol+"//"+window.location.host;
	
	$('.post_btn_block').on('click','input',function(){
		
		var button = $(this).val(); //누른 버튼 value값
		var decla_Num = $('#decla_Num').val(); //게시글 번호
		var decla_re_ref = $('#decla_re_ref').val();
		var decla_re_lev = $('#decla_re_lev').val();
		var decla_re_seq = $('#decla_re_seq').val();
		
		var postdata = "?decla_Num="+decla_Num+
					   "&decla_re_ref="+decla_re_ref+
					   "&decla_re_lev="+decla_re_lev+
					   "&decla_re_seq="+decla_re_seq;
		
		if(button == '목록'){
			
			var fullurl = URL+"/project/dboardList.brd";
			window.location.href = fullurl;
			
		}else if(button == '답글'){
			
			var fullurl = URL+"/project/declare/dreply.jsp"+postdata;
			window.location.href = fullurl;
			
		}else if(button == '수정'){

			var fullurl = URL+"project/boardDeclaModify.brd?decla_Num="+decla_Num;
			window.location.href = fullurl;
			
		}else if(button == '삭제'){
			
			var input = prompt('자신의 이메일 주소를 입력하세요');
			var fullurl = URL+"project/dboardDeclaDelete.brd?decla_Num="+decla_Num+"&input="+input;
			window.location.href = fullurl;
		}
	});
	
	
});