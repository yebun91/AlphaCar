<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class='notice_paging'>
	<c:if test="${page.curBlock gt 1 }"> <!-- lt < 같은 의미 -->
		<i class="fas fa-angle-double-left page_first"><a class='page_first' title='처음' onclick='go_page(1)'></a></i>
		<i class="fas fa-angle-left page_prev"><a class='page_prev' title='이전' onclick='go_page(${page.beginPage - page.blockPage })'></a></i>
			
	</c:if>
	<c:forEach var="no" begin="${page.beginPage }" end="${page.endPage }">
		<!-- 현재 보고 있는 페이지인 경우 -->	
		<c:if test="${no eq page.curPage }">
			<span class='page_on'>${no }</span>
		</c:if>
		<!-- 현재 보고 있지 않는 페이지인 경우 -->
		<c:if test="${no ne page.curPage }">
			<a class='page_off' onclick='go_page(${no})'>${no }</a>
		</c:if>	
	</c:forEach>
	<!-- 현재 블록 번호가 총 블록수 보다 작으면 이미지가 나오고 그렇지 않으면 않 보임 -->
	<c:if test="${page.curBlock lt page.totalBlock }"> <!-- lt < 같은 의미 -->
		<i class="fas fa-angle-right"><a class='page_next' title="다음" onclick='go_page(${page.endPage+1})'></a></i>
		<i class="fas fa-angle-double-right"><a class='page_last' title='마지막' onclick='go_page(${page.totalPage })'></a></i>	
	</c:if>
	
	
</div>
<script type="text/javascript">
	function go_page(page) {
		$('[name=curPage]').val(page);
		$('form').submit();
	}
</script>
<style>
	.page_on, .page_off, .page_prev, .page_next, .page_last, .page_first {
		display: inline-block; line-height: 30px; margin: 0;
	}
	
	.page_on {
		border: 1px solid #777; background: #999; color: #fff; font-weight: bold;
	}
	.page_on, .page_off {
		min-width: 22px; padding: 0 5px 2px;
	}
	
	.page_prev, .page_next, .page_last, .page_first {
		width: 30px; height: 32px; color: #777; border: 1px soild gray;
	}
	
	/* .page_next {background: url("imgs/page_next.jpg") center no-repeat;}
	 .page_last {background: url("imgs/page_last.jpg") center no-repeat;}
	 .page_first {background: url("imgs/page_first.jpg") center no-repeat;}
	.page_prev {background: url("imgs/page_prev.jpg") center no-repeat;} */




</style>