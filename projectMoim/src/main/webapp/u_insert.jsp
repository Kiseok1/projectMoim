<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			*{margin:0; padding:0;}
			div{width:800px; margin:30px auto; text-align: center;}
			h1{margin-bottom:30px;}
			table,th,td{border:1px solid black; border-collapse: collapse;
			font-size:16px; }
			th{width:300px; height:40px;}
			td{width:500px; text-align: left; padding-left: 50px;}
			button{width: 200px; height: 60px; margin-top:30px;}
			td *{vertical-align: middle; }
			#idCheck{width: 100px; height: 20px; margin-top:0;}
		</style>
		<script>
			$(function(){
				$("#fbtn").click(function(){
					if($("#id").val().length<2){
						alert("아이디를 입력하셔야 합니다.");
						$("#id").focus();
						return false;
					}
					
					alert( "회원정보를 저장합니다." );
					mFrm.submit();
				});//click
				
				$("#idCheck").click(function(){
					if($("#id").val().length<2){
						alert("아이디는 2자리 이상 입력하셔야 합니다.");
						$("#id").focus();
						return false;
					}
					
					alert("아이디를 중복체크 합니다.");
					var id=$("#id").val();
					//ajax사용해서 id가 존재하는지 확인
					$.ajax({
						url:"IdCheck",       //url 확인 주소
						type:"post",  //get, post
						data:{"id":id,"name":$("#name").val()},	  //url로 보내는 데이터
						dataType:"json", //받는 데이터 타입 정의 xml,json,html,text
						success:function(data){
							//alert("성공");
							console.log("전달받은 데이터 : "+data[0]);
							console.log("전달받은 데이터 : "+data[0].result);
							if(data[0].result==0){
								alert("아이디가 존재합니다. 다른 아이디를 사용하세요");
								$("#id").val("");
								$("#id").focus();
								return false;
							} else{
								alert("사용가능한 아이디입니다.")
							}
						},
						error:function(){
							alert("실패");
						}
						
						
					});
					
					
					
					
				});//idCheck click
				
			});//jquery
		</script>
	</head>
	<body>
		<div>
			<h1>회원가입</h1>
			<form name="mFrm" method="post" action="u_DoInsert.do" enctype="multipart/form-data">
				<table>
					<tr>
						<th>아이디</th>
						<td>
							<input type="text" name="id" id="id">
							<button type="button" id="idCheck">아이디 확인</button>
						</td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" name="pw" id="pw"></td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td><input type="text" name="nickname" id="nickname"></td>
					</tr>
					<tr>
						<th>프로필 사진</th>
						<td>
							<input type="file" name="u_profileImg" id="u_profileImg">
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" id="email"></td>
					</tr>
					<tr>
						<th>지역</th>
						<td>
							<input type="radio" name="local" id="서울" value="서울">
							<label for="서울">서울</label>
							<input type="radio" name="local" id="경기" value="경기">
							<label for="경기">경기</label>
							<input type="radio" name="local" id="인천" value="인천">
							<label for="인천">인천</label>
							<input type="radio" name="local" id="강원" value="강원">
							<label for="강원">강원</label><br>
							<input type="radio" name="local" id="충북" value="충북">
							<label for="충북">충북</label>
							<input type="radio" name="local" id="충남" value="충남">
							<label for="충남">충남</label>
							<input type="radio" name="local" id="세종" value="세종">
							<label for="세종">세종</label>
							<input type="radio" name="local" id="대전" value="대전">
							<label for="대전">대전</label><br>
							
						</td>
					</tr>
					<tr>
						<th>관심 카테고리</th>
						<td>
							<input type="checkbox" name="category" id="culture" value="culture">
							<label for="culture">문화/예술</label>
							<input type="checkbox" name="category" id="activity" value="activity">
							<label for="activity">액티비티</label>
							<input type="checkbox" name="category" id="food" value="food">
							<label for="food">푸드/드링크</label>
							<input type="checkbox" name="category" id="hobby" value="hobby">
							<label for="hobby">취미</label><br>
							<input type="checkbox" name="category" id="party" value="party">
							<label for="party">파티/소개팅</label>
							<input type="checkbox" name="category" id="trip" value="trip">
							<label for="trip">여행/동행</label>
							<input type="checkbox" name="category" id="develop" value="develop">
							<label for="develop">자기계발</label>
							<input type="checkbox" name="category" id="amity" value="amity">
							<label for="amity">동네/친목</label><br>
						</td>
					</tr>
				</table>
				<button type="button" id="fbtn">저장</button>
				<button type="button" onclick="javascript:history.back()">취소</button>
			</form>
		</div>
	
	</body>
</html>