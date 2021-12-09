<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <div class="nav_shadow"></div>
  <div class="slide_box">
	  <div class="slide_wrap">
	    <div class="img_divs"><img src="img/main_image3.png" alt="" class="inner"></div>     
	    <div class="img_divs"><img src="img/main_image2.png" alt="" class="inner"></div>
	    <div class="img_divs"><img src="img/main_image1.png" alt="" class="inner"></div>
	    <div class="img_divs"><img src="img/main_image3.png" alt="" class="inner"></div>
	  </div>
  </div>
</nav>
<div class="button-list">
  <button class="button-left">← Left</button>
  <button class="button-right">Right →</button>
</div>

<script type="text/javascript">

//div사이즈 동적으로 구하기
const outer = document.querySelector('.slide_box');
const oneinner = document.querySelector('.inner');
const innerList = document.querySelector('.slide_wrap');
const inners = document.querySelectorAll('.inner');
const img_divs = document.querySelectorAll('.img_divs');
let currentIndex = 0; // 현재 슬라이드 화면 인덱스

/* inners.forEach((inner) => {
	inner.style.width = outer.clientWidth+'px'; // inner의 width를 모두 outer의 width로 만들기
	console.log(`${outer.clientWidth}px`);
	console.log(outer.clientWidth);
	console.log(outer.clientWidth+'px');
}) */

innerList.style.width = outer.clientWidth * inners.length+'px'; // innerList의 width를 inner의 width * inner의 개수로 만들기


//버튼에 이벤트 등록하기
const buttonLeft = document.querySelector('.button-left');
const buttonRight = document.querySelector('.button-right');


const one_div = document.querySelector('.img_divs');
buttonLeft.addEventListener('click', () => {
	currentIndex--;
	currentIndex = currentIndex < 0 ? 0 : currentIndex; // index값이 0보다 작아질 경우 0으로 변경
	//innerList.style.marginLeft = -outer.clientWidth * currentIndex+'px'; // index만큼 margin을 주어 옆으로 밀기
	innerList.style.transform = 'translate3d('+ -one_div.clientWidth*currentIndex+'px'+', 0px, 0px)';
	//innerList.style.marginLeft = -one_div.clientWidth * currentIndex+'px'; // index만큼 margin을 주어 옆으로 밀기
});

buttonRight.addEventListener('click', () => {
	currentIndex++;
	currentIndex = currentIndex >= inners.length ? inners.length - 1 : currentIndex; // index값이 inner의 총 개수보다 많아질 경우 마지막 인덱스값으로 변경
	//innerList.style.marginLeft = -outer.clientWidth * currentIndex+'px'; // index만큼 margin을 주어 옆으로 밀기
	innerList.style.transform = 'translate3d('+ -one_div.clientWidth*currentIndex+'px'+', 0px, 0px)';
	//innerList.style.marginLeft = -one_div.clientWidth * currentIndex+'px'; // index만큼 margin을 주어 옆으로 밀기
});

window.addEventListener('resize', function() {
	img_divs.forEach((img_div) => {
		img_div.style.width = outer.clientWidth+'px';
	});
	console.log(outer.clientWidth*-4);
	innerList.style.width = outer.clientWidth*4+'px'; // inner의 width를 모두 outer의 width로 만들기
}, true);
</script>
<!-- 메인 콘텐츠 -->
<main>
  <div id="recommend">
    <h1>추천 세차장</h1>
    <div class="recommend_box">
    <c:forEach items="${wash}" var="vo" begin="0" end="5">
    	<div class="best_company">
    		<a href="detail.wa?store_number=${vo.store_number }">
    		  <img alt="세차장 이미지" src="${vo.imgpath }">
    		</a>
    		<div class="best_company_back" onclick="location.href='detail.wa?store_number=${vo.store_number }'"></div>
    		<div class="best_company_select" onclick="location.href='detail.wa?store_number=${vo.store_number }'">
	          <p>${vo.store_name }</p>
	        </div>
    	</div>
    		
	</c:forEach>
      <div>
        <a href="list.wa">
          <p>세차장 전체보기</p>
        </a>
      </div>
    </div>
  </div>
  <div id="distinction">
    <h1>AlphaCar만의 특징</h1>
    <h3>알파카는 세계 최고 우수 짱짱 세차장 어플 회사다.</h3>
    <div class="distinction_box">
      <div>
      	<span class="distinction_header">상생</span>
      	<p>인간은 바로 사람과 사람이 서로 기대어 구성됩니다. 상생은 상대의 부정이 아닌 긍정을 통해 이를 수 있는 세계입니다. 알파카는 상생을 추구합니다. 알파카는 수많은 개발자분들과 함께, 개발자분들에 의해, 개발자분들을 위해 같이 성장하고 싶습니다.</p>
      	<p>#together, #winwin</p>
      </div>
      <div>
      	<span class="distinction_header" >생산성</span>
      	<p>개발자의 생산성 향상은 우리의 중요한 목표 중 하나입니다. 개발자분들 이 앱의 핵심 로직에 좀 더 집중하여, 보다 가치있는 앱들을 창출할 수 있도록 편리한 환경을 제공하는것, 이것이 우리가 추구하는 방향입니다.</p>
      	<p>#productivity</p>
      </div>
      <div>
      	<span class="distinction_header">가치창출</span>
      	<p>알파카는 새로운 문화를 개척하고 다양한 부가가치를 창출하는 창의적인 개발자분들을 존중합니다. 열린 기술, 열린 서비스, 하지만 정제되고 절제된 소중한 서비스들을 통해, 보다 나은 새로운 세상, 보다 의미있는 사용자 가치를 만들어 나가고 싶습니다.</p>
      	<p>#value, #create</p>
      </div>
    </div>
  </div>
  <div id="notice">
    <h1>공지사항</h1>
      <a href="list.no">
      	<div class="notice_image">
          <img src="img/main_image.jpg" alt="main image">
          <h2>공지사항 전체보기</h2>
      	</div>
      </a>
      <div class="notice_contents">
      	<c:forEach items="${page.list}" var="vo" begin="0" end="2">
			<a href='detail.no?id=${vo.notice_id }'>
	          <div class="notice_content">
	            <c:if test="${vo.notice_attribute eq 'N'}">
	              <h3>[공지]</h3>
	            </c:if>
	            <c:if test="${vo.notice_attribute eq 'A'}">
	              <h3>[알파카]</h3>
	            </c:if>
	            <c:if test="${vo.notice_attribute eq 'M'}">
	              <h3>[점검]</h3>
	            </c:if>
	            <h3>${vo.notice_title}</h3>
	            <p>${vo.notice_writedate}</p>
	          </div>
        	</a>
		</c:forEach>
      </div>
  </div>
  <div id="news">
      <h1>관련 소식</h1>
      <div class="news_box">
          <div>
          	<img alt="" src="img/img1.PNG">
          	<h3>careers.alphacar.com</h3>
          	<h2>알파카 개발자 채용</h2>
          </div>
          <div>
          	<img alt="" src="img/img2.PNG">
          	<h3>tech.alphacar.com</h3>
          	<h2>알파카 기술 사이트</h2>
          </div>
          <div>
          	<img alt="" src="img/img3.PNG">
          	<h3>if.alphacar.com</h3>
          	<h2>if AlphaCar 2021</h2>
          </div>
      </div>
  </div>
</main>