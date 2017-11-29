<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
			background: url(images/roldelebac.png);
			background-size: 1100px 760px;
		}
	</style>
</head>
<body>
	<span class="some-bb">怎能忘了西游？</span>
	<a href="#" class="delete-rol-btn" data-toggle="modal" data-target="#deleterol-dialog">删除</a>
	<div class="modal fade" id="deleterol-dialog" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin: 150px auto;">
				<div class="modal-content">
					<div class="modal-body">
						<button type="button" class="close" data-dismiss="modal" style="font-size: 30px;">
        				<span aria-hidden="true">&times;</span>
    				</button>
						<div class="login-box">
							<h1>确定删除？要不要再考虑一下</h1>
						</div>
						<div class="delet-bb-box">
						<%
							Rol rol = (Rol)session.getAttribute("rolInfo");
							if(rol!=null){
						%>
							<a href="RolServlet?option=6&&rolId=<%=rol.getRolId() %>" target="_top" class="delet-bb-btn">残忍删除</a>
							<a href="#" class="delet-bb-btn" data-dismiss="modal">回心转意</a>
						<%} %>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>