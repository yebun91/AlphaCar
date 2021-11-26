<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="sub_image">
        <img src="img/main_image.jpg" alt="">
    </div>
	<div class="page_header_text">
		<p>고객센터</p>
		<p>새로운 FAQ를 작성하는 페이지 입니다.</p>
	</div>
  </nav>

  <!-- 메인 시작 -->
  <main>
    <div id="page">
      <h1>신규글 작성</h1>
		<form action="insert.se" class="page_write">
			<div class="page_write_index">
				<div class="page_search_index">
					<select name="notice_search_index" id="notice_search_index">
						<option value="user-info" selected="selected">고객</option>
            <option value="store">가게</option>
            <option value="app_web" >모바일/홈페이지</option>
            <option value="alphacar">알파카</option>
					</select>
				</div>
				<div class="page_write_title">
					<input type="text" placeholder="제목" name="best_qna_title">
				</div>
			</div>
			<div class="page_write_space">
				<textarea id="summernote" name="best_qna_content">
	    
		    </textarea> 
			</div>
			<div class="page_write_button">
				<button>작성완료</button>
				<button type="button">취소</button>
			</div>
		</form>
    </div>
  </main>
  
  <!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="resources/js/summernote-lite.js"></script>
  <script src="resources/js/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="resources/css/summernote-lite.css">
  <!--  -->
  

	
	<script>
			$('#summernote').summernote({
				height: 300,                 // 에디터 높이
				minHeight: null,             // 최소 높이
				maxHeight: null,             // 최대 높이
				focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
				lang: "ko-KR",					// 한글 설정
				placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
				callbacks: {	//여기 부분이 이미지를 첨부하는 부분
					onImageUpload : function(files) {
						uploadSummernoteImageFile(files[0],this);
					},
					onPaste: function (e) {
						var clipboardData = e.originalEvent.clipboardData;
						if (clipboardData && clipboardData.items && clipboardData.items.length) {
							var item = clipboardData.items[0];
							if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
								e.preventDefault();
							}
						}
					}
				}
		});
		
		
		
		/**
		* 이미지 파일 업로드
		*/
		function uploadSummernoteImageFile(file, editor) {
			data = new FormData();
			data.append("file", file);
			$.ajax({
				data : data,
				type : "POST",
				url : "uploadSummernoteImageFile", 
				contentType : false,
				processData : false,
				success : function(data) {
			    	//항상 업로드된 파일의 url이 있어야 한다.
					$(editor).summernote('insertImage', data.url);
				}
			});
		}
		
	</script>