<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap3/css/jquery.min.js"></script>
<script type="text/javascript">

        function edit(id,repayMoneyNow,residueMoney){
            $("#repayId").val(id);
            $("#repay").empty();
            $("#repay").append("<option value=''>请选择还款余额</option>");
            if (repayMoneyNow != residueMoney){
                $("#repay").append("<option value='1'>"+"本期应还："+repayMoneyNow.toFixed(2)+"</option>");
            }
            $("#repay").append("<option value='2'>"+"全部待还"+residueMoney.toFixed(2)+"</option>");
        }

        function empty(){
            $("#repay").empty();
            $("#repayId").val();
        }

        function save(){
            var choice = $("#repay").val();
            if (choice == ''){
                alert("请选择");
                return false;
			}
            var id = $("#repayId").val();
            var url = "${pageContext.request.contextPath}/user/loan/repay.html";
            $.ajax({
                url: url,
                data: {id:id,choice:choice},
                success: function(data){
                    if(data.success){
                        alert("success");
                        location.href="${pageContext.request.contextPath}/user/loan/list.html";
					}else {
                        if(data.message != null){
                            alert(data.message);
						}else {
                            alert("操作失败！请重试！");
                        }
                        $("#myModal").modal('hide');
                    }
				},
                dataType: "json"
            });
            $("#repayId").val();
        }


	</script>
<title>闲钱贷-p2p理财平台</title>

</head>
<body>
	<jsp:include page="/common/daohang.jsp"></jsp:include>

	<jsp:include page="/common/daohangLoan.jsp"></jsp:include>


	<div class="container">
		<div class="jumbotron" style="background-color:white;padding: 0px">
			<div align="center">还款列表</div>
			<hr>
			<table class="table table-striped table-hover">
				<tr>
					<th hidden="true">编号</th>
					<th hidden="true">贷款编号</th>
					<th style='vertical-align: middle;text-align: center;'>贷款总金额</th>
					<th style='vertical-align: middle;text-align: center;'>放贷日期</th>
					<th style='vertical-align: middle;text-align: center;'>贷款月数</th>
					<th style='vertical-align: middle;text-align: center;'>贷款利率</th>
					<th style='vertical-align: middle;text-align: center;'>需还款总金额</th>
					<th style='vertical-align: middle;text-align: center;'>剩余还款金额</th>
					<th style='vertical-align: middle;text-align: center;'>还款方式</th>
					<th style='vertical-align: middle;text-align: center;'>本期应还余额</th>
					<th style='vertical-align: middle;text-align: center;'>已还款期数</th>
					<th style='vertical-align: middle;text-align: center;'>还款</th>
				</tr>
				<c:forEach items="${resultList}" var="repay">
					<tr>
						<td hidden="true"><p>${repay.id}</p></td>
						<td hidden="true"><p>${repay.loanId}</p></td>
						<td style='vertical-align: middle;text-align: center;'>
							<p><fmt:formatNumber  value="${repay.loanMoney}" type="number" pattern="0.00" />元</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p><fmt:formatDate  value="${repay.lendTime}" pattern="yyyy-MM-dd" /></p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>${repay.loanMonth}月</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p><fmt:formatNumber value="${repay.rate }" type="number" pattern="0.00" />%</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p><fmt:formatNumber value="${repay.payMoney}" type="number" pattern="0.00" /></p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p><fmt:formatNumber value="${repay.residueMoney}" type="number" pattern="0.00" /></p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p class="loanState" id="${repay.id}">
								<script type="text/javascript">
                                    var myStates = new Array();
                                    myStates[1]="按月付息，到期还本";
                                    myStates[2]="连本带息，到期一次还";
									$('#${repay.id}').html(myStates[${repay.payMethod}]);
								</script>
							</p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p><fmt:formatNumber value="${repay.repayMoneyNow}" type="number" pattern="0.00" /></p>
						</td>
						<td style='vertical-align: middle;text-align: center;'>
							<p>${repay.repayPeriods}</p>
						</td>
						<td>
							<button onclick="edit(${repay.id},${repay.repayMoneyNow},${repay.residueMoney})" type="button"
									class="btn btn-default" data-toggle="modal" data-target="#myModal">
								<span class="glyphicon glyphicon-usd"></span>
							</button>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>


	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" backdrop="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						还款
					</h4>
				</div>
				<div class="modal-body">
					<input type="text" id="repayId" hidden="true"/>
					<select id='repay' name='repay'>
					</select>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" onclick="empty()">
						关闭
					</button>
					<button type="button" class="btn btn-primary" onclick="save()">
						确认还款
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>

	<jsp:include page="/common/bottom.jsp"></jsp:include>
</body>
</html>