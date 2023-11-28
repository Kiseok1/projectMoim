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
</style>
	<head>
	<meta charset="UTF-8">
		<title>게시글</title>
		</head>
	<body>
		<section>
		<h1>ㅁㅁ소모임 게시판 </h1>
		<table>
			<tr>
				<th><strong>제목</strong><span>|</span>${bdto.b_title}<th>
			</tr>
			<tr>
				<th><strong>날짜</strong><span>|</span><fmt:formatDate value="${bdto.b_date}" pattern="yyyy/MM/dd"/><th>
			</tr>
			<tr>
				<th><strong>작성자</strong><span>|</span>${bdto.u_nicname}<th>
			</tr>
			<tr>
				<th id="b_contents">${bdto.b_content}<th>
			</tr>
			
			
			
				
				
			</tbody>
		</table>
	</body>
</html>