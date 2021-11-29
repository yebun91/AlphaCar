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
<script type="text/javascript">
const image = document.querySelector('.mypage_user_image');
const input_file = document.querySelector('.image_upload');

function choose_image() {
	image.addEventListener('click', () => {
		input_file.click();
	});
}

//첨부파일 선택시
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

function member_update() {

	$("form").submit()
}
</script>