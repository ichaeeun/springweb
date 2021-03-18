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
      $("#dname, #loc").keyup(function(e){
    	  if(e.keyCode==13){
    		  ajaxCall();
    	  }
      });
      
      $("#schBtn").click(function(){
    	  ajaxCall();
      });
   });
   function ajaxCall(){
	   $.ajax({
			type:"post",
			url:"${path}/jsonDept.do",
			data:$("form").serialize(),
			dataType:"json",
			success:function(data){
			//	alert("데이터크기: "+data.dept.length);
				console.log(data);
				var dlist = data.dept;
				var show="";
				$.each(dlist,function(idx,dept){
					show+="<tr class='text-center'>";
					show +="<td class='text-left'>"+dept.deptno+"</td>";
					show +="<td class='text-left'>"+dept.dname+"</td>";
					show +="<td class='text-left'>"+dept.loc+"</td></tr>";
				});
				$("#list").html(show);
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
  <h2>부서정보 ajax 처리</h2>
</div>
<div class="container">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
     <form class="form-inline">
       <input class="form-control mr-sm-2" type="text" 
          name="dname" id="dname" value=""
          placeholder="부서명">
       <input class="form-control mr-sm-2" type="text" 
          name="loc"  id="loc" value=""
          placeholder="부서위치">
          <button class="btn btn-success" id="schBtn" type="button">Search</button>
     </form>
  </nav>
  <table class="table table-hover">
    <thead>
      <tr class="table-success text-center">
        <th>부서번호</th>
        <th>부서명</th>
        <th>부서위치</th>
      </tr>
    </thead>
    <tbody id="list">
    
    </tbody>
  </table>    
</div>
</body>
</html>