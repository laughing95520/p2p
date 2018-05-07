package com.wyh.p2p.service;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

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
}
