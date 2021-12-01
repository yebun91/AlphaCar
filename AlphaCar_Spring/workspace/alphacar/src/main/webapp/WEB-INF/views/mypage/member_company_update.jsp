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
  <main class="mypage">
    <div id="page">
      <form action="update_work.mp" class="form company_update_form" method="post">
	      <input type="hidden" name='store_number' value="${vo.store_number}"/>
				<input type="hidden" name='attach' />
        <h1>세차장 정보 수정</h1>
        <c:forEach items="${vo }" var="vo" begin="0" end="0">
	        <div class="company_update">
	          <div>
	            <h3>세차장 이름</h3>
	            <input type="text" name="store_name" value="${vo.store_name }">
	          </div>
	          <div>
	            <h3>주소</h3>
	            <input type="text" name="store_addr" value="${vo.store_addr }">
	          </div>
	          <div>
	            <h3>전화번호</h3>
	            <input type="text" name="store_tel" value="${vo.store_tel }">
	          </div>
	          <div>
	            <h3>영업시간</h3>
	            <input type="text" name="store_time" value="${vo.store_time }">
	          </div>
	          <div>
	            <h3>휴무일</h3>
	            <input type="text" name="store_dayoff" value="${vo.store_dayoff }">
	          </div>
	          <div class="company_introduce">
	            <h3>세차장 소개</h3>
	            <input type="text" name="introduce" value="${vo.introduce }">
	            <!-- <textarea name="" id=""></textarea> -->
	          </div>
	          <div>
	            <h3>베이수</h3>
	            <input type="text" name="inventory" value="${vo.inventory }">
	          </div>
	          <div>
	            <h3>가격</h3>
	            <input type="number" name="store_price" value="${vo.store_price }">
	          </div>
	          <div>
	            <h3>사업주 이름</h3>
	            <input type="text" name="store_master_name" value="${vo.store_master_name }">
	          </div>
	          <div>
	            <h3>사업자 번호</h3>
	            <input type="text" name="store_registration_number" value="${vo.store_registration_number }">
	          </div>
	          <div> 
	            <h3>사진</h3>
	            <c:forEach items="${img.list }" var="img">
		            <div class="company_images">
		              <div class="join_profile_image">
		                <p>+</p>
		              </div>
	              </div>
	            </c:forEach>
	          </div>
	        </div>
	        <button>수정하기</button>
        </c:forEach>
      </form>
    </div>
  </main>