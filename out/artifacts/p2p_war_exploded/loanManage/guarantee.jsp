<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
    <title>闲钱贷-p2p理财平台</title>
    <style type="text/css">
    </style>
    <script type="text/javascript">


        function idcard(type, obj) {
            var formData = new FormData();
            var btnid = '#' + obj.id;
            var hidid = 0;
            if (btnid != '#sfzzmtj' && btnid != '#sfzbmtj') {
                var hid = $(btnid).next();
                hidid = '#' + hid.attr("id");
                hidid = $(hidid).val();
            }
            formData.append("fid", hidid);
            var file = $(btnid).prev();
            var fileid = '#' + file.attr("id");
            var img = $(fileid).prev();
            var imgid = '#' + img.attr("id");
            formData.append("file", $(fileid)[0].files[0]);
            formData.append("type", type);
            $.ajax({
                url: "${pageContext.request.contextPath}/user/loan/uploadwyh.html",
                type: "post",
                data: formData,
                processData: false,
                contentType: false,
                success: function (data) {
                    var data = eval('(' + data + ')');
                    var src = "${pageContext.request.contextPath}/" + data.imagePath;
                    $(imgid).attr('src', src);
                }
            });
        }

        function change(){
            $("#typeSelect option[value=${type}]").attr("selected",false);
        }

        function upload() {
            var type = $('#typeSelect').val();
            var formData = new FormData();
            formData.append("file", $('#zl')[0].files[0]);
            formData.append("type", type);
            $.ajax({
                url: "${pageContext.request.contextPath}/user/loan/uploadwyh.html",
                type: "post",
                data: formData,
                processData: false,
                contentType: false,
                success: function (data) {
                    var data = eval('(' + data + ')');
                    var dataType = data.type;
                    if (data.error == "error") {
                        alert("上传图片出错，请重试");
                        return false;
                    }
                    if (dataType != null){
                        switch(parseInt(dataType)){
                            case 1:
                                var html = '<option value=“1”>收入证明</option>';
                                $("typeSelect").append(html);
                                break;
                            case 2:
                                var html = '<option value=“2”>房产证</option>';
                                $("typeSelect").append(html);
                                break;
                            case 3:
                                var html = '<option value=“3”>工资条</option>';
                                $("typeSelect").append(html);
                                break;
                            default:
                                break;
                        }
                    }
                    var src = "${pageContext.request.contextPath}/" + data.imagePath;
                    $('#zlimg').attr('src', src);
                }
            });
        }
    </script>
</head>
<body>
<jsp:include page="/common/daohang.jsp"></jsp:include>

<jsp:include page="/common/daohangLoan.jsp"></jsp:include>

<hr>

<div class="container">

    <div class="jumbotron">
        <div align="center">身份证资料</div>
        <hr>
        <div class="row">
            <div class="col-md-3 col-md-offset-2">
                <img src="${pageContext.request.contextPath}/${cardFront}" alt="身份证正面"
                     class="img-rounded" width="200px" height="100px" id='imgsfzzm'>
                <input type="file" id='sfzzm'>
                <button type="submit" class="btn btn-success btn" style="width: 200px" onclick="idcard(6,this)"
                        id='sfzzmtj'>提交
                </button>
            </div>
            <div class="col-md-3 col-md-offset-2">
                <img src="${pageContext.request.contextPath}/${cardBack}" alt="身份证背面" class="img-rounded"
                     width="200px" height="100px" id='imgsfzbm'>
                <input type="file" id='sfzbm'>
                <button type="submit" class="btn btn-success btn" style="width: 200px" onclick='idcard(7,this)'
                        id='sfzbmtj'>提交
                </button>
            </div>
        </div>
    </div>

    <div class="jumbotron">
        <div align="center">
                <select style="margin-top:0px;width:200px;" name="hkfs" id="typeSelect"
                        class="form-control" onchange="change()">
                    <option value="1">收入证明</option>
                    <option value="2">房产证</option>
                    <option value="3">工资条</option>
                </select>
        </div>
        <script language="javascript" type="text/javascript">
            $(document).ready(function(){
                $("#typeSelect option[value=${type}]").attr("selected",true);
            });
        </script>

        <hr>
        <div class="row">
            <div class="col-md-3 col-md-offset-2">
                <img src="${pageContext.request.contextPath}/${imgPath}" alt="贷款担保资料" class="img-rounded" width="200px"
                     height="100px" id='zlimg'>
                <input type="file" id='zl'>
                <button type="submit" class="btn btn-success btn" style="width: 200px" onclick='upload()' id='zlsubmit'>
                    提交
                </button>
            </div>
        </div>

    </div>
</div>

<jsp:include page="/common/bottom.jsp"></jsp:include>
</body>
</html>