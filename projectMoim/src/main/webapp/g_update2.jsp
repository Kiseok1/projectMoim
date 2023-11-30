<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<script src="http://code.jquery.com/jquery-latest.min.js"></script>
			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<link rel="stylesheet" type="text/css" href="css/g_create.css">
			<title>모임수정페이지</title>
		</head>
			<style>
	  
			</style>
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
						<p class="page-title">모임정보수정</p> 
				<br>
				<form class="innerbox">
					<div class="toast">
						<a href="https://https://www.notion.so/Project-1-d3dbad96ba6a4df498ae5eb0abe7927f" class="aa" target="blank">모임수정가이드</a>
					</div>
				<br>
				<br>	
				<div class="form-group1">
					<label class="form-label1">모임명</label>	
						<input type="text" placeholder="모임명을 수정하세요." class="form-input" maxlength="100">
				</div>	
				<br>
				<br>
				<div class="form-group2">	
					<label class="form-label2">지역</label>
					 	<div class="select1">
					 		<input type="text" class="location-text" placeholder="지역을 수정하세요.">
					 	<br>
							<select name="location">
								<option value="seoul" selected>지역</option>
								<option value="seoul">서울</option>
								<option value="busan">부산</option>
								<option value="incheon">인천</option>
								<option value="deagu">대구</option>
								<option value="deagu">대전</option>
								<option value="gwangju">광주</option>
							</select>
						</div>
					</div>
				<br>
				<br>
				<div class="id">	
					<label class="member_id">멤버아이디</label>
					 	<div class="select2">
					 		<input type="text" class="input_id">
				 		</div>
			 		</div>
				<br>
				<br>
				<div class="form-group3">
					<label class="form-label3">장소명</label>
						 <input type="text" placeholder="장소명을 수정하세요." class="form-input3" maxlength="30">		
				</div>
				<br>
				<br>
				<dl id="join_address">
					<dt> 
						<div></div>
							<label for="">주소수정</label>
					</dt>
						<dd>
							<input type="text" id="f_postal" name="f_postal" required readonly />
							<input type="button" id="postBtn" value="우편번호"/><div></div>
							<input type="text" id="address1" name="address1" required readonly /><div></div>
							<input type="text" id="address2" name="address2" required />
						</dd>				
				</dl>	
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<div class="form-group4">
					<label class="form-label4">인원수</label>
						 <input type="text" placeholder="인원수를 수정하세요.(예시:0)" class="form-input4" maxlength="30">		
				</div>
				<br>
				<br>
				<div class="form-group5">
					<label class="form-label5">이미지등록</label>
				<br>
						<div  class="formfile">
							<input type="file" accept="image/*" class="input-form-file">
								<button class="btn-upload">이미지등록</button>
						</div>
				<br>
				<div class="uplaod-img">
					<div class="upload-thumbnail"></div>
						<span class="upload_file"></span>
							<img src="#" alt class="delete">
					</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<div class="form-group6">
					<label class="form-label6">모임상세정보</label>
				<br>	
						 <textarea rows="7" cols="61" id="textarea"></textarea>		
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<dl id="join_mail">
					<dt>
						<div></div>
							<label for="mail_id">이메일</label>
					</dt>
				<br>
					<script>
					    $(function(){
					    	$("#chgMail").change(function(){
					    		if($("#chgMail").val()==""){
					    			$("#mail_tail").val("");
					    			$("#mail_tail").prop("readonly",false);
					    		}else{
						    		$("#mail_tail").val($("#chgMail").val());
						    		$("#mail_tail").prop("readonly",true);
					    		}
					    	});
					    });
					</script>
				<dd id="mailbox">
					<input type="text" id="mail_id" name="mail_id" required />
						<span>@</span>
							<input type="text" id="mail_tail" name="mail_tail" required />
								<select id="chgMail">
									<option value="" selected>직접입력</option>
									<option value="gmail.com">지메일</option>
									<option value="naver.com">네이버</option>
									<option value="daum.net">다음</option>
									<option value="nate.com">네이트</option>
								</select>
						<div></div>
					</dd>
				</dl>	
			<br>
			<br>	
			<dl id="join_tell_dl">
				<dt>
					<div></div>
						<label for="f_tell">휴대전화</label>
				</dt>
				<br>
				<dd>
					<input type="text" id="f_tell" name="f_tell" maxlength="3" required />
					<span> - </span>
					<input type="text" id="m_tell" name="m_tell" maxlength="4" required />
					<span> - </span>
					<input type="text" id="l_tell" name="l_tell" maxlength="4" required />
				</dd>
			</dl>
			<br>
			<br>
			<div class="form-group7">
				<label class="form-label7">카카오톡오픈채팅</label>
				 	<input type="text" placeholder="오픈채팅 링크정보를 수정하세요." class="form-input7" maxlength="30">		
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
				<div id="input-button">
					<input type="reset" class="reset" value="취소하기">
					<input type="submit" class="submit" value="수정하기">
				</div>
			<br>
			<br>
			<h1 class="select_name">추가 선택 정보 수정</h1>
				<div class="select_info">
			<br>
					<div id="join_job">
						<div>
							<label for="job">직업</label>
								<select id="job" name="job">
									<option selected>선택</option>
									<option value="worker">회사원</option>
									<option value="self">자영업</option>
									<option value="freelancer">프리랜서</option>
									<option value="housewife">전업주부</option>
									<option value="student">학생</option>
									<option value="etc">기타</option>
								</select>
						</div>	
					</div>
				<br>
			<div class="join_marry">
				<div>
					<label for>결혼여부</label>
					<input type="radio" name="marry" id="marry_yes" value="yes">
					<label for="marry_yes">예</label>			
					<input type="radio" name="marry" id="marry_no" value="no">
					<label for="marry_no">아니오</label>					
				</div>
			</div>
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
		</div>
			</form>
		</div>
	</div>
	
	</body>
</html>