<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>闲钱贷-p2p理财平台</title>
<!-- bootstarp3 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-datetimepicker.css">

<!-- icon -->
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<!-- jquery -->
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.fr"></script>

<script type="text/javascript">
$(function(){
	if($("#setActiveMainTemp").val() == 1){
		$("#sy").addClass('activeMainTemp');
	}else if($("#setActiveMainTemp").val() == 2){
		$("#yhzy").addClass('activeMainTemp');
	}else if($("#setActiveMainTemp").val() == 3){
		$("#dkgl").addClass('activeMainTemp');
	}else if($("#setActiveMainTemp").val() == 4){
		$("#wdgl").addClass('activeMainTemp');
	}
})
</script>
</head>
<body>
	<div class="container">
		<div class="row">
		  <div class="col-md-9">
		  	<iframe width="700" scrolling="no" height="70" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=2&bgc=%23&bdc=%23&icon=5&num=3"></iframe>
		  </div>
		  <div class="col-md-3">
			  <div class="row">
			  	  <div class="col-md-8" style="position: relative;top: 15px;">
				  	  <c:if test="${customerUser != null }">
				  	  	<font size="4px">欢迎您:${customerUser.name }</font>
				  	  </c:if>
			  	  </div>
				  <div class="col-md-2">
				  	<c:if test="${customerUser == null }">
					  	<a href="${pageContext.request.contextPath}/login.jsp" target="_blank" style="text-decoration: none;"><button type="button" class="btn btn-link btn-lg"><font id="setActive" size="4px">登录  </font></button></a>
				  	</c:if>
				  	<c:if test="${customerUser != null }">
					  	<a href="${pageContext.request.contextPath}/user/customer/loginout.html" target="_blank"><button type="button" class="btn btn-link btn-lg"><font size="4px">退出  </font></button></a>
				  	</c:if>
				  </div>
				  <div class="col-md-2">
				  	<a href="${pageContext.request.contextPath}/register.jsp" target="_blank"><button type="button" class="btn btn-link btn-lg"><font size="4px">注册</font></button></a>
				  </div>
		  	  </div>
		  </div>
		</div>
	 	
	 	<div class="row">
	  	   <div class="col-md-12" style="padding: 10px;">
			 <nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header nav">
			      <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html"><font id="sy">首页</font> </a>
			    </div>
			    <div class="navbar-header">
			      <a class="navbar-brand" href="${pageContext.request.contextPath}/user/customer/index.html"><font id="yhzy">用户主页</font> </a>
			    </div>
			    <div class="navbar-header">
			      <a class="navbar-brand" href="${pageContext.request.contextPath}/user/loan/myloan.html"><font id="dkgl">贷款管理 </font></a>
			    </div>
			    <%-- <div class="navbar-header">
			      <a class="navbar-brand" href="${pageContext.request.contextPath}/user/qa/index.html"><font id="wdgl">问答管理</font></a>
			    </div> --%>
			  </div>
			</nav>
		   </div>
	 	</div>
		</div>
		<input type="hidden" id="setActiveMainTemp" value="${mainTempIndex }">
	</body>
</html>

