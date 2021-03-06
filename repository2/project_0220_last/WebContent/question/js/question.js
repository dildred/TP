$(function() {
	var URL = window.location.protocol+"//"+window.location.host+"/project_0220_last/";

	//페이지에 맞는 리스트 보기
	$('.writing input').click(function() {
		var fullurl = URL+"questionWrite.do";// 이거 앞에 question/ 지웠음 문제생기면 이거 돌리기, 근대 말이되나 이게;
		
		window.location.href = fullurl;
	});
	
	$('.pagebtn').on('click','input',function(){
		
		var maxPage = $('.count input').val(); //최대 페이지 수
		var page = $(this).val(); //누른 페이지
		var nowPage = Number($(this).attr('name')); //현재 페이지
		
		if(page == '<'){
			if(nowPage == 1){
				$.eventblock(nowPage);
			}else{
				nowPage -= 1;
				$.eventblock(nowPage);
			}
		}else if(page == '>'){
			if(nowPage == maxPage){
				$.eventblock(nowPage);
			}else{
				nowPage += 1;
				$.eventblock(nowPage);
			}
		}else {
			$.eventblock(page);
		}

	});
	
	$.eventblock = function(page) {
		
	
			$.ajax({
				type: "get",
				async: true,
				url: URL+"questionList.do?Handler=ajax",
				data: {"page" : page},
				dataType: "text",
				success: function(data) {
					
					var jsonInfo = JSON.parse(data);
					var articleList = jsonInfo.members;
					var list = "";
					var page = "";
					
					for(var i in articleList){
						list += "<tr id='row'>";
						list += 	"<td class='num'>"+articleList[i].num+"</td>";
						list += 	"<td class='title'>"
						if(articleList[i].re_lev != 0){
							for(var j=1; j<articleList[i].re_lev; j++){
						list += 	"<img src='./question/images/reply/blank.gif' alt='화살표이미지'> ";	
							}
						list += 	"<img src='./question/images/reply/arrow.png' alt='화살표이미지'> ";
							}
						list +=		articleList[i].title;
						list += 	"</td>";
						
						list += 	"<td class='Email'>"+articleList[i].Email+"</td>";
						list += 	"<td class='date'>"+articleList[i].date+"</td>";
						//list +=  	"<td class='views'>"+articleList[i].count+"</td>"; 조회수안함
						list += "</tr>";
						
					}
					
					/*if(jsonInfo.pageInfo.page > 1){*/ 
						page += "<input type='button' name='"+jsonInfo.pageInfo.page+"' value='<'>";
					/*}*/
					for(var i=0; i<jsonInfo.pageInfo.maxpage; i++){	
						page += "<input type='button' name='"+jsonInfo.pageInfo.page+"' value='"+(i+1)+"'>";
					}
					/*if(jsonInfo.pageInfo.page != jsonInfo.pageInfo.maxpage){*/
						page += "<input type='button' name='"+jsonInfo.pageInfo.page+"' value='>'>";
					/*}*/
	
					$('tbody').html(list); //게시글 리스트	
					$('.pagebtn').html(page); //게시판 페이지번호
				}
			
			});
		
		
	} //페이지 버튼 이벤트
	
	//게시글 상세보기
	$(document).on('click','#row',function(){
		
		var tr = $(this);
		var td = tr.children();
		var num = td.eq(0).text();
		console.log("js임니당");
		
		var fullurl = URL+"questionDetail.do?num="+num;
		window.location.href = fullurl;
		
	});
	
	$('.left input').on('click', function() {
		window.location.href = URL+"question/division.jsp?arrow=left";
	});
	
	$('.right input').on('click', function() {
		window.location.href = URL+"question/division.jsp?arrow=right";
	});
	
	
	
});
	
	

