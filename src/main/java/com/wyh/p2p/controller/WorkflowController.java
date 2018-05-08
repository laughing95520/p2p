package com.wyh.p2p.controller;

import com.wyh.p2p.entities.Admin;
import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.generator.entities.P2pLoan;
import com.wyh.p2p.service.ApplyLoanService;
import com.wyh.p2p.service.CustomerService;
import com.wyh.p2p.service.MyWorkflowService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author wangyihang
 * @date 2018/5/7 下午1:30
 **/

@Controller
@RequestMapping("/admin/workflow")
public class WorkflowController {

    @Autowired
    private MyWorkflowService workflowService;

    @Autowired
    private ApplyLoanService applyLoanService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;
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
     * 跳转到新增流程部署
     * @return
     */
    @RequestMapping("/addDeploy")
    public ModelAndView addDeploy(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("workflow/add");
        return mv;
    }


    /**
     * 任务管理首页显示
     *
     * @return
     */
    @RequestMapping("/listTask")
    public String listTask(HttpSession session, Model model)
    {
        // 1：从Session中获取当前用户名
        Admin admin = (Admin) session.getAttribute("currnetUser");
        String name = admin.getName();
        if (StringUtils.isEmpty(name))
        {
            return "redirect:/loginAdmin.jsp";
        }
        // 2：使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>
        List<Task> list = workflowService.findTaskListByName(name);
        model.addAttribute("list", list);
        return "workflow/tasklist";
    }


    /**
     * 打开任务表单
     */
    @RequestMapping("/viewTaskForm")
    public ModelAndView viewTaskForm(@RequestParam("taskId")String  taskId)
    {
        ModelAndView mv = new ModelAndView();
        //根据任务id获取P2pLoan
        String pid = workflowService.findP2pLoanBytid(taskId);
        P2pLoan p2pLoan = applyLoanService.findbyProInsId(pid);
        Customer customer = customerService.getCustomerById(p2pLoan.getCustomerId());
        mv.addObject("loan",p2pLoan);
        mv.addObject("name",customer.getName());
        mv.addObject("taskId",taskId);
        mv.setViewName("workflow/taskForm");
        return mv;
    }

    @RequestMapping("/subTask")
    public String subTask(String reason, String approvalStatue, HttpServletRequest request, String id, String taskId){
        String processInstanceId;
        String res;
        processInstanceId = taskService.createTaskQuery().
                taskId(taskId).singleResult().getProcessInstanceId();
        Map<String,Object> variables = taskService.getVariables(taskId);
        P2pLoan pLoan = (P2pLoan) variables.get("p2pLoan");
        if (pLoan.getWords() != null&&pLoan.getWords() != ""){
            res = pLoan.getWords()+"审核批注："+reason;
        }else{
            res = "审核批注："+reason;
        }
        pLoan.setWords(res);
        taskService.complete(taskId,variables);
        ProcessInstance processInstance = runtimeService
                .createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();
        //流程结束
        if (processInstance == null){
            request.setAttribute("reason",res);
            request.setAttribute("approvalStatus",approvalStatue);
            request.setAttribute("id",id);
            return "forward:/admin/application/approval.do";
        }
        //流程没结束
        else {
            return "redirect:/admin/workflow/listTask.do";
        }
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


    /**
     * 查看当前流程图（查看当前活动节点，并使用红色的框标注）
     */
    @RequestMapping("/viewCurrentImage")
    public String viewCurrentImage(@RequestParam("taskId") String taskId, Model model)
    {
        // 任务ID
        /** 一：查看流程图 */
        // 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象
        ProcessDefinition pd = workflowService.findProcessDefinitionByTaskId(taskId);
        // workflowAction_viewImage?deploymentId=<s:property value='#deploymentId'/>&imageName=<s:property
        // value='#imageName'/>
        model.addAttribute("deploymentId", pd.getDeploymentId());
        model.addAttribute("imageName", pd.getDiagramResourceName());
        /** 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中 */
        Map<String, Object> map = workflowService.findCoordingByTask(taskId);
        model.addAttribute("acs", map);
        return "workflow/image";
    }

}
