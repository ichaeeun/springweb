<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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
      
   });
</script>
</head>
<div class="jumbotron text-center">
  <h2>부트스트랩 form</h2>
</div>
<div class="container">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
     <form class="form-inline" method="post" 
       action="${path}/">
       <select name="fruit" class="form-control mr-sm-2">
       		<option value="0">과일</option>
       		<c:forEach var="fruit" items="${fruits}">
       			<option value="${fruit.name}">${fruit.name}</option>
       		</c:forEach>
       </select>
       <select name="price" class="form-control mr-sm-2">
       		<option value="0">가격</option>
       		<c:forEach var="fruit" items="${fruits}">
       			<option value="${fruit.price}">${fruit.price}</option>
       		</c:forEach>
       </select>
       <button class="btn btn-success" type="submit">Search</button>
     </form>
  </nav>
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