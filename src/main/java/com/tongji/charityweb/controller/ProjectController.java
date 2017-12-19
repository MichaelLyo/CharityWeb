package com.tongji.charityweb.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.repository.RepositoryID;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.repository.RepRepository;
import com.tongji.charityweb.service.ProjectService;
import com.tongji.charityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.util.resources.CalendarData;

import javax.security.sasl.SaslServer;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    RepRepository repRepository;
    @Autowired
    UserService userService;

    @RequestMapping(value = "createProject" ,method = RequestMethod.GET)
    public String getCreateProjectPage(HttpServletRequest request){
        return "management/addProject";
    }

    @RequestMapping(value = "createProject", method = {RequestMethod.POST})
    public String createProject(HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest){
        try{
            User user = userService.getUserInSession(request.getSession());
            if(user==null)
                return "login/sessionLost";
            String repName = request.getParameter("repName");
            String projName = request.getParameter("projName");
            String context = request.getParameter("context");
            String endDate = request.getParameter("endDate");

            Project project = new Project(repName, projName, user.getUsername());
            project.setContext(context);
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            Date date = fmt.parse(endDate);
            project.setEndDate(date);

            Repository repository = repRepository.findOne(new RepositoryID(user.getUsername(), repName));
            repository.addProject(project);
            request.setAttribute("jsRepositoryName",repName);
            return "redirect:/showProjects";
        }
        catch (Exception e){
            return "error";
        }

    }

    @RequestMapping(value = "showProjects",method = {RequestMethod.POST, RequestMethod.GET})
    public String showProjects(HttpServletRequest request){
        try{
            String repName = request.getParameter("jsRepositoryName");
            User user   =  userService.getUserInSession(request.getSession());
            Repository repository = repRepository.findOne(new RepositoryID(user.getUsername(), repName));
            List<Project> projects = repository.getProjects();
            System.out.println(repName);
            return "management/mgtProject";
        }
        catch (Exception e){
            return "error";
        }

    }

    @RequestMapping(value = "/createProFol",method = RequestMethod.POST)
    public String createProFol(HttpServletRequest request)
    {
        try {
            String projectName = request.getParameter("projectName");
            String repName =  request.getParameter("repName");
            String followerName =  request.getParameter("followerName");
            String userName = request.getParameter("userName");
            if (projectService.createProFollower(projectName, repName, followerName, userName))
                return "create ProjectFollower succeed!";
            else
                return "create fail";
        } catch (Exception e) {
            System.out.println("para from createProFol error");
            return "create ProjectFollower fail!";
        }
    }

    @RequestMapping(value = "/deleteProFol",method = RequestMethod.POST)
    @ResponseBody
    public String deleteProFol(HttpServletRequest request)
    {
        try {
            String projName = request.getParameter("projName");
            String repName = request.getParameter("repName");
            String followerName = request.getParameter("followerName");
            String userName = request.getParameter("userName");
            if (projectService.deleteProFollower(projName, repName, followerName, userName))
                return "delete ProjectFollower succeed!";
            else
                return "delete fail";
        } catch (Exception e) {
            System.out.println("para from deleteProFol error");
            return "delete ProjectFollower fail!";
        }
    }

    @RequestMapping(value = "/showProFol",method= RequestMethod.POST)
    @ResponseBody
    public String showProFol(HttpServletRequest request)
    {
        try {
            String userName = request.getParameter("userName");
            String repName = request.getParameter("repName");
            String projName = request.getParameter("projName");
            return projectService.showAllProFollower(userName, repName, projName);
        } catch (Exception e) {
            e.printStackTrace();
            return "error showProFol";
        }
    }
}
