<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/workflow/head.jsp"%>
<title>贷款申请任务办理</title>
	<script type="text/javascript">
        function checkGuarantee(){
            var cusId = ${loan.customerId};
            $.ajax({
                url:"${pageContext.request.contextPath}/admin/application/findGuarantee.do",
                type:"post",
                data: {"id":cusId},
                success:function(data){
                    var data = eval('(' + data + ')');
                    $("#idCardFront").attr('src',("/"+data.frontPath));
                    $("#idCardBack").attr('src',("/"+data.backPath));
                    switch(parseInt(data.guaType)){
                        case 1:
                            $("#guaType").html("收入证明");
                            break;
                        case 2:
                            $("#guaType").html("房产证");
                            break;
                        case 3:
                            $("#guaType").html("工资条");
                            break;
                        default:
                            break;
                    }

                    $("#guaPath").attr('src',("/"+data.guaPath));
                }
            });
        }
	</script>
</head>
<body>
	<div class="container" id="LG">
		<div class="row">
			<div class="span12">
				<ul class="breadcrumb">
					<li>导航</li>
					<li>
						<a href="javascript:void(0)" onclick="listTask()">任务管理</a>
					</li>
				</ul>
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<h2 class="breadcrumb">贷款申请的任务办理</h2>
				<div class="table-responsive">
					<form action="${ctx}/admin/workflow/subTask.do" method="POST">
						<table class="table table-condensed table-striped table-bordered" >
							<tbody>
							<tr>
								<td hidden="true" >任务ID</td>
								<td>
									<input type="hidden" id="taskId" name="taskId" value="${taskId}" />
								</td>
							</tr>
							<tr>
								<td align="right">编号：</td>
								<td><input id="id" name="id" type="text"
										   value="${loan.id }" readonly></td>
							</tr>
							<tr>
								<td align="right">申请人:</td>
								<td><input id="nam" name="name" type="text"
									value="${name}" readonly></td>
							</tr>
							<tr>
								<td align="right">贷款金额:</td>
								<td><input id="money" name="money" type="text"
									value="${loan.money}" readonly></td>
							</tr>

							<tr>
								<td align="right">贷款期限:</td>
								<td><input id="loanMonth" name="loanMonth" type="text"
										   value="${loan.loanMonth}" readonly></td>
							</tr>

							<tr>
								<td align="right">年利率:</td>
								<td><input id="rate" name="rate" type="text"
										   value="${loan.rate}" readonly>%</td>
							</tr>

							<tr>
								<td align="right">还款方式:</td>
								<td><input id="repayWay" name="repayWay" type="text"
									value="" readonly></td>
								<script type="text/javascript">
                                    var val = ${loan.repayWay};
                                    switch(val){
                                        case 1:
                                            val =  "按月付息，到期还本";
                                            break;
                                        case 2:
                                            val =  "连本带息，到期一次还";
                                            break;
                                    }
                                    $("#repayWay").val(val);
								</script>
							</tr>
							<tr>
								<td align="right">贷款担保：</td>
								<td>
									<input type="button" value="查看" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#GuaranteeModal" onclick="checkGuarantee()" />
								</td>
							</tr>
							<tr>
								<td align="right">审批: </td>
								<td>
									<select id='approvalStatue' name='approvalStatue' style="width: 130px">
										<option disabled selected style='display:none;'>待审批</option>
										<option value="2">通过</option>
										<option value="1">待审批</option>
										<option value="3">不通过</option>
									</select>
								</td>
							</tr>

							<tr>
								<td align="right">审批备注: </td>
								<td>
									<textarea id="reason" name="reason" maxlength="500" rows="6" cols="40" ></textarea>
								</td>
							</tr>
							<tr>
								<button class="btn btn-primary" type="submit" name="outcome" value="提交审批">提交审批</button>
							</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>

		<!-- 模态框（Modal） -->
		<div class="modal fade" id="GuaranteeModal" tabindex="-1" role="dialog" aria-labelledby="GuaModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="GuaModalLabel">
							用户贷款担保资料
						</h4>
					</div>
					<div class="modal-body">
						<table cellspacing="8px">
							<tr>
								<td>
									<span class = "fontOnImg" >身份证正面</span>
									<img  id="idCardFront" alt="身份证正面" class="img-rounded" width="200px" height="200px">
								</td>
								<td>
									<span class = "fontOnImg" >身份证背面</span>
									<img  id="idCardBack" alt="身份证背面" class="img-rounded" width="200px" height="200px">
								</td>
							</tr>
							<tr>
								<td style="padding-top: 20px;" >
									<span id="guaType" class="fontOnImg"></span>
									<img  id="guaPath" alt="担保资料" class="img-rounded" width="200px" height="200px">
								</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>

		<br>
		<div class="row">
			<div class="span12">
				<c:choose>
					<c:when test="${commentList!=null && commentList.size()>0 }">

						<div class="table-responsive">
							<table class="table table-condensed table-striped table-bordered">
								<thead class="bg-primary">
									<tr>
										<th>时间</th>
										<th>批注人</th>
										<th>批注信息</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${commentList}" var="dep">
										<tr>

											<td><fmt:formatDate value="${dep.time }" type="both"
													pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td>${dep.userId }</td>
											<td>${dep.fullMessage }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>

					</c:when>
					<c:otherwise>
		暂时没有批注信息
		</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
	<script src="${ctx }/static/js/modules/oa.js"></script>
</body>
</html>