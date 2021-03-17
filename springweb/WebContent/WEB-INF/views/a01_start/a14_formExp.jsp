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
      
   });
</script>
</head>
<div class="jumbotron text-center">
  <h2>물건구매</h2>
</div>
<div class="container">
  <form:form modelAttribute="purchase" class="form-inline" method="post">
  <table class="table table-hover">
    <tbody>
      <tr class="text-center">
         <th class="table-success">물건 종류</th>
         <td>
         <form:select path="kind" class="form-control mr-sm-2">
         	<option value="">물건종류</option>
         	<form:options items="${prodKind }"/>
         </form:select></td>
      </tr>
       <tr class="text-center">
       <th class="table-success">물건명</th>
       <td><form:input path="name" class="form-control mr-sm-2" placeholder="물건명"/></td>
       </tr>
      <tr class="text-center">
         <th class="table-success">가격</th>
         <td>
         <form:select path="price" class="form-control mr-sm-2">
         	<option value="">가격</option>
         	<form:options items="${prices }"/>
         </form:select></td>
      </tr>
      <tr class="text-center">
         <th class="table-success">갯수</th>
         <td><form:select path="cnt" class="form-control mr-sm-2">
         	<option value="">갯수</option>
         	<form:options items="${cnts }"/>
         </form:select></td>
      </tr>
      <tr class="text-center">
         <td colspan="2"><button class="btn btn-success" type="submit">등록</button></td>
      </tr>
    </tbody>
  </table>  
  </form:form>  
  <table class="table table-hover">
    <tbody>
    <col width="50%"> <col width="50%">
      <tr class="text-center">
         <th class="table-success">물건 종류</th>
         <td>${purchase.kind }</td>
      </tr>
      <tr class="text-center">
         <th class="table-success">물건명</th>
         <td>${purchase.name }</td>
      </tr>
      <tr class="text-center">
         <th class="table-success">가격</th>
         <td>${purchase.price }</td>
      </tr>
      <tr class="text-center">
         <th class="table-success">갯수</th>
         <td>${purchase.cnt }</td>
      </tr>
    </tbody>
  </table>  
</div>
</body>
</html>