<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
    <%@ include file="/workflow/head.jsp"%>
   <title>查看当前流程图</title>
  </head>
</head>
<body>
<a href="${ctx }/admin/workflow/listTask.do">返回</a>
<!-- 1.获取到规则流程图 -->
<img style="position: absolute;top: 0px;left: 20px;" src="${ctx }/admin/workflow/viewImage.do?deploymentId=${deploymentId }&imageName=${imageName}">

<!-- 2.根据当前活动的坐标，动态绘制DIV -->
<div style="position: absolute;border:1px solid red;top:${acs.y}px;left: ${acs.x+20}px;width: ${acs.width}px;height:${ acs.height}px;   "></div></body>
</body>
</html>