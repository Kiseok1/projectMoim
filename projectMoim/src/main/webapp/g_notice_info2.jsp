<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>        
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<script src="http://code.jquery.com/jquery-latest.min.js"></script>
			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<link rel="stylesheet" type="text/css" href="css/g_notice.css">
			<title>모임공지사항정보</title>
		</head>
			<style>
			
	  
			</style>
			<script>
			$(function(){
				 $("#load").click(function(){
					if(confirm("이전페이지로 가시겠습니까?"))
					location.href="g_notice.jsp";
				 }			 
				 lfrm.submit();
				 });
				});


			</script>
			<body>
				<div class="top">
					<div class="inner">
						<div>
							<a><img src="./images/logo.png" id="logo"></a>
						</div>
							<div class="logo-search">
								<div>
									<input type="text" class="input-form">
										<div class="btn-search"></div>
								</div>
						</div>
								<div class="menu-area">
									<a href="#" class="items">로그인</a>
									<a href="#" class="items">회원가입</a>
									<a href="#" class="items">모임개설</a>
									<a href="#" class="items">공지사항</a>
								</div>	
								<div class="user">
				       		<div class="user-img"></div>
						</div>
					</div>
				</div>
				<br>
				<br>
				<div class="continer-box">
					<div class="box-group">
						<p class="page-title">공지사항</p> 
				<br>
				<form action="g_notice.jsp" name="lfrm" class="innerbox" method="post" enctype="multipart/form-data">
					 <div class="notice-header">
					 	<span class="notice-title">[공지]4.12.0 버전 업데이트 안내</span>
					 	<span class="notice-date">2023.11.22</span>
					 </div>
					 <br>
					 <div class="notice-content">
					 	<p>안녕하세요! 문토 조이예요🤗</p>
					 	<br>
					 	<br>
					 	<p style="padding-top: 0px;">
					 	"입김 그리고 겨울과 함께,"
					 	<br>
					 	"문토 업데이트 소식!"
					 	</p>
					 	<p>
							<br>
						</p>						 	
					 	<p style="padding-top:0px;">
					 		<br>
					 	</p>	
					 	<p style="padding-top:0px;">
					 		<strong style="font-size:18px;">#1) 찜한 모임을 쉽게 보는 방법</strong>
					 	</p>
					 	<ul>
							<li style="padding-top:0px;">
							"그동안 찾기 불편했던 찜한 모임 모아보기의 위치가 메인 상단으로 변경됐어요."
							</li>					 	
							<li style="padding-top:0px;">
							"메인 상단의 하트 아이콘을 누르면, 찜한 모든 모임들(소셜링, 클럽, 챌린지)을 쉽게 모아볼 수 있어요."
							</li>					 	
					 	</ul>
					 	<p style="padding-top:0px">
					 		<img class="notice-img" src="./images/info.png">
					 	</p>
					 	<ul>
							<li style="padding-top:0px;">
							"그동안 찾기 불편했던 찜한 모임 모아보기의 위치가 메인 상단으로 변경됐어요."
							</li>					 	
							<li style="padding-top:0px;">
							"메인 상단의 하트 아이콘을 누르면, 찜한 모든 모임들(소셜링, 클럽, 챌린지)을 쉽게 모아볼 수 있어요."
							</li>					 	
					 	</ul>
					 </div> 
				<div class="moreList" aria-hidden="true">
					<div>
					<!-- 	<h1 id="moreList_font">더보기</h1>
						<img class="moreListArrow" src="./images/paging_next.png" alt="arrow" width="4" height="8.75" decoding="async" 
						data-nimg="1" style="color:transparent"> -->
						<input type="submit" id="load" value="이전으로">
					</div>
				</div>			
				</form>
		</div>
	</div>
	
	</body>
</html>
