<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			*{margin:0; padding:0;}
			div{width:850px; margin:30px auto; text-align: center;}
			h1{margin-bottom:30px;}
			table,th,td{border:1px solid black; border-collapse: collapse;
			font-size:16px; }
			th{width:300px; height:40px;}
			td{width:550px; text-align: left; padding-left: 50px;}
			button{width: 200px; height: 60px; margin-top:30px;}
			td *{vertical-align: middle; }
			#idCheck{width: 100px; height: 20px; margin-top:0;}
		</style>
		<script>
			$(function(){
				
			});//jquery
		</script>
	</head>
	<body>
		<div>
			<h1>회원정보수정</h1>
			<form name="mFrm" method="post" action="u_DoUpdate.do" enctype="multipart/form-data">
				<table>
					<tr>
						<th>아이디</th>
						<td>
							${udto.u_id}
						</td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" name="pw" id="pw"></td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td><input type="text" name="nickname" id="nickname" value="${udto.u_nicname}"></td>
					</tr>
					<tr>
						<th>프로필 사진</th>
						<td>
							<input type="file" name="u_profileImg" id="u_profileImg" value="${udto.u_profileImg}">
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" id="email" value="${udto.u_email}"></td>
					</tr>
					<tr>
						<th>지역</th>
						<td>
							
							<input type="radio" name="local" id="서울" value="서울" <c:if test="${fn:contains(udto.u_local,'서울')}">checked</c:if> >
							<label for="서울">서울</label>
							<input type="radio" name="local" id="경기" value="경기" <c:if test="${fn:contains(udto.u_local,'경기')}">checked</c:if> >
							<label for="경기">경기</label>
							<input type="radio" name="local" id="인천" value="인천" <c:if test="${fn:contains(udto.u_local,'인천')}">checked</c:if> >
							<label for="인천">인천</label>
							<input type="radio" name="local" id="강원" value="강원" <c:if test="${fn:contains(udto.u_local,'강원')}">checked</c:if> >
							<label for="강원">강원</label>
							<input type="radio" name="local" id="충북" value="충북" <c:if test="${fn:contains(udto.u_local,'충북')}">checked</c:if> >
							<label for="충북">충북</label>
							<input type="radio" name="local" id="충남" value="충남" <c:if test="${fn:contains(udto.u_local,'충남')}">checked</c:if> >
							<label for="충남">충남</label>
							<input type="radio" name="local" id="세종" value="세종" <c:if test="${fn:contains(udto.u_local,'세종')}">checked</c:if> >
							<label for="세종">세종</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<input type="radio" name="local" id="대전" value="대전" <c:if test="${fn:contains(udto.u_local,'대전')}">checked</c:if> >
							<label for="대전">대전</label>
							<br>
							<input type="radio" name="local" id="광주" value="광주" <c:if test="${fn:contains(udto.u_local,'광주')}">checked</c:if> >
							<label for="광주">광주</label>
							<input type="radio" name="local" id="전북" value="전북" <c:if test="${fn:contains(udto.u_local,'전북')}">checked</c:if> >
							<label for="전북">전북</label>
							<input type="radio" name="local" id="경북" value="경북" <c:if test="${fn:contains(udto.u_local,'경북')}">checked</c:if> >
							<label for="경북">경북</label>
							<input type="radio" name="local" id="대구" value="대구" <c:if test="${fn:contains(udto.u_local,'대구')}">checked</c:if> >
							<label for="대구">대구</label>
							<input type="radio" name="local" id="제주" value="제주" <c:if test="${fn:contains(udto.u_local,'제주')}">checked</c:if> >
							<label for="제주">제주</label>
							<input type="radio" name="local" id="전남" value="전남" <c:if test="${fn:contains(udto.u_local,'전남')}">checked</c:if> >
							<label for="전남">전남</label>
							<input type="radio" name="local" id="경남/울산" value="경남/울산" <c:if test="${fn:contains(udto.u_local,'경남/울산')}">checked</c:if> >
							<label for="경남/울산">경남/울산</label>
							<input type="radio" name="local" id="부산" value="부산" <c:if test="${fn:contains(udto.u_local,'부산')}">checked</c:if> >
							<label for="부산">부산</label>
						</td>
					</tr>
					<tr>
						<th>관심 카테고리</th>
						<td>
							<input type="checkbox" name="category" id="culture" value="culture" <c:if test="${fn:contains(udto.u_category,'culture')}">checked</c:if> >
							<label for="culture">문화/예술</label>&nbsp&nbsp&nbsp&nbsp
							<input type="checkbox" name="category" id="activity" value="activity" <c:if test="${fn:contains(udto.u_category,'activity')}">checked</c:if> >
							<label for="activity">액티비티</label>&nbsp&nbsp
							<input type="checkbox" name="category" id="food" value="food" <c:if test="${fn:contains(udto.u_category,'food')}">checked</c:if> >
							<label for="food">푸드/드링크</label>&nbsp
							<input type="checkbox" name="category" id="investment" value="investment" <c:if test="${fn:contains(udto.u_category,'investment')}">checked</c:if> >
							<label for="investment">재테크</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<input type="checkbox" name="category" id="hobby" value="hobby" <c:if test="${fn:contains(udto.u_category,'hobby')}">checked</c:if> >
							<label for="hobby">취미</label><br>
							<input type="checkbox" name="category" id="party" value="party" <c:if test="${fn:contains(udto.u_category,'party')}">checked</c:if> >
							<label for="party">파티/소개팅</label>&nbsp
							<input type="checkbox" name="category" id="trip" value="trip" <c:if test="${fn:contains(udto.u_category,'trip')}">checked</c:if> >
							<label for="trip">여행/동행</label>&nbsp
							<input type="checkbox" name="category" id="develop" value="develop" <c:if test="${fn:contains(udto.u_category,'develop')}">checked</c:if> >
							<label for="develop">자기계발</label>&nbsp&nbsp&nbsp&nbsp&nbsp
							<input type="checkbox" name="category" id="amity" value="amity" <c:if test="${fn:contains(udto.u_category,'amity')}">checked</c:if> >
							<label for="amity">동네/친목</label>&nbsp&nbsp
							<input type="checkbox" name="category" id="language" value="language" <c:if test="${fn:contains(udto.u_category,'language')}">checked</c:if> >
							<label for="language">외국어</label>
						</td>
					</tr>
				</table>
				<button type="button" id="fbtn">저장</button>
				<button type="button" onclick="javascript:history.back()">취소</button>
			</form>
		</div>
	
	</body>
</html>
