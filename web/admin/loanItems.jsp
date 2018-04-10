<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	
	function formatDay(val,row){
		return val+'月';
	}
	
	function formatMoney(val,row){
		return val+'元';
	}
	
	function formatRate(val,row){
		return val*100+"%";
	}
	
	function formatRelease(val,row){
		if(val == 0){
			return "待发布";
		}else{
			return "已发布";			
		}
	}
	
	var url;
	
	function setRelease(release){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要设置的贷款项目！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要设置这<font color=red>"+selectedRows.length+"</font>个贷款项目吗？",function(r){
			if(r){
				$.post('${pageContext.request.contextPath}/admin/loanItems/release.do',{ids:ids,release:release},function(result){
					if(result.success){
						$.messager.alert("系统提示","已设置成功！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","设置失败！");
					}
				},"json");
			}
		});
	}
	
	function add(){
		$('#dlg').dialog('open').dialog('setTitle','添加贷款项目');
		url='${pageContext.request.contextPath}/admin/loanItems/save.do';
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
				$.post("${pageContext.request.contextPath}/admin/loanItems/del.do",{"ids":ids},function(result){
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
		$("#moneyDown").val('');
		$("#moneyUp").val('');
		$("#dayDown").val('');
		$("#dayUp").val('');
		$("#rate").val('');
		$("#overRate").val('');
	}
	
</script>
</head>
<body style="margin: 1px">
	<table class="easyui-datagrid" title="贷款项目"
		id="dg"
    	url='${pageContext.request.contextPath}/admin/loanItems/list.do'
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
			<th field='moneyDown' width=50px align="center" formatter="formatMoney">项目金额下限</th>
			<th field='moneyUp' width=50px align="center" formatter="formatMoney">项目金额上限</th>
			<th field='dayDown' width=50px align="center" formatter="formatDay">贷款期限下限</th>
			<th field='dayUp' width=50px align="center" formatter="formatDay">贷款期限上限</th>
			<th field='rate' width=50px align="center" formatter="formatRate">年利率</th>
			<th field='overRate' width=50px align="center" formatter="formatRate">逾期年利率</th>
			<th field='creatTime' width=50px align="center">创建时间</th>
			<th field='releaseNum' width=50px align="center" formatter="formatRelease">是否发布</th>
		</tr>
    </thead>
	</table>
	<div id="tb">
		<div>
			&nbsp;<a href="javascript:add()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
			&nbsp;<a href="javascript:del()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'">删除</a>
			&nbsp;<a href="javascript:setRelease(1)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'" plain="true">发布</a>
			&nbsp;<a href="javascript:setRelease(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'" plain="true">取消发布</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" data-options="iconCls:'icon-save',buttons:'#dlg-buttons'" style="width: 400px;height: 310px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<tr>
					<td>项目金额下限:</td>
					<td>
						<input type="text" id="moneyDown" name="moneyDown" class="easyui-validatebox" required='true'/>  元
					</td>
				</tr>
				<tr>
					<td>项目金额上限:</td>
					<td>
						<input type="text" id="moneyUp" name="moneyUp" class="easyui-validatebox" required='true'/>  元
					</td>
				</tr>
				<tr>
					<td>贷款期限下限:</td>
					<td>
						<input type="text" id="dayDown" name="dayDown" class="easyui-validatebox" required='true' /> 月
					</td>
				</tr>
				<tr>
					<td>贷款期限上限:</td>
					<td>
						<input type="text" id="dayUp" name="dayUp" class="easyui-validatebox" required='true' /> 月
					</td>
				</tr>
				<tr>
					<td>年利率:</td>
					<td>
						<input type="text" id="rate" name="rate" class="easyui-validatebox" required='true' />
					</td>
				</tr>
				<tr>
					<td>逾期年利率:</td>
					<td>
						<input type="text" id="overRate" name="overRate" class="easyui-validatebox" required='true' />
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