<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员信息</title>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
	var url;
	
	function formatStatus(val,row){
		if(val == 0){
			return '超级管理员';
		}else if(val == 1){
			return '普通管理员';
		}else{
			return '财务管理员';
		}
	}
	
	function add(){
		$('#dlg').dialog('open').dialog('setTitle','添加管理员信息');
		url='${pageContext.request.contextPath}/admin/save.do';
	}
	
	function edit(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一个要修改的管理员！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","修改管理员信息");
		$("#fm").form('load',row);
		url="${pageContext.request.contextPath}/admin/save.do?id="+row.id;
	}
	
	function save(){
		$("#fm").form('submit',{
			url:url,
			onSubmit:function(){
				return $(this).form('validate');
			},
			success:function(data){
				var data = eval('(' + data + ')'); 
				if (data.success){
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		})
	}
	

	function del(){
		var selections = $("#dg").datagrid("getSelections");
		if(selections.length == 0){
			$.messager.alert('系统提示', '请选择要删除的数据!');
			return;
		}
		$.messager.confirm('系统提示',"您确定要删除这<font color='red'>"+selections.length+'</font>条数据吗?',function(r){
			if(r){
				var strIds = [];
				for(var i=0; i < selections.length; i++){
					strIds.push(selections[i].id);
				}
				var ids = strIds.join(',');
				$.post("${pageContext.request.contextPath}/admin/delete.do",{"ids":ids},function(result){
					if(result.success){
						$.messager.alert('系统提示', '删除成功!');
						$("#dg").datagrid("reload");
					}
				},'json');
				$("#dg").datagrid("reload");
			}
			
		});
	}
	
	function close(){
		$('#dlg').dialog('close');
		resetValue();
	}
	
	function resetValue(){
		$("#name").val('');
		$("#jobNum").val('');
		$("#statue").val('0');
		$("#pasword").val('');
	}
	
</script>
</head>
<body style="margin: 1px">
	<table class="easyui-datagrid" title="管理员信息"
		id="dg"
    	url='${pageContext.request.contextPath}/admin/list.do'
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
			<th field='name' width=100px align="center">用户名</th>
			<th field='jobNum' width=50px align="center">工号</th>
			<th field='statue' width=50px align="center" formatter="formatStatus">管理员级别</th>
		</tr>
    </thead>
	</table>
		<div id="tb">
			<div>
				&nbsp;<a href="javascript:edit()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">修改</a>
				&nbsp;<a href="javascript:add()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
				&nbsp;<a href="javascript:del()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'">删除</a>
			</div>
		</div>
	
	<div id="dlg" class="easyui-dialog" data-options="iconCls:'icon-save',buttons:'#dlg-buttons'" style="width: 420px;height: 230px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<tr>
					<td>用户名:</td>
					<td>
						<input type="text" id="name" name="name" class="easyui-validatebox" required='true'/>
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td>
						<input type="text" id="pwd" name="pwd" class="easyui-validatebox" required='true'/>
					</td>
				</tr>
				<tr>
					<td>工号:</td>
					<td>
						<input type="text" id="jobNum" name="jobNum" class="easyui-numberbox" required='true'/>
					</td>
				</tr>
				<tr>
					<td>管理员级别:</td>
					<td>
						<select id='statue' name='statue' style="width: 130px">
							<option disabled selected style='display:none;'>请选择管理员级别</option>
							<option value="0">超级管理员</option>
							<option value="1">普通管理员</option>
							<option value="2">财务管理员</option>
						</select>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:save()" class="easyui-linkbutton">保存</a>
		<a href="javascript:close()" class="easyui-linkbutton">取消</a>
	</div>
	
</body>
</html>