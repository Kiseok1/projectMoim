<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	</head>
	<body>
		<div id="header"></div>
		<div>
		<ul>
			<li><a href="u_update.jsp">개인정보 수정</a></li>
			<li><a href="g_create.jsp">모임 개설</a></li>
		</ul>
		<ul> 참여 모임
			<c:forEach items="${list}" var="gdto">
				<a href="g_view.do?g_id=${gdto.g_id}" style="display: inline;"><li>§ ${gdto.g_name}</li></a>
			</c:forEach>
		</ul>
		</div>
	</body>
		<script>
		$(function(){
			$("#header").load("header.jsp");
		})
		</script>
</html>