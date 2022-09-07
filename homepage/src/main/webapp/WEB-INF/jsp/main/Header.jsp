<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="/css/index.css" />
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link href="/asset/front/css/style.css" rel="stylesheet" />


</head>
<body>

<header id="header">
    <h1>
		<a href="/index.do"><img src="/images/logo.png" class="logo"></a>
	</h1>
  <nav class="gnb">
    <div class="left_menu">
      <ul>
        <li><a href="/index.do">Home</a></li>
        <li><a href="/festival.do">축제소개</a></li>
        <li><a href="/board/selectList.do">이벤트</a></li>
        <li><a href="/board2/selectList.do">공지사항 / Q&A</a></li>
      </ul>
    </div>
    <div class="right_menu">
      <ul>
        <li>
        
			<c:choose>
				<c:when test="${empty USER_INFO.id}">
					<a href="/login/egovLoginUsr.do" class="login">로그인</a>
				</c:when>
				<c:otherwise>
					<a href="/login/actionLogout.do"><c:out value="${USER_INFO.name}"/>님 로그아웃</a>
				</c:otherwise>
			</c:choose>
			
		</li>
		<li>
			<a href="/join/memberType.do">회원가입</a>
		</li>
      </ul>
    </div>
  </nav>    
</header>


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