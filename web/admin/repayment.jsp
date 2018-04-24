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
	    var res = val.toFixed(2);
		return res+'元';
	}
	
	function formatRate(val,row){
	    var res = val.toFixed(2);
		return res+"%";
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
			$.messager.alert("系统提示","请选择一条要提醒的还款记录！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","还款提醒");
		var text = "本期应还余额："+row.repayMoneyNow;
		$("#message").val(text);
		url="${pageContext.request.contextPath}/admin/repayment/sendMessage.do?id="+row.uid;
	}
	
	function save(){
	    var text = $("#message").val();
        $.ajax({
            url: url,
			type:"post",
            data: {message:text},
            success: function(data){
                if (data.success){
                    $.messager.alert("系统提示","提醒成功");
                }else{
                    $.messager.alert("系统提示","提醒出错");
                }
                resetValue();
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");
            },
            dataType: "json"
        });


		// $("#fm").form('submit',{
		// 	url:url,
		// 	onSubmit:function(){
		// 		return $(this).form('validate');
		// 	},
		// 	success:function(data){
		// 		var data = eval('(' + data + ')');
		// 		if (data.success){
		// 			$.messager.alert("系统提示","审批成功");
		// 			resetValue();
		// 			$("#dlg").dialog("close");
		// 			$("#dg").datagrid("reload");
		// 		}
		// 	}
		// })
	}
	
	function close(){
		$('#dlg').dialog('close');
		resetValue();
	}
	
	function resetValue(){
        $("#message").val();
	}

</script>
</head>
<body style="margin: 1px">
	<table class="easyui-datagrid" title="还款信息"
		id="dg"
    	url='${pageContext.request.contextPath}/admin/repayment/list.do'
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
			<th field='loanId' width=50px align="center" hidden="true">贷款编号</th>
			<th field='uid' width=50px align="center" hidden="true">贷款用户编号</th>
			<th field="customerName" width="50px" align="center">贷款用户</th>
			<th field='loanMoney' width=50px align="center" formatter="formatMoney">贷款总金额</th>
			<th field='lendTime' width=50px align="center">放贷日期</th>
			<th field='loanMonth' width=50px align="center" formatter="formatDay">贷款月数</th>
			<th field='rate' width=50px align="center" formatter="formatRate">贷款利率</th>
			<th field='payMoney' width=50px align="center" formatter="formatMoney">需还款总金额</th>
			<th field='residueMoney' width=50px align="center" formatter="formatMoney">剩余还款金额</th>
			<th field='payMethod' width=50px align="center" formatter="formatRepayWay">还款方式</th>
			<th field='repayMoneyNow' width=50px align="center" formatter="formatMoney">本期应还余额</th>
			<th field='repayPeriods' width=50px align="center" >已还款期数</th>
		</tr>
    </thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:edit()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">提醒还款</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" data-options="iconCls:'icon-save',buttons:'#dlg-buttons'" style="width: 420px;height: 260px;padding: 10px 20px" closed="true">
			<table cellspacing="8px">
				<tr>
					<td>提醒消息:</td>
					<td>
						<textarea id="message" name="message" maxlength="500" rows="6" cols="40" ></textarea>
					</td>
				</tr>
			</table>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:save()" class="easyui-linkbutton">保存</a>
		<a href="javascript:close()" class="easyui-linkbutton">取消</a>
	</div>
	
</body>
</html>