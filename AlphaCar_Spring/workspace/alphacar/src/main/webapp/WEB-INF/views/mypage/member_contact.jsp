<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mypage_image">
    </div>
    <div class="mypage_select">
      <div class="mypage_userinfo">
        <a href=""><p class="mypage_userinfo_select">회원정보</p></a>
        <a href=""><p>보안설정</p></a>
      </div>
    </div>
  </nav>
  <!-- 메인 시작 -->
  <main>
    <div id="page">
      <h1>1:1 문의 내역</h1>
      <div class="page_index">
        <div class="page_select">
          <ul>
            <li>전체</li>
            <li>고객정보</li>
            <li>배송</li>
            <li>주문/결제</li>
          </ul>
        </div>
        <!-- service 검색기능 -->
        <form action="" class="page_search">
          <div class="page_search_index">
            <select name="service_search_index" id="service_search_index">
              <option value="all" selected="selected">전체</option>
            <option value="user-info">고객정보</option>
            <option value="delivery">배송</option>
            <option value="payment">주문/결제</option>
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
          <h3></h3>
          <h3>조회수</h3>
          <h3>활동</h3>
        </div>
       <div class="page_list_box">
      	<c:forEach items="${list}" var="vo">
      		<div class="page_list_content">
	          <div class="page_list_content_title">
	            <a href='detail.no?id=${vo.qna_id }'>
	              <c:if test="${vo.qna_attribute eq 'C'}">
	              	<p>[고객]</p>
	              </c:if>
	              <c:if test="${vo.qna_attribute eq 'S'}">
	              	<p>[가게]</p>
	              </c:if>
	              <c:if test="${vo.qna_attribute eq 'M'}">
	              	<p>[모바일/홈페이지]</p>
	              </c:if>
	              <c:if test="${vo.qna_attribute eq 'A'}">
	              	<p>[알파카]</p>
	              </c:if>
	              <p>${vo.qna_title}</p>
	            </a>
	          </div>
	          <p>${vo.customer_name}</p>
	          <p>${vo.qna_readcnt}</p>
	        </div>
				</c:forEach> 
	     </div>  
          <div class="page_list_content">
            <div class="page_list_content_title">
              <a href="">
                <p>[배송]</p>
                <p>배송이 안옵니다 취소해주세요</p>
              </a>
            </div>
            <p></p>
            <p>2</p>
            <p>2시간</p>
          </div>  
          <div class="page_list_content">
            <div class="page_list_content_title">
              <a href="">
                <p>[주문/결제]</p>
                <p>결제방식이 너무 복잡함 ㅡㅡ</p>
              </a>
            </div>
            <p></p>
            <p>2</p>
            <p>1일</p>
          </div>  
          <div class="page_list_content">
            <div class="page_list_content_title">
              <a href="">
                <p>[공지]</p>
                <p>좌표로 주소 변환하기 api어쩌고</p>
              </a>
            </div>
            <p></p>
            <p>0</p>
            <p>3일</p>
          </div>  
          <div class="page_list_content">
            <div class="page_list_content_title">
              <a href="">
                <p>[공지]</p>
                <p>좌표로 주소 변환하기 api어쩌고</p>
              </a>
            </div>
            <p></p>
            <p>1</p>
            <p>1달</p>
          </div>  
          <div class="page_list_content">
            <div class="page_list_content_title">
              <a href="">
                [공지] 좌표로 주소 변환하기 api어쩌고 좌표로 주소 변환하기 api어쩌고 좌표로 주소 변환하기 api어쩌고 좌표로 주소 변환하기 api어쩌고 좌표로 주소 변환하기 api어쩌고</p>
              </a>
            </div>
            <p></p>
            <p>1</p>
            <p>1년</p>
          </div>  
        </div>
      </div>
      <div class="page_content_create">
        <button type="button" onclick="location.href='write.se'">글 작성</button>
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