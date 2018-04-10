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
	<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/layer.css"/>--%>

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
			<h1 class="threed" align="center">想贷就贷，无需等待</h1>
		</div>
		<div style="margin-bottom:20px; width: 100%;height: 500px;background:transparent;background-color:rgba(255,255,255,0.5)">

			<div class="modal-body">
				<!-- 贷款利息计算器START -->
				<div class="">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title calc-title rel">
								贷款利息计算器
								<div class="cal-tabs">
									<div class="calc-tab active jCalcTab">小额贷款</div>
								</div>
							</h3>
						</div>
						<div class="panel-body p-0">
							<div class="calc-bd-tabs jCalcBdTabs">
								<div class="cal-bd-tab jCalBdTab">
									<div class="row mt-15">
										<div class="col-md-6">
											<div class="col-xs-4 calc-label">贷款金额</div>
											<div class="col-xs-8">
												<div class="input-group">
													<!--input type="text" onblur="inputblur(this);" onkeypress="inputkeypress(this);" onkeyup="inputkeyup(this);" id="bidAmount" class="form-control"-->
													<input type="text" name="jkje" id="jkje" placeholder="借款金额"
														   class="form-control"/>
													<div class="input-group-addon calc-addon">元</div>
												</div>
											</div>
										</div>
										<div class="col-md-6 col-sm-6 mt-md-10  mt-sm-10  mt-xs-10 col-xs-12">
											<div class="col-xs-4 calc-label">年利率</div>
											<div class="col-xs-8">
												<div class="input-group">
													<!--
													<input type="text" onblur="inputblur(this);" onkeypress="inputkeypress(this);" onkeyup="inputkeyup(this);" id="bidRate" class="form-control">
                                                    -->

													<%--动态年利率
													value="<fmt:formatNumber value="${loanItem.rate *100} " pattern="0.00"/>"--%>

													<input type="text" name="nlv" id="nlv" class="form-control" disabled="disabled"
														   value="<fmt:formatNumber value="5" pattern="0.00"/>" />
													<div class="input-group-addon calc-addon">%</div>
												</div>
											</div>
										</div>
										<div class="col-md-6 col-sm-6 mt-10">
											<div class="col-xs-4 calc-label">借款期限</div>
											<div class="col-xs-8">
												<div class="input-group">
													<input type="text" name="jkqx" id="jkqx" placeholder="期限"
														   class="form-control"/>
													<div class="input-group-addon calc-addon">月
													</div>

												</div>
											</div>
										</div>
										<div class="col-md-6 col-sm-6 mt-10">
											<div class="col-xs-4 calc-label">还款方式</div>
											<div style="width:200px;" class="col-xs-8">
												<!--	<select style="" name="bidWay" id="bidWay">
                                                        <option value="按月等额本息">按月等额本息</option>
                                                        <option value="按月付息到期还本">按月付息到期还本</option>
                                                    </select>-->
												<select style="margin-top:0px;width:200px;" name="hkfs" id="hkfs"
														class="form-control">
													<option value="1">按月付息，到期还本</option>
													<option value="2">一次性还本付息</option>
												</select>
											</div>

										</div>
									</div>
									<div class="row mt-15">
										<div class="col-md-12 tc" style="margin-top:-20px;margin-bottom: 20px;">
											<div class="col-xs-6 tc" style="text-align: center;">
												<input type="button" value="计算" class="sub " id="btn-profit"/>
											</div>
											<div class="col-xs-6 tc" style="text-align: center;">
												<input type="button" value="立即贷款" class="sub " id="btn-ljdk"/>
												<span id="expect-profit"></span>
											</div>
										</div>

										<div class="col-md-12" style="margin-top: 10px;;">
											<div class="col-md-6">
												<span class="spanfont">贷款金额： </span><span class="spanje"
																						  id="dkje"></span><span
													class="spanfont">元</span>
											</div>
											<div class="col-md-6">
												<span class="spanfont">贷款期限：</span><span class="spanje"
																						 id="dkqx"></span><span
													class="spanfont">个月</span>
											</div>
											<div class="col-md-6">
												<span class="spanfont">利息： </span><span class="spanje"
																						id="lx"></span><span
													class="spanfont">元</span>
											</div>
											<div class="col-md-6">
												<span class="spanfont">本息合计：</span><span class="spanje"
																						 id="bxhj"></span><span
													class="spanfont">元</span>
											</div>
										</div>

									</div>

								</div>
								<div class="cal-bd-tab hidden jCalBdTab">

								</div>
							</div>

							<div class="calc-tps mt-20 text-center"><strong></strong></div>
							<br/>
							<div class="table-responsive"></div>
							<div id="bxmx">
								<table class="table table-striped table-hover carl-record" id="repayplan">
									<tbody>
									<tr style="height: 40px;" align="center">
										<th width="12%" style="text-align: center;">期数</th>
										<th width="22%" style="text-align: center;">每月还款本息</th>
										<th width="22%" style="text-align: center;">应还本金</th>
										<th width="22%" style="text-align: center;">应还利息</th>
										<th width="22%" style="text-align: center;">剩余回款本息</th>
									</tr>
									</tbody>
									<!--</tbody>
                                            <tbody id="tBodyId" style="display: table-row-group;">


                                            </tbody>-->
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>

    //一次性还本付息 设置
    $(".calc-addon").on("click", 'input[name="nyy"]', function () {
        //alert($(this).val());
        if ($(this).val() == 2) {
            $('#hkfs').val(2);
        }
    });

    //还款方式
    $("#hkfs").change(function () {
        var val = $(this).val();
        var dw = $('input[name="nyy"]:checked').val();
        /* alert($(this).val()+"1111111111111");
         alert(dw);*/
        if (dw == 2 && val !== 1) {
            layer.msg("单位是天,只能有一次还本付息！", {time: 2000, offset: ['60px']});
            $('#hkfs').val(2);
        }
    });

    //重置
    $("#btn-reset").on("click", function () {
        var resultList = $("#bxmx");
        var $table = $("#repayplan");

        resultList.fadeOut(0, function () {
            $table.find("tr:gt(0)").remove();
            $('input[name="nyy"]').eq(0).click();
            $("#jkje,#jkqx,#nlv").val("");
            $("#dkje,#dkqx,#lx,#bxhj").html("");
        });

    });

    $("#btn-ljdk").on("click", function () {
        var money = $('#jkje').val();
        var loanMonth = $('#jkqx').val();
        var rate = $('#nlv').val();
        var repayWay = $('#hkfs').val();
        var interest = $('#lx').html();
        if (interest == ""||interest == null){
            alert("请先计算利息，谢谢！");
            return false;
		}
        $.post("${pageContext.request.contextPath}/user/loan/applynow.html", {
            money: money,
            loanMonth: loanMonth,
			rate: rate,
			repayWay: repayWay,
			interest: interest,
        }, function (data) {
            var data = eval('(' + data + ')');
            if (data.success == 0) {
                alert("贷款申请成功");
                window.location.href = "${pageContext.request.contextPath}/user/loan/myloan.html";
            } else if (data.success == 1) {
                alert("请先完善贷款资料");
                window.location.href = "${pageContext.request.contextPath}/user/loan/loaninfo.html";
            } else if (data.success == 2) {
                alert("请先完善个人资料");
                window.location.href = "${pageContext.request.contextPath}/user/customer/personinfo.html";
            }
        });

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


    $("#btn-profit").on("click", function () {

        var jkje = $('#jkje').val();
        var nlv = $('#nlv').val();
        var jkqx = $('#jkqx').val();
        var type = $("#hkfs").val();
        var $table = $("#repayplan");
        var resultLists = $("#bxmx");
        var loadtype = $('input[name="nyy"]:checked').val();
        //alert(jkje);
        if (jkje >100000) {
            layer.tips('贷款金额输入不能大于10万'+
            '元', $('#jkje'), {tips: [3, '#fff616'], time: 2000}
        )
            ;
            $("#jkje").val('').focus();
            return false;
        }
        if (jkje <500) {
            layer.tips('贷款金额输入不能小于500'+
            '元', $('#jkje'), {tips: [2, '#fff616'], time: 2000}
        )
            ;
            $("#jkje").val('').focus();
            return false;
        }

        if (!isRealNum(jkje)){
            layer.tips('贷款金额输入非法', $('#jkje'), {tips: [3, '#fff616'], time: 2000}
            )
            ;
            $("#jkje").val('').focus();
            return false;
		}

        if (nlv <= 0) {
            layer.tips('年利率输入不正确！', $('#nlv'), {tips: [3, '#fff616'], time: 2000});
            $("#nlv").val('').focus();
            return false;
        }
        if (parseFloat(jkqx) <= 0) {
            layer.tips('贷款期限输入不正确！', $('#jkqx'), {tips: [3, '#fff616'], time: 2000});
            $("#jkqx").val('').focus();
            return false;
        }

        if (parseInt(jkqx) >24) {
            layer.tips('期限不能超过24'+
            '个月！', $('#jkqx'), {tips: [3, '#fff616'], time: 2000}
        )
            ;
            $("#jkqx").val('').focus();
            return false;
        }

        if (parseInt(jkqx) <1) {
            layer.tips('期限至少一'+
            '个月！', $('#jkqx'), {tips: [3, '#fff616'], time: 2000}
        )
            ;
            $("#jkqx").val('').focus();
            return false;
        }

        if (parseFloat(jkqx) !== parseInt(jkqx)) {
            layer.tips('期限不能为小数！', $('#jkqx'), {tips: [3,'#fff616'], time: 2000});
            $("#jkqx").val('').focus();
            return false;
        }


        resultLists.fadeOut(0, function () {
            $table.find('tr:gt(0)').remove();
            $("#dkje,#dkqx,#lx,#bxhj").html("");
        });


        switch (parseInt(type)) {
            /*  一次还本付息法的计算公式如下： 　到期一次还本付息额=贷款本金×[1+年利率（%）] （贷款期为一年）
            到期一次还本付息额=贷款本金×[1+月利率（‰）×贷款期（月）] （贷款期不到一年）
              其中：月利率=年利率÷12
           如以住房公积金贷款1万元，贷款期为7个月，则到期一次还本付息额为：
               10000元×[1+（4.14%÷12月）×7月] = 10241.5元 */
            case 2:
                var sum = jkje * (1 + (nlv / 100 / 12) * jkqx); //到期一次还本付息额
                var lx = jkje * (nlv / 100 / 12) * jkqx;
                var sumfinal = sum.toFixed(2);
                resultLists.fadeOut(0);
                //贷款金额
                $("#dkje").html(jkje);
                //贷款期限
                if (loadtype == 1) {
                    $("#dkqx").html(jkqx);
                } else {
                    $("#dkqx").html(jkqx);
                }
                //本息合计
                $("#bxhj").html(sumfinal);
                //利息
                $("#lx").html(parseFloat(lx).toFixed(2));
                break;
            /*
            预设金额：10000元，年化利率12％.还款计算公式：
            首月还款利息为：10000*(12％/365)*（放款当日到首月还款日的实际天数）；
            除去首月和最后一个月，
            中间月份的还款计算方式为：10000*(12％/365)*（每月实际天数）=实际还款利息；
            最后一月的还款利息为10000*(12％/365)*（上个还款日到指定还款截止日期的实际天数），
            此外，最后一个月还需支付本金，所以，最后一个月的还款计算方式为：还款利息+本金（10000元）
            */
            case 1:
                //利息总和
                var lxSum = jkje * nlv / 100 / 12 * jkqx;
                //每月还款利息
                var everyMonth = lxSum / jkqx;
                //最后一个月应还钱数
                var lastSum = parseFloat(jkje) + parseFloat(everyMonth);
                //本息合计
                var finalSum = parseFloat(jkje) + parseFloat(everyMonth * jkqx);

                var objtitle = $("");

                if (loadtype == 1) {
                    $("#dkqx").html(parseFloat(jkqx).toFixed(0));
                } else {
                    $("#dkqx").html(parseFloat(jkqx).toFixed(1));
                }
                $("#dkje").html(parseFloat(jkje).toFixed(2));
                $("#bxhj").text(parseFloat(finalSum).toFixed(2));
                $("#lx").text(parseFloat(lxSum).toFixed(2));
                resultLists.fadeIn(0);

                for (var i = 1; i < jkqx; i++) {
                    var objb = $(
                        "<tr style='height: 40px;'>"
                        + " <td align='center' >"
                        + i
                        + "</td>"
                        + " <td align='center' >"
                        + parseFloat(everyMonth).toFixed(2)
                        + "元</td>"
                        + " <td align='center' >0元</td>"
                        + " <td align='center' >"
                        + parseFloat(everyMonth).toFixed(2)
                        + "元</td>"
                        + " <td align='center' >"
                        + ((parseFloat(finalSum)) - parseFloat(everyMonth).toFixed(2)
                        * i).toFixed(2)
                        + "元</td></tr>");
                    $("#repayplan").append(objb);
                }
                var objb =
                    " <tr style='height:40px'>"
                    + " <td align='center'>"
                    + jkqx
                    + "</td>"
                    + " <td align='center'>"
                    + parseFloat(lastSum).toFixed(2)
                    + "元</td>"
                    + " <td align='center'>"
                    + parseFloat(jkje).toFixed(2)
                    + "元</td>"
                    + " <td align='center'>"
                    + parseFloat(everyMonth).toFixed(2)
                    + "元</td>"
                    + " <td align='center'>"
                    + 0
                    + "元</td></tr>";
                $("#repayplan").append(objb);
                break;
        }
    });


    function invest_calc(jkje, nlv, jkqx) {
        var jkje = parseInt($('#jkje').val());
        var nlv = parseInt($('#nlv').val());
        var jkqx = parseInt($('#jkqx').val());
        var Deadline = parseInt(jkqx);
        var hkfs = parseInt($("#hkfs").val());
        var datalist = new Array(jkqx);

        if (jkje) {
            if (jkqx) {
                if (nlv) {
                    var tablett = $("tablett");

                    datalist = Calculate(jkje, nlv, jkqx);
                    $("#dkje").html(jkje);
                    if (jkqx > 1) {
                        $("#dkqx").html(jkqx);
                    } else {
                        $("#dkqx").html(jkqx.toFixed(1));
                    }
                    $("#dkje").html(jkje.toFixed(2));

                    for (var i = 0; i < Deadline; i++) {
                        var newTr = repayplan.insertRow(-1);
                        var newTd0 = newTr.insertCell(-1);
                        var newTd1 = newTr.insertCell(-1);
                        var newTd2 = newTr.insertCell(-1);
                        var newTd3 = newTr.insertCell(-1);
                        var newTd4 = newTr.insertCell(-1);

                        //这里修改与页面对应值
                        newTd0.innerHTML = datalist[i][0] + "";
                        newTd1.innerHTML = datalist[i][1] + "元";
                        newTd2.innerHTML = datalist[i][3] + "元";
                        newTd3.innerHTML = datalist[i][2] + "元";
                        newTd4.innerHTML = datalist[i][4] + "元";
                    }
                }
            }
        }
    }

    function Calculate(jkje, nlv, jkqx) {
        var Deadline = parseInt(jkqx);
        var Amount = parseFloat(jkje);
        var Rate = parseFloat(nlv) / 1200;
        var datalist = new Array(Deadline);
        var i;
        var a; // 偿还本息
        var b; // 偿还利息
        var c; // 偿还本金
        var TotalRate = (Amount * Deadline * Rate * Math.pow((1 + Rate), Deadline)) / (Math.pow((1 + Rate), Deadline) - 1) - Amount;
        //alert(TotalRate+"Amount!!!!!!!!!");
        var TotalRepay = TotalRate + Amount;//本金+利息
        var d = Amount + TotalRate; // 剩余本金
        //alert(d + "ddddddddddd");
        TotalRate = Math.round(TotalRate * 100) / 100;// 支付总利息
        //alert(TotalRate + "支付总利息");
        TotalRepay = Math.round(TotalRepay * 100) / 100;
        //alert(TotalRepay + "TotalRepay");
        a = TotalRepay / Deadline;
        //alert(a +" TotalRepay / Deadline;")
        a = Math.round(a * 100) / 100;// 支付总还款额


        for (i = 1; i <= Deadline; i++) {
            b = (Amount * Rate * (Math.pow((1 + Rate), Deadline) - Math.pow((1 + Rate), (i - 1)))) / (Math.pow((1 + Rate), Deadline) - 1);
            //alert(b + "bbbbbbbbbb");
            b = Math.round(b * 100) / 100;
            c = a - b;
            c = Math.round(c * 100) / 100;
            d = d - a;
            d = Math.round(d * 100) / 100;
            if (i == Deadline) {
                c = c + d;
                b = b - d;
                c = Math.round(c * 100) / 100;
                b = Math.round(b * 100) / 100;
                d = 0;
            }
            ;
            var tempList = new Array([5]);
            tempList[0] = i;// 期数
            tempList[1] = a.toFixed(2);// 偿还本息
            tempList[2] = b.toFixed(2);// 偿还利息
            tempList[3] = c.toFixed(2);// 偿还本金
            tempList[4] = d.toFixed(2);// 剩余本金
            datalist[i - 1] = tempList;
        }
        lab_totalmomey = (Math.round((Amount + TotalRate) * 100) / 100).toFixed(2);
        $("#lx").html(TotalRate);
        $("#bxhj").html(lab_totalmomey);
        return datalist;
    }

    function debx() {
        var jkje = parseInt(10000);
        var nlv = parseInt(0.12);
        var jkqx = parseInt(12);
        var ylv = nlv / 100 / 12;
        var rest = jkje * ylv * Math.pow(1 + ylv, jkqx) / (Math.pow(1 + ylv, jkqx) - 1) * jkqx;
        return rest;
    }


</script>
<div style="text-align:center;">
</div>
</div>
</div>
</html>