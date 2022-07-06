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

<div class="dim"></div>
<!-- 로그인 -->
<div class="layer-popup layer-login" style="display: none;">
	<header class="layer-header">
		<span class="logo">
			<img alt="한국폴리텍대학교 대전캠퍼스 하이테크과정" src="/images/logo.png">
		</span>
		<button type="button" class="layer-close"><span>팝업 닫기</span></button>
	</header>
	<div class="layer-body">
		<form action="/login/actionLogin.do" id="frmLogin" name="frmLogin" method="post" onabort="return vali()">
			<input type="hidden" name="userSe" value="USR"/>
			<fieldset>
				<legend>로그인을 위한 아이디/비밀번호 입력</legend>
				<div class="ipt-row">
					<input type="text" id="loginId" name="id" placeholder="아이디" required="required">
				</div>
				<div class="ipt-row">
					<input type="password" id="loginPw" name="password" placeholder="비밀번호" required="required">
				</div>
				<button type="submit" class="btn-login"><spen>로그인</spen></button>
			</fieldset>
		</form>
	</div>
</div>

    <!-- Swiper -->
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide"><img src='<c:url value="/images/index/01_01.png"/>'></div>
        <div class="swiper-slide"><img src='<c:url value="/images/index/02_01.png"/>'></div>
        <div class="swiper-slide">진주논개제</div>
        <div class="swiper-slide">진주소싸움대회</div>
        <div class="swiper-slide">진주국제농식품박람회</div>
        <div class="swiper-slide">진주탈춤한마당</div>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
    </div>

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