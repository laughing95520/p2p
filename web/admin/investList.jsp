<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员信息</title>
    <link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

        var url;

        function formatDay(val, row) {
            return val;
        }

        function formatMoney(val, row) {
            val = val.toFixed(2);
            return val + '元';
        }

        function formatRate(val, row) {
            val = val.toFixed(2);
            return val + "%";
        }

        function returnUser(){
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一个要把投资项目归还给用户！");
                return;
            }
            var id = selectedRows[0].id;
            $.messager.confirm("系统提示", "您确认要把这个投资项目归还给用户吗？", function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath}/admin/invest/returnMoneyToUser.do', {
                        id: id,
                    }, function (result) {
                        if (result.success) {
                            $.messager.alert("系统提示", "归还成功！");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", "归还失败！");
                        }
                    }, "json");
                }
            });
        }

    </script>
</head>
<body style="margin: 1px">
<table class="easyui-datagrid" title="投资记录"
       id="dg"
       url='${pageContext.request.contextPath}/admin/invest/list.do'
       pagination=true
       rownumbers=true
       fitColumns=true
       toolbar="#tb"
       fit=true
>
    <thead>
    <tr>
        <th field='cb' checkbox=true></th>
        <th field='id' width=20px align="center" hidden="true">投资记录id</th>
        <th field='pid' width=20px align="center" hidden="true">投资产品id</th>
        <th field='uid' width=20px align="center" hidden="true">投资用户id</th>
        <th field='userName' width=20px align="center">投资用户名字</th>
        <th field='title' width=50px align="center">投资产品名字</th>
        <th field='rate' width=50px align="center" formatter="formatRate">投资产品年利率</th>
        <th field='investMoney' width=50px align="center" formatter="formatMoney">用户投资金额</th>
        <th field='income' width=50px align="center" formatter="formatMoney">用户收益</th>
        <th field='incomeDate' width=50px align="center" formatter="formatDay">投资收益时间</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        &nbsp;<a href="javascript:returnUser()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">归还投资</a>
    </div>
</div>


</body>
</html>