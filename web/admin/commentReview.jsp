<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客管理</title>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function formatBlogTitle(val,row){
		return "<a target='_blank' href='${pageContext.request.contextPath}/blog/articles/"+val.id+".html'>"+val.title+"</a>";
	}
	
	function formatBlogger(val,row){
		return val.userName;
	}
	
	function commentReview(state){
		var selections = $("#dg").datagrid("getSelections");
		if(selections.length == 0){
			$.messager.alert('系统提示', '请选择要审核的数据!');
			return;
		}
		$.messager.confirm('系统提示',"您确定要审核这<font color='red'>"+selections.length+'</font>条评论吗?',function(r){
			if(r){
				var strIds = [];
				for(var i=0; i < selections.length; i++){
					strIds.push(selections[i].id);
				}
				var ids = strIds.join(',');
				$.post("${pageContext.request.contextPath}/admin/comment/review.do",{"ids":ids,"state":state},function(result){
					if(result.success){
						$.messager.alert('系统提示', '审核成功!');
						$("#dg").datagrid("reload");
					}
				},'json');
				$("#dg").datagrid("reload");
			}
			
		});
	}
</script>
</head>
<body style="margin: 1px">
	<table class="easyui-datagrid" title="评论审核管理"
		id="dg"
    	url='${pageContext.request.contextPath}/admin/comment/list.do?state=0'
    	pagination=true
		rownumbers=true
		fitColumns=true
		toolbar="#tb"
		fit=true
		>
		<thead>
		<tr>
			<th field='cb' checkbox=true></th>
			<th field='id' width=20px align="center">编号</th>
			<th field='blog' width=200px align="center" formatter="formatBlogTitle">博客标题</th>
			<th field='blogger' width=50px align="center" formatter="formatBlogger">用户名</th>
			<th field='content' width=200px align="center">评论内容</th>
			<th field='commentDate' width=50px align="center">评论日期</th>
		</tr>
    </thead>
	</table>
	<div id="tb">
		<div>
			&nbsp;<a href="javascript:commentReview(1)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">审核通过</a>
			&nbsp;<a href="javascript:commentReview(2)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-no'">审核不通过</a>
		</div>
	</div>
</body>
</html>