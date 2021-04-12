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
	   // 1. 전역변수 웹소켓 통신 처리한 변수 선언 
	   var wsocket;
	   // 2. 접속 시, 처리 내용 
	   $("#enterBtn").click(function(){
		   if(confirm("채팅서버에 접속하시겠습니까?")){
			   wsocket = new WebSocket("ws://192.168.0.63:8080/${path}/chat-ws.do"); //192.168.0.63:8080 // 211.63.89.63:7080 
			   // 1. 접속 시. 
			   wsocket.onopen=function(evt){
				   // 채팅서버에 접속되었을 때 처리할 내용 
				   console.log(evt);
				   // 접속메시지 전송 
		//		   wsocket.send("msg:"+$("#id").val()+": 연결 접속했습니다!");
				   wsocket.send($("#group").val()+$("#id").val()+": 연결 접속했습니다!");  // 그룹 채팅 
				   
			   }
			   // 2. 서버에서 메시지 받기 
			   wsocket.onmessage=function(evt){
				   var data = evt.data; // 메시지 받음 
				   // 그룹채팅 
				   var user = data.splig(":");
				   if(user[0]==$("#group").val()){
					   revMsg(user[1]+":"+user[2]);
				   }
				 /*   if(data.substring(0,4)=="msg:"){
					   // 메시지만 전달 처리 
					   revMsg(data.substring(4));
				   } */
				   
			   }
			   // 3. 서버에 종료 처리 
			   wsocket.onclose=function(){
				   alert("접속을 종료합니다!!");
				   $("#chatMessageArea").text("");
				   $("#id").val("").focus();
			   }
			   
		   }
	   });
	   // .send()는 서버의 handleTextMessage와 연동 
	   $("#sendBtn").click(function(){
		   sendMsg();
	   });
	   $("#msg").keyup(function(e){
		   if(e.keyCode==13){
			   sendMsg();
		   }
	   });
	   $("#exitBtn").click(function(){
		   wsocket.send("msg: "+$("#id").val()+": 연결 종료");
		   wsocket.close();
	   });
	   
	   function sendMsg(){
		   var id=$("#id").val();
		   var msg=$("#msg").val();
		   wsocket.send("msg:"+$("#group").val()+id+":"+msg);
		   $("#msg").val("");
	   }
	   
	   function revMsg(msg){
		   $("#chatMessageArea").append(msg+"<br>");
		   // 자동 스크롤링 처리..(메시지 내용)
		   var mx = parseInt($("#chatMessageArea").height());
		   $("#chatArea").scrollTop(mx);
		   
	   }
	   
	   
   });
</script>
<style>

.input-group-text{
	width:100%;
	background-color:linen;
	color:black;
	font-weight:bolder;
}
.input-group-prepend{
	width:20%;
}
#chatArea{
	width:80%;
	height:200px;
	overflow-y:auto;
	text-align:left;
	border:1px solid green;
}
</style>
</head>
<body>
<div class="jumbotron text-center">
  <h2>채팅</h2>
</div>
<div class="container">
     <div class="input-group mb-3">
     	<div class="input-group-prepend">
     		<span class="input-group-text">아이디</span>
     	</div>
     	  <input class="form-control" 
          name="id" id="id" placeholder="접속할 그룹을 입력하세요">
          <div class="input-group-prepend">
     		<span class="input-group-text">그룹</span>
     	</div>
     	  <input class="form-control" 
          name="group" id="group" placeholder="접속할 아이디를 입력하세요">&nbsp;
          <input type="button" class="btn btn-info" value="채팅입장" id="enterBtn"/>&nbsp;
          <input type="button" class="btn btn-warning" value="나가기" id="exitBtn"/>
     </div>
       
          
      <div class="input-group mb-3">
     	<div class="input-group-prepend">
     		<span class="input-group-text">메시지</span>
     	</div>
     	   <input id ="msg" class="form-control" type="text" 
          name="msg" placeholder="보낼 메시지를 입력하세요">&nbsp;
          <input type="button" class="btn btn-success" value="전송" id="sendBtn"/>
     </div>
      
    
    
     <div class="input-group mb-3">
     	<div class="input-group-prepend">
     		<span class="input-group-text">내용</span>
     	</div>
     	<!-- #chatArea -->
     	<div id="chatArea" class="input-group-append">
     		<div id="chatMessageArea"></div>
     	</div>
     </div>
</div>
</body>
</html>