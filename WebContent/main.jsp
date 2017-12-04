<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<%
		Object resultFlags = request.getAttribute("resultFlag");
		if(resultFlags!=null){
			int resultFlag = (Integer)resultFlags;
			if(resultFlag==1){
	%>
		<script type="text/javascript">
			layer.msg('平局');
		</script>
	<%}else if(resultFlag==2){ %>
		<script type="text/javascript">
			layer.msg('战败');
		</script>
		<%}else if(resultFlag==3){ %>
		<script type="text/javascript">
			layer.msg('胜利');
		</script>
	<%} }%>
</body>
</html>