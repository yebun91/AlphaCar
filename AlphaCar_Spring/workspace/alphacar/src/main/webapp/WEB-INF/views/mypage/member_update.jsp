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
      <form action="memberSubmit.mp" enctype="multipart/form-data" class="customer_update_form form" method="post">
        <h1>회원 정보 수정</h1>
        <input type="text" name="customer_email" value="${loginInfo.customer_email}" class="join_email" readonly>
        <input type="password" placeholder="기존 비밀번호를 작성해주세요." class="old_join_pw">
        <input type="password" name="customer_pw" value="${loginInfo.customer_pw}" placeholder="변경할 비밀번호" class="join_pw">
        <input type="password" placeholder="변경할 비밀번호 확인" class="join_pw2">
        <input type="text" name="customer_name" value="${loginInfo.customer_name}" class="join_name">
        <div class="join_company">
          <h3>사업자 이신가요?</h3>
          <div>
            <label><input type="radio" name="admin" value="M"
            	<c:if test="${loginInfo.admin eq 'M'}">checked</c:if>
            	>예</label>
            <label><input type="radio" name="admin" value="C"
            	<c:if test="${loginInfo.admin eq 'C'}">checked</c:if>
            	>아니오</label>
            <c:if test="${loginInfo.admin eq 'A'}">
                <label><input type="radio" name="admin" value="A" checked>관리자</label>
            </c:if>	
          </div>
        </div>
        <div class="join_addr">
        	<h3>지역을 선택해주세요.</h3>
        	<%-- <select name="addr" class="gwangju addr" style="<c:if test="${loginInfo.addr ne 'gwangju'}"> display:none</c:if>">
        		<option value="seogu" <c:if test="${loginInfo.addr eq 'seogu'}">selected</c:if> >서구</option>
        		<option value="donggu" <c:if test="${loginInfo.addr eq 'donggu'}">selected</c:if> >동구</option>
        		<option value="buggu" <c:if test="${loginInfo.addr eq 'buggu'}">selected</c:if> >북구</option>
        		<option value="namgu" <c:if test="${loginInfo.addr eq 'namgu'}">selected</c:if> >남구</option>
        		<option value="gwangsangu" <c:if test="${loginInfo.addr eq 'gwangsangu'}">selected</c:if> >광산구</option>
        	</select>
        	<select name="addr" class="seoul addr" style="<c:if test="${loginInfo.addr ne 'seoul'}">display:none</c:if>">
        		<option value="mapogu" <c:if test="${loginInfo.addr eq 'mapogu'}">selected</c:if> >마포구</option>
        		<option value="yeongdeungpogu" <c:if test="${loginInfo.addr eq 'yeongdeungpogu'}">selected</c:if> >영등포구</option>
        	</select> --%>
        	
	        <select name="city" id="city"></select>
			<select name="addr" id="gugun"></select>	
        	
        </div>
        <div class="join_profile">
          <h3>프로필 사진</h3>
          <div class="mypage_user_image" >
          	<img src=
            <c:if test="${loginInfo.customer_picture == null}">
          	  "resources/pictures/profiles/noImage.png" 
          	</c:if>
          	<c:if test="${loginInfo.customer_picture != null}">
          	  "${loginInfo.customer_picture}"
          	</c:if>
          	alt="ProfileImage" onclick="choose_image()" class="mypage_user_images">
          </div>
        </div>
        <input type="file" name="image_file" style="display:none" 
        	class="image_upload" accept="image/*"/>
        <button type="button" onclick="member_update()" >수정하기</button>
      </form>
    </div>
  </main>
<script language=javascript>
$('document').ready(function() {
	 var area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
	  var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
	   var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
	   var area3 = ["대덕구","동구","서구","유성구","중구"];
	   var area4 = ["광산구","남구","동구",     "북구","서구"];
	   var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
	   var area6 = ["남구","동구","북구","중구","울주군"];
	   var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
	   var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
	   var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
	   var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
	   var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
	   var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
	   var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
	   var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
	   var area15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
	   var area16 = ["서귀포시","제주시","남제주군","북제주군"];

	 

	 // 시/도 선택 박스 초기화

	 $("select[name^=city]").each(function() {
	  $selsido = $(this);
	  $.each(eval(area0), function() {
	   $selsido.append("<option value='"+this+"'>"+this+"</option>");
	  });
	  $selsido.next().append("<option value=''>구/군 선택</option>");
	 });

	 

	 // 시/도 선택시 구/군 설정

	 $("select[name^=city]").change(function() {
	  var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
	  var $addr = $(this).next(); // 선택영역 군구 객체
	  $("option",$addr).remove(); // 구군 초기화

	  if(area == "area0")
	   $addr.append("<option value=''>구/군 선택</option>");
	  else {
	   $.each(eval(area), function() {
	    $addr.append("<option value='"+this+"'>"+this+"</option>");
	   });
	  }
	 });


	});

</script>  
  
<script type="text/javascript">

const city = document.querySelector(".city");
const seoul = document.querySelector(".seoul");
const gwangju = document.querySelector(".gwangju");
const addr = document.querySelectorAll(".addr");

function selectAddr() {
	for (var i = 0; i < addr.length; i++) {
		addr[i].style.display = "none";
		addr[i].value = "";
	}
	if(city.value == 'seoul'){
		seoul.style.display='';
	}else if(city.value == 'gwangju'){
		gwangju.style.display='';
	}
}

const image = document.querySelector('.mypage_user_image');
const input_file = document.querySelector('.image_upload');

//이미지 파일 누를 때 input_file도 같이 클릭
function choose_image() {
	image.addEventListener('click', () => {
		input_file.click();
	});
}

//첨부파일 선택시 처리
$(document).on('change', '.image_upload', function() {
	var attached = this.files[0];
	if(attached){ // 첨부된 파일이 있을 경우
       $('.mypage_user_images').html('<img src="" />');
       var reader = new FileReader();
       reader.onload = function(e) {
          $('.mypage_user_images').attr('src', e.target.result);
       }
       reader.readAsDataURL(attached );
	}
})

//회원정보 수정 버튼 누를 시
function member_update() {

	$("form").submit()
}

</script>