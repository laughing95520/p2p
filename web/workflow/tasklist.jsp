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
    <title>任务管理</title>
    
  </head>
  <body>
  <div class="container" id="LG">

			<div class="row">
				<div class="span12">
				<ul class="breadcrumb">
				<li>导航</li>
				<li>
					<a href="javascript:void(0)" onclick="listTask()">首页</a>
				</li>
				<li>
					<a href="javascript:void(0)" onclick="listTask()">任务管理</a>
				</li>
				</ul>
					<h2 class="breadcrumb"> 
						个人任务管理列表
					</h2>
					<div class="table-responsive">
						<table class="table table-condensed table-striped table-bordered">
							<thead class="bg-primary">
								<tr>
									<th>
										任务ID
									</th>
									<th>
										任务名称
									</th>
									<th>
										创建时间
									</th>
									<th>
										办理人
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="task">
								<tr>
									<td>
										<div class="checkbox">
											<label>
												<input type="checkbox" id="ids" name="ids" value="${task.id }">${task.id }
											</label>
										</div>
									</td>
									<td>
										${task.name }
									</td>
									<td>
										<fmt:formatDate value="${task.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
			
									</td>
									<td>
										${task.assignee }
									</td>
									
									<td>
			 					<a href="javascript:void(0)" onclick="viewTaskForm('${task.id }')">办理任务</a>
			 					<a href="javascript:void(0)" onclick="viewCurrentImage('${task.id }')" >查看当前流程图</a>

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