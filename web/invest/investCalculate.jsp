<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>闲钱贷-p2p理财平台</title>
    <link href="/favicon0.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap3/js/layer.js"></script>

    <style>
        .cal-tabs {
            border-bottom: 1px solid #dfdfdf;
            position: absolute;
            right: 0;
            top: -4px;
        }

        .calc-title {
            font-size: 20px;
            line-height: 28px;
        }

        .calc-tab.active {
            border-bottom: 2px solid #fc6700;
            color: #fc6700;
            line-height: 40px;
        }

        .calc-tab {
            cursor: pointer;
            display: inline-block;
            font-size: 16px;
            height: 42px;
            line-height: 42px;
            text-align: center;
        }

        .p-0 {
            padding: 0 !important;
        }

        .mt-15 {
            margin-top: 15px !important;
        }

        .mt-10 {
            margin-top: 10px !important;
        }

        .rel {
            position: relative;
        }

        .form-control {
            box-shadow: none;
        }

        .calc-addon {
            background: rgba(0, 0, 0, 0) none repeat scroll 0 center;
        }

        .carl-record {
            font-size: 14px;
        }

        .carl-record {
            font-size: 14px;
        }

        .calc-label {
            font-size: 14px;
            line-height: 34px;
            text-align: right;
        }

        .spanfont {
            color: #666666;
            font-family: "微软雅黑";
            font-size: 14px;
        }

        .spanje {
            color: #ff6b00;
            font-size: 24px;
        }

        .reset {
            background: #666 none repeat scroll 0 0;
            border: 0 none;
            border-radius: 3px;
            box-sizing: border-box;
            color: #fff;
            cursor: pointer;
            display: inline-block;
            font-family: "微软雅黑";
            font-size: 14px;
            height: 30px;
            line-height: 30px;
            margin-top: 30px;
            outline: 0 none;
            text-align: center;
            width: 90px;
        }

        .sub {
            background: #53a0e3 none repeat scroll 0 0;
            border: 0 none;
            border-radius: 3px;
            box-sizing: border-box;
            color: #fff;
            cursor: pointer;
            display: inline-block;
            font-family: "微软雅黑";
            font-size: 14px;
            height: 30px;
            line-height: 30px;
            margin-top: 30px;
            outline: 0 none;
            text-align: center;
            width: 90px;
        }
    </style>
</head>
<div class="row">
    <jsp:include page="/common/daohang.jsp"></jsp:include>
    <jsp:include page="/common/daohangLoan.jsp"></jsp:include>
    <div class="container">
        <div class="jumbotron">
            <h1 class="threed" align="center">闲钱贷，带你钱生钱！</h1>
        </div>
        <div style="margin-bottom:20px; width: 100%;background:transparent;background-color:rgba(255,255,255,0.5)">
            <div class="modal-body">
                <!-- 利息计算器START -->
                <div class="">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title calc-title rel">
                                投资利息计算器
                                <div class="cal-tabs">
                                    <div class="calc-tab active jCalcTab">小额投资</div>
                                </div>
                            </h3>
                        </div>
                        <div class="panel-body p-0">
                            <div class="calc-bd-tabs jCalcBdTabs">
                                <div class="cal-bd-tab jCalBdTab">
                                    <div class="row mt-15">
                                        <div class="col-md-6">
                                            <div class="col-xs-4 calc-label">投资金额</div>
                                            <div class="col-xs-8">
                                                <div class="input-group">
                                                    <input type="text" name="investMoney" id="investMoney" placeholder="${product.lowestMoney}"
                                                           class="form-control"/>
                                                    <div class="input-group-addon calc-addon">元</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-sm-6 mt-md-10  mt-sm-10  mt-xs-10 col-xs-12">
                                            <div class="col-xs-4 calc-label">年利率</div>
                                            <div class="col-xs-8">
                                                <div class="input-group">
                                                    <input id="rate" type="text" value="${product.rate}" disabled="disabled" readonly="true" class="form-control"/>
                                                    <div class="input-group-addon calc-addon">
                                                        %
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-sm-6 mt-10">
                                            <div class="col-xs-4 calc-label">投资周期</div>
                                            <div class="col-xs-8">
                                                <div class="input-group">
                                                    <input readonly="true" value="${product.timeline}" class="form-control" type="text" id="period"/>
                                                    <div class="input-group-addon calc-addon">
                                                        月
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="row mt-15">
                                        <div class="col-md-12 tc" style="margin-top:-20px;margin-bottom: 20px;">
                                            <div class="col-xs-6 tc" style="text-align: center;">
                                                <input type="button" value="计算" class="sub " id="calMoney" onclick="calMoneyFun()"/>
                                            </div>
                                            <div class="col-xs-6 tc" style="text-align: center;">
                                                <input type="button" value="立即投资" class="sub " id="btInvest"/>
                                                <span id="expect-profit"></span>
                                            </div>
                                        </div>

                                        <div class="col-md-12" style="margin-top: 10px;;">
                                            <div class="col-md-6">
                                                <span class="spanfont">投资金额： </span><span class="spanje"
                                                                                          id="tzje"></span><span
                                                    class="spanfont">元</span>
                                            </div>
                                            <div class="col-md-6">
                                                <span class="spanfont">投资收益： </span><span class="spanje"
                                                                                          id="tzsy"></span><span
                                                    class="spanfont">元</span>
                                            </div>
                                            <div class="col-md-6">
                                                <span class="spanfont">本金收益合计：</span><span class="spanje"
                                                                                           id="byhj"></span><span
                                                    class="spanfont">元</span>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                                <div class="cal-bd-tab hidden jCalBdTab">

                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function calMoneyFun() {
        var investMon = $('#investMoney').val();
        var lowMon = ${product.lowestMoney};
        var period = $("#period").val();
        var rate = $("#rate").val();
        if (!isRealNum(investMon)){
            layer.tips('投资金额输入不合法', $('#investMoney') ,{tips: [3, '#fff616'], time: 2000}
            );
            $("#investMoney").val('').focus();
            return false;
        }
        if(parseFloat(investMon) < parseFloat(lowMon) ){
            layer.tips('投资金额输入不能小于'+'${product.lowestMoney}'+'元', $('#investMoney'), {tips: [3, '#fff616'], time: 2000}
            )
            ;
            $("#investMoney").val('').focus();
            return false;
        }
        var earnings = investMon * (rate / 100 / 12) * period;
        var sum = investMon * (1+(rate / 100 / 12) * period);
        var earnFloat = earnings.toFixed(2);
        var sumFloat = sum.toFixed(2);
        $("#tzje").html(investMon);
        $("#tzsy").html(earnFloat);
        $("#byhj").html(sumFloat);
    }


    $("#btInvest").on("click",function () {
        calMoneyFun();
        var invmon = $("#tzje").html();
        var id = ${product.id};
        var url = "${pageContext.request.contextPath}/user/invest/investRecord.html";
        var per = $("#period").val();
        $.post(url,{
            invmon: invmon,
            pid: id,
            period: per,
        },function (data) {
            var data =eval('('+data+')');
            if(data.success){
                alert("投资成功！")
            }else{
                if(data.message!=null) {
                    alert(data.message + "投资失败！");
                }else {
                alert("投资失败！");
                }
            }
        })
    });

    function isRealNum(val){
        // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
        if(val === "" || val ==null){
            return false;
        }
        if(!isNaN(val)){
            return true;
        }else{
            return false;
        }
    }
</script>
<div style="text-align:center;">
</div>
<jsp:include page="/common/bottom.jsp"></jsp:include>
</html>