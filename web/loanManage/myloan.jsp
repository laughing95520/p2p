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
							<p class="loanState" id="${myloan.id}">
								<script type="text/javascript">
                                    var myStates = new Array();
                                    myStates[1]="待审核";
                                    myStates[2]="已放款";
                                    myStates[3]="未通过";
                                    if( parseInt(${myloan.state})==3) {
                                        $('#${myloan.id}').html("未通过");
                                        var mystr = "${myloan.words}";
                                        var end = mystr.indexOf("审核人");
                                        var res  = mystr.substring(0,end);
                                        $('#${myloan.id}').after(res);
									}
									else
									$('#${myloan.id}').html(myStates[${myloan.state}]);
								</script>
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