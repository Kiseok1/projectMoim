<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&display=swap" rel="stylesheet">
<style>
*{margin:0; padding: 0;}
h1{margin:30px auto;}
section{text-align: center;}
table{width:96%; margin-top:100px; margin-left:auto; 
margin-right:auto; line-height: 40px;
 border-collapse: collapse; border: 1px solid silver;
  border-top: 2px solid black;}
  tr{border-top:1px solid black;}
  #wBtn{float: right; margin-right: 100px; margin-top:50px; width:135px; height: 50px; font-size:20px;
  font-family: 'Noto Sans KR', sans-serif;
  }
	
</style>
<script>
	$(function(){
		$("#wBtn").click(function(){
			alert("글을 작성합니다.");
			location.href="b_insert.do";
		});
	});//

</script>
</head>
<body>
	<section>
		<h1>ㅁㅁ소모임 게시판 </h1>
		<table>
			<colgroup>
				<col width="15%">
				<col width="45%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="bdto">
				<tr>
					<td>${bdto.b_no}</td>
					<td><a href="b_view.do?b_no=${bdto.b_no}">${bdto.b_title }</a></td>
					<td>${bdto.u_nicname }</td>
					<td><fmt:formatDate value="${bdto.b_date}" pattern="yyyy/MM//dd"/></td>
					<td>${bdto.b_hit}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="button" id="wBtn">쓰기</button>
	</section>

</body>
</html>