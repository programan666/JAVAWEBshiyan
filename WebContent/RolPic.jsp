<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
			background: url(images/managerbac.jpg);
			background-size: 1100px 760px;
		}
	</style>
	<script type="text/javascript">
		$('document').ready(function(){
				var rolimgFile = document.getElementById('rolimgFile');
				var rolimage = document.getElementById('rolimage');
				rolimgFile.onchange = function(e) {
				var fr = new FileReader();
				fr.readAsDataURL(this.files[0]);
				fr.onload= function(e) {					
					rolimage.src = this.result;
				}
			}
			});
	</script>
</head>
<body>
		<%
			Rol rol = (Rol)session.getAttribute("rolInfo");
			if(rol!=null){
		%>
	<div class="updateRol-box">
		<input type="hidden" name="updateRolPicId" id="updateRolPicId" value="<%=rol.getPic().getPicId() %>" placeholder="输入内容" class="form-control input-one">
		<img id="rolimage" width="300" height="300" src="ImagesServlet?option=1&&picId=<%=rol.getPic().getPicId() %>" alt=""  />
		修改头像<input type="file" id="rolimgFile" name="rolimgFile" accept="image/*">
		<input type="button" id="updateRolPicBtn" value="点击修改头像" class="form-control box-btn" style="width: 55%;bottom: 12px;"/>
	</div>
	<%} %>
</body>
</html>