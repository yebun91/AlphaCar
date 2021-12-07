<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mypage_image"></div>
<div class="mypage_select">
	<div class="mypage_userinfo">
		<a href=""><p class="mypage_userinfo_select">회원정보</p></a> <a href=""><p>보안설정</p></a>
	</div>
</div>
</nav>
<!-- 메인 시작 -->
<main class="mypage">
	<div id="page">
		<form class="form company_update_form" name="dataForm" id="dataForm"
			onsubmit="return registerAction()">
			<h1>신규 세차장 등록</h1>
			<div class="company_update">
				<div>
					<h3>세차장 이름</h3>
					<input type="text" name="store_name">
				</div>
				<div>
					<h3>우편번호</h3>
					<button type="button" onclick='daum_post()'>우편번호 찾기</button>
					<input type="text" name="store_post" value="${vo.store_post }"><br />
				</div>
				<div>
					<h3>주소</h3>
					<input type="text" name="store_addr" value="${vo.store_addr }">
				</div>
				<div>
					<h3>상세주소</h3>
					<input type="text" name="store_detail_addr"
						value="${vo.store_detail_addr }">
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
				<div class="join_profile_images">
					<h3>사진</h3>
					<div>				
						<div class="join_profile_image">
							<img onclick="choose_image()"
								class="join_profile_image1">
						</div>	
						<div class="join_profile_image">
							<img onclick="choose_image()"
								class="join_profile_image2">
						</div>	
						<div class="join_profile_image">
							<img onclick="choose_image()"
								class="join_profile_image3">
						</div>
					</div>				
				</div>
			</div>
			<div style="display: none" id="articlefileChange"></div>
	        <input style="display: none" multiple="multiple" type="file" class='input_file' id='input_file' name="file" accept="image/*" >
			<button type="button" onclick='$("form").submit()'>등록하기</button>
		</form>
	</div>
</main>
<script type="text/javascript" src='js/file_check.js'></script>
<!-- 파일 업로드 스크립트 -->
<script type="text/javascript" src='js/img_upload.js'></script>

<!-- 다음 주소 검색 API -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

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
	const image = document.querySelector('.join_profile_image');
	const input_file = document.querySelector('#input_file');
	//이미지 파일 누를 때 input_file도 같이 클릭
	function choose_image() {
		input_file.click();
	}
	//첨부파일 선택시 처리
	  $(document).on('change', '#input_file', function() {
	  	var attached1 = this.files[0];
	  	if (attached1) { // 첨부된 파일이 있을 경우
	  		$('.join_profile_image1').html('<img src="" />');
	  		var reader = new FileReader();
	  		reader.onload = function(e) {
	  			$('.join_profile_image1').attr('src', e.target.result);
	  		}
	  		reader.readAsDataURL(attached1);
	  	}
	  })
	   $(document).on('change', '#input_file', function() {
	  	var attached2 = this.files[1];
	  	if (attached2) { // 첨부된 파일이 있을 경우
	  		$('.join_profile_image2').html('<img src="" />');
	  		var reader = new FileReader();
	  		reader.onload = function(e) {
	  			$('.join_profile_image2').attr('src', e.target.result);
	  		}
	  		reader.readAsDataURL(attached2);
	  	}
	  })
	  $(document).on('change', '#input_file', function() {
	  	var attached3 = this.files[2];
	  	if (attached3) { // 첨부된 파일이 있을 경우
	  		$('.join_profile_image3').html('<img src="" />');
	  		var reader = new FileReader();
	  		reader.onload = function(e) {
	  			$('.join_profile_image3').attr('src', e.target.result);
	  		}
	  		reader.readAsDataURL(attached3);
	  	}
	  })
</script>



