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
<div id="m-player" class="m-player" style="display: block;margin-top: 100px;">
						<div class="searchBox">
							<form action="RolServlet" name="searchRolform" id="searchRolform" method="post">
							<input type="hidden" id="option" name="option" value='12'>
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
								Rol nowRol = (Rol)session.getAttribute("rolInfo");
								if(rolList!=null&&nowRol!=null){
																	
							%>
						<div style="width: 100%;height: 380px;">
						<table class="table table-hover region-table">
							<thead>
								<tr>
									<th>昵称</th>
									<th>职业</th>
									<th>大区</th>
									<th>战力</th>
									<th>对战</th>
								</tr>
							</thead>
							<tbody>
							<%
								for(Rol rol:rolList){	
							%>
								<tr>
									<td><%=rol.getRolName() %></td>
									<td><%=rol.getOcp().getOcpName() %></td>
									<td><%=rol.getReg().getRegName() %></td>
									<td><%=rol.getRolPower() %></td>
									<td>
										<a href="RolServlet?option=13&&selectesRolId=<%=rol.getRolId() %>&&nowRolId=<%=nowRol.getRolId() %>" class="updateBtn btn btn-primary btn-sm">切磋</a>
									</td>
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
							<a href="RolServlet?option=12&&rolNameForSearch=<%=rolName %>&&rolOcpForSearch=<%=rolOcpId %>&&rolRegForSearch=<%=rolRegId %>&&searchfrom=<%=6*(nowPage-2)+1 %>&&searchto=<%=6*(nowPage-1) %>">&lt;上一页</a>
							<%}
								for(int i=1;i<=pageNum;i++){
									int n = 6*(i-1)+1;
									int m = 6*i;
									System.out.println("参数1:"+rolName+"  2:"+rolOcpId+"  3:"+rolRegId+"  4:"+n+"  5:"+m);
							%>
							<a href="RolServlet?option=12&&rolNameForSearch=<%=rolName %>&&rolOcpForSearch=<%=rolOcpId %>&&rolRegForSearch=<%=rolRegId %>&&searchfrom=<%=n %>&&searchto=<%=m %>"><%=i %></a>
							<%} if(nowPage!=pageNum){%>
							<a href="RolServlet?option=12&&rolNameForSearch=<%=rolName %>&&rolOcpForSearch=<%=rolOcpId %>&&rolRegForSearch=<%=rolRegId %>&&searchfrom=<%=6*nowPage+1 %>&&searchto=<%=6*(nowPage+1) %>">下一页&gt;</a>
							<%} %>
							<p>第<%=nowPage %>/<%=pageNum %>页</p>
						</div>
						
						
						<%} }%>
					</div>
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
</body>
</html>