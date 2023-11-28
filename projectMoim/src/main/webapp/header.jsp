<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
			로고
			<c:if test="${session_id==null}">
			<a href="u_insert.do">회원가입</a>|<a href="u_login.do">로그인</a>
			</c:if>
			<c:if test="${session_id!=null}">
			<a href="u_mypage.do">${session_nickname}</a>|<a href="u_logout.do">로그아웃</a>
			</c:if>
			
		
	
	</body>
</html>