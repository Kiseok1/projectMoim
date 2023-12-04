<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쪽지 쓰기</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			.mwrite{display: flex; witdh:450px; margin-top: 10px;}
			.mcontent{display: block; margin-top: 10px;}
		</style>
		<script>
			$(function(){
				$("#sBtn").click(function(){
					//alert("${session_id}"+"받는사람 : "+$("#recvId").val());
					if($("#mcontent").val().length==0){
						alert("쪽지 내용이 없습니다.");
						$("#mcontent").focus();
						return false;
					}
					//받는사람 아이디 존재 확인
					var recvId = $("#recvId").val();
					$.ajax({
						url:"IdCheck",       //url 확인 주소
						type:"post",  //get, post
						data:{"id":recvId},	  //url로 보내는 데이터
						dataType:"json", //받는 데이터 타입 정의 xml,json,html,text
						success:function(data){
							//alert("성공");
							console.log("전달받은 데이터 : "+data[0]);
							console.log("전달받은 데이터 : "+data[0].result);
							if(data[0].result!=0){
								alert("받는사람의 아이디가 존재하지 않습니다.");
								$("#recvId").val("");
								$("#recvId").focus();
								return false;
							} 
							sFrm.submit();
						},
						error:function(){
							alert("실패");
						}
					});//ajax
					
				});//sBtn 클릭
			});//jquery
		</script>
	</head>
	<body>
		<form method="post" name="sFrm" action="m_Insert.do">
			<div>
				<input type="button" id="sBtn" value="보내기">
			</div>
			<div>
				<div class="mwrite">
					<div style="width: 80px">받는 사람</div>
					<div><input type="text" name="recvId" id="recvId" placeholder="받는 사람의 ID를 입력하세요"></div>
				</div>															
				<div class="mcontent" >
					<textarea rows="14" cols="45" id="mcontent" name="mcontent"></textarea>
				</div>
			</div>
		</form>
	</body>
</html>