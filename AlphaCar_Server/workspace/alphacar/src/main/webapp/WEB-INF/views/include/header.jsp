<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 위로 가기 버튼 -->
<a href="#header">
	<div class="go_top">
    <i class="fas fa-arrow-up"></i>
  </div>
</a>
<nav>
  <div id="header">
    <div class="alphacar_logo">
      <a href="<c:url value='/' />">
        <img src="img/alphacarLogo_white_300px.png" alt="">
      </a>
    </div>
    <ul>
      <li><a href="">AlphaCar</a></li>
      <li><a href="list.no">공지사항</a></li>
      <li><a href="list.se">고객센터</a></li>
      <li><a href="homeLogin">로그인</a></li>
      <li><a href="">마이페이지</a></li>
    </ul>
  </div>

