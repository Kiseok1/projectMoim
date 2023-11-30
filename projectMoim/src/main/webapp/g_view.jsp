<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
			$(function(){
				//가입
				$("#jBtn").click(function(){
					if(${session_id != null } ){
						alert("가입페이지로 이동합니다.");
						location.href="g_join.do?g_id=${gdto.g_id}";
					} else {
						alert("가입은 로그인후에 가능합니다.");
						location.href="u_login.do";
						return false;
					}
				});//가입 클릭
				
				//탈퇴
				$("#qBtn").click(function(){
					if(confirm("모임을 탈퇴하시겠습니까?")){
						location.href="g_quit.do?g_id=${gdto.g_id}";
					}
				});//탈퇴 클릭
			});//jquery
		</script>
		
	</head>
	<body>
		<div id="header"></div>
	
		<c:set var="id" value="${session_id}" />
		<img src="upload/${gdto.g_file}" style="width:10%;">
		<h3>${gdto.g_name}</h3>
		<h5>가입자: ${gdto.g_member_cnt}명</h3>
		<h4>${gdto.g_intro}</h4>
		<div>${gdto.g_content}</div>
		<h5>가입자</h5>
		<c:forEach	items="${list}" var="u">
			<div>
				<c:if test="${admin==u.u_id}">
					<img src="upload/${u.u_profileImg}" style="width:2%; border:1px solid red;">
					<p>${u.u_id}</p>
				</c:if>
				<c:if test="${admin!=u.u_id}">
					<img src="upload/${u.u_profileImg}" style="width:2%;">
					<p>${u.u_id}</p>
				</c:if>
			</div>
		</c:forEach>
		
		<!-- 가입자 -->
		<c:if test="${session_id!=null && fn:contains(gdto.g_member_id,id)}">
		<h3>게시판 링크</h3>	
		<h3>사진첩 링크</h3>	
		<h5 id="qBtn">탈퇴</h5>
		</c:if>
		<!-- 운영자 -->
		<c:if test="${session_id!=null && fn:contains(gdto.g_user_id,id)}">
		<h5><a href="g_admin">관리페이지</a></h5>
		</c:if>
		<!-- 비가입자(로그인) -->
		<c:if test="${not fn:contains(gdto.g_member_id,id)}">
		<h5 id="jBtn">가입</h5>
		</c:if>
		<!-- 비가입자(비로그인) -->
		<c:if test="${session_id==null}">
		<h5 id="jBtn">가입</h5>
		</c:if>
		<input type="button" onclick="javascript:history.back()" value="뒤로">

		<div id="footer"></div>	
		<script>
			$(function(){
				$("#header").load("header.jsp");
				$("#footer").load("footer.jsp");
			})
		</script>
	</body>
</html>