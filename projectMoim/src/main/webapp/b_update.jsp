<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
section{text-align: center;}
table{width:1400px; margin-top:100px; margin-left:auto; 
margin-right:auto; line-height: 40px;
 border-collapse: collapse; border: 1px solid silver;
  border-top: 2px solid black;}
  td{width: 900px;}
  tr{border-top:1px solid black; height: 100px;}
  #b_content{height: 250px;}
  button{float: right; margin-right: 100px; margin-top:50px; width:135px; margin-bottom:30px;
   height: 50px; font-size:20px; 
  }
  #b_title, #b_content{width: 950px; border: 2px solid #ccc;}
  input{height: 30px;}
  strong{text-align: center;}
  
</style>
<script>
	$(function(){
		$(".write").click(function(){
				if($("#b_title").val()=="") {
					alert("제목을 입력하세요.");
				$("#b_title").focus();
				 return false;
				 
				}else if($("#b_content").val()==""){
					alert("내용을 입력하세요.");
					$("#b_content").focus();
					
					return false;
				}
				
				updateFrm.submit();
			
		});//
	});//
</script>
	<head>
	<meta charset="UTF-8">
		<title>글 작성</title>
		</head>
	<body>
		<section>
		<h1>ㅁㅁ소모임 게시판 </h1>
		<table>
		<form action="do_update.do" name="updateFrm" method="post" enctype="multipart/form-data">
		 <input type="hidden" name="b_no" value="${bdto.b_no}">
		<p class="titleCon">
			<tr>
				<th><strong>제목</strong>|</th>
				<td>
					<input type="text" name="b_title" id="b_title" value="${bdto.b_title}">
					 <input type="hidden" name="oldfile" value="${bdto.b_file}">
				</td>
			</tr>
			<tr>
				<th >내용<span>|</span></th>
				 <td>
				 	<textarea id="b_content" name="b_content" rows="50" cols="10">${bdto.b_content}</textarea>
				 </td>  
			</tr>
			</p>
			<tr>
			<th>이미지</th>
			<td>
				<img style="width: 30%;" src="upload/${bdto.b_file}">
			</td>
			</tr>
			<tr>
				<th>이미지 표시</th>
				<td>
					<input type="file" name="b_file" id="file">
				</td>
			</tr>
			</tbody>
		</table>
			
			<button type="button" class="cancel">취소</button>
			<button type="button" class="write">작성완료</button>
		</form>
		
			
			
			
				
				
	</body>
</html>
