package com.tongji.charityweb.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tongji.charityweb.config.HttpSessionConfig;
import com.tongji.charityweb.model.project.Participate;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.project.ProjectFollower;
import com.tongji.charityweb.model.project.ProjectID;
import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.repository.RepositoryID;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.project.ParRepository;
import com.tongji.charityweb.repository.project.ProFolRepository;
import com.tongji.charityweb.repository.project.ProjectRepository;
import com.tongji.charityweb.repository.repository.RepRepository;
import com.tongji.charityweb.service.ProjectService;
import com.tongji.charityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.jpa.convert.threetenbp.ThreeTenBackPortJpaConverters;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.mail.MailException;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.session.Session;
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
import javax.servlet.http.HttpSession;
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
    @Autowired
    ProFolRepository proFolRepository;
    @Autowired
    ParRepository parRepository;

    @RequestMapping(value = "createProject" ,method = RequestMethod.POST)
    public String getCreateProjectPage(HttpServletRequest request){
        return "management/addProject";
    }

    @RequestMapping(value = "searchProject", method = RequestMethod.POST)
    public String searchProject(HttpServletRequest request, Model model){
        try{
            String projName = request.getParameter("projName");
            String repName = request.getParameter("repName");
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
            HttpSession session = request.getSession();
            String repName = session.getAttribute("curRep").toString();
            String userName = session.getAttribute("curUser").toString();
            String projName = request.getParameter("projName");
            String context = request.getParameter("context");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");

            Project project = new Project(repName, projName, userName );
            project.setContext(context);
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            Date date = fmt.parse(endDate);
            project.setEndDate(date);

            Repository repository = repRepository.findOne(new RepositoryID(user.getUsername(), repName));
            repository.addProject(project);
            repRepository.save(repository);
            return "redirect:/afterCreateProject";
        }
        catch (Exception e){
            return "error";
        }

    }

    @RequestMapping(value = "afterCreateProject", method = RequestMethod.GET)
    public String afterCreateProject(HttpServletRequest request, Model model)
    {
        try{
            HttpSession session = request.getSession();
            String repName = session.getAttribute("curRep").toString();
            String userName = session.getAttribute("curUser").toString();
            Repository repository = repRepository.findOne(new RepositoryID(userName, repName));
            List<Project> projects = repository.getProjects();

            model.addAttribute("projects", projects);
            return "management/mgtProject";
        }
        catch (Exception e){
            System.out.println("afterCreateProject");
            return "error";
        }
    }
    @RequestMapping(value = "showProjects",method = {RequestMethod.POST, RequestMethod.GET})
    public String showProjects(HttpServletRequest request, Model model){
        try{

            HttpSession session = request.getSession();
            String repName = request.getParameter("repName");
            String userName = request.getParameter("userName");

            session.setAttribute("curRep",repName);
            session.setAttribute("curUser",userName);
            Repository repository = repRepository.findOne(new RepositoryID(userName, repName));
            List<Project> projects = repository.getProjects();

            model.addAttribute("projects", projects);
            model.addAttribute("repName",repName);


            return "management/mgtProject";
        }
        catch (Exception e){
            System.out.println("showProjects");
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

    @RequestMapping(value = "showFollowProjects", method = RequestMethod.POST)
    public String showFollowProjects(HttpServletRequest request, Model model){
        try{
            String userName = request.getParameter("userName");
            List<ProjectFollower>projectFollowers  = proFolRepository.findByFollowerName(userName);
            List<Project> projects = new ArrayList<>();
            for(ProjectFollower x : projectFollowers){
                projects.add(x.getProject());
            }
            model.addAttribute("projects", projects);
            model.addAttribute("repName","repName");


            return "management/mgtProject";
        }
        catch(Exception e ){
            System.out.println("showJoinRes Error");
            return "error";
        }
    }

    @RequestMapping(value = "showParProjects", method = RequestMethod.POST)
    public String showParticipateProjects(HttpServletRequest request, Model model){
        try{
            String userName = request.getParameter("userName");
            List<Participate> participates = parRepository.findByParName(userName);
            List<Project> projects = new ArrayList<>();
            for(Participate x : participates){
                projects.add(x.getProject());
            }
            model.addAttribute("projects",projects);
            model.addAttribute("repName","repName");
        }
        catch (Exception e){
            System.out.println("showParticipateProjects");
            return "error";
        }
        return  "management/mgtProject";
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
