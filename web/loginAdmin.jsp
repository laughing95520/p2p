<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>闲钱贷-p2p理财平台</title>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<link href="/loginlib/login.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>

     
<SCRIPT type="text/javascript">
$(function(){
	//得到焦点
	$("#pwd").focus(function(){
		$("#left_hand").animate({
			left: "150",
			top: " -38"
		},{step: function(){
			if(parseInt($("#left_hand").css("left"))>140){
				$("#left_hand").attr("class","left_hand");
			}
		}}, 2000);
		$("#right_hand").animate({
			right: "-64",
			top: "-38px"
		},{step: function(){
			if(parseInt($("#right_hand").css("right"))> -70){
				$("#right_hand").attr("class","right_hand");
			}
		}}, 2000);
	});
	//失去焦点
	$("#pwd").blur(function(){
		$("#left_hand").attr("class","initial_left_hand");
		$("#left_hand").attr("style","left:100px;top:-12px;");
		$("#right_hand").attr("class","initial_right_hand");
		$("#right_hand").attr("style","right:-112px;top:-12px");
	});
});

function checkForm(){
	var name=$("#name").val();
	var pwd=$("#pwd").val();
	if(name==null || name==""){
		$("#error").html("用户名不能为空！");
		return false;
	}
	if(pwd==null||pwd==""){
		$("#error").html("密码不能为空！");
		return false;
	}
	return true;
}
</SCRIPT>
</head>
<body>

<div class="login_box">
	<div class="login_l_img"><img src="/loginlib/images/login-img.png"/></div>
	<div class="login">
		<div class="login_logo"><a href="#"><img src="/loginlib/images/login_logo.png"/></a></div>
		<div class="login_name">
			<p>理财平台管理系统</p>
		</div>
		<form action="${pageContext.request.contextPath}/loginAdmin.do" method="post" onsubmit="return checkForm()">
			<input id="name" name="name" class="ipt" type="text" placeholder="请输入用户名" value="${admin.name }">
			<INPUT id="pwd" name="pwd" class="ipt"  type="password" placeholder="请输入密码" value="${admin.pwd }">
            <span><font color="red" id="error">${errorInfo }</font></span>
			<input value="登录" style="width:100%;" type="submit">
		</form>
	</div>

</div>


</body>
</html>