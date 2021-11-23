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
      <form action="" class="form">
        <h1>회원 정보 수정</h1>
        <input type="text" placeholder="이메일" class="join_email">
        <input type="password" placeholder="기존 비밀번호" class="old_join_pw">
        <input type="password" placeholder="비밀번호" class="join_pw">
        <input type="password" placeholder="비밀번호 확인" class="join_pw2">
        <input type="text" placeholder="이름" class="join_name">
        <div class="join_company">
          <h3>사업자 이신가요?</h3>
          <div>
            <label><input type="radio" name="join_company" value="">예</label>
            <label><input type="radio" name="join_company" value="" checked="checked">아니오</label>
          </div>
        </div>
        <div class="join_profile">
          <h3>프로필 사진</h3>
          <div class="join_profile_image">
            <p>+</p>
          </div>
        </div>
        <button>수정하기</button>
      </form>
    </div>
  </main>