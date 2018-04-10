<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>闲钱贷-p2p理财平台</title>
</head>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<script type="text/javascript">
$(function(){
	if($("#setActivePersonTemp").val() == 1){
		$("#grzy").addClass('activePerson');
	}else if($("#setActivePersonTemp").val() == 2){
		$("#grzl").addClass('activePerson');
	}else if($("#setActivePersonTemp").val() == 3){
		$("#mmsz").addClass('activePerson');
	}else if($("#setActivePersonTemp").val() == 4){
		$("#xyzz").addClass('activePerson');
	}
})
</script>
<body>
	
	<div class="container">
		<ul class="nav nav-tabs">
		  <li id="grzy" role="presentation"><a href="${pageContext.request.contextPath}/user/customer/index.html">个人账户</a></li>
		  <li id="grzl" role="presentation"><a href="${pageContext.request.contextPath}/user/customer/personinfo.html">个人资料</a></li>
		  <li id="mmsz" role="presentation"><a href="${pageContext.request.contextPath}/user/customer/personpwd.html">密码设置</a></li>
		  <li id="xyzz" role="presentation"><a href="${pageContext.request.contextPath}/user/customer/personcredit.html">信用资质</a></li>
		</ul>
	</div>
	<input type="hidden" id="setActivePersonTemp" value="${mainPersonIndex }">
</body>
</html>