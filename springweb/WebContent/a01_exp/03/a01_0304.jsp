<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="jspexp.z01_vo.*"
    import="jspexp.a03_database.*"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<fmt:requestEncoding value="UTF-8" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" 
   href="${path}/a00_com/a00_com.css">
<style>

</style>
<script type="text/javascript" 
  src="${path}/a00_com/jquery-3.5.1.js"></script>
<script type="text/javascript">
<%--
 1. A01_StartController안에서 
 	메서드를 추가하고, view단도 추가해서 
 	view : WEB-INF/views/z01_exp/a01_exp01.jsp 
 	start2.do 
 	http://localhost:7080/springweb/start2.do 
 	화면에서 안녕하세요 스프링 연습입니다. 출력 
 2. springweb/z01_exp/A01_ExpController.java 만들고, 
 	http://localhost:7080/springweb/start3.do  호출해서 
 	view : WEB-INF/views/z01_exp/a03_exp.jsp 
 3. springweb2 dynamic web project 만들고 
 	초기화면을 
 	http://localhost:7080/springweb2/newSpring.do 화면 호출하게 처리 
--%>
//
   $(document).ready(function(){
      
   });
</script>
</head>
<body>
   <h3>제목</h3>
   <table>
      <tr><th>타이틀</th></tr>
      <tr><td>내용</td></tr>
   </table>
</body>
</html>