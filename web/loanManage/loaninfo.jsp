<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/favicon0.ico" rel="SHORTCUT ICON">
<title>闲钱贷-p2p理财平台</title>
<style type="text/css">
</style>
<script type="text/javascript">

	function idcard(type,obj){
		var formData = new FormData();
		var btnid = '#' + obj.id;
		var hidid = 0;
		if(btnid != '#sfzzmtj' && btnid != '#sfzbmtj'){
			var hid = $(btnid).next();
			hidid = '#' + hid.attr("id"); 
			hidid = $(hidid).val();
		}
		formData.append("fid",hidid);
		var file = $(btnid).prev();
		var fileid = '#' + file.attr("id"); 
		var img = $(fileid).prev();
		var imgid = '#' + img.attr("id");
		formData.append("file",$(fileid)[0].files[0]);
		formData.append("type",type);
		$.ajax({
            url:"${pageContext.request.contextPath}/user/loan/upload.html",
            type:"post",
            data:formData,
            processData:false,
            contentType:false,
            success:function(data){
            	var data = eval('(' + data + ')'); 
    			var src = "${pageContext.request.contextPath}/" + data.imagePath; 
    			$(imgid).attr('src',src); 
            }
		}); 
	}
	function addImg(addid,name,imgid,fileid,tjid,fid,type){
		addid = '#' + addid;
		var length = $(addid).find('div').length - 3;
		var count = 0;
		if(length != -1){
			var div = $(addid).find('div').eq(length);
			var imgcommonid = $(div).find('img').eq(0)[0].id;
			count = imgcommonid.substring(5,imgcommonid.length);
		}
		count = parseInt(count) + 1;
		imgid = imgid + count;
		fileid = fileid + count;
		tjid = tjid + count;
		fid = fid + count;
		if(length == -1){
			length = 0;
			$(addid).find('div').eq(length).before("<div class='col-md-3' style='margin-bottom: 40px;'><img src='' alt='"
					+ name 
					+ "'class='img-rounded' width='200px' height='100px' id="
					+ imgid
					+">"
					+ "<input type='file' id="
					+ fileid
					+">"
				 	+ "<button type='submit' class='btn btn-success btn' style='width: 200px' onclick='idcard("+type+",this)' id="
				 	+ tjid
				 	+">提交</button>"
				 	+ "<input type='hidden' value='0' id="
				 	+ fid
				 	+">"
			 		+ "</div>");
		}else{
			$(addid).find('div').eq(length).after("<div class='col-md-3' style='margin-bottom: 40px;'><img src='' alt='"
					+ name 
					+ "'class='img-rounded' width='200px' height='100px' id="
					+ imgid
					+">"
					+ "<input type='file' id="
					+ fileid
					+">"
				 	+ "<button type='submit' class='btn btn-success btn' style='width: 200px' onclick='idcard("+type+",this)' id="
				 	+ tjid
				 	+">提交</button>"
				 	+ "<input type='hidden' value='0' id="
				 	+ fid
				 	+">"
			 		+ "</div>");
		}
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
					     <img src="${pageContext.request.contextPath}/${customerLoan.idCardPositive}" alt="身份证正面" class="img-rounded" width="200px" height="100px" id='imgsfzzm'>
						 <input type="file" id='sfzzm'>
						 <button type="submit" class="btn btn-success btn" style="width: 200px" onclick="idcard(6,this)" id='sfzzmtj'>提交</button>
				</div>
				<div class="col-md-3 col-md-offset-2">
						 <img src="${pageContext.request.contextPath}/${customerLoan.idCardBack}" alt="身份证背面" class="img-rounded" width="200px" height="100px" id='imgsfzbm'>
						 <input type="file" id='sfzbm'>
						 <button type="submit" class="btn btn-success btn" style="width: 200px" onclick='idcard(7,this)' id='sfzbmtj'>提交</button>
				</div>
			</div>
		</div>
		
		<div class="jumbotron">
			<div align="center">收入证明</div>
			<hr>
			<div class="row" id='addsrzm'>
				
				<c:forEach items ="${loanIncomeList}" var = "income" varStatus="status">
					 <div class="col-md-3" style="margin-bottom: 40px;">
							 <img src="${pageContext.request.contextPath}/${income.path}" alt="收入证明" class="img-rounded" width="200px" height="100px" id='imgsr${status.count}'>
							 <input type="file" id='srzm${status.count}'>
							 <button type="submit" class="btn btn-success btn" style="width: 200px" onclick="idcard(1,this)" id='srzmtj${status.count}'>提交</button>
							 <input type="hidden" value="${income.id }" id='srzmfid${status.count}'>
					 </div>
				</c:forEach>
				
				<div class="col-md-3">
					<div class="btn" style="border:1px dashed #F00;">
				        <lable onclick="addImg('addsrzm','收入证明','imgsr','srzm','srzmtj','srzmfid',1)">
				            <img style="width:80%;height:100%" src="${pageContext.request.contextPath}/static/images/jiahao.png" />
				        </lable>
			    	</div>
				</div>
			</div>
		</div>
		<div class="jumbotron">
			<div align="center">房产证</div>
			<hr>
			<div class="row" id='addscz'>
				<c:forEach items ="${loanRoomList}" var = "room" varStatus="status">
					 <div class="col-md-3" style="margin-bottom: 40px;">
							 <img src="${pageContext.request.contextPath}/${room.path}" alt="房产证" class="img-rounded" width="200px" height="100px" id='imgfc${status.count}'>
							 <input type="file" id='fcz${status.count}'>
							 <button type="submit" class="btn btn-success btn" style="width: 200px" onclick="idcard(2,this)" id='fcztj${status.count}'>提交</button>
							 <input type="hidden" value="${room.id }" id='fczfid${status.count}'>
					 </div>
				</c:forEach>
				
				<div class="col-md-3">
					<div class="btn" style="border:1px dashed #F00;">
				        <lable onclick="addImg('addscz','房产证','imgfc','fcz','fcztj','fczfid',2)">
				            <img style="width:80%;height:100%" src="${pageContext.request.contextPath}/static/images/jiahao.png" />
				        </lable>
			    	</div>
				</div>
			</div>
		</div>
		
		<div class="jumbotron">
			<div align="center">工作证</div>
			<hr>
			<div class="row" id='addgzz'>
				<c:forEach items ="${loanJobList}" var = "job" varStatus="status">
					<div class="col-md-3" style="margin-bottom: 40px;">
							 <img src="${pageContext.request.contextPath}/${job.path}" alt="工作证" class="img-rounded" width="200px" height="100px" id='imggz${status.count}'>
							 <input type="file" id='gzz${status.count}'>
							 <button type="submit" class="btn btn-success btn" style="width: 200px" onclick="idcard(4,this)" id='gzztj${status.count}'>提交</button> 
							 <input type="hidden" value="${job.id }" id='gzzfid${status.count}'>
					 </div>
				</c:forEach>
				
				<div class="col-md-3">
					<div class="btn" style="border:1px dashed #F00;">
				        <lable onclick="addImg('addgzz','工作证','imggz','gzz','gzztj','gzzfid',4)">
				            <img style="width:80%;height:100%" src="${pageContext.request.contextPath}/static/images/jiahao.png" />
				        </lable>
			    	</div>
				</div>
			</div>
		</div>
		
		<div class="jumbotron">
			<div align="center">信用报告</div>
			<hr>
			<div class="row" id='addxybg'>
				<c:forEach items ="${loanCreditList}" var = "credit" varStatus="status">
					<div class="col-md-3" style="margin-bottom: 40px;">
	  				 	<img src="${pageContext.request.contextPath}/${credit.path}" alt="信用报告" class="img-rounded" width="200px" height="100px" id='imgxy${status.count}'>
						 <input type="file" id='xybg${status.count}'>
						 <button type="submit" class="btn btn-success btn" style="width: 200px" onclick="idcard(3,this)" id='xybgtj${status.count}'>提交</button> 
						<input type="hidden" value="${credit.id }" id='xybgfid${status.count}'>
					 </div>
				</c:forEach>
				
				<div class="col-md-3">
					<div class="btn" style="border:1px dashed #F00;">
				        <lable onclick="addImg('addxybg','信用报告','imgxy','xybg','xybgtj','xybgfid',3)">
				            <img style="width:80%;height:100%" src="${pageContext.request.contextPath}/static/images/jiahao.png" />
				        </lable>
			    	</div>
				</div>
			</div>
		</div>
		
		<div class="jumbotron">
			<div align="center">工资条</div>
			<hr>
			<div class="row" id='addgzt'>
				<c:forEach items ="${loanSalaryList}" var = "salary" varStatus="status">
					<div class="col-md-3" style="margin-bottom: 40px;">
					 	 	<img src="${pageContext.request.contextPath}/${salary.path}" alt="工资条" class="img-rounded" width="200px" height="100px" id='imggt${status.count}'>
						 <input type="file" id='gzt${status.count}'>
						 <button type="submit" class="btn btn-success btn" style="width: 200px" onclick="idcard(5,this)" id='gzttj${status.count}'>提交</button>
						 <input type="hidden" value="${salary.id }" id='gztfid${status.count}'>
					 </div>
				</c:forEach>
				
				<div class="col-md-3">
					<div class="btn" style="border:1px dashed #F00;">
				        <lable onclick="addImg('addgzt','工资条','imggt','gzt','gzttj','gztfid',5)">
				            <img style="width:80%;height:100%" src="${pageContext.request.contextPath}/static/images/jiahao.png" />
				        </lable>
			    	</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="/common/bottom.jsp"></jsp:include>
</body>
</html>