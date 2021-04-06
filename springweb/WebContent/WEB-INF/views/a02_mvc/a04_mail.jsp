<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<fmt:requestEncoding value="UTF-8" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
<%--
 
 
--%>
//
   $(document).ready(function(){
      var subject = "${param.subject}";
      if(subject!=""){
    	  alert("발송성공!");
      }
   });
</script>
<style>
.input-group-text{
		width:100%;
		background-color:#F8F8FF;
		color:black;
		font-weight:bolder;
	}
	.input-group-prepend{
		width:10%;
	}
</style>
</head>
<div class="jumbotron text-center">
  <h2>메일 발송</h2>
</div>
<div class="container">
     <form method="post" action="${path }/mail.do?method=send">
     <input type="hidden" name="proc"/>
       
          
    
    <div class="input-group mb-3">
     	<div class="input-group-prepend">
     		<span class="input-group-text">제목</span>
     	</div>
     	 <input class="form-control" type="text" 
          name="subject" value="" placeholder="제목을 입력하세요">             
     </div>
     
     <div class="input-group mb-3">
     	<div class="input-group-prepend">
     		<span class="input-group-text">수신자</span>
     	</div>
     	 <input class="form-control" type="text" 
          name="receiver" value="" placeholder="수신자를 입력하세요">             
     </div>
      
     <div class="input-group mb-3">
     	<div class="input-group-prepend">
     		<span class="input-group-text">내용</span>
     	</div>
     	 <textarea class="form-control" rows=10
          name="content" placeholder="내용을 입력하세요"></textarea>
     </div>
      
     <div style="text-align:right;">
     	<input type="submit" class="btn btn-info" value="보내기" id="sendBtn"/>
     </div>
             
     </form>
     
</div>
</body>
</html>