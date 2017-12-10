<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
		<link rel="stylesheet" href="css/login.css" />
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
		<!--		<script src="js/layer/layer.js" ></script>
		<script src="js/param.js" ></script>-->
		<script src="js/global.js"></script>
</head>
<body>
<div class="container">
			<div id="header">
				<div class="lay-center">
					<h2 class="common head-select">
				<div class="row" style="width: 84%;height:250px;margin: 0 auto;">
          			<div class="col-md-4 no-padding" style="height: 230px;top: 30px;left: 30px;">
          				<a href="RolServlet?option=1" class="login-btn">
            				<div class="login-btn-s" style="width: 200px;height: 200px;background: url(images/zhucea.png);background-size: cover;"></div>
            				<div class="show-hover" style="height: 200px;width: 200px;"></div>
            			</a>
          			</div>
          			<div class="col-md-4 no-padding" style="height: 250px;width: 250px;">
            			<a href="#" id="login" class="login-btn" data-toggle="modal" data-target="#login-dialog">
            				<div class="login-btn-s"></div>
            				<div class="show-hover" style="height: 250px;width: 250px;"></div>
            			</a>
          			</div>
          			<div class="col-md-4 no-padding" style="height: 230px;top: 30px;left: 20px;">
            			<a href="exe/DzsFullSetup_1.6.10.5693.exe" class="login-btn">
            				<div class="login-btn-s" style="width: 200px;height: 200px;background: url(images/downlaod.png);background-size: cover;"></div>
            				<div class="show-hover" style="height: 200px;width: 200px;"></div>
            			</a>
          			</div>                  
        		</div>
				</h2>

					<div class="entry-footer">
						<div class="row" style="height: 300px;margin-bottom: 10px;">
							<div class="col-md-2 ht no-padding">
								<a href="" class="left-btn lfet-btn_1">
									<div class="btnshow-hover" style="height: 112px;width: 156.9px;"></div>
								</a>
								<a href="" class="left-btn lfet-btn_2">
									<div class="btnshow-hover" style="height: 45px;width: 156.9px;"></div>
								</a>
								<a href="" class="left-btn lfet-btn_3">
									<div class="btnshow-hover" style="height: 45px;width: 156.9px;"></div>
								</a>
								<a href="" class="left-btn lfet-btn_4">
									<div class="btnshow-hover" style="height: 45px;width: 156.9px;"></div>
								</a>
								<a href="" class="left-btn lfet-btn_5">
									<div class="btnshow-hover" style="height: 45px;width: 156.9px;"></div>
								</a>
							</div>
							<div class="col-md-8 ht">
								<a id="vedioBtn" href="#" onclick="return false;" class="left-btn vedio-btn"></a>
								<embed id="vedio" class="control-vedio" src="vedio/DZS.mp4" loop=true autostart="false" width="600px" height="300px" title="哈哈"></embed>
							</div>
							<div class="col-md-2 ht no-padding">
								<a href="#" onclick="return false">
									<img src="images/right-btn.png" alt="" width="157" height="300" />
								</a>
							</div>
						</div>
						<div class="row" style="height: 130px;margin-bottom: 10px;">
							<div class="col-md-3 htt no-margin">
								<a href="">
									<img src="images/bottem1.png" width="230" height="120" />
								</a>
							</div>
							<div class="col-md-3 htt">
								<a href="">
									<img src="images/bottem2.png" width="230" height="120" />
								</a>
							</div>
							<div class="col-md-3 htt">
								<a href="">
									<img src="images/bottem3.png" width="230" height="120" />
								</a>
							</div>
							<div class="col-md-3 htt no-margin">
								<a href="">
									<img src="images/bottem4.png" width="230" height="120" />
								</a>
							</div>
						</div>
						<div class="row footer-link" style="height: 150px;margin-bottom: 10px;">
							<div class="col-md-5 httt" style="border: 0;">
								<img src="images/footerpic.png" alt="" />
							</div>
							<div class="col-md-1 httt" style="border: 0;">
								<a href="#" onclick="return false">腾讯互动娱乐</a>
							</div>
							<div class="col-md-1 httt">
								<a href="#" onclick="return false">服务条款</a>
							</div>
							<div class="col-md-1 httt">
								<a href="#" onclick="return false">广告服务</a>
							</div>
							<div class="col-md-1 httt">
								<a href="#" onclick="return false">游戏地图</a>
							</div>
							<div class="col-md-1 httt">
								<a href="#" onclick="return false">商务合作</a>
							</div>
							<div class="col-md-1 httt">
								<a href="#" onclick="return false">网站导航</a>
							</div>
							<div class="col-md-1 httt">
								<a href="#" onclick="return false">腾讯游戏客服</a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		
		<div class="modal fade" id="login-dialog" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin: 150px auto;">
				<div class="modal-content">
					<div class="modal-body">
						<button type="button" class="close" data-dismiss="modal" style="font-size: 30px;">
        				<span aria-hidden="true">&times;</span>
    				</button>
						<div class="login-box">
							<h1>安全登录</h1>
						<form onsubmit="return checkLogin();" action="MngServlet" name="loginform" id="loginform" method="post">
							<input type="hidden" name="option" value="1" />
							<p id="wronginfo" class="wrong-info">${errorMessage }</p>
							<input type="text" id="loginName" name="loginName" placeholder="请输入用户名" class="form-control login-input" value="${LoginName }">
							<input type="password" id="pwd" name="pwd" placeholder="请输入密码" class="form-control login-input">
							<span class="longin-type-select">
							<%
								String loginType = (String)request.getAttribute("loginType");
							%>
							<%
							if(loginType==null){
							%>
								<input type="radio" name="loginType" id="loginType" value="player" style="margin: 4px 6px 0;" checked/>玩家
                				<input type="radio" name="loginType" id="loginType" value="manager" style="margin: 4px 6px 0;"/>管理员
							<%} %>
							<%
							if(loginType!=null){
							if(loginType.length()==6){
							%>
								<input type="radio" name="loginType" id="loginType" value="player" style="margin: 4px 6px 0;" checked/>玩家
                				<input type="radio" name="loginType" id="loginType" value="manager" style="margin: 4px 6px 0;"/>管理员
							<%} %>
							<%
							if(loginType.length()==7){
							%>
								<input type="radio" name="loginType" id="loginType" value="player" style="margin: 4px 6px 0;"/>玩家
                				<input type="radio" name="loginType" id="loginType" value="manager" style="margin: 4px 6px 0;" checked/>管理员
							<%} }%>

                			</span>
							<input type="submit" id="loginBtn" value="登录" class="form-control login-input login-box-btn" onclick="checkLogin()">
						</form>
						</div>
						<div class="login-box-footer">
							<a href="#" onclick="return false" class="login-box-footer-inner" style="width: 70px;border-left: 1px solid #000000;">意见反馈</a>
							<a href="#" onclick="return false" class="login-box-footer-inner">注册新账号</a>
							<a href="#" onclick="return false" class="login-box-footer-inner" style="border-right: 1px solid #000000;">忘记密码？</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<%
			Object loginResult = request.getAttribute("loginResult");
		if(loginResult!=null){
			int i = (Integer)loginResult;
			if(i==1||i==2){
		%>
		<script type="text/javascript">
			$('#login').click();
		</script>
		<%}} %>

</body>
<script type="text/javascript" src="js/index.js"></script>
</html>