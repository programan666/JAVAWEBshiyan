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
		<title>管理员页面</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="css/index.css" />
		<link type="text/css" rel="Stylesheet" href="css/imageflow.css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
		<script src="js/layer/layer.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript" src="js/imageflow.js"></script>
		<script type="text/javascript" src="js/global.js"></script>
		
		<script>
			$('document').ready(function(){
				var imgFile = document.getElementById('imgFile');
				var image = document.getElementById('image');
				imgFile.onchange = function(e) {
				var fr = new FileReader();
				fr.readAsDataURL(this.files[0]);
				fr.onload= function(e) {					
					image.src = this.result;
				}
			}
				var addOcpImgFile = document.getElementById('addOcpImgFile');
				var addOcpImage = document.getElementById('addOcpImage');
				addOcpImgFile.onchange = function(e) {
				var fr = new FileReader();
				fr.readAsDataURL(this.files[0]);
				fr.onload= function(e) {					
					addOcpImage.src = this.result;
				}
			}
			});
		</script>
	</head>

	<body>
		<div class="manager-page">
			<div class="container">

				<nav class="navbar navbar-default navbar-fixed-top">
					<div class="container-fluid">
						<a href="MngServlet?option=3" id="mRegionCon" class="manager-title"><span id="mRegionCon2">大区设置</span></a>
						<a href="OcpServlet?option=1" id="mOccupationCon" class="manager-title"><span id="mOccupationCon2">职业设置</span></a>
						<a href="#" onclick="return false" class="manager-title">
							<img src="images/logo.png" alt="斗战神" width="200" />
						</a>
						<a href="EqtServlet?option=1" id="mEquipmentCon" class="manager-title"><span id="mEquipmentCon2">装备设置</span></a>
						<a href="RolServlet?option=3" id="mPlayerCon" class="manager-title"><span id="mPlayerCon2">角色查询</span></a>

					</div>
					<%
						Mng loginMng = (Mng)session.getAttribute("loginMng");
						if(loginMng!=null){
					%>
					<p id="loginInfo" class="loginInfo">
						HELLO!<br> <%=loginMng.getMngLoginName() %><br>
						<a href="#" id="mPersonalInfoCon" style="font-size: 12px;font-weight:bold ;">修改密码</a>
						<a href="MngServlet?option=8" id="overloginCon" style="font-size: 12px;font-weight:bold ;">注销登录</a>
					</p>
					<%} %>
				</nav>

				<div id="manager-body" name="manager-body" class="manager-body">

					<div id="m-region" class="m-region" ${mRegBlock}>
						<table id="allReg" class="table table-hover region-table">
							<thead>
								<tr>
									<th>大区编号</th>
									<th>大区名称</th>
									<th>大区操作</th>
								</tr>
							</thead>
							<tbody>
								<%
									ArrayList<Reg> regList = (ArrayList<Reg>)request.getAttribute("regList");
									if(regList!=null){
									for(Reg reg:regList){
								%>
								<tr>
									<td>
										<%=reg.getRegId() %>
									</td>
									<td>
										<%=reg.getRegName() %>
									</td>
									<td>
										<a href="MngServlet?option=5&&regId=<%=reg.getRegId() %>" class="updateBtn btn btn-primary btn-sm">修改</a>
										<a href="MngServlet?option=6&&regId=<%=reg.getRegId() %>" class="delBtn btn btn-danger btn-sm">删除</a>
									</td>
								</tr>
								<%}} %>

							</tbody>
						</table>
						<div class="col-md-offset-9 col-md-3">
							<a href="#" id="addRegButton" class="btn btn-success btn-block" data-toggle="modal" data-target="#addReg-dialog">添加游戏大区</a>
						</div>
					</div>

					<div id="m-equipment" class="m-equipment" ${mEqtBlock }>

						<%
							ArrayList<Eqt> eqtList = (ArrayList<Eqt>)request.getAttribute("eqtList");
							if(eqtList!=null){
								for(Eqt eqt:eqtList){
						%>
						<div class="equipment-box">
							<img src="ImagesServlet?option=1&&picId=<%=eqt.getPic().getPicId() %>" alt="" />
							<span><%=eqt.getEqtName() %></span>
							<a href="EqtServlet?option=4&&eqtId=<%=eqt.getEqtId() %>" class="equipment-del-btn">删除</a>
							<a href="EqtServlet?option=2&&eqtId=<%=eqt.getEqtId() %>" class="equipment-info-btn">查看/修改</a>
						</div>
						<%} }%>
						<div class="col-md-offset-9 col-md-3">
							<a href="#" id="addEqtButton" class="btn btn-success btn-block" data-toggle="modal" data-target="#addEqtDialog">添加装备</a>
						</div>

					</div>

					<div id="m-start" class="m-start" ${mStartNone }>
						<div style="width:100%;height:420px;">
							<img src="images/mamaleft.png" class="start-left" alt="" width="570" height="420"/>
							<img src="images/mamaright.png" class="start-right" alt="" width="570" height="420"/>
						</div>
					</div>

					<div id="m-occupation" class="m-occupation" ${mOcpBlock }>
						
						<%
							ArrayList<Ocp> ocpList = (ArrayList<Ocp>)request.getAttribute("allOcp");
							if(ocpList!=null){
								for(Ocp ocp:ocpList){
						%>
						<div class="equipment-box">
							<img src="ImagesServlet?option=1&&picId=<%=ocp.getPic().getPicId() %>" alt="" />
							<span><%=ocp.getOcpName() %></span>
							<a href="OcpServlet?option=4&&ocpId=<%=ocp.getOcpId() %>" class="equipment-del-btn">删除</a>
							<a href="OcpServlet?option=2&&ocpId=<%=ocp.getOcpId() %>" class="equipment-info-btn">查看/修改</a>
						</div>
						<%} }%>
						<div class="col-md-offset-9 col-md-3">
							<a href="#" id="addEqtButton" class="btn btn-success btn-block" data-toggle="modal" data-target="#addOcpDialog">添加职业</a>
						</div>
						
					</div>

					<div id="m-player" class="m-player" ${mRolBlock}>
						<div class="searchBox">
							<form action="RolServlet" name="searchRolform" id="searchRolform" method="post">
							<input type="hidden" id="option" name="option" value='4'>
							<input type="hidden" id="searchfrom" name="searchfrom" value='1'>
							<input type="hidden" id="searchto" name="searchto" value='6'>
							<span class="searchCondition">昵称:
								<input type="text" name="rolNameForSearch" id="rolNameForSearch" value="${rolName }" placeholder="输入内容" class="form-control" style="width: 150px">
							</span>
							<span class="searchCondition">职业:
								<select id="rolOcpForSearch" name="rolOcpForSearch" value="" class="form-control" style="width: 150px">
									<option value="0">所有职业</option>
								<%
									Object ocplist = (Object)request.getAttribute("ocpList");
									if(ocplist!=null){
										ArrayList<Ocp> allocp = (ArrayList<Ocp>)ocplist;
										for(Ocp ocp:allocp){
								%>
									<option value="<%=ocp.getOcpId() %>"><%=ocp.getOcpName() %></option>
								<%} }%>
                				</select>
							</span>
							
							<span class="searchCondition">大区:
								<select id="rolRegForSearch" name="rolRegForSearch" value="" class="form-control" style="width: 150px">
									<option value="0">所有大区</option>
								<%
									Object reglist = (Object)request.getAttribute("regList");
									if(reglist!=null){
										ArrayList<Reg> allreg = (ArrayList<Reg>)reglist;
										for(Reg reg:allreg){
								%>
									<option value="<%=reg.getRegId() %>"><%=reg.getRegName() %></option>
								<%} }%>
                				</select>
							</span>
							
							<span class="searchCondition">
								<input type="submit" id="searchRolBtn" value="查找" class="form-control box-btn" style="width: 100px;"/>
							</span>
							</form>
						</div>
						<%
								ArrayList<Rol> rolList = (ArrayList<Rol>)request.getAttribute("rolList");
								
								if(rolList!=null){
																	
							%>
						<div style="width: 100%;height: 380px;">
						<table class="table table-hover region-table">
							<thead>
								<tr>
									<th>昵称</th>
									<th>账号</th>
									<th>密码</th>
									<th>邮箱</th>
									<th>职业</th>
									<th>大区</th>
									<th>战力</th>
								</tr>
							</thead>
							<tbody>
							<%
								for(Rol rol:rolList){	
							%>
								<tr>
									<td><%=rol.getRolName() %></td>
									<td><%=rol.getRolLoginName() %></td>
									<td><%=rol.getRolPwd() %></td>
									<td><%=rol.getRolEmail() %></td>
									<td><%=rol.getOcp().getOcpName() %></td>
									<td><%=rol.getReg().getRegName() %></td>
									<td><%=rol.getRolPower() %></td>
								</tr>
							<%} %>
							</tbody>
						</table>
						</div>
						<%
							Object rolCounts = request.getAttribute("rolCount");
							Object rolOcpIds = request.getAttribute("rolOcpId");
							Object rolRegIds = request.getAttribute("rolRegId");
							Object rolNames = request.getAttribute("rolName");
							Object nowPages = request.getAttribute("nowPage");
							int rolOcpId = (Integer)rolOcpIds;
							int rolRegId = (Integer)rolRegIds;
							int nowPage = (Integer)nowPages;
							String rolName = (String)rolNames;
							if(rolCounts!=null){
								int rolCount = (Integer)rolCounts;
								int pageNum;
								if((rolCount%6)==0)
									pageNum = rolCount/6;
								else
									pageNum = rolCount/6+1;
						%>
						<div class="searchPage">
							<%
								if(nowPage!=1){
							%>
							<a href="RolServlet?option=4&&rolNameForSearch=<%=rolName %>&&rolOcpForSearch=<%=rolOcpId %>&&rolRegForSearch=<%=rolRegId %>&&searchfrom=<%=6*(nowPage-2)+1 %>&&searchto=<%=6*(nowPage-1) %>">&lt;上一页</a>
							<%}
								for(int i=1;i<=pageNum;i++){
									int n = 6*(i-1)+1;
									int m = 6*i;
									System.out.println("参数1:"+rolName+"  2:"+rolOcpId+"  3:"+rolRegId+"  4:"+n+"  5:"+m);
							%>
							<a href="RolServlet?option=4&&rolNameForSearch=<%=rolName %>&&rolOcpForSearch=<%=rolOcpId %>&&rolRegForSearch=<%=rolRegId %>&&searchfrom=<%=n %>&&searchto=<%=m %>"><%=i %></a>
							<%} if(nowPage!=pageNum){%>
							<a href="RolServlet?option=4&&rolNameForSearch=<%=rolName %>&&rolOcpForSearch=<%=rolOcpId %>&&rolRegForSearch=<%=rolRegId %>&&searchfrom=<%=6*nowPage+1 %>&&searchto=<%=6*(nowPage+1) %>">下一页&gt;</a>
							<%} %>
							<p>第<%=nowPage %>/<%=pageNum %>页</p>
						</div>
						
						
						<%} }%>
					</div>

					<div id="m-personalInfo" class="m-personalInfo" ${mPinfoBlock }>
						<div class="info-center">
							<form onsubmit="return checkPasswordOK();" action="MngServlet" name="updatemngpwdform" id="updatemngpwdform" method="post">
								<input type="hidden" name="option" value="2" />
								<span>
									<h4>原始密码:</h4>
									<input type="password" name="lpassWord" id="lpassWord" value="${lpassWord }" placeholder="输入内容" class="form-control"> 
								</span>
								<span>
									<h4>新密码:</h4>
									<input type="password" name="xpassWord" id="xpassWord" value="${xpassWord }" placeholder="输入内容" class="form-control"> 
								</span>
								<span>
									<h4>确认新密码:</h4>
									<input type="password" name="xpassWord2" id="xpassWord2" value="${xpassWord2 }" placeholder="输入内容" class="form-control"> 
								</span>
								<span>
									<input type="submit" id="pwdUpdateBtn" value="修改" class="form-control box-btn" onclick="checkPasswordOK()">
								</span>
							</form>
							<%
								Object updatePassWordResult = request.getAttribute("updatePassWordResult");
							if(updatePassWordResult!=null){
								int i = (Integer)updatePassWordResult;
							%>
							<%
									if(i==0){
								%>
							<script type="text/javascript">
								$('document').ready(function() {
									layer.msg('密码不正确');
								});
							</script>
							<%} %>
							<%
									if(i==1){
								%>
							<script type="text/javascript">
								$('document').ready(function() {
									layer.msg('修改成功');
								});
							</script>
							<%} %>
							<%} %>
						</div>
					</div>

				</div>

			</div>

			<div class="modal fade" id="addReg-dialog" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="margin: 150px auto;">
					<div class="modal-content">
						<div class="modal-body">
							<button type="button" class="close" data-dismiss="modal" style="font-size: 30px;">
        					<span aria-hidden="true">&times;</span>
    					</button>
							<div class="addreg-box">
								<h1 style="margin-bottom: 35px;">添加大区</h1>
								<form onsubmit="return checkAddReg();" action="MngServlet" name="loginform" id="loginform" method="post">
									<input type="hidden" name="option" value="4" />
									<span>
									<h4 style="color: #000000!important;">大区名称:</h4>
									<input type="text" name="addRegName" id="addRegName" value="" placeholder="输入内容" class="form-control input-one">
								</span>
									<span>
									<input type="submit" id="addRegBtn" value="添加" class="form-control box-btn" style="width: 45%;" onclick="checkAddReg()"/>
								</span>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="modal fade" id="updateRegdialog" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="margin: 150px auto;">
					<div class="modal-content">
						<div class="modal-body">
							<button type="button" id="getReReg" class="close" data-dismiss="modal" style="font-size: 30px;">
        					<span aria-hidden="true">&times;</span>
    					</button>
							<div class="updatereg-box">
								<h1 style="margin-bottom: 35px;">修改大区信息</h1>
								<form onsubmit="return checkUpdateReg();" action="MngServlet" name="loginform" id="loginform" method="post">
									<input type="hidden" name="option" value="7" />
									<span>
									<h4 style="color: #000000!important;">大区名称:</h4>
									<input type="hidden" name="updateRegId" id="updateRegId" value="${regIdReturn }"/>
									<input type="text" name="updateRegName" id="updateRegName" value="${regNameReturn }" placeholder="输入内容" class="form-control input-one"/>
								</span>
									<span>
									<input type="submit" id="updateRegBtn" value="修改" class="form-control box-btn" style="width: 45%;" onclick="checkUpdateReg()"/>
								</span>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="modal fade" id="getEqtDialog" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="margin: 150px auto;">
					<div class="modal-content">
						<div class="modal-body" style="height: 530px;">
							<button type="button" id="getReEqt" class="close" data-dismiss="modal" style="font-size: 30px;">
        					<span aria-hidden="true">&times;</span>
    					</button>

							<%
    						Object eqtReturn = (Object)request.getAttribute("eqtReturn");
    						if(eqtReturn!=null){
    							Eqt eqt = (Eqt)eqtReturn;
    					%>

							<div class="updateEqt-box">
							
									<h1 style="margin: 15px;width: 95%;">查看/修改装备</h1>
									<form onsubmit="return checkUpdateEqt();" action="EqtServlet" name="updateEqtForm" id="updateEqtForm" method="post">
									<div class="updateEqt-box-left">
										<input type="hidden" name="option" value="3" />
										<span>
									<input type="hidden" name="addEqtId" id="addEqtId" value="<%=eqt.getEqtId() %>" placeholder="输入内容" class="form-control input-one">
									<h4 style="color: #000000!important;">装备名称:</h4>
									<input type="text" name="addEqtName" id="addEqtName" value="<%=eqt.getEqtName() %>" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">使用等级:</h4>
									<input type="text" name="addEqtLevel" id="addEqtLevel" value="<%=eqt.getEqtLevel() %>" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">描述:</h4>
									<input type="text" name="addEqtAttribute" id="addEqtAttribute" value="<%=eqt.getEqtAttribute() %>" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">战斗力:</h4>
									<input type="text" name="addEqtPower" id="addEqtPower" value="<%=eqt.getEqtPower() %>" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">类型:</h4>
									<input type="text" name="addEqtType" id="addEqtType" value="<%=eqt.getEqtType() %>" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">品质:</h4>
									<input type="text" name="addEqtQuality" id="addEqtQuality" value="<%=eqt.getEqtQuality() %>" placeholder="输入内容" class="form-control input-one">
								</span>
									<input type="hidden" name="addEqtPicId" id="addEqtPicId" value="<%=eqt.getPic().getPicId() %>" placeholder="输入内容" class="form-control input-one">
									</div>
									<span style="width: 100%;">
									<input type="submit" id="updateEqtBtn" value="修改" class="form-control box-btn" style="width: 45%;position: absolute;bottom: 12px;margin: 10px 22.5%!important;" onclick="checkUpdateEqt()"/>
								</span>
								
									<div class="updateEqt-box-right">
										<!-- <form onsubmit="true" action="ImagesServlet" name="updateEqtForm" id="updateEqtForm" method="post"> -->
										<!--<input type="hidden" name="option" value="2" />-->
										<input type="hidden" name="addEqtPicId" id="addEqtPicId" value="<%=eqt.getPic().getPicId() %>" placeholder="输入内容" class="form-control input-one">
										<img id="image"  src="ImagesServlet?option=1&&picId=<%=eqt.getPic().getPicId() %>" alt=""  />
										修改图片<input type="file" id="imgFile" name="imgFile" accept="image/*">
										<input type="button" id="updateEqtPicBtn" value="修改图片" class="form-control box-btn" style="width: 45%;bottom: 12px;"/>
									</div>
								
									
								</form>
							</div>
							<%} %>
						</div>
					</div>
				</div>
			</div>
			
			<div class="modal fade" id="addEqtDialog" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="margin: 150px auto;">
					<div class="modal-content">
						<div class="modal-body" style="height: 530px;">
							<button type="button" id="getReEqt" class="close" data-dismiss="modal" style="font-size: 30px;">
        					<span aria-hidden="true">&times;</span>
    						</button>

							<div class="updateEqt-box">
									<h1 style="margin: 15px;width: 95%;">添加装备</h1>
									<div class="updateEqt-box-left">
										<input type="hidden" name="option" value="3" />
										<span>
									<h4 style="color: #000000!important;">装备名称:</h4>
									<input type="text" name="addEqtName" id="addEqtName" value="" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">使用等级:</h4>
									<input type="text" name="addEqtLevel" id="addEqtLevel" value="" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">描述:</h4>
									<input type="text" name="addEqtAttribute" id="addEqtAttribute" value="" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">战斗力:</h4>
									<input type="text" name="addEqtPower" id="addEqtPower" value="" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">类型:</h4>
									<input type="text" name="addEqtType" id="addEqtType" value="" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">品质:</h4>
									<input type="text" name="addEqtQuality" id="addEqtQuality" value="" placeholder="输入内容" class="form-control input-one">
								</span>
									</div>
									<span style="width: 100%;">
									
								</span>
									<div class="updateEqt-box-right">
										<img id="image" src="" alt=""  />
										选择图片<input type="file" id="imgFile" name="imgFile" accept="image/*">
									</div>
								<input type="submit" id="addEqtBtn" value="添加" class="form-control box-btn" style="width: 45%;position: absolute;bottom: 12px;margin: 10px 22.5%!important;" onclick="checkUpdateEqt()"/>
							</div>
						
						</div>
					</div>
				</div>
			</div>
			
			<div class="modal fade" id="getOcpDialog" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="margin: 150px auto;">
					<div class="modal-content">
						<div class="modal-body" style="height: 530px;">
							<button type="button" id="getReOcp" class="close" data-dismiss="modal" style="font-size: 30px;">
        					<span aria-hidden="true">&times;</span>
    					</button>

							<%
    						Object ocpReturn = (Object)request.getAttribute("ocpReturn");
    						if(ocpReturn!=null){
    							Ocp ocp = (Ocp)ocpReturn;
    					%>

							<div class="updateEqt-box">
							
									<h1 style="margin: 15px;width: 95%;">查看/修改职业</h1>
									<form onsubmit="return checkUpdateOcp();" action="OcpServlet" name="updateOcpForm" id="updateOcpForm" method="post">
									<div class="updateEqt-box-left">
										<input type="hidden" name="option" value="3" />
										<span>
									<input type="hidden" name="updateOcpId" id="updateOcpId" value="<%=ocp.getOcpId() %>" placeholder="输入内容" class="form-control input-one">
									<h4 style="color: #000000!important;">职业名称:</h4>
									<input type="text" name="updateOcpName" id="updateOcpName" value="<%=ocp.getOcpName() %>" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">职业描述:</h4>
									<textarea rows="7" name="updateOcpAttribute" id="updateOcpAttribute" style="margin: 0px -12px 0px 0px; width: 296px; height: 243px;" placeholder="输入内容" class="form-control"><%=ocp.getOcpAttribute() %></textarea>
								</span>
									</div>
									<input type="hidden" name="updateOcpPicId" id="updateOcpPicId" value="<%=ocp.getPic().getPicId() %>" placeholder="输入内容" class="form-control input-one">
									<span style="width: 100%;">
									<input type="submit" id="updateOcpBtn" value="修改" class="form-control box-btn" style="width: 45%;position: absolute;bottom: 12px;margin: 10px 22.5%!important;" onclick="checkUpdateOcp()"/>
								</span>
								
									<div class="updateEqt-box-right">
										<input type="hidden" name="updateOcpPicId" id="updateOcpPicId" value="<%=ocp.getPic().getPicId() %>" placeholder="输入内容" class="form-control input-one">
										<img id="image"  src="ImagesServlet?option=1&&picId=<%=ocp.getPic().getPicId() %>" alt=""  />
										修改图片<input type="file" id="imgFile" name="imgFile" accept="image/*">
										<input type="button" id="updateOcpPicBtn" value="修改图片" class="form-control box-btn" style="width: 45%;bottom: 12px;"/>
									</div>
								</form>
							</div>
							<%} %>
						</div>
					</div>
				</div>
			</div>
			
			<div class="modal fade" id="addOcpDialog" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="margin: 150px auto;">
					<div class="modal-content">
						<div class="modal-body" style="height: 530px;">
							<button type="button" id="getReOcp" class="close" data-dismiss="modal" style="font-size: 30px;">
        					<span aria-hidden="true">&times;</span>
    				</button>
							<div class="updateEqt-box">
							
									<h1 style="margin: 15px;width: 95%;">添加职业</h1>
									<div class="updateEqt-box-left">
										<span>
									<h4 style="color: #000000!important;">职业名称:</h4>
									<input type="text" name="addOcpName" id="addOcpName" value="" placeholder="输入内容" class="form-control input-one">
								</span>
										<span>
									<h4 style="color: #000000!important;">职业描述:</h4>
									<textarea rows="7" name="addOcpAttribute" id="addOcpAttribute" style="margin: 0px -12px 0px 0px; width: 296px; height: 243px;" placeholder="输入内容" class="form-control"></textarea>
								</span>
									</div>
									<span style="width: 100%;">
									<input type="submit" id="addOcpBtn" value="添加" class="form-control box-btn" style="width: 45%;position: absolute;bottom: 12px;margin: 10px 22.5%!important;"/>
								</span>
								
									<div class="updateEqt-box-right">
										<img id="addOcpImage" src="" alt=""  />
										选择图片<input type="file" id="addOcpImgFile" name="addOcpImgFile" accept="image/*">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

			<%
				Object searchEqtResponse = request.getAttribute("searchEqtResponse");
				if(searchEqtResponse!=null){
					int i =(Integer)searchEqtResponse;
					if(i==1){
			%>
			<script type="text/javascript">
				$('#getEqtDialog').modal('show');
			</script>
			<%}} %>
			
			<%
				Object searchOcpResponse = request.getAttribute("searchOcpResponse");
				if(searchOcpResponse!=null){
					int i =(Integer)searchOcpResponse;
					if(i==1){
			%>
			<script type="text/javascript">
				$('#getOcpDialog').modal('show');
			</script>
			<%}} %>

			<%
				Object serchRegResponse = request.getAttribute("serchRegResponse");
				if(serchRegResponse!=null){
					int i = (Integer)serchRegResponse;
					if(i==1){
			%>
			<script type="text/javascript">
				$('#updateRegdialog').modal('show');
			</script>
			<%}} %>

			<%
				Object insertRegResponse = request.getAttribute("insertRegResponse");
				if(insertRegResponse!=null){
					int i = (Integer)insertRegResponse;
					if(i==1){
			%>
			<script type="text/javascript">
				layer.msg('大区添加成功');
				setTimeout(function() {
					$('#mRegionCon2').click();
				}, 1000);
			</script>
			<%}} %>

			<%
				Object deleteRegResponse = request.getAttribute("deleteRegResponse");
				if(deleteRegResponse!=null){
					int i = (Integer)deleteRegResponse;
					if(i==1){
			%>
			<script type="text/javascript">
				layer.msg('删除成功');
				setTimeout(function() {
					$('#mRegionCon2').click();
				}, 1000);
			</script>
			<%}} %>

			<%
				Object updateRegResponse = request.getAttribute("updateRegResponse");
				if(updateRegResponse!=null){
					int i = (Integer)updateRegResponse;
					if(i==1){
			%>
			<script type="text/javascript">
				layer.msg('修改成功');
				setTimeout(function() {
					$('#mRegionCon2').click();
				}, 1000);
			</script>
			<%}} %>

			<%
				Object eqtReturnMessage = request.getAttribute("eqtReturnMessage");
				if(eqtReturnMessage!=null){
					int i = (Integer)eqtReturnMessage;
					if(i==1){
			%>
				<script type="text/javascript">
				layer.msg('装备信息修改成功');
				setTimeout(function() {
					$('#mEquipmentCon2').click();
				}, 1000);
			</script>
			<%}else if(i==2){ %>
				<script type="text/javascript">
					layer.msg('删除装备成功');
					setTimeout(function() {
						$('#mEquipmentCon2').click();
					}, 1000);
				</script>
			<%} }%>
			
			<%
				Object ocpReturnMessage = request.getAttribute("ocpReturnMessage");
				if(ocpReturnMessage!=null){
					int i = (Integer)ocpReturnMessage;
					if(i==1){
			%>
			<script type="text/javascript">
				layer.msg('修改成功');
				setTimeout(function() {
					$('#mOccupationCon2').click();
				}, 1000);
			</script>
			<%}else if(i==2){ %>
			<script type="text/javascript">
				layer.msg('删除成功');
				setTimeout(function() {
					$('#mOccupationCon2').click();
				}, 1000);
			</script>
			<%}} %>
			
			<%
				Object searchReturnmessage = request.getAttribute("searchReturnmessage");
				if(searchReturnmessage!=null){
					int i = (Integer)searchReturnmessage;
					if(i==6){
						Object rolOcpIds = request.getAttribute("rolOcpId");
						Object rolRegIds = request.getAttribute("rolRegId");
						int rolOcpId = (Integer)rolOcpIds;
						int rolRegId = (Integer)rolRegIds;
			%>
				<script type="text/javascript">
				function jsSelectItemByValue(objSelect,objItemText) {    
			        for(var i=0;i<objSelect.options.length;i++) {    
			            if(objSelect.options[i].value == objItemText) {    
			                objSelect.options[i].selected = true;    
			               break;    
			           }    
			         }    
			 	}
				var selectedValue1 = "<%=rolOcpId %>";  
				var selectedValue2 = "<%=rolRegId %>";  
				jsSelectItemByValue(document.getElementById("rolOcpForSearch"),selectedValue1);  
				jsSelectItemByValue(document.getElementById("rolRegForSearch"),selectedValue2);  
			</script>
			<%} } %>
		</div>
	</body>

</html>