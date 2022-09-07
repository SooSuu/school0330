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
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
	.wrap .login {text-align: center; margin-top: 70px;}
	.wrap .login .member-type {border: 1px solid black; padding: 30px;}
</style>

<!-- 헤더 인클루드 -->
<%@ include file="/WEB-INF/jsp/main/Header.jsp" %>

<div class="wrap">
	<nav class="login">
		<a href="/join/memberRegist.do?LoginType=normal" class="member-type">일반회원가입</a>
		<a class="btn-kakao" href="#" data-type="join">
			<img alt="카카오 로그인 버튼" src="/images/kakao.png" width="150">
		</a>
		<a class="btn-naver" href="${naverAuthUrl}" data-type="join">
			<img alt="네이버 로그인 버튼" src="/images/naver.png" width="150">
		</a>
	</nav>
</div>

<form action="/join/insertMember.do" id="joinFrm" name="joinFrm" method="post">
	<input type="hidden" name="loginType" value="" />
	<input type="hidden" name="emplyrId" />
	<input type="hidden" name="userNm" />
</form>

<!-- src="http://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm10vx1/o.jpg" -->

<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<script>
$(document).ready(function(){
	//카카오 로그인 버튼
	$(".btn-kakao").click(function(){
		const type = $(this).data("type");
		kakaoLogin(type);
		return false;
	});
});

//카카오 키 정보 입력
Kakao.init('a6f15dbcf315c5b7c8fcc8df54cdb17b');

//카카오SDK 초기화
Kakao.isInitialized();

//카카오 로그인
function kakaoLogin(type){
	Kakao.Auth.login({
		success : function (response){
			Kakao.API.request({
				url : '/v2/user/me',
				success :function (response){
					console.log(response)
					$("input[name=loginType]").val("KAKAO");
					
					if(type == "join"){
						$("input[name=emplyrId]").val(response.id);
						$("input[name=userNm]").val(response.properties.nickname);
						
						$("#joinFrm").submit();
					}else{
						$("input[name=id]").val(response.id);
						$("#frmLogin").submit();
					}
					
				},
				fail : function (error){
					console.log(error)
				},
			})
		}, fail : function (error){
			console.log(error)
		},
	})
}
</script>

</body>
</html>