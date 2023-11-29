<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<style>
section{text-align: center;}
table{width:96%; margin-top:100px; margin-left:auto; 
margin-right:auto; line-height: 40px;
 border-collapse: collapse; border: 1px solid silver;
  border-top: 2px solid black;}
  tr{border-top:1px solid black;}
  .files{width: 500px; height: 300px;} 
  button{float: right; margin-right:30px;}
</style>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#deleteBtn").click(function(){
			if(confirm("게시글을 삭제하시겠습니까?")){
				location.href="do_Delete.do?b_no=${bdto.b_no}";
			}
			
		});//
	});//
</script>
	<head>
	<meta charset="UTF-8">
		<title>게시글</title>
		</head>
	<body>
		<section>
		<h1>ㅁㅁ소모임 게시판 </h1>
		<table>
			<tr>
				<td><strong>제목</strong><span>|</span>${bdto.b_title}</td>
			</tr>
			<tr>
				<td><strong>날짜</strong><span>|</span><fmt:formatDate value="${bdto.b_date}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<td><strong>작성자</strong><span>|</span>${bdto.u_nicname}</td>
			</tr>
			<tr>
				<td id="b_contents">${bdto.b_content}</td>
			</tr>
			<td class="files">
				<img src="upload/${bdto.b_file}" alt="" width=50%>
			</td>
		</table>
		<tr>
			<a href="b_list.do"><button type="button">게시판</button></a>
		</tr>
		<tr>
			<a href="b_reply.do?b_no=${bdto.b_no}"><button type="button">답글달기</button></a>
		</tr>
		<tr>
			<button type="button" id="deleteBtn">삭제</button></a>
		</tr>
		<tr>
			<a href="b_update.do?b_no=${bdto.b_no}"><button type="button">글수정</button></a>
		</tr>
	</body>
</html>