<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${list }" var="vo">
	<div data-seq = ${vo.id } class="left">${vo.name } [${vo.writedate }]
		<c:if test="${vo.writer eq loginInfo.id }">
			<span style="float: right">
				<a class="btn-fill-s btn-modify-save" >수정</a>
				<a class="btn-fill-s btn-delete-cancel" >삭제</a>
			</span>
		</c:if>
		
		<div class='original'>${ fn:replace( fn:replace( vo.content, crlf, '<br>'), lf, '<br>' ) }</div>
		
	</div>
	<hr>
</c:forEach>