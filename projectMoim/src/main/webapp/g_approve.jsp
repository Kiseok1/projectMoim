<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			table{width:100%;}
			th{text-align: left;}
			td{cursor: pointer;}
			a:link{color:black; text-decoration: none;}
			a:visited{color:black; text-decoration: none;}
		</style>
		<script>
			$(function(){
				//전체 체크박스 클릭
				$("#checkAll").click(function(){
					if($("#checkAll").prop("checked")){
						$(".a_no").prop("checked",true);
					} else {
						$(".a_no").prop("checked",false);
					}
				});//checkAll check
				
				//미체크시 알람
				$("#appBtn").click(function(){
					if($("input[name=a_no]:checked").length==0){
						alert("가입을 승인하려는 유저를 선택하세요.");
						return false;
					}
					appFrm.submit();
				});//appBtn
			});//jquery
		</script>
	</head>
	<body>
		<form action="g_approveConfirm.do" method="post" name="appFrm">
		<input type="button" id="appBtn" value="승인">
		<hr>
		<table>
			<colgroup>
				<col width=5%>
				<col width=10%>
				<col width=70%>
				<col width=15%>
			</colgroup>
			<tr>
				<th><input type="checkbox" id="checkAll"></th>					
				<th>신청인</th>					
				<th>내용</th>					
				<th>신청일</th>					
			</tr>
			<c:forEach items="${listA}" var="adto">
				<tr>
					<td><input type="checkbox" class="a_no" name="a_no" value="${adto.a_no}"></td>
					<td>${adto.u_id}</td><input type="hidden" name="u_id" value="${adto.u_id}">
					<td>${adto.u_id}님이 승인 대기중입니다.</td><input type="hidden" name="g_id" value="${adto.g_id}">
					<td><fmt:formatDate value="${adto.apply_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
		</table>
		</form>
	</body>
	
</html>