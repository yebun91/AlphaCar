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
        <div id="map" style="width:1000px;height:500px;">
        
        </div>
        <div>
        </div>
      </div>  
    </div>
  </main>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e147583a7db59a9ae45a17222b6e7203"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = { 
	    center: new kakao.maps.LatLng(35.153411178408, 126.88799074307386), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	};
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성
	
	
	
	// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열
	var positions = [
	    {
	        content: '<div>카카오</div>', 
	        latlng: new kakao.maps.LatLng(35.15280218794347, 126.8890951531405),
	        store_number : 99
	    },
	    {
	        content: '<div>생태연못</div>', 
	        latlng: new kakao.maps.LatLng(35.1526347117682, 126.88719854514558),
	        store_number : 999
	    },
	    {
	        content: '<div>텃밭</div>', 
	        latlng: new kakao.maps.LatLng(35.15424122827958, 126.88726682303339),
	        store_number : 111
	    },
	    {
	        content: '<div>근린공원</div>',
	        latlng: new kakao.maps.LatLng(35.15135071630523, 126.88577988236534),
	        store_number : 112
	    }
	];

	for (var i = 0; i < positions.length; i ++) {
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: positions[i].latlng, // 마커의 위치
	        clickable: true
	    });
	    
	 	// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성
	    var iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시

	    // 인포윈도우를 생성
	    var infowindow = new kakao.maps.InfoWindow({
	        content : positions[i].content,
	        removable : iwRemoveable
	    });
	    
	    kakao.maps.event.addListener(marker, 'click', markerClick(map, marker,infowindow));
	}
	
	// 마커에 클릭이벤트를 등록
	function markerClick(map, marker, infowindow) {
		return function () {
			infowindow.open(map, marker);  
		};
	}
</script>