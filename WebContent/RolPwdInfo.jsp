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
			background: url(images/managerbac.jpg);
			background-size: 1100px 760px;
		}
	</style>
</head>
<body>
	<div class="user-update">
		<form onsubmit="return checkRolPwd();" action="RolServlet" name="rolupdatepwdform" id="rolupdatepwdform" method="post">
		<input type="hidden" name="option" value="5">
		<%
			Rol rol = (Rol)session.getAttribute("rolInfo");
			if(rol!=null){
		%>
		<input type="hidden"id="rolId" name="rolId" value="<%=rol.getRolId() %>">
		<%} %>
		<span>
			<h1>原密码:</h1>
			<input type="password" id="rolOldPwd" name="rolOldPwd" value="${oldPwd }" class="form-control" style="width: 200px;letter-spacing: 5px;">
		</span>
		<span>
			<h1>新密码:</h1>
			<input type="password" id="rolNewPwd" name="rolNewPwd" value="${newPwd }" class="form-control" style="width: 200px;letter-spacing: 5px;">
		</span>
		<span>
			<h1>确认密码:</h1>
			<input type="password" id="rolNewPwd2" name="rolNewPwd2" value="" class="form-control" style="width: 200px;letter-spacing: 5px;">
		</span>
		<span style="text-align: center;display: block;margin: 10px auto;">
			<input type="submit" id="updateRolPwdBtn" value="点击修改" class="form-control box-btn" style="width: 45%;" onclick="checkRolPwd()"/>
		</span>
	</div>
	
	<%
		Object updateRolPwdReturn = request.getAttribute("updateRolPwdReturn");
		if(updateRolPwdReturn!=null){
			int i = (Integer)updateRolPwdReturn;
			if(i==1){
	%>
		<script type="text/javascript">
			layer.msg('修改成功');
		</script>
	<%}else{ %>
		<script type="text/javascript">
			layer.msg('原密码不正确');
		</script>
	<%} }%>
</body>
</html>