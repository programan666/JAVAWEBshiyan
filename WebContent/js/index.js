

$('document').ready(function(){
	$('#vedioBtn').click(function(){
		$('#vedioBtn').remove();
		$("embed").removeClass();
	});
	
	$('#mRegionCon').click(function(){
		$('.m-equipment').css("display","none");
		$('.m-occupation').css("display","none");
		$('.m-player').css("display","none");
		$('.m-personalInfo').css("display","none");
		$('.m-start').css("display","none");
		$('.m-region').css("display","block");
	});
	
	$('#mEquipmentCon').click(function(){
		$('.m-region').css("display","none");
		$('.m-occupation').css("display","none");
		$('.m-player').css("display","none");
		$('.m-personalInfo').css("display","none");
		$('.m-start').css("display","none");
		$('.m-equipment').css("display","block");
	});
	
	$('#mOccupationCon').click(function(){
		$('.m-region').css("display","none");
		$('.m-equipment').css("display","none");
		$('.m-player').css("display","none");
		$('.m-personalInfo').css("display","none");
		$('.m-start').css("display","none");
		$('.m-occupation').css("display","block");
	});
	
	$('#mPlayerCon').click(function(){
		$('.m-region').css("display","none");
		$('.m-equipment').css("display","none");
		$('.m-occupation').css("display","none");
		$('.m-personalInfo').css("display","none");
		$('.m-start').css("display","none");
		$('.m-player').css("display","block");
	});
		
	$('#mPersonalInfoCon').click(function(){
		$('.m-region').css("display","none");
		$('.m-equipment').css("display","none");
		$('.m-occupation').css("display","none");
		$('.m-player').css("display","none");
		$('.m-start').css("display","none");
		$('.m-personalInfo').css("display","block");
	});
	
	/*$('#login').click(function(){
		$('#rolLoginName').val()='';
		$('#rolPwd').val()='';
	});*/
	
	$('#getReReg').click(function(){
		$('#mRegionCon2').click();
	});
	
	$('#getReEqt').click(function(){
		$('#mEquipmentCon2').click();
	});
	
	$('#getReOcp').click(function(){
		$('#mOccupationCon2').click();
	});
	
	$('#updateEqtPicBtn').click(function(){
		if($('#imgFile').val()!=''){
			var file = $('#imgFile').get(0).files[0];
			var formData = new FormData();
			formData.append("addEqtPicId",$('#addEqtPicId').val());
			formData.append("imgFile",file);
			$.ajax({
				url: 'http://localhost:7777/JAVAWEB/updatePicServlet',
				type: 'POST',
				data: formData,
				processData: false,
				contentType: false,
			}).done(function() {
					layer.msg('图片更改成功');
				})
		}
		else{
			layer.msg('图片没有更改');
		}
	});
	
	$('#updateRolPicBtn').click(function(){
		if($('#rolimgFile').val()!=''){
			var file = $('#rolimgFile').get(0).files[0];
			var formData = new FormData();
			formData.append("updateRolPicId",$('#updateRolPicId').val());
			formData.append("rolimgFile",file);
			$.ajax({
				url: 'http://localhost:7777/JAVAWEB/updatePicServlet',
				type: 'POST',
				data: formData,
				processData: false,
				contentType: false,
			}).done(function() {
					layer.msg('头像更改成功');
					var a = setTimeout(function(){
						parent.location.reload();
					},1500);
				})
		}
		else{
			layer.msg('图片没有改变，请重试');
		}
	});
	
	$('#updateOcpPicBtn').click(function(){
		if($('#imgFile').val()!=''){
			var file = $('#imgFile').get(0).files[0];
			var formData = new FormData();
			formData.append("picId",$('#updateOcpPicId').val());
			formData.append("imgFile",file);
			$.ajax({
				url: 'http://localhost:7777/JAVAWEB/updatePicServlet',
				type: 'POST',
				data: formData,
				processData: false,
				contentType: false,
			}).done(function() {
					layer.msg('图片更改成功');
				})
		}
		else{
			layer.msg('图片没有更改');
		}
	});
	
	$('#addEqtBtn').click(function(){
		var addEqtName = $('#addEqtName').val();
		var addEqtLevel = $('#addEqtLevel').val();
		var addEqtAttribute = $('#addEqtAttribute').val();
		var addEqtPower = $('#addEqtPower').val();
		var addEqtType = $('#addEqtType').val();
		var addEqtQuality = $('#addEqtQuality').val();
		var addEqtPicName = $('#imgFile').val();
		if(addEqtName!=''&&addEqtLevel!=''&&addEqtAttribute!=''&&addEqtPower!=''&&addEqtType!=''&&addEqtQuality!=''&&addEqtPicName!=''){
			var file = $('#imgFile').get(0).files[0];
			var formData = new FormData();
			formData.append("addEqtName",addEqtName);
			formData.append("addEqtLevel",addEqtLevel);
			formData.append("addEqtAttribute",addEqtAttribute);
			formData.append("addEqtPower",addEqtPower);
			formData.append("addEqtType",addEqtType);
			formData.append("addEqtQuality",addEqtQuality);
			formData.append("imgFile",file);
			$.ajax({
				url: 'http://localhost:7777/JAVAWEB/addEqtServlet',
				type: 'POST',
				data: formData,
				processData: false,
				contentType: false,
			}).done(function() {
					layer.msg('装备添加成功');
					$('#addEqtDialog').modal('hide');
					$('#mEquipmentCon2').click();
				})
		}
		else{
			layer.msg('信息不能为空');
		}
	});
	
	$('#addOcpBtn').click(function(){
		var addOcpName = $('#addOcpName').val();
		var addOcpAttribute = $('#addOcpAttribute').val();
		var addOcpPicName = $('#addOcpImgFile').val();
		if(addOcpName!=''&&addOcpAttribute!=''&&addOcpPicName!=''){
			var file = $('#addOcpImgFile').get(0).files[0];
			var formData = new FormData();
			formData.append("addOcpName",addOcpName);
			formData.append("addOcpAttribute",addOcpAttribute);
			formData.append("imgFile",file);
			$.ajax({
				url: 'http://localhost:7777/JAVAWEB/addOcpServlet',
				type: 'POST',
				data: formData,
				processData: false,
				contentType: false,
			}).done(function() {
					layer.msg('职业添加成功');
					$('#addOcpDialog').modal('hide');
					$('#mOccupationCon2').click();
				})
		}
		else{
			layer.msg('信息不能为空');
		}
	});
	
	
	
	
});



function checkLogin(){

	var loginName = $('#loginName').val();
	var loginPwd = $('#pwd').val();
	if(loginName==''||loginPwd==''){
		$('#wronginfo').html("输入信息不能为空!");
		return false;
	}
	if(loginName.length<6||loginPwd.length<6){
		$('#wronginfo').html("输入信息不能少于6位!");
		return false;
	}
	return true;
}

function checkPasswordOK(){
	var pwd = $('#lpassWord').val();
	var pwd1 = $('#xpassWord').val();
	var pwd2 = $('#xpassWord2').val();
	if(pwd!=''&&pwd1!=''&&pwd2!=''){
		if(pwd.length>5&&pwd1.length>5&&pwd2.length>5){
			if(pwd1==pwd2){
				return true;
			}
			else{
				layer.msg('两次输入密码不一致');
				return false;
			}
		}
		else{
			layer.msg('密码不能少于6位');
			return false;
		}
		
	}
	else{
		layer.msg('请输入完整信息');
		return false;
	}
}

function checkAddReg(){
	var regName = $('#addRegName').val();
	if(regName.length==0){
		layer.msg('请输入信息');
		return false;
	}
	else{
		return true;
	}
}

function checkUpdateReg(){
	var regName = $('#updateRegName').val();
	if(regName.length==0){
		layer.msg('请输入信息');
		return false;
	}
	else{
		return true;
	}
}

function checkInsertRol(){
	var rolName = $('#rolName').val();
	var rolLoginName = $('#rolLoginName').val();
	var rolPwd = $('#rolPwd').val();
	var rolPwd2 = $('#rolPwd2').val();
	var rolEmail = $('#rolEmail').val();
	var rolMood = $('#rolMood').val();
	if(rolName!=''&&rolLoginName!=''&&rolPwd!=''&&rolPwd2!=''&&rolEmail!=''&&rolMood!=''){
		if(rolLoginName.length>5){
			if(rolPwd2==rolPwd){
				if(rolPwd.length>5){
					return true;
				}
				else{
					layer.msg('密码不能小于6位');
					return false;
				}
			}
			else{
				layer.msg('两次输入的密码不一致');
				return false;
			}
		}
		else{
			layer.msg('账号不能小于6位');
			return false;
		}
	}
	else{
		layer.msg('请输入完整信息');
		return false;
	}
}

function checkUpdateEqt(){
	var addEqtName = $('#addEqtName').val();
	var addEqtLevel = $('#addEqtLevel').val();
	var addEqtAttribute = $('#addEqtAttribute').val();
	var addEqtPower = $('#addEqtPower').val();
	var addEqtType = $('#addEqtType').val();
	var addEqtQuality = $('#addEqtQuality').val();
	if(addEqtName!=''&&addEqtLevel!=''&&addEqtAttribute!=''&&addEqtPower!=''&&addEqtType!=''&&addEqtQuality!=''){
		return true;
	}
	else{
		layer.msg('信息不能为空');
		return false;
	}
}

function checkUpdateOcp(){
	var updateOcpName = $('#updateOcpName').val();
	var updateOcpAttribute = $('#updateOcpAttribute').val();
	if(updateOcpName!=''&&updateOcpName&&updateOcpAttribute!=''&&updateOcpAttribute){
		return true;
	}
	else{
		layer.msg('信息不能为空');
		return false;
	}
}

function checkRolPwd(){
	var rolOldPwd = $('#rolOldPwd').val();
	var rolNewPwd = $('#rolNewPwd').val();
	var rolNewPwd2 = $('#rolNewPwd2').val();
/*	alert("rolOldPwd："+rolOldPwd+"  rolNewPwd："+rolNewPwd+"  rolNewPwd2："+rolNewPwd2);*/
	if(rolOldPwd!=''&&rolOldPwd&&rolNewPwd!=''&&rolNewPwd&&rolNewPwd2!=''&&rolNewPwd2){
		if(rolNewPwd2==rolNewPwd){
			return true;
		}
		else{
			layer.msg('两次输入密码不一致');
			return false;
		}
	}
	else{
		layer.msg('信息不能为空');
		return false;
	}
}

