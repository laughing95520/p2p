package com.wyh.p2p.controller;

import com.wyh.p2p.service.MyWorkflowService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * @author wangyihang
 * @date 2018/5/7 下午1:30
 **/

@Controller
@RequestMapping("/admin/workflow")
public class WorkflowController {

    @Autowired
    private MyWorkflowService workflowService;

    /**
     * 删除部署信息
     */
    @RequestMapping("/delDeployment")
    public String delDeployment(@RequestParam("deploymentId") String deploymentId)
    {
        // 1：获取部署对象ID
        // 2：使用部署对象ID，删除流程定义
        workflowService.deleteProcessDefinitionByDeploymentId(deploymentId);
        return "redirect:deployHome.do";
    }

    /**
     * 跳转到
     * @return
     */
    @RequestMapping("/addDeploy")
    public ModelAndView addDeploy(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("workflow/add");
        return mv;
    }

    /**
     * 发布首页
     *
     * @return
     */
    @RequestMapping("/deployHome")
    public ModelAndView deployHome()
    {
        ModelAndView mv = new ModelAndView();
        // 1 查询部署对象信息，对应表（act_re_deployment)
        List<Deployment> depList = workflowService.findDeploymentList();
        // 2 查询流程定义的信息，对应表(act_re_procdef)
        List<ProcessDefinition> pdList = workflowService.findProcessDefinitionList();
        mv.addObject("depList", depList);
        mv.addObject("pdList", pdList);
        mv.setViewName("workflow/workflow");
        return mv;
    }


    /**
     * 发布流程
     *
     * @return
     */
    @RequestMapping("/newdeploy")
    public ModelAndView newdeploy(MultipartFile file, RedirectAttributes redirectAttributes)
    {
        ModelAndView modelAndView = new ModelAndView();
        if (file.isEmpty())
        {
            redirectAttributes.addFlashAttribute("message", "文件未上传");
        }
        else
        {
            // 完成部署
            workflowService.saveNewDeploye(file);
        }
        modelAndView.setViewName("redirect:/admin/workflow/deployHome.do");
        return modelAndView;
    }


    /**
     * 查看流程图
     *
     * @throws Exception
     */
    @RequestMapping("/viewImage")
    public void viewImage(@RequestParam("deploymentId")  String deploymentId,
            @RequestParam("imageName") String imageName,
            HttpServletResponse response)
            throws Exception
    {
        // 1：获取页面传递的部署对象ID和资源图片名称
        // 部署对象ID
        // 资源图片名称
        // 2：获取资源文件表（act_ge_bytearray）中资源图片输入流InputStream
        InputStream in = workflowService.findImageInputStream(deploymentId, imageName);
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = in.read(b, 0, 1024)) != -1)
        {
            response.getOutputStream().write(b, 0, len);
        }
    }


}
