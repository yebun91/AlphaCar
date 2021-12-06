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
        <div id="map" style="width:1000px;height:500px;"></div>
        <div>
        	<c:forEach items="${wash_zone}" var="item">
	        	<script type="text/javascript">
	        		console.log("${item.store_name}, ${item.store_addr}, ${item.store_number}");
	        	</script>	
			</c:forEach>
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
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	var positions = [
	    {
	        content: '카카오', 
	        addr: '상무대로 1129',
	        store_number : 99
	    },
	    {
	    	content: '생태연못', 
	        addr: '대남대로472번길 4',
	        store_number : 999
	    },
	    {
	    	content: '텃밭', 
	        addr: '경열로 6',
	        store_number : 111
	    },
	    {
	    	content: '근린공원',
	        addr: '상무대로 1160',
	        store_number : 112
	    }
	];

	// 주소로 좌표를 검색합니다
	for (let i = 0; i < positions.length; i++) {
		geocoder.addressSearch(positions[i].addr, function(result, status) {
		    // 정상적으로 검색이 완료됐으면 
		    if (status === kakao.maps.services.Status.OK) {
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords,
		            clickable: true,
		        });      
		     	// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성
			    var iwRemoveable = true;
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		        	content: '<div style="width:150px;text-align:center;padding:6px 0;">'+positions[i].content+'</div>',
		            removable : iwRemoveable
		        });

		        kakao.maps.event.addListener(marker, 'click', markerClick(map, marker,infowindow));
		    }
		});
	};
	// 마커에 클릭이벤트를 등록
	function markerClick(map, marker, infowindow) {
		return function () {
			infowindow.open(map, marker);
		};
	}
	
	
   
</script>