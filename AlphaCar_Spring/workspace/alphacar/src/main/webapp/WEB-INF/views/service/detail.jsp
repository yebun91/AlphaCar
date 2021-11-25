<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <meta charset="utf-8">

    <div class="sub_image">
       <img src="img/main_image.jpg" alt="">
    </div>
	<div class="page_detail_text">
		<p>자주 묻는 질문</p>
	</div>
  </nav>
  <!-- 메인 시작 -->
  <main>
    <div id="page">
      <div class="detail">
	    	<textarea id="summernote" name="editordata">
	    
		    </textarea> 
		  </div>
		  <div class="page_write_button">
			<button type="button" onclick="location.href='list.se'">목록으로</button>
			<!-- 관리자로 로그인된 경우만 수정 가능 -->
			<c:if test="${loginInfo.admin eq 'A'}">
	    		<button type="button" onclick="location.href='update.se'">수정</button>
				<button type="button" onclick="location.href='delete.se'">삭제</button>
			</c:if>
		  </div>
    </div>
    
    
  </main>
  
	<!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="resources/js/summernote-lite.js"></script>
  <script src="resources/js/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="resources/css/summernote-lite.css">
  <!--  -->
  
	<script>
	 $('#summernote').summernote({
         width: 800,
        height: 300,
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
			 		   ['insert',['picture','link']],
             ['view', ['help']]
           ],
         fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
         fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
      });
	</script>