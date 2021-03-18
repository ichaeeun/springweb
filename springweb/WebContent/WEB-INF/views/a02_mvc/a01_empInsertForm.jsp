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
      var isInsert = "${param.ename}";
      if(isInsert!=""){
    	  if(confirm("등록완료!!\n조회화면으로 가시겠습니까?")){
    		  location.href="${path}/empList2.do";
    	  }
      }
   });
</script>
</head>
<div class="jumbotron text-center">
  <h2>사원등록</h2>
</div>
<div class="container">
<%-- 
 <form:form commandName="emp" action="${path}/insertEmp.do">
  <table class="table table-hover">
    <tbody>
      <tr class="text-center">
      	<th class="table-success">사원명</th><td><form:input path="ename"/></td>
      </tr>
    </tbody>
  </table>    
  </form:form>
  --%>
  <form:form modelAttribute="ins" action="${path}/insertEmp.do" method="post">
  <table class="table table-hover">
    <tbody>
    	<col width="30%"><col width="70%">
      <tr class="text-center">
      	<th class="table-success">사원명</th>
      	<td><form:input path="ename" class="form-control"/></td> </tr>
      <tr class="text-center"><th class="table-success">직책</th>
      	<td>
      	  <%-- option에 대한 default 설명이나 항목이 필요 없는 경우 
      	  1. 요청값에 대한 선택 setJob emp.getJob() 
      	  		${emp.job} 으로 선택하게 처리 
      	  		<select name="job"> 으로 된 값을 선택 
      	  		==> Emp 객체 안에 job 속성 setJob, getJob() 
      	  2. select의 option 리스트를 처리 
			    모델어트리뷰트를 통해서 데이터리스트 처리 
			    
      	  --%>
      	<form:select path="job" class="form-control mr-sm-2">
       		<option value="">직책선택</option>
       		<form:options items="${jobs }"></form:options>
        </form:select></td> </tr>
       <tr class="text-center">	<th class="table-success">관리자</th><td>
       <%-- option에 대한 default 설명이나 항목이 필요 없는 경우 
       		label과 value를 해당하는 객체의 property로 설정 
       --%>
      	<form:select path="mgr" class="form-control mr-sm-2">
       		<option value="0">관리자선택</option>
       		<form:options items="${mgrs }" itemLabel="ename" itemValue="mgr"/>
        </form:select></td> </tr>
       <tr class="text-center">	<th class="table-success">급여</th><td><input name="sal" class="form-control"/></td> </tr>
       <tr class="text-center">	<th class="table-success">보너스</th><td><input name="comm" class="form-control"/></td> </tr>
       <tr class="text-center">	<th class="table-success">부서명</th><td> 
      	<form:select path="deptno" class="form-control mr-sm-2">
       		<option value="0">부서선택</option>
       		<form:options items="${depts }" itemLabel="dname" itemValue="deptno"/>
        </form:select></td> 
      </tr>
       <tr class="text-center"><td colspan="2"><button class="btn btn-info" type="submit" id="regBtn">사원등록</button></td></tr>
    </tbody>
  </table>    
  </form:form>
</div>
</body>
</html>