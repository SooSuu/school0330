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
<%-- 
 * 등록폼 *
<form action="/temp/insert.do" method="post" name="tempVO">
	<label for="tempVal">값 정보 :</label>
	<input type="text" id="tempVal" name="tempVal" value=""/>
	<br>
	<button type="submit">등록</button>
</form>
--%>

<c:choose><%--Id값의 유무를 확인--%>
	<c:when test="${not empty searchVO.crudId}">
		<c:set var="actionUrl" value="/crud2/update.do"/>
	</c:when>
	<c:otherwise>
		<c:set var="actionUrl" value="/crud2/insert.do"/>
	</c:otherwise>
</c:choose>

<form action="${actionUrl}" method="post" name="crud2VO">
	<input type="hidden" name="crudId" value="${result.crudId}"/>
	<label for="crudSj">제  목 :</label>
		<input type="text" id="crudSj" name="crudSj" value="${result.crudSj}"/>
	<br>
	<label for="crudNm">작성자 :</label>
		<input type="text" id="crudNm" name="crudNm" value="${result.crudNm}"/>
	<br>
	<label for="crudCn">내  용 :</label>
		<textarea rows="10" name="crudCn"><c:out value="${result.crudCn}"/></textarea>
	<br>
	<c:choose>
		<c:when test="${not empty searchVO.crudId}">
			<button type="submit">수정</button><%--Id값이 있으면 수정--%>
		</c:when>
		<c:otherwise>
			<button type="submit">등록</button><%--Id값이 없으면 등록--%>
		</c:otherwise>
	</c:choose>
	<br>
	<a href="/crud2/selectList.do">취소</a>
</form>

</body>
</html>