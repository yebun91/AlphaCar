<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <h1>고객센터</h1>
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
        <h3></h3>
        <h3>조회수</h3>
      </div>
      <div class="page_list_box">
        <div class="page_list_content">
          <div class="page_list_content_title">
            <a href="detail.se">
              <p>[공지]</p>
              <p>좌표로 주소 변환하기 api어쩌고</p>
            </a>
          </div>
          <p></p>
          <p></p>
          <p>109</p>
        </div>  
        <div class="page_list_content">
          <div class="page_list_content_title">
            <a href="">
              <p>[공지]</p>
              <p>좌표로 주소 변환하기 api어쩌고</p>
            </a>
          </div>
          <p></p>
          <p></p>
          <p>442</p>
        </div>  
        <div class="page_list_content">
          <div class="page_list_content_title">
            <a href="">
              <p>[공지]</p>
              <p>좌표로 주소 변환하기 api어쩌고</p>
            </a>
          </div>
          <p></p>
          <p></p>
          <p>967</p>
        </div>  
        <div class="page_list_content">
          <div class="page_list_content_title">
            <a href="">
              <p>[공지]</p>
              <p>좌표로 주소 변환하기 api어쩌고</p>
            </a>
          </div>
          <p></p>
          <p></p>
          <p>742</p>
        </div>  
        <div class="page_list_content">
          <div class="page_list_content_title">
            <a href="">
              <p>[공지]</p>
              <p>좌표로 주소 변환하기 api어쩌고</p>
            </a>
          </div>
          <p></p>
          <p></p>
          <p>66</p>
        </div>  
        <div class="page_list_content">
          <div class="page_list_content_title">
            <a href="">
              [공지] 좌표로 주소 변환하기 api어쩌고 좌표로 주소 변환하기 api어쩌고 좌표로 주소 변환하기 api어쩌고 좌표로 주소 변환하기 api어쩌고 좌표로 주소 변환하기 api어쩌고</p>
            </a>
          </div>
          <p></p>
          <p></p>
          <p>8344</p>
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