package com.tongji.charityweb.controller;

import com.tongji.charityweb.model.project.Participate;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.project.ProjectFollower;
import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.service.DonateService;
import com.tongji.charityweb.service.ProjectService;
import com.tongji.charityweb.service.RepositoryService;
import com.tongji.charityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Project> projects = projectService.getAllProjectsOrderByFolNum();
        //Project project = projectService.getTopByFollowerNum();
        model.addAttribute("projects", projects);
        //model.addAttribute("topProject", project);
        return "index";
    }

    @RequestMapping(value = "me",method = RequestMethod.GET)
    public String me(Model model) {
        List<Project> projects = projectService.getAllProjectsOrderByFolNum();
        model.addAttribute("projects", projects);
        return "index";
    }

    @RequestMapping(value = "caiyun", method = RequestMethod.GET)
    public String caiyun(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam(value = "size", defaultValue = "3")int size){
        Page<Repository> repositories = repositoryService.getRepPageByUserName("彩云支南",page,size);
        modelMap.addAttribute("projects", repositories);
        return "action/caiyun-index";
    }

    @RequestMapping(value = "chunhui", method = RequestMethod.GET)
    public String chunhui(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam(value = "size", defaultValue = "3")int size){
        Page<Repository> repositories = repositoryService.getRepPageByUserName("春晖之声",page,size);
        modelMap.addAttribute("projects", repositories);
        return "action/chunhui-index";
    }

    @RequestMapping(value = "cat", method = RequestMethod.GET)
    public String cat(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam(value = "size", defaultValue = "3")int size){
        Page<Repository> repositories = repositoryService.getRepPageByUserName("宠物之家",page,size);
        modelMap.addAttribute("projects", repositories);
        return "action/cat-index";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login/login";
    }
    @RequestMapping(value = "regist")
    public String regist(){ return "login/regist"; }

    @RequestMapping(value = "activity",method = {RequestMethod.GET,RequestMethod.POST})
    public String activity(String projName, String repName, String userName, Model model, HttpSession session){
        System.out.println("here");
        System.out.println(projName);
        System.out.println(repName);
        System.out.println(userName);
        Project project = projectService.findOneProject(projName,repName,userName);
        model.addAttribute("project", project);

        User user = userService.getUserInSession(session);
        model.addAttribute("user", user);
        if (user != null) {
            ProjectFollower projectFollower = projectService.findOneFollower(projName,repName,userName,user.getUsername());
            model.addAttribute("isFollower", projectFollower);
            Participate participate = projectService.findOneParticipater(projName,repName,userName,user.getUsername());
            model.addAttribute("isParticipater", participate);
        }
        return "action/activity";
    }

    @RequestMapping(value = "hotspot",method = RequestMethod.GET)
    public String hotspot(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam(value = "size", defaultValue = "6")int size){
        Page<Project> projects = projectService.getProjectPageOrderByFolNum(page, size);
        modelMap.addAttribute("projects", projects);
        return "hotspot/hotspot-index";
    }

    @RequestMapping(value = "participate",method = RequestMethod.GET)
    public String participate(HttpSession session,ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam(value = "size", defaultValue = "6")int size){
        //Page<Project> projects = projectService.getProjectPageOrderByParNum(page, size);
        User userInSession = userService.getUserInSession(session);
        if (userInSession==null)
            return "redirect:/sessionLost";
        Page<Project> projects = projectService.getUserParticipateProject(page, size, userInSession.getUsername());
        modelMap.addAttribute("projects", projects);
        return "participate/participate-index";
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


    //搜索相关
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(HttpServletRequest request,Model model)
    {
        //给带搜索的字符串加上搜索匹配修饰符
        String toSearch = "%" + request.getParameter("toSearch") + "%";
        List<User> users = userService.findUserContains(toSearch);
        List<Project> projects = projectService.findProjNameLike(toSearch);
        List<Repository> repositories = repositoryService.findRepositoryLike(toSearch);
        model.addAttribute("users", users);
        model.addAttribute("projects", projects);
        model.addAttribute("repositories", repositories);
        //if (users.isEmpty()){
        //    System.out.println("search not found");
        //}
        //else {
        //    for(User user:users)
        //    {
        //        System.out.println(user.getUsername());
        //    }
        //}
        return "management/searchOutput";

    }
}
