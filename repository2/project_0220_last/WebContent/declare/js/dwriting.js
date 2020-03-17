$(function() {
	var URL = window.location.protocol+"//"+window.location.host;
	
	//게시글 작성[유효성 체크]
	$('#writing_submit').click(function() {
		
		var suspect_Email = $('#suspect_Email').val();
		var attacker_Email = $('#attacker_Email').val();
		var decla_Title = $('#decla_Title').val();
		var decla_Content = $('#decla_Content').val();
		var decla_Item = $('#decla_Item').val();
		
		if(suspect_Email == "" || suspect_Email.length == 0){
			alert('신고자 이메일을 입력해주세요.');
		}else if(attacker_Email == "" || attacker_Email.length == 0){
			alert('가해자 이메일을 입력해주세요.');
		}else if(decla_Title == "" || decla_Title.length == 0){
			alert('제목을 입력해주세요.');
		}else if(decla_Content == "" || decla_Content.length == 0){
				alert('내용을 입력해주세요.');
		}else if(decla_Item == "" || decla_Item.length == 0){
				alert('해당하는 기프티콘 등록번호를 입력해주세요.');
		}else{
			$('#writer_form').submit();	
		}
	});
	
	//답글 작성[유효성 체크]
	$('#reply_submit').click(function() {
		
		var writer = $('#writer').val();
		var title = $('#title').val();
		var content = $('#content').val();
		
		if(writer == "" || writer.length == 0){
			alert('이름을 입력해주세요.');
		}else if(title == "" || title.length == 0){
			alert('제목을 입력해주세요.');
		}else if(content == "" || content.length == 0){
				alert('내용을 입력해주세요.');
		}else{
			$('#reply_form').submit();	
		}
	});
	
	//게시글 수정[유효성 체크]
	$('#modify_submit').click(function() {
		
		var writer = $('#writer').val();
		var title = $('#title').val();
		var content = $('#content').val();
		
		if(writer == "" || writer.length == 0){
			alert('작성자를 입력해주세요.');
		}else if(title == "" || title.length == 0){
			alert('제목을 입력해주세요.');
		}else if(content == "" || content.length == 0){
				alert('내용을 입력해주세요.');
		}else{
			$('#modify_form').submit();	
		}
	});
	
});