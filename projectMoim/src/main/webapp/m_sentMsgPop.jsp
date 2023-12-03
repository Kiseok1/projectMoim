<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쪽지 팝업</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			.mwrite{display: flex; witdh:450px; margin-top: 10px;}
			.mcontent{display: block; margin-top: 10px;}
		</style>
		<script>
			
		</script>
	</head>
	<body>
		<div>
			<div class="mwrite">
				<div style="width: 80px">받은 사람</div>
				<div>${mdto.m_recv_id}</div>
			</div>															
			<div class="mcontent" >
				<textarea rows="14" cols="45" id="mcontent" name="mcontent" readonly>${mdto.m_note}</textarea>
			</div>
		</div>
	</body>
</html>