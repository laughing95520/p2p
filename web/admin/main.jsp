<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>P2P闲钱贷-管理后台</title>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

	function openTab(text,url,iconCls){
		if($("#tabs").tabs("exists",text)){
			$("#tabs").tabs("select",text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='"+url+"'></iframe>";
			$("#tabs").tabs("add",{
				title:text,
				iconCls:iconCls,
				closable:true,
				content:content
			});
		}
	}
	
	function openPasswordModifyDialog(){
		$('#dlg').dialog('open').dialog('setTitle','修改密码');
	}
	
	function resetValue(){
		$("#password").val('');
		$("#password1").val('');
	}
	
	function savePassword(){
		$("#fm").form('submit',{
			url:'${pageContext.request.contextPath}/admin/modifyPwd.do',
			onSubmit:function(){
				var newPassword=$("#newPassword").val();
				var newPassword2=$("#newPassword2").val();
				if(!$(this).form("validate")){
					return false;
				}
				if(newPassword!=newPassword2){
					$.messager.alert("系统提示","确认密码输入错误！");
					return false;
				}
				return true;
			},
			success:function(data){
				var data = eval('(' + data + ')'); 
				if (data.success){
					$.messager.alert("系统提示","修改成功");
					resetValue();
					$("#dlg").dialog("close");
				}
			}
		})
	}
	function close(){
		$('#dlg').dialog('close');
		resetValue();
	}
	
	function logout(){
		$.messager.confirm("系统提示","您确定要退出系统吗?",function(r){
			if(r){
				window.location.href="${pageContext.request.contextPath}/admin/logout.do";
			}
		});
	}
</script>
</head>
<body class="easyui-layout">
<div region="north" style="height: 125px;background-color: #E0ECFF">
	<table style="padding: 5px" width="100%">
		<tr>
			<td width="8%">
				<img alt="logo" height="89%" src="${pageContext.request.contextPath}/static/images/logo.png">
			</td>
			<td width="" style="font-size: 50px" >
				p2p闲钱贷----想贷就贷，无需等贷
			</td>
			<td align="right" width="20%" style="font-size: 30px ; padding-right: 5%;">
				&nbsp;&nbsp;<strong>欢迎管理员：</strong>${currnetUser.name }
			</td>
		</tr>
	</table>
</div>
<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div title="首页" data-options="iconCls:'icon-home'">
			<div align="center" style="padding-top: 100px">
				<img width="100%" height="100%" src="${pageContext.request.contextPath}/static/images/houtai.png"> </div>
		</div>
	</div>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
	<div class="easyui-accordion" data-options="fit:true,border:false">
		<div title="贷款信息管理"  data-options="iconCls:'icon-plgl'" style="padding:10px">
			<a href="javascript:openTab('贷款项目','loanItems.jsp','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">贷款项目</a>
			<a href="javascript:openTab('贷款申请','application.jsp','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">贷款申请</a>
		</div>
		<div title="客户信息"  data-options="iconCls:'icon-grxx'" style="padding:10px">
		    <a href="javascript:openTab('客户基本信息','customer.jsp','icon-grxx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px">客户基本信息</a>
		    <a href="javascript:openTab('客户详情信息','customerDetail.jsp','icon-grxx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px">客户详情信息</a>
		    <a href="javascript:openTab('客户贷款资料','customerLoan.jsp','icon-grxx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px">客户贷款资料</a>
		</div>
		<div title="客户信用管理"  data-options="iconCls:'icon-grxx'" style="padding:10px">
			<a href="javascript:openTab('客户信用管理','credit.jsp','icon-grxxxg')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-grxxxg'" style="width: 150px;">客户信用管理</a>
		</div>
		<c:if test="${statue == 0}">
			<div title="管理员信息" data-options="iconCls:'icon-grxx'" style="padding:10px">
				<a href="javascript:openTab('管理员信息','adminManage.jsp','icon-grxx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">管理员信息</a>
			</div>
		</c:if>
		<div title="系统管理"  data-options="iconCls:'icon-system'" style="padding:10px">
			<a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
			<a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
		</div>
	</div>
</div>
<div id="dlg" class="easyui-dialog" data-options="iconCls:'icon-save',buttons:'#dlg-buttons'" style="width: 400px;height: 230px;padding: 10px 20px" closed="true">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<tr>
					<td>用户名:</td>
					<td>
    					<input type="text" id="userName" name="userName" value="${currnetUser.name }" style="width: 200px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td>新密码:</td>
					<td>
						<input type="password" id="newPassword" name="newPassword" class="easyui-validatebox" required='true' style="width: 200px"/>&nbsp;
					</td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td>
						<input type="password" id="newPassword2" name="newPassword2" class="easyui-validatebox" required='true' style="width: 200px"/>&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:savePassword()" class="easyui-linkbutton">保存</a>
		<a href="javascript:close()" class="easyui-linkbutton">取消</a>
	</div>
</body>
</html>