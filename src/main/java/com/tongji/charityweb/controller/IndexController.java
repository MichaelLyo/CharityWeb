package com.tongji.charityweb.controller;

import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.project.ProjectID;
import com.tongji.charityweb.repository.project.ProjectRepository;
import com.tongji.charityweb.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Project> projects = projectService.getAllProjectsOrderByFolNum();
        model.addAttribute("project1", projects.get(0));
        model.addAttribute("project2", projects.get(1));
        return "index";
    }

    @RequestMapping(value = "me",method = RequestMethod.GET)
    public String me(Model model) {
        List<Project> projects = projectService.getAllProjectsOrderByFolNum();
        model.addAttribute("project1", projects.get(0));
        model.addAttribute("project2", projects.get(1));
        return "index";
    }

    @RequestMapping(value = "caiyun")
    public String caiyun(){
        return "action/caiyun-index";
    }
    @RequestMapping(value = "chunhui")
    public String chunhui(){
        return "action/chunhui-index";
    }
    @RequestMapping(value = "cat")
    public String cat(){
        return "action/cat-index";
    }
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        //System.out.println("login method: get");
        return "login/login";
    }
    @RequestMapping(value = "regist")
    public String regist(){ return "login/regist"; }

    @RequestMapping(value = "activity",method = RequestMethod.GET)
    public String activity(String projName, String repName, String userName, Model model){
        Project project = projectRepository.findOne(new ProjectID(projName, repName, userName));
        model.addAttribute("project", project);
        return "action/activity";
    }

    @RequestMapping(value = "hotspot",method = RequestMethod.GET)
    public String hotspot(Model model){
        List<Project> projects = projectService.getAllProjectsOrderByFolNum();
        model.addAttribute("projects", projects);
        return "hotspot/hotspot-index";
    }

    @RequestMapping(value = "participate",method = RequestMethod.GET)
    public String participate(Model model){
        List<Project> projects = projectService.getAllProjectsOrderByParNum();
        model.addAttribute("projects", projects);
        return "participate/participate-index";
    }

    @RequestMapping(value = "donate")
    public String donate(){
        return "action/donate";
    }

    @RequestMapping(value = "editInfo",method = RequestMethod.GET)
    public String editInfo(){
        return "management/editInfo";
    }

    @RequestMapping(value = "addRepository")
    public String addRepository(){
        return "management/addRepository";
    }
    @RequestMapping(value = "addProject")
    public String addProject(){
        return "management/addProject";
    }
    @RequestMapping(value = "mgtRepository")
    public String mgtRepository(){
        return "management/mgtRepository";
    }
    @RequestMapping(value = "mgtProject")
    public String mgtProject(){
        return "management/mgtProject";
    }
    @RequestMapping(value = "mgtDonate")
    public String mgtDonate(){
        return "management/mgtDonate";
    }

    @RequestMapping(value = "sessionLost")
    public String lostSession(){
        return "login/sessionLost";
    }
}
