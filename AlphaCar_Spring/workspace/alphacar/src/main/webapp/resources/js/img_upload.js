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
	    //$("#input_file").val("");
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
	   	      url: "homeStoreRegister.mps",
	       	  data : formData,
	       	  processData: false,
	   	      contentType: false,
	   	      success: function (data) {
	   	    	  window.location.replace("memberCompany.mp");
 	   	    	
 	   	    		alert("가게등록 성공");
// 						} else
// 							alert("서버내 오류로 처리가 지연되고있습니다. 잠시 후 다시 시도해주세요");
	   	      },
	   	      error: function (xhr, status, error) {
	   	    		alert("서버오류로 지연되고있습니다. 잠시 후 다시 시도해주시기 바랍니다.");
	   	     	return false;
	   	      }
	   	    });
	   	    return false;
		}