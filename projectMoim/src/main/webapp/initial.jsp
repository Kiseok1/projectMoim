<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta http-equiv="imagetoolbar" content="no">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="format-detection" content="telephone=no">
  <meta name="title" content="웹사이트">
  <meta name="description" content="웹사이트입니다.">
  <meta name="keywords" content="키워드,키워드,키워드">
  <meta property="og:title" content="웹사이트">
  <meta property="og:description" content="웹사이트입니다">
  <meta property="og:image" content="https://웹사이트/images/opengraph.png">
  <meta property="og:url" content="https://웹사이트">
  <title>첫페이지 | test</title>
  <link rel="stylesheet" href="resources/css/setting.css">
  <link rel="stylesheet" href="resources/css/plugin.css">
  <link rel="stylesheet" href="resources/css/template.css">
  <link rel="stylesheet" href="resources/css/common.css">
  <link rel="stylesheet" href="resources/css/style.css">
  <script>
  	$(function(){
		//검색창 클릭시 검색창 비우기
		$("#g_srch").click(function(){
			$("#g_srch").val("");
		});
		
		//검색창
		$("#sBtn").click(function(){
			if( $("#g_srch").val().length < 2 ){
				alert("검색어는 두글자 이상 입력하셔야합니다.");
				$("#g_srch").focus();
				return false;
			}
			$("#g_srch").val();
			sFrm.submit();
		});//sBtn click
		
		//로그아웃 버튼
		$("#logoutBtn").click(function(){
			location.href="u_logout.do";
		});
		
		//필터
		$("#fBtn").click(function(){
			$("#g_srch").val();
			fFrm.submit();
		});//sBtn click
	});//jquery
  </script>
  <style>
  	.search{margin-left: 300px;}
  </style>
</head>

<body>
  <!-- [S]basic-N2 -->
  <div class="basic-N2" data-bid="lPLpjf5Kr1" id="">
    <div class="header-inner">
      <div class="header-container container-lg">
        <h1 class="header-title">
          <a href="javascript:void(0)">
            <img src="resources/images/img_logo_black.png" alt="로고">
          </a>
        </h1>
        <div class="header-right">
          <div class="header-title header-mobile-top">
            <a href="javascript:void(0)">
              <img src="resources/images/img_logo_black.png" alt="로고">
            </a>
          </div>
          <ul class="header-gnblist">
            <li class="header-gnbitem">
              <a class="header-gnblink" href="javascript:void(0)">
                <span>HOME</span>
              </a>
            </li>
            <c:if test="${session_id==null}">
            <li class="header-gnbitem">
              <a class="header-gnblink" href="u_insert.do">
                <span>회원가입</span>
              </a>
            </li>
            <li class="header-gnbitem">
              <a class="header-gnblink" href="u_login.do">
                <span>로그인</span>
              </a>
            </li>
            </c:if>
            <c:if test="${session_id!=null}">
            <li class="header-gnbitem">
              <a class="header-gnblink" href="u_mypage.do">
                <span>${session_nickname}님</span>
              </a>
            </li>
            <li class="header-gnbitem">
              <a class="header-gnblink" href="u_logout.do">
                <span>로그아웃</span>
              </a>
            </li>
            </c:if>
            <li class="header-gnbitem">
              <a class="header-gnblink" href="javascript:void(0)">
                <span>공지사항</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="header-dim"></div>
  </div>
  <!-- [E]basic-N2 -->
  <main class="th-layout-main ">
    <!-- [S]basic-N42 -->
    <div class="basic-N42" id="">
      <div class="contents-inner">
   		<form name="sFrm" method="post" action="g_main.do">
			<input type="text" name="g_srch" id="g_srch" class="search" placeholder="검색어를 입력하세요"> 
			<input type="button" id="sBtn" value="확인">
		</form>	
		<form name="fFrm" method="post" class="search" action="g_main.do">
			<br>
			<h4>지역</h4>
			<label for="서울">서울</label>
			<input type="radio" name="local" id="서울" value="서울">
			&nbsp&nbsp
			<label for="경기">경기</label>
			<input type="radio" name="local" id="경기" value="경기">
			&nbsp&nbsp
			<label for="인천">인천</label>
			<input type="radio" name="local" id="인천" value="인천">
			&nbsp&nbsp
			<label for="강원">강원</label>
			<input type="radio" name="local" id="강원" value="강원">
			<br>
			<label for="충북">충북</label>
			<input type="radio" name="local" id="충북" value="충북">
			&nbsp&nbsp
			<label for="충남">충남</label>
			<input type="radio" name="local" id="충남" value="충남">
			&nbsp&nbsp
			<label for="세종">세종</label>
			<input type="radio" name="local" id="세종" value="세종">
			&nbsp&nbsp
			<label for="대전">대전</label>
			<input type="radio" name="local" id="대전" value="대전">
			<br><br>
			
			<h4>카테고리</h4>
			<input type="checkbox" name="category" id="culture" value="culture">
			<label for="culture">문화/예술</label>&nbsp&nbsp&nbsp&nbsp
			<input type="checkbox" name="category" id="activity" value="activity">
			<label for="activity">액티비티</label>&nbsp&nbsp
			<input type="checkbox" name="category" id="food" value="food">
			<label for="food">푸드/드링크</label>&nbsp
			<input type="checkbox" name="category" id="hobby" value="hobby">
			<label for="hobby">취미</label><br>
			<input type="checkbox" name="category" id="party" value="party">
			<label for="party">파티/소개팅</label>
			<input type="checkbox" name="category" id="trip" value="trip">
			<label for="trip">여행/동행</label>
			<input type="checkbox" name="category" id="develop" value="develop">
			<label for="develop">자기계발</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp	
			<input type="checkbox" name="category" id="amity" value="amity">
			<label for="amity">동네/친목</label><br>
			
			<input type="button" id="fBtn" value="적용하기">
		</form>
        <div class="contents-container container-md">
          <div class="textset">
            <h2 class="textset-tit">모임&nbsp;</h2>
            <p class="textset-desc">검색 모임 혹은 추천 모임</p>
          </div>
          <div class="swiper contents-swiper">
          
            <div class="swiper-wrapper">
          <!-- 모임 반복 시작 -->
          	<c:forEach items="${list}" var="gdto">
              <div class="swiper-slide">
                <a href="g_view.do?g_id=${gdto.g_id}" class="cardset cardset-shopping">
                  <figure class="cardset-figure">
                    <img class="cardset-img" src="upload/${gdto.g_file}" alt="스와이퍼 이미지">
                  </figure>
                  <div class="cardset-body">
                    <span class="cardset-name">${gdto.g_name}</span>
                    <h2 class="cardset-tit"> ${gdto.g_intro} </h2>
                    <p class="cardset-desc">${gdto.g_local} / ${gdto.g_category}</p>
                  </div>
                </a>
              </div>
          	</c:forEach>  
          <!-- 모임 반복 끝 -->
            </div>
          
          </div>
          <div class="swiper-button-prev"></div>
          <div class="swiper-button-next"></div>
          <div class="swiper-pagination"></div>
        </div>
      </div>
    </div>
    <!-- [E]basic-N42 -->
  </main>
  <!-- [S]basic-N4 -->
  <footer class="basic-N4" data-bid="oilpjEs3Uz">
    <div class="footer-container container-lg">
      <div class="footer-top">
        <h1 class="footer-logo">
          <a href="javascript:void(0)">
            <img src="resources/images/img_logo_lightgray.png" alt="로고">
          </a>
        </h1>
        <ul class="footer-menulist">
          <li class="footer-menuitem">
            <a href="javascript:void(0)">
              <span>이용약관</span>
            </a>
          </li>
          <li class="footer-menuitem">
            <a href="javascript:void(0)">
              <span>개인정보처리방침</span>
            </a>
          </li>
          <li class="footer-menuitem">
            <a href="javascript:void(0)">
              <span>푸터메뉴1</span>
            </a>
          </li>
          <li class="footer-menuitem">
            <a href="javascript:void(0)">
              <span>푸터메뉴2</span>
            </a>
          </li>
        </ul>
        <ul class="footer-snslist">
          <li class="footer-snsitem">
            <a class="footer-snslink" href="javascript:void(0)">
              <img src="resources/icons/ico_instagram_lightgrey.svg" alt="인스타그램">
            </a>
          </li>
          <li class="footer-snsitem">
            <a class="footer-snslink" href="javascript:void(0)">
              <img src="resources/icons/ico_youtube_lightgrey.svg" alt="유튜브">
            </a>
          </li>
          <li class="footer-snsitem">
            <a class="footer-snslink" href="javascript:void(0)">
              <img src="resources/icons/ico_facebook_lightgrey.svg" alt="페이스북">
            </a>
          </li>
          <li class="footer-snsitem">
            <a class="footer-snslink" href="javascript:void(0)">
              <img src="resources/icons/ico_kakao_lightgrey.svg" alt="카카오톡">
            </a>
          </li>
        </ul>
      </div>
      <div class="footer-bottom">
        <div class="footer-txt">
          <p> 서울시 영등포구 선유로70 우리벤처타운2 705호 </p>
          <p>
            <span>T. 070-8872-8874</span>
            <span>E. help@openfield.co.kr</span>
          </p>
        </div>
        <div class="footer-txt">
          <p>2022 BY TEMPLATEHOUSE. ALL RIGHTS RESEVED</p>
        </div>
      </div>
    </div>
  </footer>
  <!-- [E]basic-N4 -->
  <script src="resources/js/setting.js"></script>
  <script src="resources/js/plugin.js"></script>
  <script src="resources/js/template.js"></script>
  <script src="resources/js/common.js"></script>
  <script src="resources/js/script.js"></script>
</body>