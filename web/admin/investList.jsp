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
                            $.messager.alert("系统提示", "已设置成功！");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", "设置失败！");
                        }
                    }, "json");
                }
            });
        }


        function close() {
            $('#dlg').dialog('close');
            resetValue();
        }

        function resetValue(){
            $("#title").val('');
            $("#lowestMoney").val('');
            $("#rate").val('');
            $("#timeline").val('');
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

<div id="dlg" class="easyui-dialog" data-options="iconCls:'icon-save',buttons:'#dlg-buttons'"
     style="width: 400px;height: 310px;padding: 10px 20px" closed="true">
    <form method="post" id="fm">
        <table cellspacing="8px">
            <tr>
                <td>产品名字:</td>
                <td>
                    <input type="text" id="title" name="title" class="easyui-validatebox" required='true'/>
                </td>
            </tr>
            <tr>
                <td>最低投资金额:</td>
                <td>
                    <input type="text" id="lowestMoney" name="lowestMoney" class="easyui-validatebox" required='true'/>
                    元
                </td>
            </tr>
            <tr>
                <td>项目期待年利率</td>
                <td>
                    <input type="text" id="rate" name="rate" class="easyui-validatebox" required='true'/> %
                </td>
            </tr>
            <tr>
                <td>项目周期(单位:月)</td>
                <td>
                    <input type="text" id="timeline" name="timeline" class="easyui-validatebox" required='true'/> 月
                </td>
            </tr>
            <tr>
                <td>是否发布</td>
                <td>
                    <select id='state' name='state' style="width: 130px">
                        <option value="0">发布</option>
                        <option value="1">不发布</option>
                    </select>
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