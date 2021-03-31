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
	<script src="../../codebase/dhtmlxgantt.js?v=7.0.13"></script>
	<link rel="stylesheet" href="../../codebase/dhtmlxgantt.css?v=7.0.13">
	<style>
		html, body {
			padding: 0px;
			margin: 0px;
			height: 100%;
		}
	</style>
</head>
<body>
	<div id="gantt_here" style='width:100%; height:100%;'></div>
	<script>
		gantt.config.date_format = "%Y-%m-%d %H:%i:%s";
		gantt.init("gantt_here");
		gantt.load("../common/data.json", "json");
	</script>
</body>