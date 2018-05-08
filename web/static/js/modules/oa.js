$(function () {

});

/**
 * 跳转到首页
 */
function index()
{
	window.location.href = ctx + "/admin/workflow/deployHome.do";
}

/**
 * 新增流程部署
 */
function add() {
	window.location.href = ctx+"/admin/workflow/addDeploy.do";
}


/**
 * 显示流程首页
 */
function showWorkflow()
{
	window.location.href = ctx + "deployHome.do";
}

/**
 * 删除部署流程，根据流程id
 * @param deploymentId
 */
function delDeployment(deploymentId)
{
	window.location.href = ctx + "delDeployment.do?deploymentId="+deploymentId;
}

/**
 * 跳转到部署流程页面
 */
function addDeployment()
{
	window.location.href = ctx + "/workflow/addDeploy";
}

/**
 * 部署新流程
 */
function newdeploy()
{
	window.location.href = ctx + "/workflow/newdeploy";
}

/**
 * 查看流程图
 */
function viewImage(deploymentId,imageName)
{
	window.location.href = ctx + "/admin/workflow/viewImage.do?deploymentId="+deploymentId+"&imageName="+imageName;
}

/**
 *办理任务列表
 */
function listTask()
{
	window.location.href = ctx + "/admin/workflow/listTask.do";
}

/**
 *办理任务
 */
function viewTaskForm(id)
{
	window.location.href = ctx + "/admin/workflow/viewTaskForm.do?taskId="+id;
}


/**
 * 查看当前流程图
 */
function viewCurrentImage(id)
{
	window.location.href = ctx + "/admin/workflow/viewCurrentImage.do?taskId="+id;
}

