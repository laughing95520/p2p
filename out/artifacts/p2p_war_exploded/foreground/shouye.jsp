<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<div class="row" style="height: 100%">
  <div class="col-md-12">
  	<div class="data_list">
		<div class="jumbotron">
		  <h1 class="threed">贷款项目</h1>
		</div>
		<div>
			<table class="table table-bordered table-hover">
				<tr>
					<th style='vertical-align: middle;text-align: center;'><p>贷款额度</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>贷款年利率</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>逾期年利率</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>贷款期限</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>操作</p></th>
				</tr>
				<c:forEach items="${loanItemsList}" var="loanItem">
					<tr>
						<td style='vertical-align: middle;text-align: center;'><p>${loanItem.moneyDown }元-${loanItem.moneyUp }元</p></td>
						<td style='vertical-align: middle;text-align: center;'><p><fmt:formatNumber  value="${loanItem.rate}" type="number" pattern="0.00%" /><fmt:formatNumber  value="${myloan.interestRate }" type="number" pattern="0.00%" /></p></td>
						<td style='vertical-align: middle;text-align: center;'><p><fmt:formatNumber  value="${loanItem.overRate}" type="number" pattern="0.00%" /><fmt:formatNumber  value="${myloan.interestRate }" type="number" pattern="0.00%" /></p></td>
						<td style='vertical-align: middle;text-align: center;'><p>${loanItem.dayDown }月-${loanItem.dayUp }月</p></td>
						<td style='vertical-align: middle;text-align: center;'><p><a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/user/loan/loan.html?id=${loanItem.id}" role="button">我要贷款</a></p></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
  </div>
</div>








