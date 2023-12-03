<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
			.mypage1{margin: 20px 0 0 200px; font-size:25px; line-height: 100px;}
			.mypage2{margin: 20px 0 0 200px; font-size:25px; line-height: 50px;}
			#g_name{margin-top:20px; margin-left: 50px;}
			img{width:50px; height: 50px; border-radius: 20%;}
			#g_content{diplay:-webkit-box; -webkit-box-orient:vertical; word-wrap:break-word; -webkit-line-camp:2; overflow:hidden; text-overflow: ellipsis;
					white-space: nowrap; width:1000px; height:50px; font-size: 16px; color:black;}	
			
		</style>
	</head>
	<body>
		<div id="header"></div>
		<div>
			<div>
				<ul class="mypage1">
					<li><a href="u_update.do"><i class="fa fa-user" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp개인정보 수정</a></li>
					<li><a href="u_message.do"><i class="fa fa-envelope" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp쪽지함</a></li>
					<li><a href="g_create.do"><i class="fa fa-plus" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp모임 개설</a></li>
				</ul>
			</div>
			<div>
				<ul class="mypage2"> <i class="fa fa-check-square" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp참여 모임
					<c:forEach items="${list}" var="gdto">
						<li id="g_name">
							<a href="g_view.do?g_id=${gdto.g_id}" style="display: inline;">
								§  <img src="upload/${gdto.g_file}">   ${gdto.g_name}
								<p id="g_content">${gdto.g_intro} / ${gdto.g_content}</p>
							</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div id="footer" style="margin-top: 200px;"></div>
	</body>
		<script>
		$(function(){
			$("#header").load("header.jsp");
			$("#footer").load("footer.jsp");
		})
		</script>
</html>