<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>闲钱贷-p2p理财平台</title>
</head>
<body>

	<jsp:include page="/common/daohang.jsp"></jsp:include>
	
	<jsp:include page="/common/daohangUserMain.jsp"></jsp:include>
	<hr>
	
	<div class="container">
		<div class="jumbotron">
			<div align="center">我的信用资质</div>
			<hr>
			<br><br>
			<div class="row">
				<div class="col-md-4 c"></div>
				<div class="col-md-6 c">
					<p class="lead">尊敬的${customerUser.name}：</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5 c"></div>
				<div class="col-md-6 c">
					<p class="lead">您的信用值${credit }，非常感谢您的支持！</p>
				</div>
			</div>
		</div>
		
			<h1 class="text-hide">Custom heading</h1>
			
	</div>
	
	<jsp:include page="/common/bottom.jsp"></jsp:include>

</body>
</html>