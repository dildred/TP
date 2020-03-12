$(function() {
	
	//게시글 작성[유효성 체크]
	$('#writing_submit').click(function() {
		
		var title = $('#title').val();
		var comment = $('#comment').val();
		var passwd = $('#passwd').val();
		
		if(title == "" || title.length == 0){
			alert('제목을 입력해주세요.');
		}else if(comment == "" || comment.length == 0){
			alert('내용을 입력해주세요.');
		}else{
			$('#writer_form').submit();
		}
		
	});
	
	//게시글 수정[유효성 체크]
	$('#modify_submit').click(function() {
		
		var title = $('#title').val();
		var comment = $('#comment').val();
		var passwd = $('#passwd').val();
		
		if(title == "" || title.length == 0){
			alert('제목을 입력해주세요.');
		}else if(comment == "" || comment.length == 0){
			alert('내용을 입력해주세요.');
		}else{
			$('#modify_form').submit();
		}
		
	});
	
});