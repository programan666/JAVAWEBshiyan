<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reg.pojo.Reg"%>
<%@page import="eqt.pojo.Eqt"%>
<%@page import="ocp.pojo.Ocp"%>
<%@page import="pic.pojo.Pic"%>
<%@page import="rol.pojo.Rol"%>
<%@page import="mng.pojo.Mng"%>
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
	<div class="userInfo">
		<%
			Rol rol = (Rol)session.getAttribute("rolInfo");
			if(rol!=null){
		%>
		<a href="RolPic.jsp" class="update-userpic" target="main">
			<div class="user-pic">
				<img width="200" height="200" src="ImagesServlet?option=1&&picId=<%=rol.getPic().getPicId() %>" alt="" />
			</div>
		</a>
		<input type="text" class="user-name" id="rolNameInp" value="<%=rol.getRolName() %>" />
<!--		<p class="user-name">
			<%=rol.getRolName() %>
		</p>-->
		
	</div>
	<div class="menu">
		<a href="RolPwdInfo.jsp" target="main" class="menu-a" style="margin-top: 33px;">修改密码</a>
		<a href="RolServlet?option=10" target="main" class="menu-a">管理装备</a>
		<a href="PK.jsp" target="main" class="menu-a">切磋武艺</a>
		<a href="RolDelet.jsp" target="main" class="menu-a">删除角色</a>
		<a href="RolServlet?option=7" target="_top" class="menu-a">注销登录</a>
	</div>
	
	
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#rolNameInp").blur(function(){
			var rolNameInptext =  $("#rolNameInp").val();
						var params = {
							newRolName:rolNameInptext,
							rolId:<%=rol.getRolId() %>
						};
					$.post('http://localhost:7777/JAVAWEB/RolServlet?option=8', params, function(data) {
						
					});
		});
		})
		
	</script>
	<%} %>
</body>
</html>