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
      <form  class="form company_update_form" name="dataForm" id="dataForm" onsubmit="return registerAction()">
        <h1>신규 세차장 등록</h1>
        <div class="company_update">
          <div>
            <h3>세차장 이름</h3>
            <input type="text" name="store_name">
          </div>
          <div>
            <h3>주소</h3>
            <button type="button" onclick='daum_post()'>우편번호 찾기</button>
            <input type="text" name="store_post"><br/>		
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
            <input type="number" name="inventory">
          </div>
          <div>
            <h3>가격</h3>
            <input type="text" name="store_price">
          </div>
          <div>
            <h3>사업주 이름</h3>
            <input type="text" name="store_master_name">
          </div>
          <div>
            <h3>사업자 번호</h3>
            <input type="text" name="store_registration_number">
          </div>
          <div class="join_profile">
	          <h3>프로필 사진</h3>
	          <div class="mypage_user_image" >
			      	<label>
								<a><img src='imgs/select.png' id="attach-file" class='file-img' /></a>
								<input multiple="multiple" type="file" id='input_file' name="file" />
							</label>
							<span style="font-size:12px; color: gray;" id='file-name' ></span>
							<div id="articlefileChange"></div>
	          </div>
	        </div>
        </div>
        <button type="button" onclick='$("form").submit()'>등록하기</button>
      </form>
		</div>
  </main>
  <script type="text/javascript" src='js/file_check.js'></script>
  <!-- 파일 업로드 스크립트 -->
  <script type="text/javascript" src='js/img_upload.js'></script>
  
  <!-- 다음 주소 검색 API -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script type="text/javascript">
		function daum_post() {
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 조회된 우편번호를 입력하기 위한 선언
		            // name 이 post 인 태그의 val(값)을 받아온 변수 (data) 내 zonecode 값을 담음
		            $('[name=store_post]').val( data.zonecode);
		            
		            // 지번 주소 : J  도로명 주소 : R
		            var addr =data.userSelectedType == 'J' ? data.jibunAddress : data.roadAddress;
		            
		            // 건물명이 있을 경우 추가
		            if ( data.buildingName != '') addr += ' ('+ data.buildingName + ')'; 
		            	$('[name=store_addr]').eq(0).val( addr );
		        }
		    }).open();
		}
	</script>
  
 	
 
