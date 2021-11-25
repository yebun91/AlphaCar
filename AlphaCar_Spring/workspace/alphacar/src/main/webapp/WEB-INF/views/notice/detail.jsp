<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="sub_image">
        <img src="img/main_image.jpg" alt="">
    </div>
	<div class="page_detail_text">
		<p>[공지] ${vo.notice_title }</p>
		<p>${vo.customer_name }</p>
		<p>${vo.notice_writedate }</p>
	</div>
  </nav>
  <!-- 메인 시작 -->
  <main>
    <div id="page">
      <div class="detail">
		<p>
			${vo.notice_content }
		</p>
	  </div>
	  <div class="page_write_button">
		<button type="button" onclick="location.href='list.no'">목록으로</button>
		<c:if test="${loginInfo.customer_email eq vo.customer_email}">
			<button type="button" onclick="location.href='update.no?id=${vo.notice_id }'">수정</button>
			<button type="button" onclick="
			if(confirm('정말 삭제 하시겠습니까?')) { 
				location.href='delete.no?id=${vo.notice_id }'} 
			">삭제</button>
			
	  	</c:if> 
	  </div>
    </div>
  </main>