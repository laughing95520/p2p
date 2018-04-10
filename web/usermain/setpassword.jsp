<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>闲钱贷-p2p理财平台</title>
<!-- bootstarp3 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/main.css">

<!-- jquery -->
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>

<link href="/favicon0.ico" rel="SHORTCUT ICON">
<script type="text/javascript">
	function submitPwd(){
		var pwd = $("#pwd").val();
		var newpwd = $("#newpwd").val();
		var newpwd2 = $("#newpwd2").val();
		$.post("${pageContext.request.contextPath}/user/customer/personsetpwd.html",{pwd:pwd,newpwd:newpwd,newpwd2:newpwd2},function(data){
			var data = eval('(' + data + ')'); 
			if (data.success){
				alert(data.info);
				$("#pwd").val('');
				$("#newpwd").val('');
				$("#newpwd2").val('');
			}
		});
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="/common/daohang.jsp"></jsp:include>
		
		<jsp:include page="/common/daohangUserMain.jsp"></jsp:include>
		
		<hr>
		<div class="jumbotron">
			<div><font size="8px;">登录密码修改</font></div>
			<hr>
			<div class="row">
				<div class="col-md-4  col-md-offset-4" align="left">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">原密码　</span>
					  	<input type="password" class="form-control" aria-describedby="basic-addon1" name='pwd' value="" id='pwd'>
					</div>
					<hr>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">新密码　</span>
					  	<input type="password" class="form-control" aria-describedby="basic-addon1" name='newpwd' value="" id='newpwd'>
					</div>
					<hr>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">确认密码</span>
				  		<input type="password" class="form-control" aria-describedby="basic-addon1" name='newpwd2' value="" id='newpwd2'>
					</div>
					<hr>
					<div class="col-md-4  col-md-offset-4">
						<div class="input-group">
							<button class="btn btn-success btn-lg" id='mmxg' onclick="submitPwd()">提交</button>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	
	<jsp:include page="/common/bottom.jsp"></jsp:include>
</body>
</html>