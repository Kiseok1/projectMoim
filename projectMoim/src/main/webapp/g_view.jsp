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
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<script>
			$(function(){
				//가입
				$("#jBtn").click(function(){
					if(${session_id != null } ){
						//alert("가입페이지로 이동합니다.");
						//location.href="g_join.do?g_id=${gdto.g_id}";
						
						location.href="g_apply.do?g_id=${gdto.g_id}";
					} else {
						alert("가입신청은 로그인후에 가능합니다.");
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
		<style>
			.gview_cont{margin:0 auto; width: 600px;}
			.memImg{display:inline-block;}
			p{text-align: center;}
			#g_name{font-size: 20px; font-weight: 500;}
		</style>
		
	</head>
	<body>
		<div id="header"></div>
	
		<c:set var="id" value="${session_id}" />
		
		<div class="gview_cont">
			<img src="upload/${gdto.g_file}" style="height:200px;">
			<div>
				<c:forEach	items="${list}" var="u">
					<c:if test="${admin==u.u_id}">
						<div class="memImg" style="margin-top: 10px; width:70px;  float: left;" >
							<img src="upload/${u.u_profileImg}" style="width:50px; height:50px; border:2px solid blue; border-radius: 50%;">
						</div>
					</c:if>
				</c:forEach>
					<div style="margin-top: 10px; vertical-align: middle;">
						<div id="g_name">${gdto.g_name}</div>
						<div>호스트 ${gdto.g_user_id}</div>
					</div>
			</div>
			<div style="display: block;"><i class="fa fa-users" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp${gdto.g_member_cnt}명</div>
			
			<div style="margin-top: 10px;">${gdto.g_content}</div>
			<h5 style="margin-top: 10px;">가입멤버</h5>
				<div>
					<c:forEach	items="${list}" var="u">
						<c:if test="${admin==u.u_id}">
							<div class="memImg">
								<img src="upload/${u.u_profileImg}" style="width:50px; height:50px; border:2px solid blue; border-radius: 50%;">
								<p>${u.u_id}</p>
							</div>
						</c:if>
						<c:if test="${admin!=u.u_id}">
							<div class="memImg">
								<img src="upload/${u.u_profileImg}" style="width:50px; height:50px; border-radius: 50%;" >
								<p>${u.u_id}</p>
							</div>
						</c:if>
					</c:forEach>
				</div>
			<!-- 가입자 -->
			<c:if test="${session_id!=null && fn:contains(gdto.g_member_id,id)}">
			<h5 style="margin-top: 10px;"><a href="b_list.do?g_id=${gdto.g_id}&g_name=${gdto.g_name}"><i class="fa fa-list" aria-hidden="true"></i>&nbsp&nbsp&nbsp게시판</a></h5>	
			<h5><a href="#"><i class="fa fa-picture-o" aria-hidden="true"></i>&nbsp&nbsp&nbsp사진첩</a></h5>	
			<h5 id="qBtn" style="cursor: pointer;"><i class="fa fa-times" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp탈퇴</h5>
			</c:if>
			<!-- 운영자 -->
			<c:if test="${session_id!=null && fn:contains(gdto.g_user_id,id)}">
			<h5><a href="g_admin.do?g_id=${gdto.g_id}"><i class="fa fa-lock" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp&nbsp관리페이지</a></h5>
			</c:if>
			<!-- 비가입자(로그인) -->
			<c:if test="${not fn:contains(gdto.g_member_id,id)}">
			<h5 id="jBtn" style="cursor: pointer;"><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp&nbsp가입 신청</h5>
			</c:if>
			<!-- 비가입자(비로그인) -->
			<c:if test="${session_id==null}">
			<h5 id="jBtn" style="cursor: pointer;"><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp&nbsp가입 신청</h5>
			</c:if>
		</div>

		
		<script>
			$(function(){
				$("#header").load("header.jsp");
				
			})
		</script>
	</body>
</html>