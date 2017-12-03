package com.tongji.charityweb.controller;

import com.tongji.charityweb.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/createProFol",method = RequestMethod.POST)
    @ResponseBody
    public String createProFol(HttpServletRequest request)
    {
        try {
            String projectID = request.getParameter("projectID");
            String followerID = request.getParameter("followerID");
            if (projectService.createProFollower(projectID, followerID))
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
            String projectID = request.getParameter("projectID");
            String followerID = request.getParameter("followerID");
            if (projectService.deleteProFollower(projectID, followerID))
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
            String projectID = request.getParameter("projectID");
            return projectService.showAllProFollower(projectID);
        } catch (Exception e) {
            e.printStackTrace();
            return "error showProFol";
        }
    }
}
