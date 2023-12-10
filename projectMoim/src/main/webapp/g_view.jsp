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
					var admin = "${admin}";
					var id = "${session_id}"
					if(confirm("모임을 탈퇴하시겠습니까?")){
						if(admin!=id){
							location.href="g_quit.do?g_id=${gdto.g_id}";
						} else{
							alert("호스트는 탈퇴할 수 없습니다.");
						}
					}
				});//탈퇴 클릭
				
				$(".popup").hide();
			});//jquery
				
		</script>
		<style>
			.gview_cont{margin:0 auto; width: 600px;}
			.memImg{display:inline-block;}
			p{text-align: center;}
			#g_name{font-size: 20px; font-weight: 500;}
			.popup{width: 100px; border: 1px solid rgba(195,195,195); background: white;}
			.popup table{margin: auto; cursor: pointer;}
			.popup td:hover{opacity: 0.5;}
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
						<div style="margin-top: 10px; vertical-align: middle;">
							<div id="g_name">${gdto.g_name}</div>
							<div>호스트 ${u.u_nicname}</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div style="display: block;"><i class="fa fa-users" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp${gdto.g_member_cnt}명</div>
			
			<script>
				$(function(){
					var g_id="${session_gid}";
					var myLike = "${my_like_status}";
					var htmlData = "";
					var recvId;
					//좋아요 클릭
					$("#like").click(function(){
						if(${session_id==null}){
							alert("좋아요는 로그인 후에 가능합니다.");
							return false;
						}//if  로그인 안했을 경우
						if(${session_id!=null}){
							if(myLike==0){
								$.ajax({
									url:"LikeUpdate",
									type:"post",
									data:{"g_id":g_id,"like_status":1},
									dataType:"text",
									success:function(data){
										htmlData='';
										htmlData+='<div style="display: block;"><i class="fa fa-heart" aria-hidden="true" style="color:red;"></i>&nbsp&nbsp'+data+'명이 좋아합니다.</div>'
										$("#like").html(htmlData);	
									},
									error:function(){
										alert("실패");
									}
								});//ajax
							} else {
								$.ajax({
									url:"LikeUpdate",
									type:"post",
									data:{"g_id":g_id,"like_status":0},
									dataType:"text",
									success:function(data){
										htmlData='';
										htmlData+='<div style="display: block;"><i class="fa fa-heart-o" aria-hidden="true"></i>&nbsp&nbsp'+data+'명이 좋아합니다.</div>'
										$("#like").html(htmlData);	
									},
									error:function(){
										alert("실패");
									}
								});//ajax
							}//if 좋아요 상태 확인
						}//로그인 했을 경우	
					});//like click
					
					//가입자 이미지 클릭시 팝업창 띄우기
					$('.memImg').unbind('click').bind('click',function(e){
						target = $(e.target);
						var p = $(target).offset();
						recvId = $(this).attr('id');
						

						var divTop 	= p.top + 37; //상단 좌표 
						var divLeft = p.left + 37; //좌측 좌표 

						//레이어 팝업 view
						$('.popup').css({ "z-index":'10000',"top": divTop ,"left": divLeft , "position": "absolute" }).show();
					});//가입자 이미지 클릭시 팝업창 띄우기
					
					//가입자이미지 외 클릭시 팝업 감추기
					$(document).click(function() {
					    var popup = $(".popup");
					    var memImg = $(".memImg");
					    if (!memImg.is(event.target) && !memImg.has(event.target).length) {
					    	popup.hide();
					    }
					});//가입자이미지 외 클릭시 팝업 감추기
					
					//쪽지 보내기 클릭
					$("#sendMsg").click(function(){
						var id = "${session_id}";
						
						if(id==""){
							alert("로그인 후에 이용가능합니다.");
							return false;
						}
						var msgPop = window.open('m_write.do?recvId='+recvId,'쪽지 보내기','width=350px,height=310px,location=no');
					})//쪽지 보내기 클릭
					
				});//jquery
				
				//쪽지 보내기 클릭
				/* function msgPop(){
					var id = "${session_id}";
					alert(recvId);
					
					if(id==""){
						alert("로그인 후에 이용가능합니다.");
						return false;
					}
					var msgPop = window.open('m_write.do?','쪽지 보내기','width=350px,height=310px,location=no');
				} */
			</script>
			<div id="like">
				<c:if test="${my_like_status==0}">
					<div style="display: block;"><i class="fa fa-heart-o" aria-hidden="true"></i>&nbsp&nbsp${all_like_count}명이 좋아합니다.</div>
				</c:if>
				<c:if test="${my_like_status==1}">
					<div style="display: block;"><i class="fa fa-heart" aria-hidden="true" style="color:red;"></i>&nbsp&nbsp${all_like_count}명이 좋아합니다.</div>
				</c:if>
			</div>
			
			<div style="margin-top: 10px; white-space: pre;">${gdto.g_content}</div>
			<h5 style="margin-top: 10px;">가입멤버</h5>
				<div>
					<c:forEach	items="${list}" var="u" end="4">
						<c:if test="${admin==u.u_id}">
							<div class="memImg" id="${u.u_id}">
								<img src="upload/${u.u_profileImg}" style="width:50px; height:50px; border:2px solid blue; border-radius: 50%;">
								<p>${u.u_nicname}</p>
							</div>
						</c:if>
						<c:if test="${admin!=u.u_id}">
							<div class="memImg" id="${u.u_id}">
								<img src="upload/${u.u_profileImg}" style="width:50px; height:50px; border-radius: 50%;" >
								<p>${u.u_nicname}</p>
							</div>
						</c:if>
					</c:forEach>
					
				</div>
			<!-- 가입자 -->
			<c:if test="${session_id!=null && fn:contains(gdto.g_member_id,id)}">
			<h5 style="margin-top: 10px;"><a href="b_list.do?g_id=${gdto.g_id}"><i class="fa fa-list" aria-hidden="true"></i>&nbsp&nbsp&nbsp게시판</a></h5>	
			<h5><a href="#"><i class="fa fa-picture-o" aria-hidden="true"></i>&nbsp&nbsp&nbsp사진첩</a></h5>	
			<h5 id="qBtn" style="cursor: pointer;"><i class="fa fa-times" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp탈퇴</h5>
			</c:if>
			<!-- 운영자 -->
			<c:if test="${session_id!=null && fn:contains(gdto.g_user_id,id)}">
			<h5><a href="g_admin.do?g_id=${gdto.g_id}"><i class="fa fa-lock" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp&nbsp관리페이지</a></h5>
			</c:if>
			<!-- 비가입자(로그인) -->
			<c:if test="${not fn:contains(gdto.g_member_id,id)}">
				<c:if test="${status==100}">
					<h5 id="jBtn" style="cursor: pointer;"><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp&nbsp가입 신청</h5>
				</c:if>
				<c:if test="${status==0}">
					<h5><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp&nbsp가입 대기중</h5>
				</c:if>
			</c:if>
			<!-- 비가입자(비로그인) -->
			<c:if test="${session_id==null}">
			<h5 id="jBtn" style="cursor: pointer;"><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp&nbsp&nbsp&nbsp&nbsp가입 신청</h5>
			</c:if>
		</div>
		
		<div class="popup">
			<table>
				<tr><td target="_blank" id='sendMsg' onclick="msgPop()">쪽지 보내기</td></tr>
				<tr><td>작성글 보기</td></tr>
			</table>
		</div>
		
		<script>
			$(function(){
				$("#header").load("header.jsp");
				
			})
		</script>
	</body>
</html>