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
<title>진주축제</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- 헤더 인클루드 -->
<%@ include file="/WEB-INF/jsp/main/Header.jsp" %>

    <!-- Swiper -->
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide"><img src='<c:url value="/images/index/01_01.png"/>'></div>
        <div class="swiper-slide"><img src='<c:url value="/images/index/02_01.png"/>'></div>
        <div class="swiper-slide"><img src='<c:url value="/images/index/03_01.png"/>'></div>
        <div class="swiper-slide">진주소싸움대회</div>
        <div class="swiper-slide"><img src='<c:url value="/images/index/05_01.png"/>'></div>
        <div class="swiper-slide"><img src='<c:url value="/images/index/06_01.png"/>'></div>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
    </div>

    <footer>
		진주축제<br>
		관리자 연락처 : 010-0000-0000<br>
		52789 경상남도 진주시 동진로 155 (상대동)
    </footer>
    
    <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });
    </script>
    
<script>
$(document).ready(function(){
	//로그인
	$(".login").click(function(){
		$(".dim, .layer-login").fadeIn();
		return false;
	});
	
	//레이어닫기
	$(".layer-close").click(function(){
		$(".dim, .layer-login").fadeOut();
		return false;
	});
});

function vali(){
	if(!$("loginId").val()){
		alert("아이디를 입력해주세요.");
		$("#loginId").focus();
		return false;
	}
	if(!$("loginPw").val()){
		alert("비밀번호를 입력해주세요.");
		$("#loginPw").focus();
		return false;
	}
}

<c:if test="${not empty loginMessage}">
	alert("${loginMessage}")
</c:if>
</script>

</body>
</html>