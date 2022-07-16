<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>축제소개</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Jua&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- 헤더 인클루드 -->
<%@ include file="/WEB-INF/jsp/main/Header.jsp" %>


    <img src='<c:url value="/images/light02_1.jpg"/>' class="sidebar">

    <section>
        <div class="sub_bar">
            <span><a href="#fes01">진주남강유등축제</a></span>
            <span><a href="#fes02">개천예술제</a></span>
            <span><a href="#fes03">진주논개제</a></span>
            <span><a href="#fes04">진주소싸움대회</a></span>
            <span><a href="#fes05">진주국제농식품박람회</a></span>
            <span><a href="#fes06">진주탈춤한마당</a></span> 
            <span><a href="#fes07">오시는 길</a></span> 
        </div>
    </section>
    <section class="content">
        <div class="item-wrap">
            <div class="item" id="fes01">
                <img class="fesImg" src="/images/river02.jpg"><br>
                <p class="menu">진주남강유등축제</p>
                <p class="list">
                ○ 본행사<br>
				초혼점등식, 소망등달기, 유등띄우기, 세계풍물등 및 한국의 등(燈) 전시, 빛으로 되살아난 진주성 등(燈) 전시 창작등(燈) 전시
				<br>
				○ 체험참여마당 및 부대행사<br>
				유등과 함께하는 시인들, 소망등(燈) 달기 체험, 소형등(燈) 만들기 체험, 유등 만들어 띄우기 체험, 사랑다리 건너기 체험(부교), 사랑, 고백 이벤트, 시민참여 등(燈) 만들기 체험 전통놀이 체험, 소원성취 나무 등(燈) 체험, 대한민국 등(燈) 공모대전 출품작 전시, 유람선으로 아름다운 등(燈) 관람체험, 남가람 어울마당, 축등 설치, 수상 등(燈) 카페 운영, 음식큰잔치 및 농·특산품 판매코너, 멀티파이어 불꽃놀이
				<br>
				○ 동반행사<br>
				박물관 문화체험(탁본, 목판인쇄, 엽서쓰기), 3D입체영화 진주성 전투, 진주성 한복 체험, 진주 역사 골든벨<br>
            	</p>
            </div>
            <div class="item" id="fes02">
                <img class="fesImg" src="/images/02_02.jpg"><br>
                <p class="menu">개천예술제</p>
                <p class="list">
                ○ 전야 서제<br>
				성화 채화, 진다례 말차시연, 호국타종, 성화 봉송 및 안치, 제향, 진군명령 퍼포먼스, 불꽃놀이, 개천합창제
				<br>
				○ 개제식<br>
				식전퍼포먼스, 개제식, 가장행렬 출정선언식, 가장행렬
				<br>
				○ 예술문화축하행사<br>
				진주오광대 정기공연, 대한민국 농악축제, 남가람열린마당, 촉석산성아리아(창작 뮤지컬) 종야축제 등
				<br>
				○ 진주성특별체험행사<br>
				경상우병영체혐(진주성 별무사체험(무과체험), 진주목사 진주성 민정순시, 진주성 별무사 무예시연, 짚풀공예체험 등)
				<br>
				○ 예술경연대회<br>
				국악경연, 시조경창, 무용경연, 개천문학상, 학생백일장, 시낭송대회, 미술대상전, 개천 미술실기대회, 전국 휘호대회, 사진촬영대회, 학생연극제, 남가람가요제, 전국음악경연대회
                <br>
                ○ 각종전시<br>
				미술대상전, 전국휘호대회, 전국사진촬영대회, 한·중 사진 교류전, 사진작가 협회 진주지부 회원전, 분재 전시회, 개천 꽃 예술 작품전
				<br>
				○ 동반 축하 행사<br>
				진주실크박람회, 진주 공예인 축제 한마당, 진주 민속소싸움대회, 시민의 날 행사, 진주가요제, 전국밴드경연대회<br>
                </p>
            </div>
            <div class="item" id="fes03">
                <img class="fesImg" src="/images/03_02.jpg"><br>
                <p class="menu">진주논개제</p>
                <p class="list">
                ○ 본 행사<br>
				헌다례, 신위순행, 개제선언, 의암별제, 논개순국 재현극, 전통혼례 등
                <br>
                ○ 부대행사<br>
				논개정가 공연, 마리오네트 인행의 진주성이야기, 의기논개<넋을 기리며>, 논개 깃발전, 의기논개 동영상 스트리밍 등
                <br>
                ○ 동반행사<br>
				진주 스트릿댄스 페스티벌, 볼래로협동조합 콘서트, 진주 포구락무 공연, 온라인 프린지 공연, 연지골 예술단 공연 등<br>
                </p>
            </div>
            <div class="item" id="fes04">
                <img class="fesImg" src="/images/04_02.jpg"><br>
                <p class="menu">진주소싸움대회</p>
                <p class="list">
                    ○ 진주 토요상설 민속소싸움경기<br>
                    - 개최시기 : 4월 ~ 9월 (매주 토요일)<br>
                   	 ※ 혹서기 및 장마철 : 7~8월 일부 제외<br>
                    - 주 소 : 진주전통소싸움경기장(진주시 판문오동길 100)<br>
                    - 관리기관 : 진주시 관광진흥과<br>
                    - 전화번호 : 055-749-8597<br>
                    * 진주투우협회 055-747-6159<br>
                    - 이 용 료 : 무료<br>
                    - 주차정보 : 경기장 맞은편 꿈키움동산 주차가능<br>
                </p>
            </div>
            <div class="item" id="fes05">
                <img class="fesImg" src="/images/05.jpg"><br>
                <p class="menu">진주국제농식품박람회</p>
                <p class="list">
                    ○ 전시관<br>
                    - 농기자재관 : 대형·소형 농기계 전시, 농업용 드론,무인헬기 전시, 바이오 산업,비료,농약 등 농자재 전시<br>
                    - 농업홍보관 : 경상남도·진주시·지역대학 홍보관 운영, 농업기술 전시 및 체험<br>
                    - 녹색식품관 : 경남·남해안남중권 우수 농식품 전시, 경남벤처농업 우수사례 전시<br>
                    - 해외관 : 해외 농식품·문화 특별 전시, 경남 수출 유망 농식품 전시 및 비즈니스센터 운영<br>
                    - 종자생명관 : 종자의 중요성·미래식량 확보 이해 공간 조성, 종자 활용 작품 전시 및 체험<br>
                    - 체험관 : 농촌교육농장 체험, 농업 체험 프로그램 운영<br>
                    - 펫 체험관 : 펫 관련 동물 교육·체험, 가축동물 체험<br>
                    <br>
                    ○ 부대행사/특별행사 : 도심 속 목장 나들이, 문화예술 페스티벌, 먹거리 장터, 문화공연
                </p>
            </div>
            <div class="item" id="fes06">
                <img class="fesImg" src="/images/06_02.jpg"><br>
                <p class="menu">진주탈춤한마당</p>
                <p class="list">
               	○ 축제내용 : 한국전통탈춤, 창작탈춤, 농악, 마당극, 대동굿, 학술행사, 창작탈 전시회, 시민참여마당 및 체험행사
                  <br>
                  ○ 장소 : 남강야외무대 일원
                  <br>
                  ○ 주요 행사 내용<br>
		                    위령굿, 한국탈춤공연, 창작탈춤 및 마당극공연, 특별/축하공연, 창작 대동굿, 설치미술, 창작탈 전시회, 시민참여행사 
                </p>
            </div>
            <div class="item" id="fes07">
                <p class="menu">오시는 길</p>
                <br>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3260.6841416458674!2d128.07968821558407!3d35.18942426439311!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x356efc1488a4893f%3A0xc9987c0b1b26d1ef!2z7LSJ7ISd66Oo!5e0!3m2!1sko!2skr!4v1657083411773!5m2!1sko!2skr" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                <br>
                 <p class="list">
                	진주남강유등축제, 개천예술제, 진주논개제 개최 장소 입니다.<br>
                </p>
            </div>
        </div>
        <span class="material-symbols-outlined">
            <a href="#header">
                arrow_upward
            </a>
        </span>
    </section>

    <footer>
		진주축제<br>
		관리자 연락처 : 010-0000-0000<br>
		52789 경상남도 진주시 동진로 155 (상대동)
    </footer>

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