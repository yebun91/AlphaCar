<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main>
  <div class="join_page">
    <h1>회원가입</h1>
    <div class="text_logo">
      <img src="img/alphacarLogo_text_black_500px.png" alt="alphaCar">
    </div>
    <form action="" class="form">
      <input type="text" placeholder="이메일" class="join_email">
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
      <button>회원가입</button>
    </form>
  </div>
</main>