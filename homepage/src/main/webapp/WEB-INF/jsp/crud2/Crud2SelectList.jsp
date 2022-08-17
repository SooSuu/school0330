<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<title>CRUD2</title>
<style type="text/css">
	table {
	    width: 100%;
	    border: 1px solid #444444;
		border-collapse: collapse;
	}
	th, td {
	    border: 1px solid #444444;
	    padding: 5px;
	    text-align: center;
	    text-decoration: none;
	}
	.paging_align{
		list-style: none;
	}
</style>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>관리</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList}">
			<tr>
				<td><c:out value="${result.crudId}"/></td>
				<td>
					<c:url var="viewUrl" value="/crud2/select.do">
						<c:param name="crudId" value="${result.crudId}"/>
					</c:url>
					<a href="${viewUrl}"><c:out value="${result.crudSj}"/></a>
				</td>
				<td><c:out value="${result.crudNm}"/></td>
				<td><c:out value="${result.frstRegistPnttm}"/></td>
				<td><c:url var="delUrl" value="/crud2/delete.do">
						<c:param name="crudId" value="${result.crudId}"/>
					</c:url>
					<a href="${delUrl}" class="btn-del">삭제</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div id="paging_div">
	<ul class="paging_align">
		<c:url var="pageUrl" value="/crud2/selectList.do?"/>
		<c:set var="pagingParam"><c:out value="${pageUrl}"></c:out></c:set>
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="${pagingParam}"/>
	</ul>
</div>

<a href="/crud2/crudRegist.do">글쓰기</a>

</body>
</html>