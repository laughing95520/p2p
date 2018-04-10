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

function formatProPic(val,row){
	return "<a href='bigimg.jsp?src=${pageContext.request.contextPath}/"
			+val
			+"' target='_blank'>"
			+"<img width=100 height=100 src='${pageContext.request.contextPath}/"+val+"'></a>";
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

var url;

function srzm(){
	var selectedRows=$("#dg").datagrid("getSelections");
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一个要查看的客户收入证明！");
		return;
	}
	var row=selectedRows[0];
	$.post("${pageContext.request.contextPath}/admin/customerloan/loaninfoson.do",{"id":row.id},function(result){
	});
	$("#srzm").dialog("open").dialog("setTitle",row.name+"的收入证明");
	
}
function fcz(){
	var selectedRows=$("#dg").datagrid("getSelections");
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一个要查看的客户房产证！");
		return;
	}
	var row=selectedRows[0];
	$.post("${pageContext.request.contextPath}/admin/customerloan/loaninfoson.do",{"id":row.id},function(result){
	});
	$("#fcz").dialog("open").dialog("setTitle",row.name+"的房产证");
}
function gzz(){
	var selectedRows=$("#dg").datagrid("getSelections");
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一个要查看的客户工作证！");
		return;
	}
	var row=selectedRows[0];
	$.post("${pageContext.request.contextPath}/admin/customerloan/loaninfoson.do",{"id":row.id},function(result){
	});
	$("#gzz").dialog("open").dialog("setTitle",row.name+"的工作证");
}
function xybg(){
	var selectedRows=$("#dg").datagrid("getSelections");
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一个要查看的客户信用报告！");
		return;
	}
	var row=selectedRows[0];
	$.post("${pageContext.request.contextPath}/admin/customerloan/loaninfoson.do",{"id":row.id},function(result){
	});
	$("#xybg").dialog("open").dialog("setTitle",row.name+"的信用报告");
}
function gzt(){
	var selectedRows=$("#dg").datagrid("getSelections");
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一个要查看详情的贷款资料！");
		return;
	}
	var row=selectedRows[0];
	$.post("${pageContext.request.contextPath}/admin/customerloan/loaninfoson.do",{"id":row.id},function(result){
	});
	$("#gzt").dialog("open").dialog("setTitle",row.name+"的工作条");
}

function edit(){
	var selectedRows=$("#dg").datagrid("getSelections");
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一个要审批的贷款资料！");
		return;
	}
	var row=selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle","审批贷款资料");
	$("#fm").form('load',row);
	url="${pageContext.request.contextPath}/admin/customerloan/approval.do?id="+row.id;
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
	<table class="easyui-datagrid" title="客户基本信息"
		id="dg"
    	url='${pageContext.request.contextPath}/admin/customerloan/list.do'
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
			<th field='name' width=50px align="center">用户名</th>
			<th field='idCardPositive' width=50px align="center" formatter="formatProPic">身份证正面</th>
			<th field='idCardBack' width=50px align="center" formatter="formatProPic">身份证背面</th>
			<th field='approver' width=50px align="center">审批人</th>
			<th field='approval' width=50px align="center" formatter="formatApproval">审批</th>
			<th field='approvalDate' width=50px align="center">审批日期</th>
			<th field='reason' width=50px align="center">不通过原因</th>
		</tr>
    </thead>
	</table>
	<div id="tb">
		<div>
			&nbsp;<a href="javascript:edit()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">审批</a>
			&nbsp;<a href="javascript:detail()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">详情</a>
			&nbsp;<a href="javascript:srzm()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">收入证明</a>
			&nbsp;<a href="javascript:fcz()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">房产证</a>
			&nbsp;<a href="javascript:gzz()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">工作证</a>
			&nbsp;<a href="javascript:xybg()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">信用报告</a>
			&nbsp;<a href="javascript:gzt()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">工资条</a>
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
							<option value="0">不通过</option>
							<option value="1">通过</option>
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
	
	<div id="srzm" class="easyui-dialog" style="width: 480px;height: 400px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<c:forEach items ="${loanIncome}" var = "income" varStatus="status">
					<tr>
						<td>
							<a href='bigimg.jsp?src=${pageContext.request.contextPath}/${income.path}' target="_blank">
								<img src="${pageContext.request.contextPath}/${income.path}" 
										alt="收入证明" class="img-rounded" 
										width="400px" height="400px">
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<div id="fcz" class="easyui-dialog" style="width: 480px;height: 400px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<c:forEach items ="${loanRoom}" var = "room" varStatus="status">
					<tr>
						<td>
							<a href='bigimg.jsp?src=${pageContext.request.contextPath}/${room.path}' target="_blank">
								<img src="${pageContext.request.contextPath}/${room.path}" alt="房产证" class="img-rounded" width="400px" height="400px">
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<div id="gzz" class="easyui-dialog" style="width: 480px;height: 400px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<c:forEach items ="${loanJob}" var = "job" varStatus="status">
					<tr>
						<td>
							<a href='bigimg.jsp?src=${pageContext.request.contextPath}/${job.path}' target="_blank">
								<img src="${pageContext.request.contextPath}/${job.path}" alt="工作证" class="img-rounded" width="400px" height="400px">
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<div id="xybg" class="easyui-dialog" style="width: 480px;height: 400px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<c:forEach items ="${loanCredit}" var = "credit" varStatus="status">
					<tr>
						<td>
							<a href='bigimg.jsp?src=${pageContext.request.contextPath}/${credit.path}' target="_blank">
								<img src="${pageContext.request.contextPath}/${credit.path}" alt="信用报告" class="img-rounded" width="400px" height="400px">
							</a>	
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<div id="gzt" class="easyui-dialog" style="width: 480px;height: 400px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<c:forEach items ="${loanSalary}" var = "salary" varStatus="status">
					<tr>
						<td>
							<a href='bigimg.jsp?src=${pageContext.request.contextPath}/${salary.path}' target="_blank">
								<img src="${pageContext.request.contextPath}/${salary.path}" alt="工资条" class="img-rounded" width="400px" height="400px">
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:save()" class="easyui-linkbutton">保存</a>
		<a href="javascript:close()" class="easyui-linkbutton">取消</a>
	</div>
</body>
</html>