<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>闲钱贷-p2p理财平台</title>
	<link href="/favicon0.ico" rel="SHORTCUT ICON">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap3/js/layer.js"></script>

	<style>
		.cal-tabs {
			border-bottom: 1px solid #dfdfdf;
			position: absolute;
			right: 0;
			top: -4px;
		}

		.calc-title {
			font-size: 20px;
			line-height: 28px;
		}

		.calc-tab.active {
			border-bottom: 2px solid #fc6700;
			color: #fc6700;
			line-height: 40px;
		}

		.calc-tab {
			cursor: pointer;
			display: inline-block;
			font-size: 16px;
			height: 42px;
			line-height: 42px;
			text-align: center;
		}

		.p-0 {
			padding: 0 !important;
		}

		.mt-15 {
			margin-top: 15px !important;
		}

		.mt-10 {
			margin-top: 10px !important;
		}

		.rel {
			position: relative;
		}

		.form-control {
			box-shadow: none;
		}

		.calc-addon {
			background: rgba(0, 0, 0, 0) none repeat scroll 0 center;
		}

		.carl-record {
			font-size: 14px;
		}

		.carl-record {
			font-size: 14px;
		}

		.calc-label {
			font-size: 14px;
			line-height: 34px;
			text-align: right;
		}

		.spanfont {
			color: #666666;
			font-family: "微软雅黑";
			font-size: 14px;
		}

		.spanje {
			color: #ff6b00;
			font-size: 24px;
		}

		.reset {
			background: #666 none repeat scroll 0 0;
			border: 0 none;
			border-radius: 3px;
			box-sizing: border-box;
			color: #fff;
			cursor: pointer;
			display: inline-block;
			font-family: "微软雅黑";
			font-size: 14px;
			height: 30px;
			line-height: 30px;
			margin-top: 30px;
			outline: 0 none;
			text-align: center;
			width: 90px;
		}

		.sub {
			background: #53a0e3 none repeat scroll 0 0;
			border: 0 none;
			border-radius: 3px;
			box-sizing: border-box;
			color: #fff;
			cursor: pointer;
			display: inline-block;
			font-family: "微软雅黑";
			font-size: 14px;
			height: 30px;
			line-height: 30px;
			margin-top: 30px;
			outline: 0 none;
			text-align: center;
			width: 90px;
		}
	</style>
	<script type="text/javascript">
		function save() {
			var type = $("#type").val();
			if (type == 0){
			    alert("请选择合适的类型");
			}
            var url  = "${pageContext.request.contextPath}/user/loan/applyLoan.do?id="+type;
            location.href=url;
        }
	</script>
</head>
<div class="row">
	<jsp:include page="/common/daohang.jsp"></jsp:include>
	<jsp:include page="/common/daohangLoan.jsp"></jsp:include>
	<div class="container">
		<div class="jumbotron">
			<h2 class="threed" align="center">请根据个人需求，选择贷款类型，利率不同</h2>
			<hr>

			<select name="directorName" style="width: 200px;" class="form-control" id="type">
				<c:forEach items="${rateList}" var="v">
					<option value="${v.id}" >${v.monthType} 利率：${v.rate}</option>
				</c:forEach>
				<option value="0" selected="selected" >请选择</option>
			</select>
			<br>
			<a class="btn btn-success" style="width:200px" id="selsubmit" href="javascript:save()">
				提交
			</a>
		</div>
	</div>
</div>


<jsp:include page="/common/bottom.jsp"></jsp:include>
</html>