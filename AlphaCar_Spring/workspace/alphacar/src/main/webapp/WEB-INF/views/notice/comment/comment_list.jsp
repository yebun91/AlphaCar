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
	<div id="comment_update${vo.notice_coment_id }" style="display: none;" >
		<textarea id="summernote" name="coment_content" class="summernote ${vo.notice_coment_id }">
			${vo.coment_content }
		</textarea> 
		<button type="button" onclick="comment_update(${vo.notice_coment_id })">댓글수정</button>
	</div>
</c:forEach>


<!-- 서머노트를 위해 추가해야할 부분 -->
<script>
//서머노트
$('.summernote').summernote({
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


