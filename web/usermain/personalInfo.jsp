<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>闲钱贷-p2p理财平台</title>
    <!-- bootstarp3 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/main.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-datetimepicker.css">
    <!-- icon -->
    <link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
    <!-- jquery -->
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.fr.js"></script>

    <script type="text/javascript">
        $(function () {
            if ($("#setSex").val() == 0) {
                $("#sex").val(0);
            } else {
                $("#sex").val(1);
            }
            if ($("#seteducation").val() == 1) {
                $("#education").val(1);
            } else if ($("#seteducation").val() == 2) {
                $("#education").val(2);
            } else if ($("#seteducation").val() == 3) {
                $("#education").val(3);
            } else if ($("#seteducation").val() == 4) {
                $("#education").val(4);
            }
            var date = new Date();
            var birthday = $('#birth').val();
            if (birthday != "") {
                date = new Date(birthday);
            }
            birthday = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
            $('#birth').val(birthday);
        })
    </script>
</head>

<body>
<jsp:include page="/common/daohang.jsp"></jsp:include>

<jsp:include page="/common/daohangUserMain.jsp"></jsp:include>
<hr>
<form action="${pageContext.request.contextPath}/user/customer/personupdate.html" method="post">
    <div class="row">
        <div class="col-md-3 col-md-offset-2">
            <div class="input-group">
                <span class="input-group-addon">真实姓名　</span>
                <input type="text" class="form-control" aria-describedby="basic-addon1" readonly
                       value="${customer.name}">
            </div>
            <hr>
            <div class="input-group">
                <span class="input-group-addon">性别</span>
                <select class="form-control" name='sex' id="sex">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </div>
            <hr>
            <div class="input-group">

                <span class="input-group-addon">出生日期　</span>
                <div class="input-append date form_datetime" id="datetime">
                    <input type="text" class="form-control" id="birth" onclick="text()" name='birthday' value="${customer.birthday }" readonly />
                </div>
            </div>
            <script type="text/javascript">
                function text() {
                    $('#birth').datetimepicker({
                            format: "yyyy-mm-dd",
                            minView: 'month',
                            todayBtn: true,
                            autoclose: true,
                        }
                    );
                }
            </script>

            <hr>
            <div class="input-group">
                <span class="input-group-addon">身份证号码</span>
                <input type="text" class="form-control" aria-describedby="basic-addon1" value="${customer.idNum }"
                       name='idNum'>
            </div>
            <hr>
            <div class="input-group">
                <span class="input-group-addon">联系电话　</span>
                <input type="text" class="form-control" aria-describedby="basic-addon1" name='phoneNum'
                       value="${customer.phoneNum }">
            </div>
            <hr>
            <div class="input-group">
                <span class="input-group-addon">家庭地址　</span>
                <input type="text" class="form-control" aria-describedby="basic-addon1" name='address'
                       value="${customer.address }">
            </div>
        </div>

        <div class="col-md-3 col-md-offset-1">
            <div class="input-group">
                <span class="input-group-addon">学历　　　　　</span>
                <select class="form-control" value='1' name='education' id='education'>
                    <option value="1">本科</option>
                    <option value="2">硕士</option>
                    <option value="3">博士</option>
                    <option value="4">其他</option>
                </select>
            </div>
            <hr>
            <div class="input-group">
                <span class="input-group-addon">职业　　　　　</span>
                <input type="text" class="form-control" aria-describedby="basic-addon1" name='career'
                       value="${customerDetail.career }">
            </div>
            <hr>
            <div class="input-group">
                <span class="input-group-addon">公司　　　　　</span>
                <input type="text" class="form-control" aria-describedby="basic-addon1" name='company'
                       value="${customerDetail.company }">
            </div>
            <hr>
            <div class="input-group">
                <span class="input-group-addon">公司地址　　　</span>
                <input type="text" class="form-control" aria-describedby="basic-addon1" name='companyAddress'
                       value="${customerDetail.companyAddress }">
            </div>
            <hr>
            <div class="input-group">
                <span class="input-group-addon">银行卡号　　</span>
                <input type="text" class="form-control" aria-describedby="basic-addon1" name='fBankNum'
                       value="${customer.fBankNum }">
            </div>
            <hr>
            <div class="input-group">
                <span class="input-group-addon">紧急联系电话</span>
                <input type="text" class="form-control" aria-describedby="basic-addon1" name='urgentPersonPhone'
                       value="${customer.urgentPersonPhone }">
            </div>
        </div>
    </div>
    <div class="col-md-3 col-md-offset-5">
        <hr>
        <button type="submit" class="btn btn-success btn-lg">提交</button>
        <hr>
    </div>
</form>
<hr>
<jsp:include page="/common/bottom.jsp"></jsp:include>
<input type="hidden" id="setSex" value="${customer.sex}">
<input type="hidden" id="seteducation" value="${customerDetail.education }">
</body>
</html>