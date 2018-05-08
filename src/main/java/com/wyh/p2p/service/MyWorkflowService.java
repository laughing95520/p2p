package com.wyh.p2p.service;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author wangyihang
 * @date 2018/5/7 下午1:32
 **/
public interface MyWorkflowService {

    String saveNewDeploye(MultipartFile file);

    List<Deployment> findDeploymentList();

    List<ProcessDefinition> findProcessDefinitionList();

    InputStream findImageInputStream(String deploymentId, String imageName);

    void deleteProcessDefinitionByDeploymentId(String deploymentId);

    List<Task> findTaskListByName(String name);

    String findP2pLoanBytid(String taskId);

    ProcessDefinition findProcessDefinitionByTaskId(String taskId);

    Map<String,Object> findCoordingByTask(String taskId);
}
