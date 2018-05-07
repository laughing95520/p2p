<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="head.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>部署管理</title>

</head>
<body>
	<div class="container" id="LG">
		<div class="row">
			<div class="span12">
				<ul class="breadcrumb">
					<li>导航：</li>
					<li><a href="javascript:void(0)" onclick="showWorkflow()">部署流程列表</a>
					</li>
					<li><a href="javascript:void(0)" onclick="add()">新增部署流程</a>
					</li>
				</ul>

				<h2 class="breadcrumb">部署信息管理列表</h2>
				<br>
				<div class="table-responsive">
					<table class="table table-condensed table-striped table-bordered">
						<thead class="bg-primary">
							<tr>
								<th>#ID</th>
								<th>流程名称</th>
								<th>发布时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${depList}" var="dep">
								<tr>
									<td>
										<div class="checkbox">
											<label> <input type="checkbox" id="ids" name="ids"
												value="${dep.id }">${dep.id }
											</label>
										</div>
									</td>
									<td>${dep.name }</td>
									<td>
									<fmt:formatDate value="${dep.deploymentTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td><a href="javascript:void(0)" onclick="delDeployment('${dep.id }')">删除</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="4" align="right"></td>
							</tr>
						</tbody>
					</table>

				</div>

				<div class="table-responsive">
				<h2 class="breadcrumb">流程定义信息列表</h2>
					<table class="table table-condensed table-striped table-bordered">
						<thead class="bg-primary">
							<tr>
								<th>#ID</th>
								<th>名称</th>
								<th>流程定义的KEY</th>
								<th>流程定义的版本</th>
								<th>流程定义的规则文件名称</th>
								<th>流程定义的规则图片名称</th>
								<th>部署ID</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pdList}" var="pd">
								<tr>
									<td>
										<div class="checkbox">
											<label> <input type="checkbox" id="ids" name="ids"
												value="${pd.id }">${pd.id }
											</label>
										</div>
									</td>
									<td>${pd.name }</td>
									<td>${pd.key }</td>
									<td>${pd.version }</td>
									<td>${pd.resourceName }</td>
									<td>${pd.diagramResourceName }</td>
									<td>${pd.deploymentId }</td>
									<td><a  target="_blank"  href="javascript:void(0)" onclick="viewImage('${pd.deploymentId }','${pd.diagramResourceName }')">查看流程图</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		</div>
		<script src="${ctx }/static/js/modules/oa.js"></script>
</body>
</html>