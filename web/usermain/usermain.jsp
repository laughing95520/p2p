<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>闲钱贷-p2p理财平台</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/main.css">
<!-- icon -->
<link href="/favicon0.ico" rel="SHORTCUT ICON">
<!-- jquery -->
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<script type="text/javascript">
function idcard(obj){
	var formData = new FormData();
	var btnid = '#' + obj.id;
	var file = $(btnid).prev();
	var fileid = '#' + file.attr("id"); 
	var img = $(fileid).prev();
	var imgid = '#' + img.attr("id");
	formData.append("file",$(fileid)[0].files[0]);
	$.ajax({
        url:"${pageContext.request.contextPath}/user/customer/updatephoto.html",
        type:"post",
        data:formData,
        processData:false,
        contentType:false,
        success:function(data){
        	var data = eval('(' + data + ')'); 
			var src = "${pageContext.request.contextPath}/" + data.imagePath; 
			$(imgid).attr('src',src); 
        }
	}); 
}
</script>
</head>
<body>

	
		
	<jsp:include page="/common/daohang.jsp"></jsp:include>
	
	<jsp:include page="/common/daohangUserMain.jsp"></jsp:include>
	<hr>
	
	<div class="container">
		<div class="jumbotron">
			<div align="center"><font size="6px">个人账户详情</font></div>
			<hr>
			<div class="row">
			  <div class="col-md-8 c" style="padding-left: 80px; padding-top: 40px;">
			  	<br>
				<p>用户名　:&nbsp;&nbsp;${customer.name}</p>
				<br>
				<p>账户余额　:&nbsp;&nbsp;${customer.balance }</p>
				<br>
				<p>投资收益　:&nbsp;&nbsp;${customer.income }</p>
				<br>
				<p><a href="${pageContext.request.contextPath}/user/loan/myloan.html">贷款统计:</a>&nbsp;&nbsp;共${loanInfoMap['loanNum'] }条贷款记录</p>
			  </div>
			  <div class="col-md-4 c" style="padding-right: 100px">
					 <img src="${pageContext.request.contextPath}/${photo}" alt="个人照片" class="img-rounded" width="230px" height="260px" id='imggrzp'>
					 <input type="file" id='grzp'>
					 <button type="submit" class="btn btn-success btn" style="width: 200px" onclick="idcard(this)" id='grzptj'>提交</button>
			  </div>
			</div>
			<hr>
			<div class="row">
			  <div class="col-md-12 c"><p align="center">贷款统计</p></div>
			</div>
			<div class="row">
			  <div class="col-md-3 c"><p align="right">总借金额</p></div>
			  <div class="col-md-3 c"><p align="center">${loanInfoMap['allMoney'] }元</p></div>
			  <div class="col-md-3 c"><p align="left">成功借款次数</p></div>
			  <div class="col-md-3 c"><p align="left">${loanInfoMap['successNum'] }/${loanInfoMap['loanNum'] }</p></div>
			</div>
		</div>
		
	</div>

	<jsp:include page="/common/bottom.jsp"/>

</body>
</html>