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
      <form class="form company_update_form" name="dataForm" id="dataForm" onsubmit="return registerAction()">
	      <input type="hidden" name='store_number' value="${vo.store_number}"/>
				<input type="hidden" name='attach' />
        <h1>세차장 정보 수정</h1>
	        <div class="company_update">
	          <div>
	            <h3>세차장 이름</h3>
	            <input type="text" name="store_name" value="${vo.store_name }">
	          </div>
	          <div>
	            <h3>우편번호</h3>
	            <button type="button" onclick='daum_post()'>우편번호 찾기</button>
	            <input type="text" name="store_post" value="${vo.store_post }"><br/>		
	          </div>
	          <div>
	            <h3>주소</h3>
	            <input type="text" name="store_addr" value="${vo.store_addr }">	
	          </div>
	          <div>
	            <h3>상세주소</h3>
	            <input type="text" name="store_detail_addr" value="${vo.store_detail_addr }">	
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
	          <div class="join_profile_images"> 
	            <h3>사진</h3>
	            <div>
	            	<c:forEach items="${img }" var="img">
					<div class="join_profile_image">
						<img alt="" src="${img.imgpath }">
					</div>
		            	<%-- <input class="image_upload"  value="${img.imgpath }" /> --%>
		            </c:forEach>
	            </div>
		             <!--<div class="company_images">
		             <div class="join_profile_image">
			             <label>
							<a><img src='imgs/select.png' id="attach-file" class='file-img' /></a>
							<input multiple="multiple" type="file" id='input_file' name="file" accept="image/*" />
						</label> 
						<span style="font-size:12px; color: gray;" id='file-name' ></span>
						<div id="articlefileChange"></div>
		              </div>
		              <div id="articlefileChange" style="display: none"></div>
		              <input multiple="multiple" type="file" id='input_file' name="file" accept="image/*"  style="display: none"/>
	              </div>-->
	              <div id="articlefileChange" style="display: none"></div>
		          <input multiple="multiple" type="file" id='input_file' name="file" accept="image/*"  style="display: none"/>
	              
	          </div>
	        </div>
	        <button type="button" onclick='$("form").submit()'>수정하기</button>
      </form>
    </div>
  </main>
  
  <!-- 다음 주소 검색 API -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  
  <!-- 파일 업로드 스크립트 -->
  
  <script type="text/javascript">
  $(document).ready(function()
			// input file 파일 첨부시 fileCheck 함수 실행
			{
				$("#input_file").on("change", fileCheck);
			});
	
	/**
	 * 첨부파일로직
	 */
	$(function () {
	    $('#btn-upload').click(function (e) {
	        e.preventDefault();
	        $('#input_file').click();
	    });
	});
	
	// 파일 현재 필드 숫자 totalCount랑 비교값
	var fileCount = 0;
	// 해당 숫자를 수정하여 전체 업로드 갯수를 정한다.
	var totalCount = 3;
	// 파일 고유넘버
	var fileNum = 0;
	// 첨부파일 배열
	var content_files = new Array();
	
	function fileCheck(e) {
	    var files = e.target.files;
	    
	    // 파일 배열 담기
	    var filesArr = Array.prototype.slice.call(files);
	    
	    // 파일 개수 확인 및 제한
	    if (fileCount + filesArr.length != totalCount) {
	      alert('파일은 '+totalCount+'개만 업로드 할 수 있습니다.');
				$("#input_file").val('');
	      return;
	    } else {
	    	 fileCount = fileCount + filesArr.length;
	    }
	    
	    // 각각의 파일 배열담기 및 기타
	    filesArr.forEach(function (f) {
	      var reader = new FileReader();
	      reader.onload = function (e) {
	        content_files.push(f);
	        $('#articlefileChange').append(
	       		'<div id="file' + fileNum + '" onclick="fileDelete(\'file' + fileNum + '\')">'
	       		+ '<font style="font-size:12px">' + f.name + '</font>'  
	       		+ '<img src="/img/icon_minus.png" style="width:20px; height:auto; vertical-align: middle; cursor: pointer;"/>' 
	       		+ '<div/>'
			);
	        fileNum ++;
	      };
	      reader.readAsDataURL(f);
	    });
	    console.log(content_files);
	    //초기화 한다.
	    $("#input_file").val("");
	  }
	
	// 파일 부분 삭제 함수
	function fileDelete(fileNum){
	    var no = fileNum.replace(/[^0-9]/g, "");
	    content_files[no].is_delete = true;
		$('#' + fileNum).remove();
		fileCount --;
	    console.log(content_files);
	}
	
	/*
	 * 폼 submit 로직
	 */
		function registerAction(){
			
		var form = $("form")[0];        
	 	var formData = new FormData(form);
			for (var x = 0; x < content_files.length; x++) {
				// 삭제 안한것만 담아 준다. 
				if(!content_files[x].is_delete){
					 formData.append("article_file", content_files[x]);
				}
			}
	   /*
	   * 파일업로드 multiple ajax처리
	   */    
		$.ajax({
	   	      type: "post",
	   	   	  enctype: "multipart/form-data",
	   	      url: "update_work.mp",
	       	  data : formData,
	       	  processData: false,
	   	      contentType: false,
	   	      success: function (data) {
	   	    	  window.location.replace("memberCompany.mp");
	   	    	
	   	    		alert("가게수정 성공");
//						} else
//							alert("서버내 오류로 처리가 지연되고있습니다. 잠시 후 다시 시도해주세요");
	   	      },
	   	      error: function (xhr, status, error) {
	   	    		alert("서버오류로 지연되고있습니다. 잠시 후 다시 시도해주시기 바랍니다.");
	   	     	return false;
	   	      }
	   	    });
	   	    return false;
		}
		
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
	