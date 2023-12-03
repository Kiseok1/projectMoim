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
			a:link{color:gray; text-decoration: none;}
			a:visited{color:gray; text-decoration: none;}
		</style>
		<script>
			$(function(){
				//전체 체크박스 클릭
				$("#checkAll").click(function(){
					if($("#checkAll").prop("checked")){
						$(".m_no").prop("checked",true);
					} else {
						$(".m_no").prop("checked",false);
					}
				});//checkAll check
				
				//미체크시 알람
				$("#delBtn").click(function(){
					if($("input[name=m_no]:checked").length==0){
						alert("삭제하려는 쪽지를 체크해주세요");
						return false;
					}
					delFrm.submit();
				});//delBtn
			});//jquery
		</script>
	</head>
	<body>
		<form action="m_delSent.do" method="post" name="delFrm">
		<input type="button" id="delBtn" value="삭제">
		<hr>
		<table>
			<colgroup>
				<col width=5%>
				<col width=10%>
				<col width=55%>
				<col width=15%>
				<col width=15%>
			</colgroup>
			<tr>
				<th><input type="checkbox" id="checkAll"></th>					
				<th>받는 사람</th>					
				<th>내용</th>					
				<th>보낸날짜</th>					
				<th>받은날짜</th>					
			</tr>
			<c:forEach items="${list}" var="mdto">
			<tr style="color:gray;">
				<td><input type="checkbox" class="m_no" name="m_no" value="${mdto.m_no}"></td>
				<td>${mdto.m_recv_id}</td>
				<td><a href="m_sentMsgPop.do?m_no=${mdto.m_no}">${mdto.m_note}</a></td>
				<td><fmt:formatDate value="${mdto.m_date_sent}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<c:if test="${mdto.m_date_read!=null}">
						<fmt:formatDate value="${mdto.m_date_read}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</c:if>
					<c:if test="${mdto.m_date_read==null}">
						확인안함
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
		</form>
	</body>
</html>