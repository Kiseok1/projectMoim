<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<script src="http://code.jquery.com/jquery-latest.min.js"></script>
			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<link rel="stylesheet" type="text/css" href="css/g_create.css">
			<link rel="stylesheet" type="text/css" href="css/g_update.css">
			<title>모임개설페이지</title>
		</head>
			<style>
			#map{width:500px; height:300px;}
	  
			</style>
			<script>
			 $(function(){
					 $("#submit").click(function(){
						if($("#submit").val()==null){
							alert("글작성을 모두 완료해주세요!")		
							return false;
						}
						lfrm.submit();  
					 });
					 
					 $("#reset").click(function(){
						if(confirm("정보수정을 취소하시겠습니까?")){
							location.href="main.do";		
						}
						lfrm.submit();  
					 });
					 
				 //우편번호검색
				 $("#postBtn").click(function(){
					alert("daum 우편번호 검색창으로 이동"); 
					new daum.Postcode({
				        oncomplete: function(data) {
				            $("#f_postal").val(data.zonecode);
				            $("#address1").val(data.address);
				        }
				    }).open();
					
				 });
			 });
			</script>
			<body>
				<div class="top">
					<div class="inner">
						<div>
							<a><img src="./images/logo.png" id="logo"></a>
						</div>
							<div class="logo-search">
								<div>
									<input type="text" class="input-form">
										<div class="btn-search"></div>
								</div>
						</div>
								<div class="menu-area">
									<a href="#" class="items">로그인</a>
									<a href="#" class="items">회원가입</a>
									<a href="#" class="items">모임개설</a>
									<a href="#" class="items">공지사항</a>
								</div>	
								<div class="user">
				       		<div class="user-img"></div>
						</div>
					</div>
				</div>
				<br>
				<br>
				<div class="continer-box">
					<div class="box-group">
						<p class="page-title">모임만들기</p> 
				<br>
				<form class="innerbox">
					<div class="toast">
						<a href="https://https://www.notion.so/Project-1-d3dbad96ba6a4df498ae5eb0abe7927f" class="aa" target="blank">모임개설가이드</a>
					</div>
				<br>
				<br>	
				<div class="form-group1">
					<label class="form-label1">모임명</label>	
						<input type="text" placeholder="모임명을 입력하세요." class="form-input"  maxlength="100">
				</div>	
				<br>
				<br>
				<div class="form-group2">	
					<label class="form-label2">지역</label>
					<br>
						<div class="select1">
					 		<input type="text" id="location-text" name="location-text" placeholder="지역을 선택하세요.">
					 	<br>
					 	<script>
					 		$(function(){
					 		 //지역입력
					 			$("#location").change(function(){
					 				if($("#location").val()==""){
					 					$("#location-text").val("");
					 					$("#location-text").prop("readonly",false);
					 				}else{
					 					$("#location-text").val($("#location").val());
					 					$("#location-text").prop("readonly",true);
					 					
					 				}	
					 			});
					 		});
					 	</script>
							<select id="location">
								<option value="seoul" selected>지역</option>
								<option value="서울">서울</option>
								<option value="부산">부산</option>
								<option value="인천">인천</option>
								<option value="대구">대구</option>
								<option value="대전">대전</option>
								<option value="광주">광주</option>
							</select>
						</div>
					</div>
				<br>
				<br>
				<br>
				<br>
				<div class="form-group3">
					<label class="form-label3">장소명</label>
						 <input type="text" placeholder="장소명을 입력하세요." class="form-input3" maxlength="30">		
				</div>
				<div id="map">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6320.291871538852!2d126.91717979676459!3d37.62225488591868!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9786122a4fb1%3A0x7174a0da38729d2b!2z7Jew7Iug64K07Jet!5e0!3m2!1sko!2skr!4v1701327670887!5m2!1sko!2skr" 
				width="500px" height="300px" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade">
				</iframe>
				</div>
				<br>		
				<div id="join_address">
						<label for="">주소</label>
				</div>		
				<div>
					<input type="text" id="f_postal" name="f_postal" required readonly />
					<input type="button" id="postBtn" value="우편번호"/><div></div>
					<input type="text" id="address1" name="address1" required readonly /><div></div>
					<input type="text" id="address2" name="address2">		
				</div>	
				<br>
				<br>
				<div class="form-group4">
					<label class="form-label4">모임정원수</label>
						 <input type="text" placeholder="인원수를 입력하세요.(예시:0)" class="form-input4" maxlength="30">		
				</div>
				<br>
				<br>
				<div class="form-group5">
					<label class="form-label5">이미지수정</label>	
					<br>
						<input type="file" id="image" accept="images/*" onchange="setThumbnail(event);">
							<div class="image_container">
								<img src="images/1.jpg">
							</div>
						<script>
					      function setThumbnail(event) {
					        for (var image of event.target.files) {
					          var reader = new FileReader();
					
					          reader.onload = function(event) {
					            var img = document.createElement("img");
					            img.setAttribute("src", event.target.result);
					            document.querySelector("div#image_container").appendChild(img);
					          };
					
					          console.log(image);
					          reader.readAsDataURL(image);
					        }
					      }
					</script>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<div class="form-group6">
					<label class="form-label6">모임상세정보</label>	
				<br>
					<label class="form-label6">짧은소개글</label>
					<textarea rows="3" cols="60" id="textarea"></textarea>	
					<label class="form-label6">긴소개글</label>
					<textarea rows="6" cols="60" id="textarea"></textarea>	
				</div>
				<div></div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
			<div class="form-group7">
				<label class="form-label7">카카오톡오픈채팅</label>
				 	<input type="text" placeholder="오픈채팅 링크정보를 입력하세요" class="form-input7" maxlength="30">		
			</div>
			<br>
			<br>
			<div id="join_gender">
				<label for>성별</label>
					<input type="radio" name="gender" id="male" value="male" checked="checked">
						<label for="male">남성</label>
					<input type="radio" name="gender" id="female" value="female">
						<label for="female">여성</label>
			</div>
			<br>
			<br>
			<div id="open_moim">
				<label for>모임공개여부</label>
					<input type="radio" name="select" id="open" value="open" checked="checked">
						<label for="open">공개</label>
					<input type="radio" name="select" id="close" value="close">
						<label for="close">비공개</label>
			</div>
			<br>
			<br>
			<form action="main.do" name="lfrm" method="post">
				<div id="input-button">
					<input type="reset" id="reset" value="취소하기">
					<input type="submit" id="submit" value="모임만들기">
				</div>
			</form>
			<br>
			<br>
			<!-- <h1 class="select_name">추가 선택 입력 정보</h1>
				<div class="select_info">
				
			<br>
			 <div id="join_interest">
				<div class="join_div">
					<label id="interest_name" for>관심사</label>				
				</div>
					<div class="interest_div">
					<ul>
						<li>
						<input type="checkbox"  name="computer" id="computer" value="computer">
						<label for="computer">컴퓨터/인터넷</label>
						</li>
						<li>
						<input type="checkbox"  name="movie" id="movie" value="movie">
						<label for="movie">영화</label>
						</li>
						<li>
						<input type="checkbox" name="music" id="music" value="music">
						<label for="music">음악</label>
						</li>
						<li>
						<input type="checkbox"  name="shopping" id="shopping" value="shopping">
						<label for="shopping">쇼핑</label>
						</li>
						<li>
						<input type="checkbox"  name="game" id="game" value="game">
						<label for="game">게임</label>
						</li>
						<li>
						<input type="checkbox"  name="culture" id="culture" value="culture">
						<label for="culture">문화/예술</label>
						</li>
						<li>
						<input type="checkbox" name="parenting" id="parenting" value="parenting">
						<label for="parenting">육아/아동</label>
						</li>
						<li>
						<input type="checkbox"  name="cooking" id="cooking" value="cooking">
						<label for="cooking">요리</label>
						</li>
						<li>
						<input type="checkbox"  name="interier" id="interier" value="interier">
						<label for="interier">인테리어</label>
						</li>
						<li>
						<input type="checkbox"  name="leisure" id="leisure" value="leisure">
						<label for="leisure">레저/여가</label>
						</li>
						<li>
						<input type="checkbox"  name="health" id="health" value="health">
						<label for="health">건강/다이어트</label>
						</li>
						<li>
						<input type="checkbox"  name="fashion" id="fashion" value="fashion">
						<label for="fashion">패션</label>
						</li>
					</ul>
				</div>
			</div>
		</div>-->
			</form>
		</div>
	</div>
	
	</body>
</html>