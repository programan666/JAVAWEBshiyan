<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reg.pojo.Reg"%>
<%@page import="eqt.pojo.Eqt"%>
<%@page import="ocp.pojo.Ocp"%>
<%@page import="pic.pojo.Pic"%>
<%@page import="rol.pojo.Rol"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
	<link rel="stylesheet" href="css/index.css" />
	<link type="text/css" rel="Stylesheet" href="css/imageflow.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<script src="js/layer/layer.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/imageflow.js"></script>
	<script type="text/javascript" src="js/global.js"></script>
	<style type="text/css">
			body {
				background: url(images/menu-bac.png) repeat;
			}
		</style>
</head>
<body>
	<div class="user-title">
		角色详情
	</div>
	<%
		Rol rol = (Rol)session.getAttribute("rolInfo");
		if(rol!=null){
	%>
	<div class="user-detail">
		<span>职业：<%=rol.getOcp().getOcpName() %></span>
		<span>战斗力：<%=rol.getRolPower() %></span>
		<span>大区：<%=rol.getReg().getRegName() %></span>
	</div>
	<div class="user-ocp">
		<img src="ImagesServlet?option=1&&picId=<%=rol.getOcp().getPic().getPicId() %>" alt="" width="307" height="260px"/>
	</div>
	<div class="user-mood">
		心情：
		<textarea rows="7" name="usermoodup" id="usermoodup" class="mood-tex" style="margin: 0px -12px 0px 0px; width: 279px; height: 150px;margin-top: 20px;" placeholder="" class="form-control"><%=rol.getRolMood() %></textarea>
		
		
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#usermoodup").blur(function(){
			var rolMoodInptext =  $("#usermoodup").val();
				var params = {
						newRolMood:rolMoodInptext,
						rolId:<%=rol.getRolId() %>
					};
				$.post('http://localhost:7777/JAVAWEB/RolServlet?option=9', params, function(data) {
					
				});
		});
		})
	</script>
	
	<%} %>
</body>
</html>