<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쪽지함</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			.box{width: 100%; height: 710px; box-sizing: border-box; display: flex;}
			.leftBar{width: 300px; height: 710px; box-sizing: border-box;}
			.main{width: 100%; height: 710px; box-sizing: border-box; }
			.left-button{margin-top: 30px; margin-left:60px; font-size:15px; line-height: 50px; weigth:800;}
			.left-button div{background-color: black; color: white; text-align: center; border-radius: 20px;  
							margin-bottom: 30px; width: 140px; cursor: pointer;}
			.left-button a:link {color : white; text-decoration: none;}				
			.left-button a:visited {color : white; text-decoration: none;}				
			.left-button a:hover {color : white; text-decoration: none;}				
			.left-button a:acvtive {color : white; text-decoration: none;}				
		</style>
		<script>
			$(function(){
				//쪽지 쓰기
				$("a").click(function(){
					$('#iframe').attr('src',$(this).attr('data-url'));
				});//쪽지쓰기 클릭
				
			});//jquery
		</script>
	</head>
	<body>
		<div id="header"></div>
		<div class="box">
			<input type="hidden" id="id" value="${session_id}">
			<div class="leftBar">
				<div class="left-button"> 
					<a data-url="m_write.do"><div id="m_write">쪽지 쓰기</div></a>
					<a data-url="m_recvMsg.do"><div>받은 쪽지함</div></a>
					<a data-url="m_sentMsg.do"><div>보낸 쪽지함</div></a>
				</div>
			</div>
			<div class="main">
				<hr>
				<iframe id="iframe" src="m_recvMsg.do" width="100%" height="100%"></iframe>
				
				
				
					
			</div>	
		</div>
		<div id="footer"></div>
	</body>
	<script>
		$(function(){
			$("#header").load("header.jsp");
			$("#footer").load("footer.jsp");
		})
	</script>
</html>