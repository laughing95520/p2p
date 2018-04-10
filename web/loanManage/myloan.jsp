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
			<div align="center">贷款列表</div>
			<hr>
			<table class="table table-bordered table-hover">
				<tr>
					<th style='vertical-align: middle;text-align: center;'><p>贷款金额</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>年利率</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>贷款期限</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>申请时间</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>贷款状态</p></th>
				</tr>
				<c:forEach items="${loanList}" var="myloan">
					<tr>
						<td style='vertical-align: middle;text-align: center;'><p>${myloan.money }元</p></td>
						<td style='vertical-align: middle;text-align: center;'><p><fmt:formatNumber  value="${myloan.rate}" type="number" pattern="0.00" />%</p></td>
						<td style='vertical-align: middle;text-align: center;'><p>${myloan.loanMonth }月</p></td>
						<td style='vertical-align: middle;text-align: center;'><p><fmt:formatDate value="${myloan.loanTime }" pattern="yyyy-MM-dd" /> </p></td>
						<td style='vertical-align: middle;text-align: center;'>
							<p class="loanState"></p>
								<script type="text/javascript">
								switch(parseInt(${myloan.state})){
									case 1:
									    $('.loanState').html("待审核");
										break;
									case 2:
                                        $('.loanState').html("已放款");
									    break;
									case 3:
                                        $('.loanState').html("未通过");
									    break;
									default:
									    break;
								}
								</script>
						</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	</div>
	
	<jsp:include page="/common/bottom.jsp"></jsp:include>
</body>
</html>