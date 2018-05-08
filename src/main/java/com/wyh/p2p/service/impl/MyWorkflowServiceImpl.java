package com.wyh.p2p.service.impl;

import com.wyh.p2p.service.MyWorkflowService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @author wangyihang
 * @date 2018/5/7 下午1:33
 **/
@Service
public class MyWorkflowServiceImpl implements MyWorkflowService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public String saveNewDeploye(MultipartFile file) {
        {
            String message = "";

            String fileName = file.getOriginalFilename();

            String name = fileName.substring(0,fileName.indexOf("."));

            try {
                InputStream fileInputStream = file.getInputStream();
                Deployment deployment = null;
                String extension = FilenameUtils.getExtension(fileName);
                if (extension.equals("zip") || extension.equals("bar")) {
                    ZipInputStream zip = new ZipInputStream(fileInputStream);
                    deployment = repositoryService.createDeployment()// 创建部署对象
                            .name(name)// 添加部署名称
                            .addZipInputStream(zip)
                            .deploy();// 完成部署
                } else if (extension.equals("png")) {
                    deployment = repositoryService.createDeployment()
                            .addInputStream(fileName, fileInputStream)
                            .name(name)
                            .deploy();
                } else if (fileName.indexOf("bpmn20.xml") != -1) {
                    deployment = repositoryService.createDeployment()
                            .addInputStream(fileName, fileInputStream)
                            .name(name)
                            .deploy();
                } else if (extension.equals("bpmn")) { // bpmn扩展名特殊处理，转换为bpmn20.xml
                    String baseName = FilenameUtils.getBaseName(fileName);
                    deployment = repositoryService.createDeployment()
                            .addInputStream(baseName + ".bpmn20.xml", fileInputStream)
                            .name(name)
                            .deploy();
                } else {
                    message = "不支持的文件类型：" + extension;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return message;
        }
    }

    /** 查询部署对象信息，对应表（act_re_deployment） */
    @Override
    public List<Deployment> findDeploymentList()
    {
        List<Deployment> list = repositoryService.createDeploymentQuery()// 创建部署对象查询
                .orderByDeploymenTime()
                .asc()//
                .list();
        return list;
    }

    /** 查询流程定义的信息，对应表（act_re_procdef） */
    @Override
    public List<ProcessDefinition> findProcessDefinitionList()
    {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()// 创建流程定义查询
                .orderByProcessDefinitionVersion()
                .asc()//
                .list();
        return list;
    }

    /** 使用部署对象ID和资源图片名称，获取图片的输入流 */
    @Override
    public InputStream findImageInputStream(String deploymentId, String imageName)
    {
        return repositoryService.getResourceAsStream(deploymentId, imageName);
    }

    /** 使用部署对象ID，删除流程定义 */
    @Override
    public void deleteProcessDefinitionByDeploymentId(String deploymentId)
    {
        repositoryService.deleteDeployment(deploymentId, true);
    }

    /** 2：使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task> */
    @Override
    public List<Task> findTaskListByName(String name)
    {
        List<Task> list = taskService.createTaskQuery()
                .taskCandidateOrAssigned(name)
                //.taskAssignee(name)// 指定个人任务查询
                .orderByTaskCreateTime()
                .asc()//
                .list();
        return list;
    }


    /** 根据任务id获取p2p_loan 贷款信息**/
    @Override
    public String findP2pLoanBytid(String taskId) {

        String pid = taskService.createTaskQuery()
                .taskId(taskId).singleResult().getProcessInstanceId();
        return pid;
    }

    /** 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象 */
    @Override
    public ProcessDefinition findProcessDefinitionByTaskId(String taskId)
    {
        // 使用任务ID，查询任务对象
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();
        // 获取流程定义ID
        String processDefinitionId = task.getProcessDefinitionId();
        // 查询流程定义的对象
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()// 创建流程定义查询对象，对应表act_re_procdef
                .processDefinitionId(processDefinitionId) // 使用流程定义ID查询
                .singleResult();
        return pd;
    }

    /**
     * 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中 map集合的key：表示坐标x,y,width,height
     * map集合的value：表示坐标对应的值
     */
    @Override
    public Map<String, Object> findCoordingByTask(String taskId)
    {
        // 存放坐标
        Map<String, Object> map = new HashMap<String, Object>();
        // 使用任务ID，查询任务对象
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)// 使用任务ID查询
                .singleResult();
        // 获取流程定义的ID
        String processDefinitionId = task.getProcessDefinitionId();
        // 获取流程定义的实体对象（对应.bpmn文件中的数据）
        ProcessDefinitionEntity processDefinitionEntity =
                (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processDefinitionId);
        // 流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        // 使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()// 创建流程实例查询
                .processInstanceId(processInstanceId)// 使用流程实例ID查询
                .singleResult();
        // 获取当前活动的ID
        String activityId = pi.getActivityId();
        // 获取当前活动对象
        ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);// 活动ID
        // 获取坐标
        map.put("x", activityImpl.getX());
        map.put("y", activityImpl.getY());
        map.put("width", activityImpl.getWidth());
        map.put("height", activityImpl.getHeight());
        return map;
    }
}

