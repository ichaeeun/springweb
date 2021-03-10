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
 <%--        
[스프링]
[하] 1. 소스에 @Autowired 설정처리시, 사용되는 객체와 객체간의 연계부분을 기술하세요.
[하] 2. 특정패키지에 Emp(이름), Manager(이름), Ceo(이름) 클래스를 Company클래스(회사명,Emp, Manager, Ceo)로
        설정하여, 소스상 Autowired로 설정하여 호출처리하게 하세요.
[하] 3. ModelAttribute란 무엇인가? 개념을 기술하고, 기본 예제를 만들어 보세요. 

--%>
<%--  
[jquery]
[하] 1. filter기능 메서드를 이용해서, 5X5테이블에서 각 td의 3개단위로 배경색상이 다르게 출력, tr의 짝홀번째 글자가 다르게
    출력처리하세요. end()메서드 활용.
--%>
 
--%>
//
   $(document).ready(function(){
      $("td").each(function(){
    	  
      });
   });
</script>
</head>
<div class="jumbotron text-center">
  <h2>JQUERY</h2>
</div>
<div class="container">
  <table class="table table-hover">
    <tbody>
      <tr class="text-center">
        <td>내용</td>
      </tr>
    </tbody>
  </table>    
</div>
</body>
</html>