//코멘트 수정 버튼 누를 때 textarea 생기게 하기
function comment_update_button(no) {	
	var comment = document.getElementById("comment_update"+no);
	//안보이는 상태일때
	if(comment.style.display == 'none'){
		//보이는것으로 변경
		comment.style.display = '';
	}else{
		comment.style.display = 'none';
	}
}

//코멘트 수정시 처리
function comment_update(no) {
	if ( $.trim( $("."+no).val() ) == ''  ) { 
		//내용 없이 등록하기를 눌렀을 경우
		alert ('댓글을 입력하세요!');
		$("."+no).val('');
		$("."+no).focus();
		return;
	}
	
	$.ajax({
		url : "board/comment/update",
		data : {coment_content:$("."+no).val(),  notice_coment_id:no},
		success : function ( response ) {
			if ( response ) {	// true == true T, false == true F
				alert ('댓글이 수정되었습니다.');
				$("."+no).val('');
				comment_list();		// 댓글 목록 조회 요청 함수
			} else 
				alert('댓글 수정이 실패하였습니다.');
		}, error : function (req, text) {
			alert(text + ":" + req.status);
		}
	});
}