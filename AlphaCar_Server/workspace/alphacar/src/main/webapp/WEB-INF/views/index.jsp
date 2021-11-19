<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>AlphaCar</title>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <!-- 위로 가기 버튼 -->
  <a href="#header">
  	<div class="go_top">
      <i class="fas fa-arrow-up"></i>
    </div>
  </a>
  <!-- 네비게이션 바 -->
  <nav>
    <div class="main_image">
      <a href="">
        <img src="img/main_image.jpg" alt="">
      </a>
    </div>
    <div id="header">
      <div class="alphacar_logo">
        <a href="">
          <img src="img/알파카로고_white_300px.png" alt="">
        </a>
      </div>
      <ul>
        <li><a href="">AlphaCar</a></li>
        <li><a href="">공지사항</a></li>
        <li><a href="">고객센터</a></li>
        <li><a href="">로그인</a></li>
        <li><a href="">마이페이지</a></li>
      </ul>
    </div>
  </nav>
  <!-- 메인 콘텐츠 -->
  <main>
    <div id="recommend">
      <h1>추천 세차장</h1>
      <div class="recommend_box">
        <div><a href=""></a></div>
        <div><a href=""></a></div>
        <div><a href=""></a></div>
        <div><a href=""></a></div>
        <div><a href=""></a></div>
        <div><a href=""></a></div>
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
          <a href=""><div class="notice_image">
              <img src="img/main_image.jpg" alt="main image">
              <h2>공지사항 전체보기</h2>
          </div></a>
          <div class="notice_contents">
            <a>
              <div class="notice_content">
                <h3>[공지]</h3>
                <h3>좌표로 주소 변환하기 api어쩌고</h3>
                <p>2021.11.17</p>
              </div>
            </a>
            <a>
              <div class="notice_content">
                <h3>[공지]</h3>
                <h3>좌표로 주소 변환하기 api어쩌고</h3>
                <p>2021.11.17</p>
              </div>
            </a>
            <a>
              <div class="notice_content">
                <h3>[공지]</h3>
                <h3>좌표로 주소 변환하기 api어쩌고</h3>
                <p>2021.11.17</p>
              </div>
            </a>
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
  <jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>