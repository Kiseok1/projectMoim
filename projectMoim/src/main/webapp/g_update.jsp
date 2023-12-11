<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0" />
   			<meta http-equiv="X-UA-Compatible" content="ie=edge" />
			<script src="http://code.jquery.com/jquery-latest.min.js"></script>
			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<link rel="stylesheet" type="text/css" href="css/g_update.css">
			<title>모임수정페이지</title>
		</head>
			<style>
			#map{width:500px; height:300px;}
	  
			</style>
			<script>
			 $(function(){
					 $("#submit").click(function(){
						if(confirm("정보수정을 완료하시겠습니까?")){	
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
				<div class="continer-box">
					<div class="box-group">
						<p class="page-title">모임정보수정</p> 
				<br>
				
				<form action="doG_update.do?g_id=${gdto.g_id}" name="lfrm" class="innerbox" method="post" enctype="multipart/form-data">
					<div class="toast">
						<a href="https://https://www.notion.so/Project-1-d3dbad96ba6a4df498ae5eb0abe7927f" class="aa" target="blank">모임개설가이드</a>
					</div>
				<br>
				<br>	
				<div class="form-group">
					<label class="form-label">관리자 아이디</label>	
						<input type="text" placeholder="사용자아이디를 입력하세요." class="form-input" name="g_user_id" value="${gdto.g_user_id}" readonly maxlength="100">
				</div>	
				<br>
				<br>		
				<div class="form-group1">
					<label class="form-label1">모임명</label>	
						<input type="text" placeholder="모임명을 수정하세요."  class="form-input1" name="g_name" value="${gdto.g_name }" maxlength="100">
				</div>	
				<br>
				<br>
				<div class="form-group2">	
					<label class="form-label2">지역</label>
					<br>
						<div class="select1">
					 		<input type="text" id="location-text" name="g_local" value="${gdto.g_local}" placeholder="지역을 다시 선택하세요.">
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
								<option value="서울" selected>서울</option>
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
						 <input type="text" placeholder="장소명을 수정하세요."  class="form-input3" maxlength="30">		
				</div>
				<div id="map">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6320.291871538852!2d126.91717979676459!3d37.62225488591868!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9786122a4fb1%3A0x7174a0da38729d2b!2z7Jew7Iug64K07Jet!5e0!3m2!1sko!2skr!4v1701327670887!5m2!1sko!2skr" 
				width="500px" height="300px" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade">
				</iframe>
				</div>
				<br>	
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
						 <input type="text" placeholder="인원수를 다시 입력하세요.(예시:30)"  class="form-input4" name="g_member_cnt" value="${gdto.g_member_cnt }" maxlength="30">		
				</div>
				<br>
				<br>
				<div class="form-group5">
					<label class="form-label5">이미지수정</label>	
					<br>
						<input type="file" id="id" accept="images/*" name="g_file" value="upload=${gdto.g_file}"  onchange="setThumbnail(event);">
							<%-- <div class="image_container">
							  <c:if test="${bdto2.g_file != null }">
			       				<img src="upload/${bdto2.g_file}">
		    				  </c:if>
		       				  <c:if test="${bdto2.g_file == null }">
			       	          <i class="fa fa-ban" aria-hidden="true"></i>
			                	첨부파일없음
			                  </c:if>		
							</div>	 --%>
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
				<div class="form-group6">
					<label class="form-label6">상세정보수정</label>	
				<br>
					<label class="form-label6">짧은소개글</label>
					<textarea rows="3" cols="60" id="textarea" name="g_intro">${gdto.g_intro }</textarea>	
					<label class="form-label6">긴소개글</label>
					<textarea rows="6" cols="60" id="textarea" name="g_content">${gdto.g_content }</textarea>	
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
				<label class="form-label7">개설일</label>
				 	<input type="text" placeholder="YY/MM/DD(예시:23/12/01)" name="g_date" value="${gdto.g_date}"  class="form-input7" maxlength="30"> 		
			</div>
			<br>
			<br>
			
		</fieldset>
				<h4>
					선택 입력 정보 
				</h4>
				<fieldset class="fieldset_class">
					<dl id="join_interests_dl">
						<dt>
							<label for="">취미</label>
						</dt>
						<dd>
							<ul>
								<input type="checkbox" id="culture" value="culture" name="g_category" <c:if test="${fn:contains(gdto.g_category,'culture')}">checked</c:if> >
								<label for="culture">문화/예술</label>&nbsp&nbsp&nbsp&nbsp
								<input type="checkbox" id="activity" value="activity" name="g_category" <c:if test="${fn:contains(gdto.g_category,'activity')}">checked</c:if> >
								<label for="activity">액티비티</label>&nbsp&nbsp
								<input type="checkbox" id="food" value="food" name="g_category" <c:if test="${fn:contains(gdto.g_category,'food')}">checked</c:if> >
								<label for="food">푸드/드링크</label>&nbsp
								<input type="checkbox" id="investment" value="investment" name="g_category" <c:if test="${fn:contains(gdto.g_category,'investment')}">checked</c:if> >
								<label for="investment">재테크</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<input type="checkbox" id="hobby" value="hobby" name="g_category" <c:if test="${fn:contains(gdto.g_category,'hobby')}">checked</c:if> >
								<label for="hobby">취미</label><br>
								<input type="checkbox" id="party" value="party" name="g_category" <c:if test="${fn:contains(gdto.g_category,'party')}">checked</c:if> >
								<label for="party">파티/소개팅</label>
								<input type="checkbox" id="trip" value="trip" name="g_category" <c:if test="${fn:contains(gdto.g_category,'trip')}">checked</c:if> >
								<label for="trip">여행/동행</label>
								<input type="checkbox" id="develop" value="develop" name="g_category" <c:if test="${fn:contains(gdto.g_category,'develop')}">checked</c:if> >
								<label for="develop">자기계발</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp	
								<input type="checkbox" id="amity" value="amity" name="g_category" <c:if test="${fn:contains(gdto.g_category,'amity')}">checked</c:if> >
								<label for="amity">동네/친목</label>
								<input type="checkbox" id="language" value="language" name="g_category" <c:if test="${fn:contains(gdto.g_category,'language')}">checked</c:if> >
								<label for="language">외국어</label>
							</ul>
						</dd>
					</dl>
				</fieldset>
			<br>	
			<br>	
				<div id="input-button">
					<input type="button" id="reset" onclick="javascript:history.back()" value="취소하기">
					<input type="submit" id="submit" value="수정하기">
				</div>	
			<br>
			<br>
			</form>
		</div>
	</div>
	
	</body>
</html>
