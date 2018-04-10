<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
<!-- icon -->
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<!-- jquery -->
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function loginSubmit(){
		var userName = $("#userName").val();
		var password = $("#password").val();
		var password1 = $("#password1").val();
		if(userName == ''){
			$("#error").html('账户不能为空');
			return false;
		}
		if(password == ''){
			$("#error").html('密码不能为空');
			return false;
		}
		if(password1 == ''){
			$("#error").html('确认密码不能为空');
			return false;
		}
		if(password != password1){
			$("#error").html('密码与确认密码不一致');
			return false;
		}
		if($("#error").html() == '此账户已被注册'){
			return false;
		}
		$.post("${pageContext.request.contextPath}/register.html",{'name':userName,'password':password},function(result){
			if(result.success){
				if(confirm('恭喜你,注册成功,立即登录!')){
					location.href="${pageContext.request.contextPath}/login.jsp";
				}
			}
		},'json')
	}
	
	$(function(){
		$("#userName").change(function() {
			var userName = $("#userName").val();
			var $this = $(this);
			$.post("${pageContext.request.contextPath}/existName.html",{'userName':userName},function(result){
				if(result.success){
					$("#error").html('请在这里注册');
				}else{
					$("#error").html('此账户已被注册');
					$(this).focus();
				}
			},'json')
		}); 
	})
</script>
<title>新用户注册-P2P小额贷款</title>
</head>
<body style="background: #fff url(${pageContext.request.contextPath}/static/images/1.jpg) 50% 0 no-repeat;">
	<div class="container" style="margin-top: 270px;">
	<div class="row">
	<div class="col-md-3">
	</div>
	<div class="col-md-9">
	<div style="width: 400px;height: 380px;background:transparent;background-color:rgba(255,255,255,0.08)">
		<div style="position: relative;left: 120px;top: 20px;">
			<h2><b>新&nbsp;用&nbsp;户&nbsp;注&nbsp;册</b></h2>
		</div>
		<div role="alert" style="width: 300px;height: 30px;position: relative;left: 100px;top: 15px;">
		  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		  <span class="sr-only">Error:</span>
		  <label style="color: red"><h4 id="error">请在这里注册</h4></label>
		</div>
		<div class="input-group input-group-lg" style="	width: 300px;top: 25px;left: 40px;">
		  <span class="input-group-addon" id="sizing-addon1">账　　户</span>
		  <input id="userName" name="userName" type="text" class="form-control" placeholder="请输入你的账户" aria-describedby="sizing-addon1">
		</div>
		<div class="input-group input-group-lg" style="position: relative;left: 40px;width: 300px;top: 45px;">
		  <span class="input-group-addon" id="sizing-addon1">密　　码</span>
		  <input type="password" id="password" name="password" class="form-control" placeholder="请输入你的密码" aria-describedby="sizing-addon1">
		</div>
		<div class="input-group input-group-lg" style="position: relative;left: 40px;width: 300px;top: 65px;">
		  <span class="input-group-addon" id="sizing-addon1">确认密码</span>
		  <input type="password" id="password1" name="password1" class="form-control" placeholder="请确认你的密码" aria-describedby="sizing-addon1">
		</div>
		<div style="position: relative;left:100px;top:90px;">
			<button id="submitBtn" type="submit" onclick="return loginSubmit()" class="btn btn-success" style="width: 180px;height: 40px;"><font size="5px;">
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>注册</font></button>
		</div>
	</div>
	</div>
	</div>
	</div>
</body>
</html>