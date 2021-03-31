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
<script src="${path}/gantt/codebase/dhtmlxgantt.js?v=7.0.13"></script>
	<link rel="stylesheet" href="${path }/gantt/codebase/dhtmlxgantt.css?v=7.0.13">
	<style>
		html, body {
			padding: 0px;
			margin: 0px;
			height: 100%;
		}
	</style>
<script type="text/javascript">
$.ajax({
	type:"post",
	url:"${path}/loadData.do",	// 데이터를 가져올 URL
	data:$("form").serialize(),	// 요청값에 대한 처리 
	dataType:"json",			// 매개변수로 받은 data의 type에 대한 선언 
	success:function(data){
	//	alert("데이터크기: "+data.emp.length);
		console.log(data.tasks);
		console.log(data.links);
		var tasks = data.tasks;
		var links = data.links;
		var show="";
		/*
		$.each(elist,function(idx,emp){
			show+="<tr class='text-center'>";
			show +="<td>"+emp.empno+"</td>";
			show +="<td class='text-left'>"+emp.ename+"</td>";
			show +="<td class='text-left'>"+emp.job+"</td>";
			show +="<td>"+emp.mgr+"</td>";
			// 1970.1.1 GMT 1/1000초 씩 카운트된 데이터
			// 날짜객체에 담아서 
			var dt = new Date(emp.hiredate);
			// toLocaleDateString() : 현재 우리나라 날짜 출력 형식으로 변환해서 처리 
			show +="<td>"+dt.toLocaleDateString()+"</td>";
			show +="<td class='text-right'>"+comma(emp.sal)+"</td>";
			show +="<td class='text-right'>"+comma(emp.comm)+"</td>";
			show += "<td>"+emp.deptno+"</td></tr>";
		});
		$("#list").html(show); */
	},
	error:function(err){
		alert("에러발생");
		console.log(err);
	}
});
</script>
	
</head>
<body>
	<div id="gantt_here" style='width:100%; height:100%;'></div>
	<script>
		
		gantt.config.date_format = "%Y-%m-%d %H:%i:%s";
		gantt.init("gantt_here");
		gantt.load("${path}/loadData.do", "json");
	</script>
</body>