<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${list }" var="vo">
	<div data-seq = ${vo.notice_coment_id } class="comment_detail">
		<div class="comment_name">
			<p class="comment_write_name">${vo.customer_name }</p>
			<p class="comment_date">[${vo.coment_writedate }]<p>
		</div>
		
		<c:if test="${vo.customer_email eq loginInfo.customer_email }">
			<span class="comment_setting">
				<button type="button" onclick="location.href='comment_update.no?id=${vo.notice_coment_id }'">수정</button>
				<button type="button" onclick="
				if(confirm('정말 삭제 하시겠습니까?')) { 
					location.href='comment_delete.no?id=${vo.notice_coment_id }&notice_id=${vo.notice_id }'} 
				">삭제</button>
			</span>
		</c:if>
		<div class='comment_content'>${vo.coment_content }</div>
	</div>
</c:forEach>