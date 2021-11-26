<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${list }" var="vo">
	<div data-seq = ${vo.notice_coment_id } class="comment_detail">
		<div class="comment_name">
			<p class="comment_write_name">${vo.customer_name }</p>
			<p class="comment_date">[${vo.coment_writedate }]<p>
		</div>
		
		<c:if test="${vo.customer_email eq loginInfo.customer_email }">
			<span class="comment_setting">
				<button type="button" onclick="comment_update_button('${vo.notice_coment_id }')">수정</button>
				<button type="button" onclick="
				if(confirm('정말 삭제 하시겠습니까?')) { 
					location.href='comment_delete.no?id=${vo.notice_coment_id }&notice_id=${vo.notice_id }'} 
				">삭제</button>
			</span>
		</c:if>
		<div class='comment_content'>${vo.coment_content }</div>
	</div>
	<div id="comment_update" style="display: none" class="${vo.notice_coment_id }">
		<textarea id="summernote" name="coment_content" >
			${vo.coment_content }
		</textarea> s
	</div>
</c:forEach>
<script type="text/javascript">
function comment_update_button(number) {
	var note = document.getElementsByClassName(number);
	if(note.style.display == 'none'){
		note.style.display = 'block';
	}else{
		note.style.display = 'none';
	}
}
</script>

<!-- 서머노트를 위해 추가해야할 부분 -->

<script src="resources/js/summernote-lite.js"></script>
<script src="resources/js/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="resources/css/summernote-lite.css">
<script>
	//서머노트
$('#summernote').summernote({
      height: 150,
      lang: "ko-KR",
      toolbar: [
           // [groupName, [list of button]]
           ['fontname', ['fontname']],
           ['fontsize', ['fontsize']],
           ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
           ['color', ['forecolor','color']],
           ['para', ['ul', 'ol', 'paragraph']],
           ['height', ['height']],
	       // 그림첨부, 링크만들기, 동영상첨부
	 		   ['insert',['picture']],
           ['view', ['help']]
         ],
       fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
       fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
    });
</script>
<script>
	/* function comment_update(comment_id) {
		
		$.ajax ({
			//경로 형태로 url 지정
			url : "board/comment/update"
			, data : { notice_id:${vo.notice_id} , coment_content:$('#summernote').val()  }
			, success : function ( response ) {
				if ( response ) {	// true == true T, false == true F
					alert ('댓글이 등록되었습니다.');
					$('#summernote').val('');
					comment_list();		// 댓글 목록 조회 요청 함수
				} else 
					alert('댓글 등록이 실패하였습니다.');
			}, error : function (req, text) {
				alert(text + ":" + req.status);
			}
			
		});
	} */
</script>
