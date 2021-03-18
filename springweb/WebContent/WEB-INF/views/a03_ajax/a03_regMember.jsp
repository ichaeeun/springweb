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
	   // form이 가지고 있는 submit처리 방지 .. 
	  $("form").submit(function(e){
		  e.preventDefault();
	  });
      $("#id").keyup(function(e){
    	  if(e.keyCode==13){
    			ajaxCall();
    	  }
      });
      
      $("#chkBtn").click(function(){
    	  ajaxCall();
      });
      
   });
   
   function ajaxCall(){
	   $.ajax({
			type:"post",
			url:"${path}/isMember.do",
			data:$("#frm").serialize(),
			dataType:"json",
			success:function(data){
				console.log(data);
				var mlist = data.mem;
				if(mlist==0){
					alert("등록되지 않은 회원입니다.");
				}else{
					alert("등록된 회원입니다.");
				}
			},
			error:function(err){
				alert("에러발생");
				console.log(err);
			}
		});
   }
</script>
</head>
<div class="jumbotron text-center">
  <h2>회원등록여부</h2>
</div>
<div class="container">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
     <form id="frm" class="form-inline">
       <input class="form-control mr-sm-2" type="text" 
          name="id" id="id" value=""
          placeholder="아이디">
       <button class="btn btn-success" type="button" id="chkBtn">Check</button>
     </form>
  </nav>
</div>
</body>
</html>