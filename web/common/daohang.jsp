<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <script src="${pageContext.request.contextPath}/static/bootstrap3/css/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.fr.js"></script>


    <!-- loginlib -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/loginlib/style.css"/>
    <script src="${pageContext.request.contextPath}/loginlib/main.js"></script>
    <script type="text/javascript">
        $(function () {
            if ($("#setActiveMainTemp").val() == 1) {
                $("#sy").addClass('activeMainTemp');
            } else if ($("#setActiveMainTemp").val() == 2) {
                $("#yhzy").addClass('activeMainTemp');
            } else if ($("#setActiveMainTemp").val() == 3) {
                $("#dkgl").addClass('activeMainTemp');
            } else if ($("#setActiveMainTemp").val() == 4) {
                $("#wdgl").addClass('activeMainTemp');
            }
        })

        function loginSubmit() {
            var userName = $("#signin-username").val();
            var password = $("#signin-password").val();
            if (userName == '') {
                alert("账户不能为空");
                $("#error").html('账户不能为空');
                return false;
            }
            if (password == '') {
                alert("密码不能为空");
                $("#error").html('密码不能为空');
                return false;
            }
            return true;
        }

        function registerSubmit(){
            var userName = $("#signup-username").val();
            var password = $("#signup-password").val();
            var password1 = $("#signup-password1").val();
            if(userName == ''){
                alert("账户不能为空")
                $("#error").html('账户不能为空');
                return false;
            }
            if(password == ''){
                alert("密码不能为空");
                $("#error").html('密码不能为空');
                return false;
            }
            if(password1 == ''){
                alert("确认密码不能为")
                $("#error").html('确认密码不能为空');
                return false;
            }
            if(password != password1){
                alert("密码与确认密码不一致")
                $("#error").html('密码与确认密码不一致');
                return false;
            }
            if($("#error").html() == '此账户已被注册'){
                return false;
            }
            $.post("${pageContext.request.contextPath}/register.html",{'name':userName,'password':password},function(result){
                if(result.success){
                    if(confirm('恭喜你,注册成功,立即登录!')){
                        location.href="${pageContext.request.contextPath}/index.html";
                    }
                }
            },'json')
        }

        $(function(){
            $("#signup-username").change(function() {
                var userName = $("#signup-username").val();
                var $this = $(this);
                $.post("${pageContext.request.contextPath}/existName.html",{'userName':userName},function(result){
                    if(result.success){
                        $("#error").html('');
                    }else{
                        $("#error").html('此账户已被注册');
                        $(this).focus();
                    }
                },'json')
            });
        });

        function readMess() {
            $.ajax({
                url: "${pageContext.request.contextPath}/user/customer/messageList.html",
                success: function(data){
                    if(data.success){
                        $("#modalMessage").empty();
                        var arr = data.messages;
                        for(var i=0;i<arr.length;i++){
                            var text = arr[i].message;
                            $("#modalMessage").append("<li value="+arr[i].id+">"+text+"</li>");
                        }
                    }else {
                        $("#messageModal").modal('hide');
                    }
                },
                dataType: "json"
            });
        }

        function changeState() {
            var ulArr = $("#modalMessage").children();
            var ids = [];
            for(var i= 0;i<ulArr.length;i++){
                var id = ulArr[i].value;
                ids.push(id);
            }
            var paramIds = ids.join(",");
            $.ajax({
                url: "${pageContext.request.contextPath}/user/customer/changeState.html",
                type:"post",
                data:{ids:paramIds},
                success: function(data){
                    window.location.href="${pageContext.request.contextPath}/index.html";
                },
                dataType: "json"
            });



        }
    </script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-7">
            <iframe width="700" scrolling="no" height="70" frameborder="0" allowtransparency="true"
                    src="http://i.tianqi.com/index.php?c=code&id=2&bgc=%23&bdc=%23&icon=5&num=3">
            </iframe>
        </div>
        <div class="col-md-2">
            <c:if test="${messageNUm!= null}">
                <span onclick="readMess()"  data-toggle="modal" data-target="#messageModal">
                    <p style="color: red;text-decoration:underline">还款提醒：${messageNUm}条未读</p>
                </span>
            </c:if>
        </div>

        <!-- 模态框（Modal） -->
        <div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="messModalLabel" aria-hidden="true" backdrop="false">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="messModalLabel">
                            还款提醒消息：
                        </h4>
                    </div>
                    <div class="modal-body">
                        <ul id="modalMessage">
                        </ul>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="changeState()">
                            已读
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>


        <div class="col-md-3">
            <div class="row">
                <div class="col-md-8" style="position: relative;top: 15px;">
                    <c:if test="${customerUser != null }">
                        <font size="4px">欢迎您:${customerUser.name }</font>
                    </c:if>
                </div>
                <nav class="main_nav">
                    <ul style="list-style-type: none">
                            <c:if test="${customerUser == null }">
                                <li>
                                <a style="text-decoration:none" class="cd-signin" href="#0">登录</a>
                                </li>
                            </c:if>
                            <c:if test="${customerUser != null }">
                                <a href="${pageContext.request.contextPath}/user/customer/loginout.html"><button type="button" class="btn btn-link btn-lg"><font size="4px">退出  </font></button></a>
                            </c:if>
                        <c:if test="${customerUser == null}">
                            <li>
                                <a style="text-decoration:none" class="cd-signup" href="#0">注册</a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
                <div class="cd-user-modal">
                    <div class="cd-user-modal-container">
                        <ul style="list-style-type: none" class="cd-switcher">
                            <li><a style="text-decoration:none" href="#0" style="text-decoration:none">用户登录</a></li>
                            <li><a style="text-decoration:none" href="#0">注册新用户</a></li>
                            <li><span id="error"></span></li>
                        </ul>

                        <div id="cd-login"> <!-- 登录表单 -->
                            <form class="cd-form" action="${pageContext.request.contextPath}/login.html" method="post"
                                  onsubmit="loginSubmit()">
                                <p class="fieldset">
                                    <label class="image-replace cd-username" for="signin-username">用户名</label>
                                    <input class="full-width has-padding has-border" id="signin-username" name="name"
                                           type="text" placeholder="输入用户名">
                                </p>
                                <p class="fieldset">
                                    <label class="image-replace cd-password" for="signin-password">密码</label>
                                    <input class="full-width has-padding has-border" id="signin-password"
                                           name="password" type="password" placeholder="输入密码">
                                </p>

                                <p class="fieldset">
                                    <input class="full-width2" type="submit" value="登 录">
                                </p>
                            </form>
                        </div>

                        <div id="cd-signup"> <!-- 注册表单 -->
                            <form class="cd-form" action="${pageContext.request.contextPath}/" onsubmit="registerSubmit()">
                                <p class="fieldset">
                                    <label class="image-replace cd-username" for="signup-username">用户名</label>
                                    <input class="full-width has-padding has-border" id="signup-username" type="text"
                                           placeholder="输入用户名">
                                </p>

                                <%--<p class="fieldset">
                                    <label class="image-replace cd-email" for="signup-email">邮箱</label>
                                    <input class="full-width has-padding has-border" id="signup-email" type="email" placeholder="输入mail">
                                </p>--%>

                                <p class="fieldset">
                                    <label class="image-replace cd-password" for="signup-password">密码</label>
                                    <input class="full-width has-padding has-border" id="signup-password" type="password"
                                           placeholder="输入密码">
                                </p>

                                <p class="fieldset">
                                    <label class="image-replace cd-password" for="signup-password1">密码</label>
                                    <input class="full-width has-padding has-border" id="signup-password1" type="password"
                                           placeholder="确认密码">
                                </p>

                                <p class="fieldset">
                                    <input type="checkbox" id="accept-terms">
                                    <label for="accept-terms">我已阅读并同意 <a href="#0">用户协议</a></label>
                                </p>

                                <p class="fieldset">
                                    <input class="full-width2" type="submit" value="注册新用户">
                                </p>
                            </form>
                        </div>

                        <a href="#0" class="cd-close-form">关闭</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12" style="padding: 10px;">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html"><font
                                id="sy">闲钱贷</font> </a>
                    </div>
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/user/customer/index.html"><font
                                id="yhzy">用户中心</font> </a>
                    </div>
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/user/loan/myloan.html"><font
                                id="dkgl">财富中心 </font></a>
                    </div>
                    <%-- <div class="navbar-header">
                      <a class="navbar-brand" href="${pageContext.request.contextPath}/user/qa/index.html"><font id="wdgl">问答管理</font></a>
                    </div> --%>
                </div>
            </nav>
        </div>
    </div>
</div>
<input type="hidden" id="setActiveMainTemp" value="${mainTempIndex }">
</body>
</html>

