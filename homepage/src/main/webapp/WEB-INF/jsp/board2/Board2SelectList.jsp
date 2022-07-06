<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- 기본 url -->
<c:url var="_BASE_PARAM" value="">
	<c:param name="menuNo" value="50"/>
	<c:if test="${not empty searchVO.searchCondition}">
		<c:param name="searchCondition" value="${searchVO.searchCondition}"/>
	</c:if>
	<c:if test="${not empty searchVO.searchKeyword}">
		<c:param name="searchKeyword" value="${searchVO.searchKeyword}"/>
	</c:if>
</c:url>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximun-scale=1.0,user-scalable=no"/>
<title>Q&A</title>

<!-- BoardSelectList CSS -->
<!-- BBS Style -->
<link href="/asset/BBSTMP_0000000000001/style.css" rel="stylesheet"/>
<!-- 공통 style -->
<link href="/asset/LYTTMP_0000000000000/style.css" rel="stylesheet"/>
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

<div class="container">
	<div class="contents">

		
		<!-- 목록영역 -->
		<div id="bbs_wrap">
			<div class="total">
				총게시물<strong><c:out value="${paginationInfo.totalRecordCount}"/></strong>건 | 현재페이지<strong><c:out value="${paginationInfo.currentPageNo}"/></strong>/ <c:out value="${paginationInfo.totalPageCount}"/> 
			</div>
			<div class="bss_list">
				<table class="list_table">
					<thead>
						<tr>
							<th class="num" scope="col">번호</th>
							<th class="tit" scope="col">제목</th>
							<th class="writer" scope="col">작성자</th>
							<th class="date" scope="col">작성일</th>
							<th class="hits" scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
						<!-- 공지 글 -->
						<c:forEach var="result" items="${noticeResultList}" varStatus="status">
							<tr class="notice">
								<td class="num"><span class="label-bbs spot">공지</span></td>
								<td class="tit">
									<c:url var="viewUrl" value="/board2/select.do${_BASE_PARAM}">
										<c:param name="boardId" value="${result.boardId}"/>
										<c:param name="pageIndex" value="${searchVO.pageIndex}"/>
									</c:url>
									<a href="${viewUrl}"><c:out value="${result.boardSj}"/></a>
								</td>
								<td class="writer" data-cell-header="작성자 : ">
									<c:out value="${result.frstRegisterId}"/>
								</td>
								<td class="date" data-cell-header="작성일 : ">
									<fmt:formatDate value="${result.frstRegistPnttm}" pattern="yyyy-MM-dd"/>
								</td>
								<td class="hits" data-cell-header="조회수 : ">
									<c:out value="${result.inqireCo}"/>
								</td>
							</tr>
						</c:forEach>
						
						<!-- 일반 글 -->
						<c:forEach var="result" items="${resultList}" varStatus="status">
							<tr>
								<td class="num">
									<c:out value="${paginationInfo.totalRecordCount - ((searchVO.pageIndex-1) * searchVO.pageUnit) - (status.count - 1)}"/>
								</td>
								<td class="tit">
									<c:if test="${not empty result.atchFileNm}">
										<c:url var="thumbUrl" value="/cmm/fms/getThumbImage.do">
											<c:param name="thumbYn" value="Y"/>
											<c:param name="atchFileNm" value="${result.atchFileNm}"/>
										</c:url>
										<img src="${thumbUrl}" alt="">
									</c:if>
									<br>
									<c:url var="viewUrl" value="/board2/select.do${_BASE_PARAM}">
										<c:param name="boardId" value="${result.boardId}"/>
										<c:param name="pageIndex" value="${searchVO.pageIndex}"/>
									</c:url>
									<a href="${viewUrl}">
										<c:if test="${result.othbcAt eq 'Y'}">
											<img alt="비밀 글 아이콘" src="/asset/BBSTMP_0000000000001/images/ico_board_lock.gif">
										</c:if>
										<c:out value="${result.boardSj}" />
									</a>
								</td>
								<td class="writer" data-cell-header="작성자 : ">
									<c:out value="${result.frstRegisterId}"/>
								</td>
								<td class="date" data-cell-header="작성일 : ">
									<fmt:formatDate value="${result.frstRegistPnttm}" pattern="yyyy-MM-dd"/>
								</td>
								<td class="hits" data-cell-header="조회수 : ">
									<c:out value="${result.inqireCo}"/>
								</td>
								</td>
							</tr>
						</c:forEach>
						<!-- 게시글이 없을 경우 -->
						<c:if test="${fn:length(resultList) == 0}">
							<tr class="empty"><td colspan="5">검색 데이터가 없습니다.</td></tr>
						</c:if>
					</tbody>
				</table>				
			</div>
			<div id="paging">
				<c:url var="pageUrl" value="/board2/selectList.do${_BASE_PARAM}"/>
				<c:set var="pagingParam"><c:out value="${pageUrl}"/></c:set>
				<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="${pagingParam}"/>
			</div>
		</div>
		<div class="bit-cont ar">
			<a href="/board2/board2Regist.do" class="btn spot">
				<i class="ico-check-spot"></i> 글쓰기
			</a>
		</div>
	</div>
</div>
<script>
	<c:if test="${not empty message}">
		alert("${message}");
	</c:if>
</script>

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