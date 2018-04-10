<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贷款申请</title>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
	function formatDay(val,row){
		return val+'月';
	}
	
	function formatStage(val,row){
		return val+'期';
	}
	
	function formatMoney(val,row){
		return val+'元';
	}
	
	function formatRate(val,row){
		return '百分之' + val*100;
	}
	
	function formatApproval(val,row){
		if(val == 0){
			return '不通过';
		}else if(val == 1){
			return '通过';
		}else{
			return '待审批';
		}
	}
	
	function formatRelease(val,row){
		if(val == 0){
			return '不通过';
		}else if(val == 1){
			return '已发放';
		}else{
			return '待审批';
		}
	}
	
	var url;
	
	function edit(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一个要审批的贷款申请！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","审批贷款申请");
		$("#fm").form('load',row);
		url="${pageContext.request.contextPath}/admin/application/approval.do?id="+row.id;
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
					$.messager.alert("系统提示","审批成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		})
	}
	
	function close(){
		$('#dlg').dialog('close');
		resetValue();
	}
	
	function resetValue(){
		$("#approvalStatue").val('2');
		$("#reason").val('');
	}

</script>
</head>
<body style="margin: 1px">
	<table class="easyui-datagrid" title="贷款申请"
		id="dg"
    	url='${pageContext.request.contextPath}/admin/application/list.do'
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
			<th field='name' width=50px align="center">申请人</th>
			<th field='money' width=50px align="center" formatter="formatMoney">贷款金额</th>
			<th field='day' width=50px align="center" formatter="formatDay">贷款天数</th>
			<th field='interestRate' width=50px align="center" formatter="formatRate">年利率</th>
			<th field='overdueInterestRate' width=50px align="center" formatter="formatRate">逾期利率</th>
			<th field='stageCount' width=50px align="center" formatter="formatStage">分期次数</th>
			<th field='applyDate' width=50px align="center">申请日期</th>
			<th field='approvalName' width=50px align="center">审批人</th>
			<c:if test="${statue == 1}">
				<th field='approvalOrdinary' width=50px align="center" formatter="formatApproval">审批通过（普通）</th>
				<th field='approvalDateOrdinary' width=50px align="center">审批日期（普通）</th>
			</c:if>
			<c:if test="${statue == 0}">
				<th field='approvalSuper' width=50px align="center" formatter="formatApproval">审批通过（超级）</th>
				<th field='approvalDateSuper' width=50px align="center">审批日期（超级）</th>
			</c:if>
			<c:if test="${statue == 2}">
				<th field='releaseA' width=50px align="center" formatter="formatRelease">贷款发放</th>
				<th field='approvalDateFinance' width=50px align="center">审批日期（财务）</th>
			</c:if>
			<th field='reason' width=50px align="center">不通过原因</th>
		</tr>
    </thead>
	</table>
	
	<div id="tb">
		<div>
			&nbsp;<a href="javascript:edit()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">审批</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" data-options="iconCls:'icon-save',buttons:'#dlg-buttons'" style="width: 420px;height: 260px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<tr>
					<td>审批:</td>
					<td>
						<select id='approvalStatue' name='approvalStatue' style="width: 130px">
							<option disabled selected style='display:none;'>待审批</option>
							<option value="1">通过</option>
							<option value="0">不通过</option>
							<option value="2">待审批</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>原因:</td>
					<td>
						<textarea id="reason" name="reason" maxlength="500" rows="6" cols="40" ></textarea>
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