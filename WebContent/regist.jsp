<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reg.pojo.Reg"%>
<%@page import="eqt.pojo.Eqt"%>
<%@page import="pic.pojo.Pic"%>
<%@page import="ocp.pojo.Ocp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户注册</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="css/index.css" />
		<link type="text/css" rel="Stylesheet" href="css/imageflow.css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
		<script src="js/layer/layer.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript" src="js/imageflow.js"></script>
		<style type="text/css">
			body {
				background: url(images/zhucebc.jpg)!important;
				background-size: 100%!important;
			}
		</style>
	</head>

	<body>
		<div class="regist-page">
			<div class="regist-left">
				<form onsubmit="return checkInsertRol();" action="RolServlet" name="registform" id="registform" method="post">
				<input type="hidden" id="option" name="option" value='2'>
				<span>
					<h1>昵称</h1>
					<input type="text" id="rolName" name="rolName" value="${rolName }" class="form-control">
				</span>
				<span>
					<h1>账号</h1>
					<input type="text" id="rolLoginName" name="rolLoginName" value="${rolLoginName }" class="form-control">
				</span>
				<span>
					<h1>密码</h1>
					<input type="password" id="rolPwd" name="rolPwd" value="${rolPwd }" class="form-control">
				</span>
				<span>
					<h1>确认密码</h1>
					<input type="password" id="rolPwd2" value="${rolPwd }" class="form-control">
				</span>
				<span>
					<h1>邮箱</h1>
					<input type="text" id="rolEmail" name="rolEmail" value="${rolEmail }" class="form-control" style="font-size: 18;letter-spacing: 3px;">
				</span>
				<span>
					<h1>心情</h1>
					<input type="text" id="rolMood" name="rolMood" value="${rolMood }" class="form-control">
				</span>
				<span>
					<h1>大区</h1>
					<select id="rolRegSelected" name="rolRegSelected" value="${rolRegSelected }" class="form-control">
					<%
						Object regList = (Object)request.getAttribute("regList");
						Object errorMessage = request.getAttribute("errorMessage");
						if(regList!=null){
							ArrayList<Reg> allreg = (ArrayList<Reg>)regList;
							for(Reg reg:allreg){
					%>
						<option value="<%=reg.getRegId() %>"><%=reg.getRegName() %></option>
					<%} }%>
                	</select>
				</span>
				<input type="hidden" id="rolOcpName" name="rolOcpName" value='灵猴'>
				<span style="text-align: center;">
					<input type="submit" id="insertRolBtn" value="点击注册" class="form-control box-btn" style="width: 45%;" onclick="checkInsertRol()"/>
				</span>

			</div>
			<div class="regist-right">
				<span>
					<h1 style="width: 100%;text-align: center;">角色选择</h1>
				</span>
				<div class="c-body">
					<div class="c-b-left">
						<div class="banner">
						<%
							Object ocpList = request.getAttribute("ocpList");
							Object ocpNum = request.getAttribute("ocpNum");
							Object rolOcpName = request.getAttribute("rolOcpName");
							if(ocpList!=null){
								int ocpnum = (Integer)ocpNum;
								ArrayList<Ocp> allocp = (ArrayList<Ocp>)ocpList;
						%>
							<div class="imgs">
						<%
							int i1 = 1;
							for(Ocp ocp:allocp){
								if(i1==1){
						%>
								<img src="ImagesServlet?option=1&&picId=<%=ocp.getPic().getPicId() %>" class="active" alt="" />
								<%}else{ %>
								<img src="ImagesServlet?option=1&&picId=<%=ocp.getPic().getPicId() %>" alt="" />
						<%}i1++; } %>
							</div>
							<div class="arrow arrow-left">
								&lt;
							</div>
							<div class="arrow arrow-right">
								&gt;
							</div>
							<div class="circle">
						<%
							for(int j=0;j<ocpnum;j++){
								if(j == 0){
						%>
								<span class="circle-item active"></span>
							<%}else{ %>
								<span class="circle-item"></span>
						<%} }%>
							</div>
							<div class="rol-name">
							<%
								int i2 = 1;
								for(Ocp ocp:allocp){
									if(i2==1){
							%>
								<span class="name-rol active"><%=ocp.getOcpName() %></span>
							<%}else{ %>
								<span class="name-rol"><%=ocp.getOcpName() %></span>
							<%}i2++; }%>
							</div>
							<div class="rol-info">
							<%
								int i3 = 1;
								for(Ocp ocp:allocp){
									if(i3==1){
							%>
								<span class="info-rol active"><%=ocp.getOcpAttribute() %></span>
							<%}else{ %>
								<span class="info-rol"><%=ocp.getOcpAttribute() %></span>
							<%}i3++; }%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			var arrowRight = $('.banner .arrow-right');
			var arrowLeft = $('.banner .arrow-left');
			var imgs = $('.banner .imgs img');
			var circles = $('.banner .circle-item');
			var info = $('.banner .info-rol');
			var rname = $('.banner .name-rol');
			var i = 0;
			arrowRight.click(function() {
				i++;
				i %= <%=ocpnum %>;
				move();
			});
			arrowLeft.click(function() {
				i--;
				if (i == -1) {
					i = <%=ocpnum-1 %>;
				}
				move();
			});
			function move() {
				imgs.removeClass('active');
				imgs.eq(i).addClass('active');
				circles.removeClass('active');
				circles.eq(i).addClass('active');
				info.removeClass('active');
				info.eq(i).addClass('active');
				rname.removeClass('active');
				rname.eq(i).addClass('active');
				var a = $('.rol-name .active').html();
				$('#rolOcpName').val(a);
			}
			circles.hover(function() {
				i = $(this).index();
				move();
			});
			<%
				if(errorMessage!=null){
					int ocpi = 0;
					if(rolOcpName!=null){
						String rolOcpname = (String)rolOcpName;
						for(Ocp ocp:allocp){
							System.out.println(ocp.getOcpName()+"    "+rolOcpname);
							if(ocp.getOcpName().equals(rolOcpname)){
								System.out.println("找到匹配");
								break;
							} 
							ocpi++;
						}
						%>
						i = <%=ocpi %>;
						
						move();
						<%
						System.out.println(ocpi);
					}
				}%>
		</script>
		<%} %>
		
		<%
			
			Object rolRegSelected = request.getAttribute("rolRegSelected");
			if(errorMessage!=null&&rolRegSelected!=null){
				String message = (String)errorMessage;
				int regid = (Integer)rolRegSelected;
		%>
			<script type="text/javascript">
				layer.msg('<%=message %>');
				function jsSelectItemByValue(objSelect,objItemText) {    
			        for(var i=0;i<objSelect.options.length;i++) {    
			            if(objSelect.options[i].value == objItemText) {    
			                objSelect.options[i].selected = true;    
			               break;    
			           }    
			         }    
			 	}
				var selectedValue = "<%=regid %>";  
				jsSelectItemByValue(document.getElementById("rolRegSelected"),selectedValue);  
			</script>
		<%} %>
	</body>

</html>