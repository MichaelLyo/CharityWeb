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
import com.tongji.charityweb.repository.user.UserRepository;
import com.tongji.charityweb.service.FileService;
import com.tongji.charityweb.service.ProjectService;
import com.tongji.charityweb.service.UserService;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.jpa.convert.threetenbp.ThreeTenBackPortJpaConverters;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.mail.MailException;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import redis.clients.jedis.BinaryClient;
import sun.security.util.Length;
import sun.util.resources.CalendarData;

import javax.jws.WebParam;
import javax.security.sasl.SaslServer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    UserRepository userRepository;
    @Autowired
    FileService fileService;

    @RequestMapping(value = "createProject" ,method = RequestMethod.POST)
    public String getCreateProjectPage(HttpServletRequest request, Model model){
        String repName = request.getParameter("repName");
        model.addAttribute("repName",repName);

        return "management/addProject";
    }

    @RequestMapping(value = "testAjax",  method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> testAjax(String userName, String repName, String projName){
        System.out.println("hello");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<Project> projects = new ArrayList<>() ;
        Project project = projectRepository.findOne(new ProjectID(projName, repName, userName));
        projects.add(project);
        resultMap.put("projects", projects);
        System.out.println(userName);
        System.out.println(repName);
        System.out.println(projName);
        Map map = new HashMap();
       if(project.getFollowers() == null)
           map.put("followerNum",0);
       else
           map.put("followerNum",project.getFollowers().size());

       if(project.getParticipates()==null)
           map.put("participateNum",0);
       else
           map.put("participateNum",project.getParticipates().size());

       map.put("projName",projName);
       map.put("context",project.getContext());
       map.put("endDate",project.getEndDate().toString().replace("00:00:00.0",""));


        return map;
    }


    @RequestMapping(value = "searchProject", method = RequestMethod.POST)
    public String searchProject(HttpServletRequest request, Model model){
        try{
            String projName = request.getParameter("projName");
            String repName = request.getParameter("repName");
            String userName =request.getSession().getAttribute(HttpSessionConfig.SESSION_USERNAME).toString();
            List<Project> projects = new ArrayList<>() ;
            if(repName == null){
                projects = projectRepository.findByUserName(userName);
            }
            else{
                Project project = projectRepository.findOne(new ProjectID( projName ,repName, userName));
                projects.add(project);
            }
            model.addAttribute("projects", projects);
            return "management/mgtProject";
        }
        catch (Exception e){
            System.out.println("??");
            return "error";
        }
    }
    @RequestMapping(value = "examCreateProject", method = {RequestMethod.POST})
    public String createProject(MultipartHttpServletRequest request, Model model,MultipartHttpServletRequest mulRequest){
        try{
            User user = userService.getUserInSession(request.getSession());
            if(user==null)
                return "login/sessionLost";
            HttpSession session = request.getSession();
            String repName = request.getParameter("repName");
            String projName = request.getParameter("projName");
            String context = request.getParameter("context");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            MultipartFile file = mulRequest.getFile("photo");

            Project project = new Project(repName, projName, user.getUsername() );
            project.setContext(context);
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            project.setEndDate(fmt.parse(endDate));
            project.setStartDate(fmt.parse(startDate));
            String projectUrl = fileService.uploadProjectPicture(file, project);
            project.setDescriptionPictureUrl(projectUrl);
            Repository repository = repRepository.findOne(new RepositoryID(user.getUsername(), repName));
            repository.addProject(project);
            repRepository.save(repository);

            List<Project> projects = repository.getProjects();
            String pictureUrl = repository.getDescriptionPictureUrl();
            String pictureName = repository.getRepositoryName();
            model.addAttribute("projects", projects);
            model.addAttribute("pictureUrl",pictureUrl);
            model.addAttribute("pictureName",pictureName);
            model.addAttribute("userName",user.getUsername());
            model.addAttribute("repName",repName);
            return "management/mgtProject";
        }
        catch (Exception e){
            System.out.println("examCreateProject");
            return "error";
        }

    }


    @RequestMapping(value = "showOwnerProjects",method = {RequestMethod.POST, RequestMethod.GET})
    public String showOwnerProjects(HttpServletRequest request, Model model){
        try{

            HttpSession session = request.getSession();
            User userInsession = userService.getUserInSession(session);
            if(userInsession == null)
                return "login/sessionLost";

            List<Project> projects = projectRepository.findByUserName(userInsession.getUsername());
            model.addAttribute("projects", projects);
            model.addAttribute("pictureUrl",userInsession.getHpPictureUrl());
            model.addAttribute("pictureName", userInsession.getUsername());


            return "management/showOwnerProjects";
        }
        catch (Exception e){
            System.out.println("showProjects");
            return "error";
        }

    }

    @RequestMapping(value = "showProjects",method = {RequestMethod.POST, RequestMethod.GET})
    public String showProjects(HttpServletRequest request, Model model){
        try{

            String repName = request.getParameter("repName");
            String userName = request.getParameter("userName");
            repName = repName.replace(" ","");
            userName = userName.replace(" ","");
            repName = repName.replace("\r\n","");
            userName = userName.replace("\r\n","");


            Repository repository = repRepository.findOne(new RepositoryID(userName, repName));
            List<Project> projects = repository.getProjects();


            model.addAttribute("projects", projects);
            model.addAttribute("pictureUrl",repository.getDescriptionPictureUrl());
            model.addAttribute("pictureName",repName);
            model.addAttribute("userName",userName);
            model.addAttribute("repName",repName);

            return "management/mgtProject";
        }
        catch (Exception e){
            System.out.println("showProjects");
            return "error";
        }

    }

    @RequestMapping(value = "showProjectDetail",method = RequestMethod.POST)
    public String showProjectDetail(HttpServletRequest request, Model model){
        String userName = request.getParameter("userName");
        String repName = request.getParameter("repName");
        String projName = request.getParameter("projName");

        repName = repName.replace(" ","");
        userName = userName.replace(" ","");
        projName  = projName.replace(" ","");
        repName = repName.replace("\r\n","");
        userName = userName.replace("\r\n","");
        projName  = projName.replace("\r\n","");
        Project project = projectRepository.findOne(new ProjectID(projName, repName, userName));
        model.addAttribute("project",project);
        return "action/activity";
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

    @RequestMapping(value = "showFollowProjects", method = RequestMethod.POST)
    public String showFollowProjects(HttpServletRequest request, Model model){
        try{
            String userName = request.getParameter("userName");
            User user = userRepository.getOne(userName);
            List<ProjectFollower>projectFollowers  = proFolRepository.findByFollowerName(userName);
            List<Project> projects = new ArrayList<>();
            for(ProjectFollower x : projectFollowers){
                projects.add(x.getProject());
            }
            model.addAttribute("projects", projects);
            model.addAttribute("pictureUrl",user.getHpPictureUrl());
            model.addAttribute("pictureName",userName);
            model.addAttribute("userName",userName);


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
            User user = userRepository.findOne(userName);
            List<Participate> participates = parRepository.findByParName(userName);
            List<Project> projects = new ArrayList<>();
            for(Participate x : participates){
                projects.add(x.getProject());
            }
            model.addAttribute("projects",projects);
            model.addAttribute("pictureUrl",user.getHpPictureUrl());
            model.addAttribute("pictureName",userName);
            model.addAttribute("userName",userName);
        }
        catch (Exception e){
            System.out.println("showParticipateProjects");
            return "error";
        }
        return  "management/mgtProject";
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
