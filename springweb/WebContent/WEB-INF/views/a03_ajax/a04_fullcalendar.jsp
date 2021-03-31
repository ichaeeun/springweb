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
<link href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.css' rel='stylesheet' />
<link href='https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.13.1/css/all.css' rel='stylesheet'>
<link href='${path}/a00_com/lib/main.css' rel='stylesheet' />
<script src='${path}/a00_com/lib/main.js'></script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }
  #schDialog label { width:90px!important; }
  
</style>

<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<style>
	input[type=text], select, label, textarea{
	  	margin-bottom:12px; 
	  	padding:.4em;
	  	width:95%;
  	}
  	.input-group-text{
  		width:100%;
  		text-align:center;
  		background-color:linen;
  		color:black;
  		font-weight:bolder;
  	}
  	.input-group-prepend{
  		width:35%;
  	}
</style>
<script type="text/javascript">
<%--
 
 
--%>
// 전역변수로 날짜 데이터 가져오기 위한 선언 
var date = {};

// document.addEventListener("DOMContentLoaded")
// 전체 DOM에 로딩되었을 때, jquery $(document).ready(); 와 동일 
 document.addEventListener('DOMContentLoaded', function() {
	 var opts = {
			 autoOpen:false,
			 width:"350px",
			 modal:true
	 }
 	 $( "#schDialog" ).dialog(opts);
	 
	 
    var calendarEl = document.getElementById('calendar');
	// new FullCalendar.Calendar(대상 DOM객체, 
	//						{속성:속성값,속성2:속성값2...}) 
    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prevYear prev today next nextYear',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
      },
      themeSystem: 'bootstrap',
      initialDate: new Date().toIOString, // 초기 로딩 날짜. (현재날짜)
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      // 이벤트명: function(){} : 각 날짜에 대한 이벤트를 통해 처리할 내용
      select: function(arg) {
		console.log(arg); // console을 통해서 해당 속성 확인 
		
		opts.buttons={
			"등록":function(){
				alert("등록 처리합니다!");
				var sch = callSch();
				console.log("등록할 데이터");
				console.log(sch);
				// 화면에 출력 
				if(sch.title){
					calendar.addEvent(sch);
					calendar.unselect();
				}
				$("#schDialog").dialog("close");
				// ajax 처리 (DB 등록)
				$.ajax({
					type:"get",
					url:"${path}/calendar.do?method=insert",
					data:sch;
					success:function(data){
						if(data.success=="Y"){
							alert("등록성공");
						}	
					},
					error:function(err){
						console.log(err);
					}
				})
			}
		};
		$("#schDialog").dialog(opts);
		$("#schDialog").dialog("open");
	  //	alert("시작일: "+arg.start.toISOString());
		// 화면에 보이는 형식 설정
		// 클릭한 날짜를 전역변수에 할당/시작일과 마지막일을 date형식으로 할당 
		date.start = arg.start;
		date.end = arg.end; 
		$("[name=start]").val(arg.start.toLocaleString());
		$("[name=end]").val(arg.end.toLocaleString());
		$("[name=allDay]").val(""+arg.allDay);
        
        
         
      },
      eventClick: function(arg) {
    	// 있는 일정 클릭 시 
    	// 상세 화면 보이기(등록되어 있는 데이터 출력)
    	// ajax를 통해서 수정/삭제 
    	
    	console.log("# 등록된 일정 클릭 #")
    	console.log(arg.event);
        if (confirm('이벤트를 삭제하시겠습니까')) {
          arg.event.remove()
        }
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: function(info,successCallback, failureCallback){
    	  // ajax처리로 데이터를 로딩 시킨다. 
    	  $.ajax({
    		  type:"get",
    		  url:"${path}/calendar.do?method=data",
    		  dataType:"json",
    		  success:function(data){
    			  console.log(data.list);
    			  successCallback(data.list);
    		  },
    		  error:function(err){
    			  console.log(err);
    		  }
    	  })
      }
    });

    calendar.render();
  });
  
   
 function callSch(){
	 var sch = {};
	 sch.title=$("[name=title]").val();
	 sch.writer=$("[name=writer]").val();
	 sch.content=$("[name=content]").val();
	 // Date타입은 화면에서 사용되는 형식으로 설정하여야 한다. 
	 sch.start= date.start.toISOString();
	 sch.end= date.end.toISOString();
	 // alert("등록할 시작일: "+sch.start);
	 sch.allDay=$("[name=allDay]").val()=="true"; // 문자열이 "true"일 때, 그외는 false 
	 sch.backgroundColor=$("[name=backgroundColor]").val(); // 배경색상 
	 sch.textColor=$("[name=textColor]").val(); // 
	 sch.borderColor=$("[name=borderColor]").val();
	 return sch;
 }
   
   $(document).ready(function(){
      
   });
</script>
</head>
<body>
 <div id='calendar'></div>
 

 <div id="schDialog" title="일정 등록">
  <form id="frm"> 
  	<input name="id" type="hidden" value="0"/>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">제목</span>
  		</div>
  		<input class="form-control" name="title" type="text"/>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">작성자</span>
  		</div>
  		<input class="form-control" name="writer" type="text"/>
  	</div>
  	
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">내용</span>
  		</div>
  		<textarea rows="5" cols="20" class="form-control" name="content"></textarea>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">종일여부</span>
  		</div>
  		<select class="form-control" name="allDay">
			<option value="true">종 일</option>  		
			<option value="false">시 간</option>  		
  		</select>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">시작일</span>
  		</div>
  		<input class="form-control" name="start" type="text"/>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">종료일</span>
  		</div>
  		<input class="form-control" name="end" type="text"/>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">배경색상</span>
  		</div>
  		<input class="form-control" name="backgroundColor" type="color" value="#0099cc"/>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">테두리색상</span>
  		</div>
  		<input class="form-control" name="borderColor" type="color" value="#0099cc"/>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">글자색상</span>
  		</div>
  		<input class="form-control" name="textColor" type="color" value="#ccffff"/>
  	</div>
  </form>
</div>
</body>
</html>