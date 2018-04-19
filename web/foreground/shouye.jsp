<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<div class="row" style="height: 100%">
  <div class="col-md-12">
  	<div class="data_list">
		<div class="jumbotron">
		  <h1 class="threed">理财大厅、闲钱投资</h1>
		</div>
		<div>
			<table class="table table-bordered table-hover">
				<tr>
					<th style='vertical-align: middle;text-align: center;'><p>项目名字</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>项目期待年利率</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>最低金额</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>项目周期(单位:月)</p></th>
					<th style='vertical-align: middle;text-align: center;'><p>操作</p></th>
				</tr>
				<c:forEach items="${productList}" var="prodItem">
					<tr>

						<td style='vertical-align: middle;text-align: center;'>
							<p>${prodItem.title}</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>
							<fmt:formatNumber  value="${prodItem.rate}" type="number" pattern="0.00" />%
							</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>${prodItem.lowestMoney}元</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>${prodItem.timeline}</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>
								<%--<a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/user/loan/loan.html?id=${prodItem.id}" role="button">
									我要投资
								</a>--%>
								我要投资
							</p>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
  </div>
</div>








