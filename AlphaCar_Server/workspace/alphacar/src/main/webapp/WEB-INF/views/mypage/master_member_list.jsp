<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <h1>회원정보 확인</h1>
      <div class="page_index">
        <div class="page_select">
          <ul>
            <li>전체</li>
            <li>일반</li>
            <li>사업자</li>
          </ul>
        </div>
        <!-- service 검색기능 -->
        <form action="" class="page_search">
          <div class="page_search_index">
            <select name="service_search_index" id="service_search_index">
              <option value="all" selected="selected">전체</option>
            <option value="user">일반</option>
            <option value="company">사업자</option>
            </select>
          </div>
          <div class="page_search_box">
            <input type="text" placeholder="search">
            <i class="fas fa-search"></i>
          </div>
        </form>
      </div>
      <!-- notice 글 목록  -->
      <div class="user_list">
        <div class="user_list_name">
          <h3>이메일</h3>
          <h3>패스워드</h3>
          <h3>이름</h3>
          <h3>사업자유무</h3>
        </div>
        <div class="page_list_box">
          <div class="user_list_content">
            <div class="user_list_content_title">
              <a href="detail.me">
                <p>text@naver.com</p>
              </a>
            </div>
            <p>testtest</p>
            <p>테스트이름</p>
            <p>일반</p>
          </div>  
          <div class="user_list_content">
            <div class="user_list_content_title">
              <a href="detail.me">
                <p>text@naver.com</p>
              </a>
            </div>
            <p>testtest</p>
            <p>토르</p>
            <p>일반</p>
          </div>  
          <div class="user_list_content">
            <div class="user_list_content_title">
              <a href="detail.me">
                <p>text@naver.com</p>
              </a>
            </div>
            <p>testtest</p>
            <p>아이언맨</p>
            <p>사업자</p>
          </div>  
          <div class="user_list_content">
            <div class="user_list_content_title">
              <a href="detail.me">
                <p>text@naver.com</p>
              </a>
            </div>
            <p>testtest</p>
            <p>배트맨</p>
            <p>사업자</p>
          </div>  
          <div class="user_list_content">
            <div class="user_list_content_title">
              <a href="detail.me">
                <p>text@naver.com</p>
              </a>
            </div>
            <p>testtest</p>
            <p>슈퍼맨</p>
            <p>사업자</p>
          </div>   
          <div class="user_list_content">
            <div class="user_list_content_title">
              <a href="detail.me">
                <p>text@naver.com</p>
              </a>
            </div>
            <p>testtest</p>
            <p>이름이름</p>
            <p>사업자</p>
          </div>  
        </div>
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