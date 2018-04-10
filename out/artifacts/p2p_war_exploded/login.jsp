<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
    <!-- icon -->
    <link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
    <!-- jquery -->
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function loginSubmit() {
            var userName = $("#userName").val();
            var password = $("#password").val();
            if (userName == '') {
                $("#error").html('账户不能为空');
                return false;
            }
            if (password == '') {
                $("#error").html('密码不能为空');
                return false;
            }
            return true;
        }
    </script>
    <style type="text/css">

    </style>
    <title>登录页面-P2P小额贷款</title>
</head>
<body style="background: #fff url(${pageContext.request.contextPath}/static/images/1.jpg) 50% 0 no-repeat;">
<div class="container" style="margin-top: 270px;">
    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-9">
            <form action="${pageContext.request.contextPath}/login.html" method="post" onsubmit="loginSubmit()">
                <div style="width: 400px;height: 300px;background:transparent;background-color:rgba(255,255,255,0.08)">
                    <div style="position: relative;left: 120px;top: 20px;">
                        <h2><b>用&nbsp;户&nbsp;登&nbsp;录</b></h2>
                    </div>
                    <div role="alert" style="width: 300px;height: 30px;position: relative;left: 100px;top: 15px;">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span>
                        <label style="color: red"><h4 id="error">${error }</h4></label>
                    </div>
                    <div class="input-group input-group-lg" style="	width: 300px;top: 25px;left: 40px;">
                        <span class="input-group-addon" id="sizing-addon">账户</span>
                        <input id="userName" name="name" type="text" class="form-control" placeholder="请输入你的账户"
                               aria-describedby="sizing-addon1">
                    </div>
                    <div class="input-group input-group-lg"
                         style="position: relative;left: 40px;width: 300px;top: 45px;">
                        <span class="input-group-addon" id="sizing-addon1">密码</span>
                        <input type="password" id="password" name="password" class="form-control" placeholder="请输入你的密码"
                               aria-describedby="sizing-addon1">
                    </div>
                    <div style="position: relative;left:145px;top:70px;">
                        <button type="submit" class="btn btn-success" style="width: 100px;height: 40px;"><font
                                size="5px;">
                            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>登录</font></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>