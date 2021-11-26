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
	    	<p>
					${vo.best_qna_content }
				</p>
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
  
	