<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <div class="main_image">
    <a href="">
      <img src="img/main_image.jpg" alt="">
    </a>
  </div>
</nav>

<!-- 메인 콘텐츠 -->
<main>
  <div id="recommend">
    <h1>추천 세차장</h1>
    <div class="recommend_box">
    	<c:forEach items="${wash}" var="vo" begin="0" end="5">
    		<div>
    			<a href="detail.wa?store_number=${vo.store_number }">
    				<img alt="세차장 이미지" src="${vo.imgpath }">
    			</a>
    		</div>
		</c:forEach>
      <div>
        <a href="">
          <p>세차장 전체보기</p>
        </a>
      </div>
    </div>
  </div>
  <div id="distinction">
    <h1>AlphaCar만의 특징</h1>
    <h3>알파카는 세계 최고 우수 짱짱 세차장 어플 회사다.</h3>
    <div class="distinction_box">
      <div></div>
      <div></div>
      <div></div>
    </div>
  </div>
  <div id="notice">
    <h1>공지사항</h1>
      <a href="list.no">
      	<div class="notice_image">
          <img src="img/main_image.jpg" alt="main image">
          <h2>공지사항 전체보기</h2>
      	</div>
      </a>
      <div class="notice_contents">
      	<c:forEach items="${page.list}" var="vo" begin="0" end="2">
			<a href='detail.no?id=${vo.notice_id }'>
	          <div class="notice_content">
	            <c:if test="${vo.notice_attribute eq 'N'}">
	              <h3>[공지]</h3>
	            </c:if>
	            <c:if test="${vo.notice_attribute eq 'A'}">
	              <h3>[알파카]</h3>
	            </c:if>
	            <c:if test="${vo.notice_attribute eq 'M'}">
	              <h3>[점검]</h3>
	            </c:if>
	            <h3>${vo.notice_title}</h3>
	            <p>${vo.notice_writedate}</p>
	          </div>
        	</a>
		</c:forEach>
      </div>
  </div>
  <div id="news">
      <h1>관련 소식</h1>
      <div class="news_box">
          <div></div>
          <div></div>
          <div></div>
      </div>
  </div>
</main>