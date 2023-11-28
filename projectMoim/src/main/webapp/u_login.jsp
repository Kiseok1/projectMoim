<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
			$(function(){
				$("#btn").click(function(){
					lFrm.submit();
				});
			});//jquery
		</script>
	</head>
	<body>
		<form name="lFrm" method="post" action="dologin.do">
			<label>id</label>
			<input type="text" name="id" id="id">
			<br>
			<label>pw</label>
			<input type="password" name="pw" id="pw">
			<br>
			<input type="button" id="btn" value="확인">
		</form>
 	
	</body>
</html>