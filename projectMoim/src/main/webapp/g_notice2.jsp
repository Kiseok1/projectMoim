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
			<title>모임공지사항</title>
		</head>
			<style>
				.BoardList{display: none;}
			
			</style>
				<script>
					$(function(){
				    $(".BoardList").slice(0, 5).show(); // 초기에는 첫 번째 div 요소만 표시됩니다.
				    $("#load").click(function(e){// "load"라는 id를 가진 요소가 클릭되면
				        e.preventDefault();// 기본 이벤트 동작을 중지합니다.
				        $(".BoardList:hidden").slice(0, 10).show(); // 숨겨진(div:hidden) 요소 중에서 1개씩 보여줍니다. (더 많이 로드하는 역할)
				       /*  if($(".BoardList:hidden").length == 0){ // 남아있는 숨겨진 요소가 없다면
				            alert("게시물의 끝입니다."); // 컨텐츠 없을시 alert 창 띄우기 
					        } */
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
				<form action="g_notice2.do" name="lfrm" class="innerbox" method="post" enctype="multipart/form-data">
				<div class="toast">
					<a href="https://https://www.notion.so/Project-1-d3dbad96ba6a4df498ae5eb0abe7927f" class="aa" target="blank">공지사항가이드</a>
				</div>
				<br>
				<br>
				<ul class="BoardList">
					<a href="g_notice_info.jsp" >
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate" name="l_date">2023.11.22</span>
						</li>
					</a>
				</ul>			
				<ul class="BoardList">
					<a href="g_notice_info.jsp" >
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate" name="l_date">2023.11.22</span>
						</li>
					</a>
				</ul>
				<ul class="BoardList">
					<a href="g_notice_info.jsp" >
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate" name="l_date">2023.11.22</span>
						</li>
					</a>
				</ul>
				<ul class="BoardList">
					<a href="g_notice_info.jsp" >
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate" name="l_date">2023.11.22</span>
						</li>
					</a>
				</ul>
				<ul class="BoardList">
					<a href="g_notice_info.do" >
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate" name="l_date">2023.11.22</span>
						</li>
					</a>
				</ul>
				<ul class="BoardList">
					<a href="g_notice_info.do" >
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate" name="l_date">2023.11.22</span>
						</li>
					</a>
				</ul>
				<ul class="BoardList">
					<a href="g_notice_info.do" >
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate" name="l_date">2023.11.22</span>
						</li>
					</a>
				</ul>
				<ul class="BoardList">
					<a href="g_notice_info.jsp" >
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate" name="l_date">2023.11.22</span>
						</li>
					</a>
				</ul>
				<ul class="BoardList">
					<a href="g_notice_info.jsp" >
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate" name="l_date">2023.11.22</span>
						</li>
					</a>
				</ul>
				<ul class="BoardList">
					<a href="g_notice_info.jsp">
						<li class="innerList">
							<span class="listtitle" name="l_title">[공지]4.12.0 버전 업데이트 안내</span>
									<img class="barrow" name="l_file" src="./images/paging_next.png" alt="arrow">							
								<br>
								<span class="listdate">2023.11.22</span>
						</li>
					</a>
				</ul>
				<br>
				<div class="moreList" aria-hidden="true">
					<div>
					<!-- 	<h1 id="moreList_font">더보기</h1>
						<img class="moreListArrow" src="./images/paging_next.png" alt="arrow" width="4" height="8.75" decoding="async" 
						data-nimg="1" style="color:transparent"> -->
						<a href="g_notice2.do"><input type="submit" id="load" value="더보기"></a>
					</div>
				</div>	
			
			</form>
		</div>
	</div>
	
	</body>
</html>
