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

function formatMoney(val,row){
    return val+'元';
}

function addBalance(){
	var selectedRows=$("#dg").datagrid("getSelections");
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一个要充值的客户！");
		return;
	}
	var row=selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle","余额充值");
	$("#fm").form('load',row);
    $("#typeDes").html("余额充值:");
    $("#type").val(1);
    url="${pageContext.request.contextPath}/admin/customer/changeBalance.do";
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
			}else {
                $.messager.alert("系统提示","操作失败");
                resetValue();
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");
			}
		}
	})
}


function reduce(){
    var selectedRows=$("#dg").datagrid("getSelections");
    if(selectedRows.length!=1){
        $.messager.alert("系统提示","请选择一个要提现的客户！");
        return;
    }
    var row=selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle","余额提现");
    $("#fm").form('load',row);
    $("#typeDes").html("余额提现:");
    $("#type").val(2);
    url="${pageContext.request.contextPath}/admin/customer/changeBalance.do";
}

function close(){
	$('#dlg').dialog('close');
	resetValue();
}

function resetValue(){
	$("#payMoney").val('');
}
</script>
</head>
<body style="margin: 1px">
	<table class="easyui-datagrid" title="客户余额管理"
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
			<th field='name' width=50px align="center">姓名</th>
			<th field="balance" width="100px" align="center" formatter="formatMoney">用户余额</th>
			<th field="fBankNum" width="200px" align="center">用户银行卡号</th>
			<th field='phoneNum' width=100px align="center">用户联系电话</th>
		</tr>
    	</thead>
	</table>
	<div id="tb">
			<div>
				&nbsp;<a href="javascript:addBalance()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">充值</a>
				&nbsp;<a href="javascript:reduce()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">提现</a>
			</div>
		</div>
	
	<div id="dlg" class="easyui-dialog" data-options="iconCls:'icon-save',buttons:'#dlg-buttons'" style="width: 420px;height: 230px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="15px">
				<tr>
					<td>用户姓名:</td>
					<td>
						<input type="hidden" id="id" name="id"/>
						<input type="text" id="name" name="name"  required='true' readonly='true' style="border:none"/>
					</td>
				</tr>
				<tr>
					<td id="typeDes" name="typeDes"></td>
					<td>
						<input type="hidden" id="type" name="type" />
						<input type="text" id="payMoney" name="payMoney" class="easyui-validatebox" required="true" />
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