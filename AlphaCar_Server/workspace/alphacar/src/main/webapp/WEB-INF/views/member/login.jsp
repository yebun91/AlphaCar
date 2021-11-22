<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <main>
    <div class="login_page">
      <div class="text_logo">
        <img src="img/alphacarLogo_text_black_500px.png" alt="alphaCar">
      </div>
      <form action="" class="form">
        <input type="text" placeholder="이메일" class="login_email">
        <input type="password" placeholder="비밀번호" class="login_pw">
        <label><input type="checkbox" name="alwaysLogin" value="" class="login_always">로그인 항상 유지</label>
        <button>로그인</button>
      </form>
      <div class="login_page_bottom_button">
        <button type="button" onclick="location.href='searchPw'">비밀번호 찾기</button>
        <button type="button" onclick="location.href='searchId'">아이디 찾기</button>
        <button type="button" onclick="location.href='homeJoin'">회원가입</button>
      </div>
    </div>
  </main>