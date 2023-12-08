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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
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
  #lBtn{float: right; margin-right: 100px; margin-top:50px; width:135px; height: 50px; font-size:20px;
  font-family: 'Noto Sans KR', sans-serif;
  }
 .page-num {
  margin-top: 15px;
}

.page-num li {
  display:inline-block;
  width: 36px;
  height: 35px;
  padding: 0;
  border: 1px #989898 solid;

}


.num {
  position: relative;
  top: -15px;
  height: 33px !important;
  
}



.wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
}
.txtOn{background: black; color:white;}

form {
    display: flex;
    align-items: center;
}

select, div, button {
    padding: 10px; /* 내용과 테두리 사이의 여백 설정 */
    font-size: 16px; /* 폰트 크기 설정 */
    border-radius: 5px; /* 테두리 모서리 둥글게 설정 */
}
#sword{width:300px;  height: 35px;}
	
</style>
<script>
	$(function(){
		$("#wBtn").click(function(){
			alert("글을 작성합니다.");
			location.href="b_insert.do";
		});
		$("#sBtn").click(function(){
	if($("#sword").val()=="") {
		alert("검색어를 입력해주세요.")
		$("#sword").focus();
		return false
			}
		searchFrm.submit();
		});//sBtn
		$("#lBtn").click(function(){
			alert("게시판의 1페이지로 돌아갑니다.")
			location.href="b_list.do";
		});//
	});//

</script>
</head>
<body>
	<section>
		<h1>ㅁㅁ소모임 게시판 </h1>
		<div class="wrapper">
		<form action="b_list.do" name="searchFrm" method="post">
		<select name="category" id="category">
			<option value="all">전체</option>
			<option value="btitle">제목</option>
			<option value="bcontent">내용</option>
		</select>
		<div>
			<input type="text" name="sword" id="sword" size="16">
		</div>
		<button type="button" id="sBtn"><i class="fas fa-search"></i></button>
	</div>
		</form>
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
					<td>
					<c:forEach var="c" begin="1" end="${bdto.b_indent}" step="1">└</c:forEach>
					<a href="b_view.do?page=${page}&b_no=${bdto.b_no}&category=${category}&sword=${sword}">${bdto.b_title }</a></td>
					<td>${bdto.u_nicname }</td>
					<td><fmt:formatDate value="${bdto.b_date}" pattern="yyyy/MM//dd"/></td>
					<td>${bdto.b_hit}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		 <ul class="page-num">
	     <a href="b_list.do?page=1&category=${category}&sword=${sword}"><li class="first"><img src="images/paging_first.png"></li></a>
	    <c:if test="${page>1}">
	      	<a href="b_list.do?page=${page-1}&category=${category}&sword=${sword}"><li class="prev"><img src="images/paging_prev.png"></li></a>
	     </c:if>
	     <c:if test="${page<=1}">
	      	<li class="prev"><img src="images/paging_prev.png"></li>
	     </c:if>
	     <c:forEach var="n" begin="${startPage}" end="${endPage}" step="1">
	     <c:if test="${page==n}">
	      <li class="num txtOn">${n}</li>
	     </c:if>
	     <c:if test="${page!=n}">
	      <a href="b_list.do?page=${n}&category=${category}&sword=${sword}"><li class="num">${n}</li></a>
	     </c:if>
	     </c:forEach>
	     <c:if test="${page<maxPage}"> 
	      <a href="b_list.do?page=${page+1}&category=${category}&sword=${sword}"><li class="next"><img src="images/paging_next.png"></li></a>
	     </c:if>
	     <c:if test="${page>=maxPage}"> 
	      <li class="next"><img src="images/paging_next.png"></li>
	     </c:if>
	      <a href="b_list.do?page=${maxPage}&category=${category}&sword=${sword}"><li class="last"><img src="images/paging_last.png"></li></a>
	    </ul>
	
		
		
		<button type="button" id="wBtn">쓰기</button>
		<button type="button" id="lBtn">게시판으로</button>
	</section>

</body>
</html>
