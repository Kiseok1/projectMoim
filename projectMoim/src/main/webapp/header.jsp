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
  <title>헤더 | test</title>
  <link rel="stylesheet" href="resources/css/setting.css">
  <link rel="stylesheet" href="resources/css/plugin.css">
  <link rel="stylesheet" href="resources/css/template.css">
  <link rel="stylesheet" href="resources/css/common.css">
  <link rel="stylesheet" href="resources/css/style.css">
</head>


<body>
  <!-- [S]basic-N2 -->
  <div class="basic-N2" data-bid="HjlpKlCg2z" id="">
    <div class="header-inner">
      <div class="header-container container-lg">
        <h1 class="header-title">
          <a href="g_main.do">
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
              <a class="header-gnblink" href="g_main.do">
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
                <span>${session_nicname}님</span>
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
        <div class="header-utils">
          <button class="btn-momenu">
            <img src="resources/icons/ico_menu_black.svg" alt="모바일메뉴 아이콘">
          </button>
          <button class="btn-close">
            <img src="resources/icons/ico_close_black.svg" alt="닫기 아이콘">
          </button>
        </div>
      </div>
    </div>
    <div class="header-dim"></div>
  </div>
  <!-- [E]basic-N2 -->
  <script src="resources/js/setting.js"></script>
  <script src="resources/js/plugin.js"></script>
  <script src="resources/js/template.js"></script>
  <script src="resources/js/common.js"></script>
  <script src="resources/js/script.js"></script>
</body>