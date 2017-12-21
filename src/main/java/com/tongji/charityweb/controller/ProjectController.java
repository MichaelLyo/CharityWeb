package com.tongji.charityweb.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tongji.charityweb.config.HttpSessionConfig;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.project.ProjectID;
import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.repository.RepositoryID;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.project.ProjectRepository;
import com.tongji.charityweb.repository.repository.RepRepository;
import com.tongji.charityweb.service.ProjectService;
import com.tongji.charityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threetenbp.ThreeTenBackPortJpaConverters;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.util.resources.CalendarData;

import javax.jws.WebParam;
import javax.security.sasl.SaslServer;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "createProject" ,method = RequestMethod.POST)
    public String getCreateProjectPage(HttpServletRequest request){
        return "management/addProject";
    }

    @RequestMapping(value = "searchProject", method = RequestMethod.POST)
    public String searchProject(HttpServletRequest request, Model model){
        try{
            String projName = request.getParameter("projName");
            String repName = request.getSession().getAttribute("jsRepositoryName").toString();
            String userName =request.getSession().getAttribute(HttpSessionConfig.SESSION_USERNAME).toString();

            Project project = projectRepository.findOne(new ProjectID( projName ,repName, userName));
            List<Project> projects = new ArrayList<>() ;
            projects.add(project);
            model.addAttribute("projects", projects);
            return "management/mgtProject";
        }
        catch (Exception e){
            System.out.println("??");
            return "error";
        }
    }

    @RequestMapping(value = "examCreateProject", method = {RequestMethod.POST})
    public String createProject(MultipartHttpServletRequest request, Model model){
        try{
            System.out.println("enheng");
            User user = userService.getUserInSession(request.getSession());
            if(user==null)
                return "login/sessionLost";
            String repName = request.getSession().getAttribute("jsRepositoryName").toString();
            String projName = request.getParameter("projName");
            String context = request.getParameter("context");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");

            Project project = new Project(repName, projName, user.getUsername());
            project.setContext(context);
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            Date date = fmt.parse(endDate);
            project.setEndDate(date);

            Repository repository = repRepository.findOne(new RepositoryID(user.getUsername(), repName));
            repository.addProject(project);
            repRepository.save(repository);
            request.getSession().setAttribute("jsRepositoryName",repName);
            return "redirect:/showProjects";
        }
        catch (Exception e){
            return "error";
        }

    }

    @RequestMapping(value = "showProjects",method = {RequestMethod.POST, RequestMethod.GET})
    public String showProjects(HttpServletRequest request, Model model){
        try{
            String repName = request.getSession().getAttribute("jsRepositoryName").toString();
            User user   =  userService.getUserInSession(request.getSession());
            Repository repository = repRepository.findOne(new RepositoryID(user.getUsername(), repName));
            List<Project> projects = repository.getProjects();

            model.addAttribute("projects", projects);
            return "management/mgtProject";
        }
        catch (Exception e){
            return "error";
        }

    }

    @RequestMapping(value = "/createProFol",method = RequestMethod.GET)
    public String createProFol(String projName, String repName, String userName, HttpServletRequest request)
    {
        try {
            User user = userService.getUserInSession(request.getSession());
            if(user==null)
                return "login/sessionLost";
            String followerName = user.getUsername();
            if (projectService.createProFollower(projName, repName, followerName, userName))
                return "redirect:/activity?projName="+projName+"&repName="+repName+"&userName="+userName;
            else
                return "create fail";
        } catch (Exception e) {
            System.out.println("para from createProFol error");
            return "create ProjectFollower fail!";
        }
    }

    @RequestMapping(value = "/deleteProFol",method = RequestMethod.GET)
    public String deleteProFol(String projName, String repName, String userName, HttpServletRequest request)
    {
        try {
            User user = userService.getUserInSession(request.getSession());
            if(user==null)
                return "login/sessionLost";
            String followerName = user.getUsername();
            if (projectService.deleteProFollower(projName, repName, followerName, userName))
                return "redirect:/activity?projName="+projName+"&repName="+repName+"&userName="+userName;
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
