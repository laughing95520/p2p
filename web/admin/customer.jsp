<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户基本信息</title>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
function formatSex(val,row){
	if(val == 1){
		return '男';
	}else{
		return '女';
	}
}
	
var url;

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
			$.post("${pageContext.request.contextPath}/admin/customer/del.do",{"ids":ids},function(result){
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

	
</script>
</head>
<body style="margin: 1px">
	<table class="easyui-datagrid" title="客户基本信息"
		id="dg"
    	url='${pageContext.request.contextPath}/admin/customer/list.do'
    	pagination=true
		rownumbers=true
		fitColumns=true
		toolbar="#tb"
		fit=true
		>
		<thead>
		<tr>
			<th field='cb' checkbox=true></th>
			<th field='id' width=20px align="center" hidden="true">编号</th>
			<th field='name' width=50px align="center">用户名</th>
			<th field='birthday' width=50px align="center">出生日期</th>
			<th field='sex' width=50px align="center" formatter="formatSex">性别</th>
			<th field='idNum' width=50px align="center">身份证号码</th>
			<th field='phoneNum' width=50px align="center">联系电话</th>
			<th field='address' width=50px align="center">地址</th>
			<th field='fBankNum' width=50px align="center">银行卡号</th>
			<th field='urgentPersonPhone' width=50px align="center">紧急联系电话</th>
		</tr>
    </thead>
	</table>
	<div id="tb">
		<div>
			&nbsp;<a href="javascript:del()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'">删除</a>
		</div>
	</div>
	
</body>
</html>