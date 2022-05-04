<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
	table {
	    width: 500px;
	    border: 1px solid #444444;
		border-collapse: collapse;
	}
	th, td {
	    border: 1px solid #444444;
	    padding: 5px;
	    text-align: center;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>제목</th>
			<th>${result.crudSj}</th>
		</tr>
		<tr>
			<th>작성자</th>
			<th>${result.crudNm}</th>
		</tr>
		<tr>		
			<th>작성일</th>
			<th>${result.frstRegistPnttm}</th>
		</tr>
		<tr>
			<th>내용</th>
			<th>${result.crudCn}</th>
		</tr>		
	</table>
﻿
	<div class="box-btn">
		<c:url var="uptUrl" value="/crud/crudRegist.do">
			<c:param name="crudId" value="${result.crudId}"/>
		</c:url>
		<a href="${uptUrl}">수정</a>
		
		<c:url var="delUrl" value="/crud/delete.do">
			<c:param name="crudId" value="${result.crudId}"/>
		</c:url>
		<a href="${delUrl}" class="btn-del">삭제</a>
		
		<a href="/crud/selectList.do">목록</a>
	</div>
	
	<script>
		$(document).ready(function() {
			$(".btn-del").click(function() {
				if(!confirm("삭제하시겠습니까?")){
					return false;
				}
			});
		});
	</script>
</body>
</html>