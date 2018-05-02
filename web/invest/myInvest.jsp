<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<title>闲钱贷-p2p理财平台</title>

</head>
<body>
	<jsp:include page="/common/daohang.jsp"></jsp:include>
	
	<jsp:include page="/common/daohangLoan.jsp"></jsp:include>

	<hr>
	
	<div class="container">
		<div class="jumbotron">
			<div align="center">投资列表</div>
			<hr>
			<table class="table table-bordered table-hover">
				<tr>
					<th style='vertical-align: middle;text-align: center;'><p>投资基金名字</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>基金收益利率</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>投资金额</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>收益金额</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>收益时间</p></th>
				</tr>
				<c:forEach items="${invests}" var="myInvest">
					<tr>
						<td style='vertical-align: middle;text-align: center;'>
							<p>
								${myInvest.title }
							</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>
								<fmt:formatNumber  value="${myInvest.rate}" type="number" pattern="0.00" />%
							</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>
							<fmt:formatNumber  value="${myInvest.investMoney}" type="number" pattern="0.00" />
							</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>
								<fmt:formatNumber  value="${myInvest.income}" type="number" pattern="0.00" />
							</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>
							<fmt:formatDate value="${myInvest.incomeDate }" pattern="yyyy-MM-dd" />
							</p>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
	
	<jsp:include page="/common/bottom.jsp"></jsp:include>
</body>
</html>