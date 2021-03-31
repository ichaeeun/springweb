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
 # dialogue 를 통해 팝업과 데이터 전송 처리 
 1. dialogue를 처리할 div를 만든다. 
 	- form객체에 입력할 데이터를 설정 처리 
 		name="" 
 	- 사용할 div의 id 설정 
 2. js
 	1) 해당 div의 id로 dialog(기본옵션) 형식으로 
 		화면에 있는 div의 기본옵션을 선언한다. 
 		ex) $("선택자").dialog({속성:속성값,...});
 	2) 특정 이벤트에 의해서 해당 dialog를 시작한다. 
 		ex) $("선택자").dialog("open"); 
 	3) 위에 특정 이벤트가 등록/상세/수정/삭제에 따라서 
 		button이나 속성이 변경할 때는 option속성을 
 		초기에는 공통으로 하고, 해당 기능이벤트 마다 
 		다르게 option을 json형식으로 변경하여 처리한다. 
 		
 	4) 각 버튼에 따라 ajax처리하는 것을 함수에서 처리할 수 있도록 한다. 
 		
 
--%>
//
   $(document).ready(function(){
       // 다이얼로그 초기 옵션 
	   var opts={
    	  autoOpen:false, // 초기에 나타나지 않음
    	  width:"350px",
    	  modal:true
       }
       $("#dialog01").dialog(opts);
	   // 이벤트에 의해서 기능 버튼 option의 변경 
	   $("#regBtn").click(function(){
		   $("[name=id]").val("초기등록아이디");
		   $("[name=name]").val("초기등록이름");
		   opts.buttons={
				  "등록":function(){
					  alert("등록합니다!!");
					  console.log("#ajax 처리")
					  console.log($("form").serialize());
				  }
		   }
		   
		   $("#dialog01").dialog(opts); // 등록 버튼 추가 
		   $("#dialog01").dialog("open"); // 기본 창 로딩 
	   })	
	   
	   
	   $("#detBtn").click(function(){
		   opts.buttons={
				  "수정":function(){
					  alert("수정합니다!!");
				  },
				  "삭제":function(){
					  alert("삭제합니다!!");
				  }
		   }
		   opts.width="500px";
		   $("#dialog01").dialog(opts); // 등록 버튼 추가 
		   $("#dialog01").dialog("open"); // 기본 창 로딩 
	   })	
   });
</script>
</head>
<div class="jumbotron text-center">
 <h2>다이얼로그</h2>
</div>
<div class="container">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
     <form class="form-inline" method="post">
      <button id="regBtn" class="btn btn-success" type="button">등록</button>
      <button id="detBtn" class="btn btn-info" type="button">상세</button>
     </form>
  </nav>
  <div id="dialog01" title="회원">
  <form>
  <table class="table table-hover table-striped">
    <tbody>
      <tr class="text-center">
        <th>아이디</th> <td><input class="form-control" type="text" name="id"/></td>
      </tr>
      <tr>
        <th>이름</th> <td><input class="form-control" type="text" name="name"/></td>
	  </tr>    
    </tbody>
  </table>   
  </form> 
  </div>
</div>
</body>
</html>