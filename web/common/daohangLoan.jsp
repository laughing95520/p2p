<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>闲钱贷-p2p理财平台</title>
    <script type="text/javascript">
        $(function () {
            if ($("#setActiveLoanTemp").val() == 1) {
                $("#wddk").addClass('activePerson');
            } else if ($("#setActiveLoanTemp").val() == 2) {
                $("#dkzl").addClass('activePerson');
            }
        })
    </script>
</head>
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<body>

<div class="container">
    <ul class="nav nav-tabs">
        <li id="wddk" role="presentation">
            <a href="${pageContext.request.contextPath}/user/loan/myloan.html">我的贷款</a>
        </li>
        <li id="dkzl" role="presentation">
            <a href="${pageContext.request.contextPath}/user/loan/loaninfo.html">贷款资料</a>
        </li>
        <li id="dksq" role="presentation">
            <a href="${pageContext.request.contextPath}/user/loan/loanType.html">贷款申请</a>
        </li>
        <li id="hk" role="presentation">
            <a href="${pageContext.request.contextPath}/user/loan/list.html">还款列表</a>
        </li>
    </ul>
</div>
<input type="hidden" id="setActiveLoanTemp" value="${loanIndex }">
</body>
</html>