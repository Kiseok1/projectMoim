<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<style>
section{text-align: center;}
table{width:80%; margin-top:100px; margin-left:auto; 
margin-right:auto; line-height: 40px;
 border-collapse: collapse; border: 1px solid silver;
  border-top: 2px solid black;}
 tr{border-top:1px solid black;}
  img{width: 500px; height: 200px;}		
  button{float: right; margin-right:30px;}
</style>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#deleteBtn").click(function(){
			if(confirm("게시글을 삭제하시겠습니까?")){
				location.href="do_Delete.do?page=${page}&b_no=${bdto.b_no}&category=${category}&sword=${sword}";
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
			<tr class="files">
				<td class="imgbox">
					<img src="upload/${bdto.b_file}">
				</td>
			</tr>
			<tr>
				<c:if test="${prenullDto.b_no==0}">
				<td><strong>이전글</strong><span>|</span>
				이전글이 없습니다.</td>
				</c:if>
				<c:if test="${preDto.b_no!=null}">
				<td><strong>이전글</strong><span>|</span>
				<a href="b_view.do?page=${page}&b_no=${preDto.b_no}&category=${category}&sword=${sword}">${preDto.b_title}1</a></td>
				</c:if>
			</tr>
			<tr>
			<c:if test="${nextnullDto.b_no==preDto.b_no}">
				<td><strong>다음글</strong><span>|</span>
				다음글이 없습니다.</td>
			</c:if>
			<c:if test="${nextDto.b_no!=null}">
				<td><strong>다음글</strong><span>|</span>
			<a href="b_view.do?page=${page}&b_no=${nextDto.b_no}&category=${category}&sword=${sword}">${nextDto.b_title}2</a></td>
			</c:if>
			</tr>
			
		</table>
		<tr>
			<a href="b_list.do?page=${page}&category=${category}&sword=${sword}"><button type="button">게시판</button></a>
		</tr>
		<tr>
			<a href="b_reply.do?page=${page}&b_no=${bdto.b_no}&b_no=${bdto.b_no}&category=${category}&sword=${sword}"><button type="button">답글달기</button></a>
		</tr>
		<tr>
			<button type="button" id="deleteBtn">삭제</button></a>
		</tr>
		<tr>
			<a href="b_update.do?page=${page}&b_no=${bdto.b_no}&category=${category}&sword=${sword}"><button type="button">글수정</button></a>
		</tr>
	</body>
</html>