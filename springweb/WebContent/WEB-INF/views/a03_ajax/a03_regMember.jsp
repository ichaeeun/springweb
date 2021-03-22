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
	   // 웹기반 화면에서 form 하위에 입력요소객체에서 enter키를 
	   // 입력하면 submit()처리가 되는 경우가 있다. 
	   // 이러한 default submit() 처리를 방지하기 위하여 아래와 같은 
	   // 기능메서드를 선언하였다. : form이 submit 처리될 때 
	   // e.preventDefault(); : 기본이벤트인 submit 방지 처리 
	   
	  $("form").submit(function(e){
		  e.preventDefault();
	  });
      $("#id").keyup(function(e){
    	  if(e.keyCode==13){	// 입력할 항목에 enter키를 입력 시 처리 
    			ajaxCall();
    	  }
      });
      
      $("#chkBtn").click(function(){  // 등록 여부 확인 버튼 클릭 시 
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