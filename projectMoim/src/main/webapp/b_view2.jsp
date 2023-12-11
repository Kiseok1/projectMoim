<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<style>
h1{text-align: center; margin-top: 10px;}
#view_table{width:60%; margin-top:30px; margin-left:auto; 
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
		<div id="header"></div>
		<section>
		<h1>소모임 게시판 </h1>
		<table id="view_table" style="border-width: 1;">
			<%-- <colgroup>
				<col width=80%>
				<col width=10%>
				<col width=10%>
			</colgroup> --%>
			<tr>
				<th style="font-size: 25px;">&nbsp&nbsp&nbsp&nbsp&nbsp${bdto.b_title}</th>
			</tr>
			<tr style="text-align: right;">
				<td><fmt:formatDate value="${bdto.b_date}" pattern="yyyy/MM/dd"/><span>  |  </span>${bdto.u_nicname}&nbsp&nbsp&nbsp&nbsp</td>
			</tr>
			<tr>
				<td id="b_contents">
					&nbsp&nbsp&nbsp&nbsp&nbsp${bdto.b_content}
				</td>
			</tr>
			<tr class="files">
			<c:if test="${bdto.b_file==null}">
				<!-- <td class="imgbox">
					 첨부된 파일이 없습니다.
				</td> -->
			</c:if>
			<c:if test="${bdto.b_file!=null}">
				<td class="imgbox" style="text-align: center;">
					<img src="upload/${bdto.b_file}">
				</td>
			</c:if>
			</tr>
			<tr>
				<c:if test="${preDto==null}">
				<td><strong>&nbsp&nbsp&nbsp&nbsp&nbsp이전글</strong><span> | </span>
				이전글이 없습니다.</td>
				</c:if>
				<c:if test="${preDto!=null}">
				<td><strong>&nbsp&nbsp&nbsp&nbsp&nbsp이전글</strong><span> | </span>
				<a href="b_view.do?page=${page}&b_no=${preDto.b_no}&category=${category}&sword=${sword}">${preDto.b_title}</a></td>
				</c:if>
			</tr>
			<tr>
			<c:if test="${nextDto==null}">
				<td><strong>&nbsp&nbsp&nbsp&nbsp&nbsp다음글</strong><span> | </span>
				다음글이 없습니다.</td>
			</c:if>
			<c:if test="${nextDto!=null}">
				<td><strong>&nbsp&nbsp&nbsp&nbsp&nbsp다음글</strong><span> | </span>
			<a href="b_view.do?page=${page}&b_no=${nextDto.b_no}&category=${category}&sword=${sword}">${nextDto.b_title}</a></td>
			</c:if>
			</tr>
			
		</table>
			<div style="display: inline-block; position:relative; top:10px; left: 1310px; " >
				<div style="border: 1px solid gray; display: inline-block;"><a href="b_list.do?page=${page}&category=${category}&sword=${sword}">모임 게시판</a></div>
				<div style="border: 1px solid gray; display: inline-block;"><a href="b_reply.do?page=${page}&b_no=${bdto.b_no}&b_no=${bdto.b_no}&category=${category}&sword=${sword}&gid=${bdto.g_id}">답글달기</a></div>
				<div style="border: 1px solid gray; display: inline-block; cursor: pointer;" id="deleteBtn">삭제</div>
				<div style="border: 1px solid gray; display: inline-block;"><a href="b_update.do?page=${page}&b_no=${bdto.b_no}&category=${category}&sword=${sword}">글수정</a></div>
			</div>
		
	</body>
	<script>
		$(function(){
			$("#header").load("header.jsp");
			
		})
	</script>
</html>
