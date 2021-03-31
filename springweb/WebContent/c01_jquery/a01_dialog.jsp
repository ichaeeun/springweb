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
 # jquery ui dialog 박스 처리 
 1. jquery 및 jquery ui css 및 js lib 설정 
 2. 화면에 div로 title과 함께 id값으로 설정 
 3. div의 id 값을 기준으로 기본 옵션 설정 
 	1) $("요소객체").dialog({
 			속성:속성값... 
 		})
 	2) 주요 속성 
 		autoOpen : 초기화면에 출력할지 여부 
 		modal : 로딩 시 다른 요소 객체 비활성화 처리 
 		buttons: { "버튼명" :function({버튼을 통해 처리할 내용..}) 
 	3) 호출 이벤트 
 		$("요소객체").dialog("open");  이벤트를 통해서 화면로딩 
 		$("요소객체").dialog("close"); 이벤트를 통해서 화면닫기 
 		
 		
--%>
//
   $(document).ready(function(){
      	$("h2").text("시작");
      	$("h2").click(function(){
      	//	$("#dialog").dialog("open");
      		$("#btn01").click(); // bootstrap dialog 호출 처리 
      		/*
      		해당 버튼 속성 display:none; 으로 처리 후 위와 같이 
      		h2 클릭 시 다이얼로그가 나오게 한다. 
      		<button type="button" id="btn01" style="display:none;"
      		*/
      		
      	});
      	
      	$("#dialog").dialog({
      		autoOpen:false,
      		modal:true,
      		buttons:{
      			"기능버튼":function(){
      				alert("버튼클릭!");
      			},
      			"창닫기":function(){
      				$("#dialog").dialog("close");
      			}
      			
      		}
      	})
      	
   });
</script>
</head>
<div id="dialog" title="Basic dialog">
	<p>This is the default dialog which is useful for displaying information</p>
</div>
<div class="jumbotron text-center">
  <h2>부트스트랩 form</h2>
</div>
<div class="container">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
     <form class="form-inline" method="post">
       <input class="form-control mr-sm-2" type="text" 
          name="ename" value=""
          placeholder="사원명">
       <input class="form-control mr-sm-2" type="text" 
          name="job"  value=""
          placeholder="직책명">
       <button class="btn btn-success" type="submit">Search</button>
     </form>
  </nav>
  <!--  button to open the Modal    style="display:none;"-->
  <button type="button"  id="btn01" class="btn btn-primary"  style="display:none;"
  			data-toggle="modal" data-target="#myModal">
  	 Open modal(boot strap)
  </button>
  <!-- The Modal -->
  <div class="modal fade" id="myModal">
  	  <div class="modal-dialog modal-lg">
  	  	  <div class="modal-content">
  	  	  	 <!-- Modal Header -->
  	  	  	 <div class="modal-header">
  	  	  	 	<h4 class="modal-title">Modal Heading</h4>
				<button type="button" class="close" data-dismiss="modal"></button>
  	  	  	 </div>
  	  	  	 <!-- Modal body -->
  	  	  	 <div class="modal-body">
  	  	  	 	Modal body.. 
  	  	  	 </div>
  	  	  	 <!-- Modal footer -->
  	  	  	 <div class="modal-footer">
  	  	  	 	<button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
  	  	  	 </div>
  	  	  </div>
  	  </div>	
  </div>
  <table class="table table-hover">
    <thead>
      <tr class="table-success text-center">
        <th>타이틀</th>
      </tr>
    </thead>
    <tbody>
      <tr class="text-center">
        <td>내용</td>
      </tr>
    </tbody>
  </table>    
</div>
</body>
</html>