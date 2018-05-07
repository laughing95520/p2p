<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%--<%@ include file="/WEB-INF/views/include/head.jsp"%>--%>
<title>Bootstrap 101 Template</title>
	<%@ include file="head.jsp"%>
</head>
<body>
	<div class="container" id="LG">
		<%--<%@ include  file="/WEB-INF/views/include/top.jsp"%>--%>
		<div class="row">
			<div class="span12">
				<ul class="breadcrumb">
					<li>导航：</li>
					<li><a href="javascript:void(0)" onclick="showWorkflow()">部署流程列表</a>
					</li>
					<li><a href="javascript:void(0)" onclick="add()">新增部署流程</a>
					</li>
				</ul>

				<div class="table-responsive">
					<form action="${pageContext.request.contextPath}/admin/workflow/newdeploy.do" enctype="multipart/form-data"
						method="post">
						<table class="table table-condensed table-striped table-bordered">
							<thead class="bg-primary">
								<tr align="center">
									<th colspan="2">部署流程定义</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td align="right">流程文件:</td>
									<td><input id="file" name="file" type="file"></td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<button type="submit" class="btn btn-info" id="submitBtn"
											name="submitBtn">上传流程</button>
										<button type="reset" class="btn btn-primary">重置</button>

									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
		</div>
		<script src="${pageContext.request.contextPath}/static/js/modules/oa.js"></script>
</body>
</html>