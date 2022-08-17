<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximun-scale=1.0,user-scalable=no"/>
<title>Ajax</title>
</head>
<body>

<form action="/temp/insertAjax.do" method="post" name="tempVO">
	<label for="tempVal">값 정보 :</label>
	<input type="text" id="tempVal" name="tempVal" value="${result.tempVal}"/>
	<button id="btn-submit" type="submit">등록</button>
</form>
<div id="ajax-box">
	<c:import url="/temp/ajaxList.do" charEncoding="utf-8"></c:import>
</div>
<script>
$(document).ready(function(){
	$("#btn-submit").click(function(){
		var tempVal = $("#tempVal").val();
		
		if(tempVal){
			$.ajax({
				url : "/temp/ajaxList.do",
				type : "post",
				data : {"tempVal" : tempVal},
				dataType : "html",
				success : function(data){
					$("#ajax-box").html(data);	
				}, error : function(){
					alert("error : list");
				}
			});
		}else{
			alert("내용을 입력하세요.");
		}
	});
});
</script>
</body>
</html>