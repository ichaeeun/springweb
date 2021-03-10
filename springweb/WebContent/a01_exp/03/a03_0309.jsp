<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" 
    import="springdi.z01_vo.Product"%>
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
[jquery]
[하] 1. focus/blur이벤트의 기본 형식을 기술하세요.
	$(선택자).focus(function(){
 		처리할 내용 
 	});
	$(선택자).blur(function(){
		처리할 내용 
	});
[하] 2. [0  ] X [0  ] [정답]  : 왼쪽과 같이 3개의 input창을 만들고 클릭 시, 입력할 기존 문자가 없어지고 정답 부분을 클릭시, 왼쪽에 
    입력된 값을 연산하여 출력처리하세요.
[중] 3. 아래와 같은 내용에 select를 선택했을 때, 구매 총액이 하단에 표기되게 하세요.
        사과    3000  [0~10]
        바나나   4500  [0~10]
        딸기   12000  [0~10]
          구매 총액  @@@
[하] 4. 3X3테이블을 만들고, 초기에 중앙에 배경색상으로 노랑색으로 되어 있다가, 키이벤트 좌우상하를 누르고 있을 때는, 중앙에 있는
    노랑색 배경색상이 해당 방향으로 이동되어 있다가, 키를 떼었을 때, 다시 중앙으로 돌아오게 이벤트 처리하세요.
--%>
//
   $(document).ready(function(){
	   $("#btn").on("click",function(){
		   var num01 = $("[name=num01]").val();
		   var num02 = $("[name=num02]").val();
		   var cal = $("[name=cal]").val();
		   var result = eval(num01+cal+num02);
		   $("#result").text(result);
		   $("[name=num01]").val();
		   $("[name=num02]").val();
		   $("[name=cal]").val();
	   });
	   $("input").focus(function(){
		   // 전체 input은 공통적으로 초기화 처리 
		   $(this).val("");
		   
		   // <input name="tot"> 인것을 focus했을 때, 
		   // 연산처리 
		   if($(this).attr("name")=="tot"){
			   var num01 = $("[name=num01]").val();
			   var num02 = $("[name=num02]").val();
			   var cal = $("[name=cal]").val();
			   var result = eval(num01+cal+num02);
			   $(this).val(result);
			   $("[name=num01]").val();
			   $("[name=num02]").val();
			   $("[name=cal]").val();
		   }
	   });
	   
	   $("select").change(function(){
		  var appleTot = $("#apple").val() * 3000;
		  var bananaTot = $("#banana").val() *4500;
		  var strawTot = $("#strawberry").val() *12000;
		  var tot = appleTot+bananaTot+strawTot;
	//	  alert(appleTot+":"+bananaTot+":"+strawTot);
	//	  alert("총계: "+tot);
		   $("#sum").text(tot+"원");
		});
	   
	   
	   
	   $("[name=test]").keyup(function(event){
		   // 좌37 위38 우39 아40 
		   alert(event.keyCode);
	   });
	   $("#tab td").eq(4).css("background","tomato");
	 //  $("#5").css("background","tomato");
	 
	 //현재 화면을 기준으로 이벤트 처리 .. $(this)
	   $(this).keydown(function(event){
		   $("td").css("background","white");
		   if(event.keyCode==38){
		//	   $("#2").css("background","tomato");
			   $("#tab td").eq(1).css("background","tomato");
		   }
		   if(event.keyCode==37){
		//	   $("#4").css("background","tomato");
			   $("#tab td").eq(3).css("background","tomato");
		   }
		   if(event.keyCode==39){
		//	   $("#6").css("background","tomato");
			   $("#tab td").eq(5).css("background","tomato");
		   }
		   if(event.keyCode==40){
		//	   $("#8").css("background","tomato");
			   $("#tab td").eq(7).css("background","tomato");
		   }
	   });
	   $("body").keyup(function(event){
		   $("td").css("background","white");
		   $("#5").css("background","tomato");
	   });
   });
     
</script>
</head>
<body>
	<input size="2" name="num01" value="0"><input size="2" name="cal" value="*"><input size="2" name="num02" value="0"><input name="tot" value="정답"/><span id="result"></span>
	<br><br><br><br>
<%
	ArrayList<Product> plist = new ArrayList<Product>();
	plist.add(new Product("apple",3000,0));
	plist.add(new Product("banana",4500,0));
	plist.add(new Product("strawberry",12000,0));
	request.setAttribute("plist",plist);
%>
	<table>
		<tr><th>물건명</th><th>가격</th><th>갯수</th></tr>
		<c:forEach var="pro" items="${plist }">
			<tr><td>${pro.name }</td><td>${pro.price }</td>
			<td>
				<!-- select 3개에 각각의 id값을 물건명으로 설정 -->
				<select id="${pro.name }"><c:forEach var="cnt" begin="0" end="10"><option>${cnt}</option></c:forEach></select>
			</td></tr>
		</c:forEach>
		<tr><th colspan="2">구매총액</th><td id="sum">0</td></tr>
	</table>
	
	
	<input name="test">
	<table id="tab" class="table table-hover">
		<tr class="text-center"><td id="1">1</td><td id="2">2</td><td id="3">3</td></tr>
		<tr class="text-center"><td id="4">4</td><td id="5">5</td><td id="6">6</td></tr>
		<tr class="text-center"><td id="7">7</td><td id="8">8</td><td id="9">9</td></tr>
	</table>
</body>
</html>
