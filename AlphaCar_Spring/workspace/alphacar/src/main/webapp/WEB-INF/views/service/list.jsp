<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <div class="sub_image">
    <img src="img/main_image.jpg" alt="">
  </div>
  <div class="service_buttons">
  	<button>실시간 채팅 문의</button>
  	<button onclick="location.href='customer_write.se'">1:1 문의하기</button>
  </div>
</nav>
<!-- 메인 시작 -->
<main>
  <div id="page">
    <h1>자주 묻는 질문</h1>
    <div class="page_index">
      <div class="page_select">
        <ul>
          <li>전체</li>
          <li>고객</li>
          <li>가게</li>
          <li>모바일/홈페이지</li>
          <li>알파카</li>
        </ul>
      </div>
      <!-- service 검색기능 -->
      <form action="" class="page_search">
        <div class="page_search_index">
          <select name="service_search_index" id="service_search_index">
            <option value="all" selected="selected">전체</option>
            <option value="user-info">고객</option>
            <option value="store">가게</option>
            <option value="app_web">모바일/홈페이지</option>
            <option value="alphacar">알파카</option>
          </select>
        </div>
        <div class="page_search_box">
          <input type="text" placeholder="search">
          <i class="fas fa-search"></i>
        </div>
        
      </form>
    </div>
    <!-- notice 글 목록  -->
    <div class="page_list">
      <div class="page_list_name">
        <h3>글</h3>
        <h3>작성자</h3>
        <h3>조회수</h3>
      </div>
       <div class="page_list_box">
      	<c:forEach items="${list}" var="vo">
      		<div class="page_list_content">
	          <div class="page_list_content_title">
	            <a href='detail.se?id=${vo.best_qna_id }'>
	              <c:if test="${vo.best_qna_attribute eq 'C'}">
	              	<p>[고객]</p>
	              </c:if>
	              <c:if test="${vo.best_qna_attribute eq 'S'}">
	              	<p>[가게]</p>
	              </c:if>
	              <c:if test="${vo.best_qna_attribute eq 'M'}">
	              	<p>[모바일/홈페이지]</p>
	              </c:if>
	              <c:if test="${vo.best_qna_attribute eq 'A'}">
	              	<p>[알파카]</p>
	              </c:if>
	              <p>${vo.best_qna_title}</p>
	            </a>
	          </div>
	          <p>${vo.customer_name}</p>
	          <p>${vo.best_qna_readcnt}</p>
	        </div>
			</c:forEach> 
     </div> 
        
    <div class="page_content_create">
    <ul>
				<!-- 관리자로 로그인된 경우만 글쓰기 가능 -->
				<c:if test="${loginInfo.admin eq 'A'}">
      		<button type="button" onclick="location.href='write.se'">글 작성</button>
				</c:if>
			</ul>
    </div>
    
    <!-- 페이징 처리 -->
    <div class="notice_paging">
      <i class="fas fa-angle-double-left"></i>
      <i class="fas fa-angle-left"></i>
      <p>1 2 3 4 5 6 7 8 9 10</p>
      <i class="fas fa-angle-right"></i>
      <i class="fas fa-angle-double-right"></i>
    </div>    
  </div>
</main>