<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  <main class="mypage">
    <div id="page">
      <h1>내 가게 정보</h1>
      <div class="mypage_companys">
      	<c:forEach items="${company}" var="vo">
      	<c:if test="${vo.rank == 1}">
	        <div class="mypage_company">
	          <img src="${vo.imgpath}" alt="회사이미지">
	          <div class="mypage_company_back"></div>
	          <div class="mypage_company_select">
	            <button onclick="location.href='memberCompanyGraph.mp?store_number=${vo.store_number }'">그래프로 보기</button>
	            <button onclick="location.href='memberCompanyUpdate.mp?store_number=${vo.store_number }'">수정하기</button>
	          </div>
	        </div>
	    </c:if>    
        </c:forEach>
        <div class="mypage_company">  
          <a href="memberCompanyInsert.mp">+</a>
        </div>
      </div>
    </div>
  </main>