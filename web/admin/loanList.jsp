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
	
	function formatRepayWay(val,row){
	    switch(val){
			case 1:
			    return "按月付息，到期还本";
			    break;
			case 2:
			    return "连本带息，到期一次还";
			    break;
		}
	}
	
	function formatMoney(val,row){
		return val+'元';
	}
	
	function formatRate(val,row){
		return val+"%";
	}
	
	function formatApproval(val,row){
		if(val == 3){
			return '不通过';
		}else if(val == 2){
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

	function checkGuarantee(){
	    var selectRows = $("#dg").datagrid("getSelections");
        if(selectRows.length!=1){
            $.messager.alert("系统提示","请选择一个要查看的贷款担保资料！");
            return;
        }
        var row = selectRows[0];
        var cusId = row.customerId;
        $.ajax({
            url:"${pageContext.request.contextPath}/admin/application/findGuarantee.do",
			type:"post",
            data: {"id":cusId},
			success:function(data){
                var data = eval('(' + data + ')');
                $("#gua").dialog("open").dialog("setTitle",row.customerName+"的贷款担保资料");
                $("#idCardFront").attr('src',("/"+data.frontPath));
                $("#idCardBack").attr('src',("/"+data.backPath));
                switch(parseInt(data.guaType)){
					case 1:
                        $("#guaType").html("收入证明");
					    break;
					case 2:
                        $("#guaType").html("房产证");
					    break;
					case 3:
                        $("#guaType").html("工资条");
					    break;
					default:
					    break;
				}

                $("#guaPath").attr('src',("/"+data.guaPath));
            }
		});
	}

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
		$("#approvalStatue").val('1');
		$("#reason").val('');
	}

</script>
	<style type="text/css">
		.fontOnImg{
			padding-left: 50px;
			font-size: 20px;
		}
	</style>
</head>
<body style="margin: 1px">
	<table class="easyui-datagrid" title="贷款申请"
		id="dg"
    	url='${pageContext.request.contextPath}/admin/application/listLoan.do'
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
			<th field='customerName' width=50px align="center">申请人</th>
			<th field='money' width=50px align="center" formatter="formatMoney">贷款金额</th>
			<th field='loanMonth' width=50px align="center" formatter="formatDay">贷款期限</th>
			<th field='rate' width=50px align="center" formatter="formatRate">年利率</th>
			<th field='repayWay' width=50px align="center" formatter="formatRepayWay">还款方式</th>
			<th field='loanTime' width=50px align="center">申请日期</th>
			<th field='state' width=50px align="center" formatter="formatApproval">审批状态</th>
			<th field='lendingTime' width=50px align="center">审批日期</th>
			<th field='words' width=50px align="center">审核备注</th>
		</tr>
    </thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:checkGuarantee()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">查看贷款担保详情</a>
			<%--&nbsp;<a href="javascript:edit()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">审批</a>--%>
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
							<option value="2">通过</option>
							<option value="1">待审批</option>
							<option value="3">不通过</option>
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

	<div id="gua" class="easyui-dialog" style="width: 480px;height: 400px;padding: 10px 20px" closed="true">
		<form method="post" id="guaForm">
			<table cellspacing="8px">
					<tr>
						<td>
							<span class = "fontOnImg" >身份证正面</span>
							<img  id="idCardFront" alt="身份证正面" class="img-rounded" width="200px" height="200px">
						</td>
						<td>
							<span class = "fontOnImg" >身份证背面</span>
							<img  id="idCardBack" alt="身份证背面" class="img-rounded" width="200px" height="200px">
						</td>
					</tr>
					<tr>
						<td>
							<span id="guaType" class="fontOnImg"></span>
							<img  id="guaPath" alt="担保资料" class="img-rounded" width="200px" height="200px">
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