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
      <div class="wash_zone_boxs">
        <div class="company_info">
        	<c:forEach items="${wash_zone}" var="vo" begin="0" end="0">
        		<div class="company_info_name">
        			<h1>${vo.store_name}</h1>
        		</div>
        		<div class="company_info_favorite_cnt">
        			<p class="favorite_cnt_h">♥</p>
        			<span>${vo.store_favorite_cnt}</span>
        		</div>
        		<div class="company_info_addr">
        			<span>주소</span>
        			<span>${vo.store_addr}</span>
        		</div>
        		<div class="company_info_tel">
        			<span>전화번호</span>
        			<span>${vo.store_tel}</span>
        			
        		</div>
        		<div class="company_info_time">
        			<span>운영시간</span>
        			<span>${vo.store_time}</span>
        			
        		</div>
        		<div class="company_info_dayoff">
        			<span>휴무일</span>
        			<span>${vo.store_dayoff}</span>
        			
        		</div>
        		<div class="company_info_introduce">
        			<span>소개</span>
        			<span>${vo.introduce}</span>
        			
        		</div>
        		<div class="company_info_price">
        			<span>가격</span>
        			<span>${vo.store_price}</span>
        		</div>
        		<input type="hidden" value="${vo.store_addr}" class="addr"/> 
        		<input type="hidden" value="${vo.store_name}" class="name"/> 
			</c:forEach>
			<div class="company_info_imgs">
				<c:forEach items="${wash_zone}" var="vo">	
        		<div class="company_info_imgpath">
        			<img alt="세차장 이미지" src="${vo.imgpath}">
        		</div>
				</c:forEach>
			</div>
			
		</div>
		<div id="map" style="width:50%;height:500px;">
        
        </div>
      </div>  
    </div>
  </main>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e147583a7db59a9ae45a17222b6e7203&libraries=services"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = { 
	    center: new kakao.maps.LatLng(35.153411178408, 126.88799074307386), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	};
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성
	var addr = document.querySelector('.addr').value;
	var name = document.querySelector('.name').value;
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(addr, function(result, status) {
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
	        });
	        infowindow.open(map, marker);
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});    
	
	
	
</script>