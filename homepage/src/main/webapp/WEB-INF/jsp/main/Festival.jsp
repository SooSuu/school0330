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
        </div>
    </section>
    <section class="content">
        <div class="item-wrap">
            <div class="item" id="fes01">
                <img src="/images/icon1.png"><br>
                <p class="menu">진주남강유등축제</p>
                The Lakers had as many all-stars as the Bulls.<br>
            </div>
            <div class="item" id="fes02">
                <img src="/images/icon2.png"><br>
                <p class="menu">개천예술제</p>
                The Lakers had as many all-stars as the Bulls.<br>
            </div>
            <div class="item" id="fes03">
                <img src="/images/icon3.png"><br>
                <p class="menu">진주논개제</p>
                The Lakers had as many all-stars as the Bulls.<br>
            </div>
            <div class="item" id="fes04">
                <img src="/images/icon4.png"><br>
                <p class="menu">진주소싸움대회</p>
                The Lakers had as many all-stars as the Bulls.<br>
            </div>
            <div class="item" id="fes05">
                <img src="/images/icon4.png"><br>
                <p class="menu">진주국제농식품박람회</p>
                The Lakers had as many all-stars as the Bulls.<br>
            </div>
            <div class="item" id="fes06">
                <img src="/images/icon4.png"><br>
                <p class="menu">진주탈춤한마당</p>
                The Lakers had as many all-stars as the Bulls.<br>
            </div>
            <div class="item">
                <p class="menu">찾아오는 길</p>
                <br>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3260.6841416458674!2d128.07968821558407!3d35.18942426439311!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x356efc1488a4893f%3A0xc9987c0b1b26d1ef!2z7LSJ7ISd66Oo!5e0!3m2!1sko!2skr!4v1657083411773!5m2!1sko!2skr" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                <br>
                The Lakers had as many all-stars as the Bulls.
                <br>
            </div>
        </div>
        <span class="material-symbols-outlined">
            <a href="#header">
                arrow_upward
            </a>
        </span>
    </section>

</body>
</html>