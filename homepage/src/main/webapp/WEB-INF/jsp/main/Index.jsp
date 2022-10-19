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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<style type="text/css">
.carousel-item img{
    max-height: 730px;
    max-width: 1400px;
    margin-left: 10%;
}
.carousel-item h5{
	font-size: 45px;
	padding-bottom: 15px;
}
.carousel-item p{
	font-size: 30px;
}
</style>
<!-- 헤더 인클루드 -->
<%@ include file="/WEB-INF/jsp/main/Header.jsp" %>


<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4" aria-label="Slide 5"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="5" aria-label="Slide 6"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src='<c:url value="/images/index/01_01.png"/>' class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>진주남강유등축제</h5>
        <p>5년 연속 대한민국 글로벌 육성 축제로 선정<br>해외로 진출하는 명품 축제</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src='<c:url value="/images/index/02_01.png"/>' class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>개천예술제</h5>
        <p>국내 최대,최고의 예술경연대회를 주축으로 한 지역고유 문화예술제</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src='<c:url value="/images/index/03_01.png"/>' class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>진주논개제</h5>
        <p>논개의 충절정신 헌창과 전통문화의 올바른 계승보존 및 복원</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src='<c:url value="/images/index/04_01.jpg"/>' class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>민속 소싸움대회</h5>
        <p>토요상설 소싸움대회<br>매년 4월부터 9월 매주 토요일 13:30<br>전국민속소싸움대회<br>10월 축제기간 중 개최</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src='<c:url value="/images/index/05_01.png"/>' class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>진주국제농식품박람회</h5>
        <p>수출상담회, 전시행사, 체험행사, 판매행사, 토종농산물 종자박람회 개최</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src='<c:url value="/images/index/06_01.png"/>' class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>진주탈춤한마당</h5>
        <p>전승탈춤의 개선과 발전, 재창조<br>탈춤문화의 대중화</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
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