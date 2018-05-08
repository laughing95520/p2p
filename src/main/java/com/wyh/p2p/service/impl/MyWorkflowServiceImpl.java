package com.wyh.p2p.service.impl;

import com.wyh.p2p.service.MyWorkflowService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
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
}

