<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div class="join_page">
    <h1>회원가입</h1>
    <div class="text_logo">
      <img src="img/alphacarLogo_text_black_500px.png" alt="alphaCar">
    </div>
    <form action="homeRegister" class="form" method="post" enctype="multipart/form-data">
      <input type="text" placeholder="이메일" class="join_email" name="customer_email">
      <input type="password" placeholder="비밀번호" class="join_pw" name="customer_pw">
      <input type="password" placeholder="비밀번호 확인" class="join_pw2" >
      <input type="text" placeholder="이름" class="join_name" name="customer_name">
      <div class="join_company">
        <h3>사업자 이신가요?</h3>
        <div>
          <label><input type="radio" name="admin" value="M">예</label>
          <label><input type="radio" name="admin" value="C" checked="checked">아니오</label>
        </div>
      </div>
      <div class="join_profile">
          <h3>프로필 사진</h3>
          <div class="mypage_user_image" >
          	<img src="resources/pictures/profiles/noImage.png" alt="ProfileImage" onclick="choose_image()" class="mypage_user_images">  	
          </div>
        </div>
      <input type="file" name="file" style="display:none" 
        	class="image_upload" accept="image/*"/>
      <button type="button" onclick="member_update()">회원가입</button>
    </form>
  </div>
<script type="text/javascript">
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

function member_update() {

	$("form").submit()
}
</script>