<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
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
  <title>로그인 페이지 | test</title>
  <link rel="stylesheet" href="resources/css/setting.css">
  <link rel="stylesheet" href="resources/css/plugin.css">
  <link rel="stylesheet" href="resources/css/template.css">
  <link rel="stylesheet" href="resources/css/common.css">
  <link rel="stylesheet" href="resources/css/style.css">
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
			$(function(){
				$("#btn").click(function(){
					lFrm.submit();
				});
			});//jquery
		</script>
</head>

<body>
  
  <div id="header"></div>
  <main class="th-layout-main ">
    <!-- [S]basic-N37 -->
    <div class="basic-N37" data-bid="SqLPkH07cN" id="">
      <div class="contents-inner">
        <div class="contents-container container-md">
          <div class="imageset">
            <img class="imageset-img" src="resources/images/img_basic_N37_1.png" alt="이미지">
          </div>
          <div class="form-group form-line">
            <div class="contents-check">
              <div class="checkset-wrap">
                <div class="checkset">
                  <input id="basic-N37-1" class="checkset-input input-fill" type="checkbox" value="" checked="">
                </div>
                <div class="checkset">
                  <input id="basic-N37-2" class="checkset-input input-fill" type="checkbox" value="">
                </div>
              </div>
            </div>
            
            <form name="lFrm" method="post" action="dologin.do">
            <div class="inputset inputset-line inputset-lg inputset-label">
              <label>
                <h6 class="inputset-tit">ID * </h6>
                <input type="text" class="inputset-input form-control" name="id" id="id" placeholder="아이디를 입력해주세요." aria-label="내용" required="">
              </label>
            </div>
            <div class="inputset inputset-line inputset-lg inputset-label">
              <label>
                <h6 class="inputset-tit">Password​ * </h6>
                <input type="password" class="inputset-input form-control" name="pw" id="pw" placeholder="비밀번호를 입력해주세요." aria-label="내용" required="">
              </label>
            </div>
            <div class="inputset inputset-line inputset-lg inputset-label">
            </div>
            <div class="inputset inputset-line inputset-lg inputset-label">
              <label>
              </label>
            </div>
            <div class="form-btn">
              <button class="btnset" id="btn" type="button">로그인</button>
            </div>
            </form>
            
          </div>
        </div>
      </div>
    </div>
    <!-- [E]basic-N37 -->
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
		<script>
			$(function(){
				$("#header").load("header.jsp");
			})
		</script>