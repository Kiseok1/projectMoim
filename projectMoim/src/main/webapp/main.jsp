<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<c:if test="${session_id==null}">
		<a href="u_insert.do"><h3>회원가입</h3></a>
		<a href="u_login.do"><h3>로그인</h3></a>
	</c:if>
	<c:if test="${session_id!=null }">
		<h3>${session_nicname}님</h3></a>
		<a href="u_logout.do"><h3>로그아웃</h3></a>
	</c:if>
		<a href="g_main.do"><h3>모임</h3></a>
		<a href="b_list.do"><h3>게시판</h3></a>
		
		<!-- test -->
		
	</body>
</html>