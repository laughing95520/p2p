<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信用管理</title>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
var url;

function add(){
	$('#dlg').dialog('open').dialog('setTitle','添加贷款利率');
	url='${pageContext.request.contextPath}/admin/loanRate/save.do';
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
			}else{
                $.messager.alert("系统提示","保存出错");
            }
            resetValue();
            $("#dlg").dialog("close");
            $("#dg").datagrid("reload");
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
			$.post("${pageContext.request.contextPath}/admin/loanRate/del.do",{"ids":ids},function(result){
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
	$("#monthType").val('');
	$("#rate").val('');
}

function formatRate(val,row) {
	return val+"%";
}
</script>
</head>
<body style="margin: 1px">
	<table class="easyui-datagrid" title="贷款利率管理"
		id="dg"
    	url='${pageContext.request.contextPath}/admin/loanRate/list.do'
		rownumbers=true
		fitColumns=true
		toolbar="#tb"
		fit=true
		>
		<thead>
		<tr>
			<th field='cb' checkbox=true></th>
			<th field='id' width=20px align="center" hidden="true">编号</th>
			<th field='monthType' width=200px align="center">贷款时间</th>
			<th field='rate' width=100px align="center" formatter="formatRate">贷款利率</th>
		</tr>
    	</thead>
	</table>
	<div id="tb">
			<div>
				&nbsp;<a href="javascript:add()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
				&nbsp;<a href="javascript:del()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'">删除</a>
			</div>
		</div>
	
	<div id="dlg" class="easyui-dialog" data-options="iconCls:'icon-save',buttons:'#dlg-buttons'" style="width: 420px;height: 230px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<tr>
					<td>贷款时间类型:</td>
					<td>
						<input type="text" id="monthType" name="monthType" class="easyui-validatebox" required='true'/>
					</td>
				</tr>
				<tr>
					<td>对应贷款利率:</td>
					<td>
						<input type="text" id="rate" name="rate" class="easyui-validatebox" required='true'>
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