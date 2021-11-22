<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="sub_image">
        <img src="img/main_image.jpg" alt="">
    </div>
	<div class="page_header_text">
		<p>공지사항</p>
		<p>새로운 공지사항을 작성하는 페이지 입니다.</p>
	</div>
  </nav>

  <!-- 메인 시작 -->
  <main>
    <div id="page">
      <h1>신규글 작성</h1>
		<form action="" class="page_write">
			<div class="page_write_index">
				<div class="page_search_index">
					<select name="notice_search_index" id="notice_search_index">
						<option value="all" selected="selected">전체</option>
						<option value="notice">공지</option>
						<option value="alphacer_business">알파카비지니스</option>
						<option value="maintainance">점검</option>
					</select>
				</div>
				<div class="page_write_title">
					<input type="text" placeholder="제목">
				</div>
			</div>
			<div class="page_write_space">
				<textarea><!-- api 넣어야 할 곳 --></textarea>
			</div>
			<div class="page_write_button">
				<button>작성완료</button>
				<button type="button">취소</button>
			</div>
		</form>
    </div>
  </main>