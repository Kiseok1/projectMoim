<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<title>Insert title here</title>
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
					sFrm.submit();
				});//sBtn click
				
				//필터
				$("#fBtn").click(function(){
					
					sFrm.submit();
				});//sBtn click
			});//jquery
		</script>
	</head>
	<body>
		<form name="sFrm" method="post" action="g_main.do">
			<input type="text" name="g_srch" id="g_srch" value="검색어를 입력하세요"> 
			<input type="button" id="sBtn" value="확인">
		<br>
		<h4>필터(모달)</h4>
		<h4>지역</h4>
		<label for="서울">서울</label>
		<input type="radio" name="local" id="서울" value="서울">
		<br>
		<label for="경기">경기</label>
		<input type="radio" name="local" id="경기" value="경기">
		<br>
		<label for="인천">인천</label>
		<input type="radio" name="local" id="인천" value="인천">
		<br>
		<label for="강원">강원</label>
		<input type="radio" name="local" id="강원" value="강원">
		<br>
		<label for="충북">충북</label>
		<input type="radio" name="local" id="충북" value="충북">
		<br>
		<label for="충남">충남</label>
		<input type="radio" name="local" id="충남" value="충남">
		<br>
		<label for="세종">세종</label>
		<input type="radio" name="local" id="세종" value="세종">
		<br>
		<label for="대전">대전</label>
		<input type="radio" name="local" id="대전" value="대전">
		<br>
		<hr>
		<h4>카테고리</h4>
		<input type="checkbox" name="category" id="culture" value="culture">
		<label for="culture">문화/예술</label><br>
		<input type="checkbox" name="category" id="activity" value="activity">
		<label for="activity">액티비티</label><br>
		<input type="checkbox" name="category" id="food" value="food">
		<label for="food">푸드/드링크</label><br>
		<input type="checkbox" name="category" id="hobby" value="hobby">
		<label for="hobby">취미</label><br>
		<input type="checkbox" name="category" id="party" value="party">
		<label for="party">파티/소개팅</label><br>
		<input type="checkbox" name="category" id="trip" value="trip">
		<label for="trip">여행/동행</label><br>
		<input type="checkbox" name="category" id="develop" value="develop">
		<label for="develop">자기계발</label><br>
		<input type="checkbox" name="category" id="amity" value="amity">
		<label for="amity">동네/친목</label><br>
		
		<input type="button" id="fBtn" value="적용하기">
		</form>
		
		<ul>
			<c:forEach items="${list}" var="gdto">
				<div>
					모임명 : ${gdto.g_name}
				</div>
			</c:forEach>
		</ul>
	</body>
</html>