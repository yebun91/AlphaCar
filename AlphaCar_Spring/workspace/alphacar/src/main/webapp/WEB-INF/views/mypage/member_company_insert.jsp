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
  <main class="mypage">
    <div id="page">
      <form action="homeStoreRegister.st" class="form company_update_form" method="post">
        <h1>신규 세차장 등록</h1>
        <div class="company_update">
          <div>
            <h3>세차장 이름</h3>
            <input type="text" name="store_name">
          </div>
          <div>
            <h3>주소</h3>
            <input type="text" name="store_addr">
          </div>
          <div>
            <h3>전화번호</h3>
            <input type="text" name="store_tel">
          </div>
          <div>
            <h3>영업시간</h3>
            <input type="text" name="store_time">
          </div>
          <div>
            <h3>휴무일</h3>
            <input type="text" name="store_dayoff">
          </div>
          <div class="company_introduce">
            <h3>세차장 소개</h3>
            <input type="text" name="introduce">
            <!-- <textarea name="" id=""></textarea> -->
          </div>
          <div>
            <h3>베이수</h3>
            <input type="text" name="inventory">
          </div>
          <div>
            <h3>가격</h3>
            <input type="number" name="store_price">
          </div>
          <div>
            <h3>사업주 이름</h3>
            <input type="text" name="store_master_name">
          </div>
          <div>
            <h3>사업자 번호</h3>
            <input type="text" name="store_registration_number">
          </div>
          <div> 
            <h3>사진</h3>
            <div class="company_images">
              <div class="join_profile_image">
                <p>+</p>
              </div>
              <div class="join_profile_image">
                <p>+</p>
              </div>
              <div class="join_profile_image">
                <p>+</p>
              </div>
            </div>
          </div>
        </div>
        <button>등록하기</button>
      </form>
    </div>
  </main>