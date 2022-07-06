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
        <li><a href="/board/selectList.do">공지사항 / 이벤트</a></li>
        <li><a href="/board2/selectList.do">Q&A</a></li>
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
      </ul>
    </div>
  </nav>
    
</header>

