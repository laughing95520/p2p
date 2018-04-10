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
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap-datetimepicker.fr.js"></script>


    <!-- loginlib -->
    <link rel="stylesheet" type="text/css" href="/loginlib/style.css"/>
    <script src="https://cdn.bootcss.com/jquery/1.12.1/jquery.min.js"></script>
    <script src="/loginlib/main.js"></script>
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
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-9">
            <iframe width="700" scrolling="no" height="70" frameborder="0" allowtransparency="true"
                    src="http://i.tianqi.com/index.php?c=code&id=2&bgc=%23&bdc=%23&icon=5&num=3">
            </iframe>
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
                <%--<c:if test="${customerUser == null }">
                    <a href="${pageContext.request.contextPath}/login.jsp" target="_blank" style="text-decoration: none;"><button type="button" class="btn btn-link btn-lg"><font id="setActive" size="4px">登录  </font></button></a>
                </c:if>
                <c:if test="${customerUser != null }">
                    <a href="${pageContext.request.contextPath}/user/customer/loginout.html" target="_blank"><button type="button" class="btn btn-link btn-lg"><font size="4px">退出  </font></button></a>
                </c:if>
                <a href="${pageContext.request.contextPath}/register.jsp" target="_blank"><button type="button" class="btn btn-link btn-lg"><font size="4px">注册</font></button></a>
          --%>
                <div class="cd-user-modal">
                    <div class="cd-user-modal-container">
                        <ul style="list-style-type: none" class="cd-switcher">
                            <li><a style="text-decoration:none" href="#0" style="text-decoration:none">用户登录</a></li>
                            <li><a style="text-decoration:none" href="#0">注册新用户</a></li>
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
                            <form class="cd-form">
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
                                    <input class="full-width has-padding has-border" id="signup-password" type="text"
                                           placeholder="输入密码">
                                </p>

                                <p class="fieldset">
                                    <label class="image-replace cd-password" for="signup-password">密码</label>
                                    <input class="full-width has-padding has-border" id="signup-password1" type="text"
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
