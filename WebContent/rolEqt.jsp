<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reg.pojo.Reg"%>
<%@page import="eqt.pojo.Eqt"%>
<%@page import="pic.pojo.Pic"%>
<%@page import="ocp.pojo.Ocp"%>
<%@page import="rol.pojo.Rol"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
	<link rel="stylesheet" href="css/index.css" />
	<link type="text/css" rel="Stylesheet" href="css/imageflow.css" />
	<link rel="stylesheet" type="text/css" href="slick/slick.css"/>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<script src="js/layer/layer.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/imageflow.js"></script>
	<script type="text/javascript" src="js/global.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="slick/slick.min.js"></script>
	<style type="text/css">
		body {
			background: url(images/managerbac.jpg);
			background-size: 1100px 760px;
		}
	</style>
	<script type="text/javascript">
		function drag(e){
			e.dataTransfer.setData("objId",e.target.id);
			/*alert(e.target.id);*/
			if($('#recevBox').is(':has(*)')){
				/*var re = document.getElementById("recevBox").innerHTML;*/
				/*$('.slick').slickAdd(re);*/
				/*var oldinner = document.getElementById("slickBox").innerHTML;
				var oldbox = document.getElementById("slickBox");
				oldinner+=re;*/
				document.getElementById("recevBox").innerHTML = "";
			}
		}
		function allowDrop(e){
			e.preventDefault();
		}
		function drop(e){
			e.preventDefault();
			var objId = e.dataTransfer.getData("objId");
			var a = document.getElementById(objId);
			var b = document.getElementById("#recevBox");
			a.setAttribute("class", "showit"); 
			
			if($('#recevBox').is(':has(*)')){
				
			}
			else{
				e.target.appendChild(a);
				layer.msg('装备成功');
				var rolId = $("#rolidForeqt").val();
				var selectedEqtId =  objId.slice(6);
				var params = {
						selectedEqtId:selectedEqtId,
						rolId:rolId
					};
				$.post('http://localhost:7777/JAVAWEB/RolServlet?option=11', params, function(data) {
					
				});
				
				setTimeout(function() {
					parent.location.reload();
				},2000);
			}
			
		}
	</script>
</head>
<body>
	<div id="slickBox" class="slick">
		<%
			ArrayList<Eqt> eqtList = (ArrayList<Eqt>)request.getAttribute("eqtList");
			Rol rol = (Rol)session.getAttribute("rolInfo");
			if(eqtList!=null&&rol!=null){
				for(Eqt eqt:eqtList){
		%>
		<input type="hidden" name="rolidForeqt" id="rolidForeqt" value="<%=rol.getRolId() %>" />
		<div id="eqtbox<%=eqt.getEqtId() %>" draggable="true" ondragstart="drag(event)">
			<div class="equipment-box-rol">
				<img width="210" height="175" src="ImagesServlet?option=1&&picId=<%=eqt.getPic().getPicId() %>" style="z-index:9;"/>
				<span><%=eqt.getEqtName() %></span>
			</div>
		</div>
		<%} }%>
	</div>
	<div id="recevBox" class="recev-eqt" ondrop="drop(event)" ondragover="allowDrop(event)" >
		
	</div>
</body>
<script type="text/javascript">
	$(function(){
    $('.slick').slick({
        slidesToShow: 4,
  		slidesToScroll: 1,
  		autoplaySpeed: 1000,
  		/*infinite: true,*/
        autoplay: true,
        pauseOnHover: true,
        
    });
});
</script>
</html>