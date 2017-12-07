package com.tongji.charityweb.controller;

import com.tongji.charityweb.service.CommentService;
import jdk.internal.org.objectweb.asm.tree.IincInsnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/createRepCom",method = RequestMethod.POST)
    @ResponseBody
    public String createRepCom(HttpServletRequest request)
    {
        try {
            String userName =  request.getParameter("userName");
            String repName = request.getParameter("repName");
            String content = request.getParameter("content");
            if (commentService.createRepComment(repName, userName, content))
                return "create RepComment succeed!";
            else
                return "create fail";
        } catch (Exception e) {
            System.out.println("para from createRepCom error");
            return "create RepComment fail!";
        }
    }

    @RequestMapping(value = "/deleteRepCom",method = RequestMethod.POST)
    @ResponseBody
    public String deleteRepCom(HttpServletRequest request)
    {
        try {
            String repName = request.getParameter("repName");
            String userName = request.getParameter("userName");
            Integer num = Integer.valueOf(request.getParameter("num"));
            if (commentService.deleteRepComment(repName, userName,num))
                return "delete RepComment succeed!";
            else
                return "delete fail";
        } catch (Exception e) {
            System.out.println("para from deleteRepCom error");
            return "delete RepComment fail!";
        }
    }

    @RequestMapping(value = "/showRepCom",method= RequestMethod.POST)
    @ResponseBody
    public String showRepCom(HttpServletRequest request)
    {
        try {
            String repName = request.getParameter("repName");
            String userName = request.getParameter("userName");
            return commentService.showAllComByRepName(repName, userName);
        } catch (Exception e) {
            e.printStackTrace();
            return "error showRepComment";
        }
    }

    @RequestMapping(value = "/createProCom",method = RequestMethod.POST)
    @ResponseBody
    public String createProCom(HttpServletRequest request)
    {
        try {
            String projectName = request.getParameter("id");
            String repName = request.getParameter("repName");
            String userName = request.getParameter("userName");
            String content = request.getParameter("content");
            if (commentService.createProComment(projectName,repName,userName,content))
                return "create ProComment succeed!";
            else
                return "create fail";
        } catch (Exception e) {
            System.out.println("para from createProCom error");
            return "create ProComment fail!";
        }
    }

    @RequestMapping(value = "/deleteProCom",method = RequestMethod.POST)
    @ResponseBody
    public String deleteProCom(HttpServletRequest request)
    {
        try {
            String projName = request.getParameter("projName");
            String repName = request.getParameter("repName");
            String userName = request.getParameter("userName");
            int num =Integer.valueOf( request.getParameter("num"));
            if (commentService.deleteProComment(projName, repName, userName, num))
                return "delete ProComment succeed!";
            else
                return "delete fail";
        } catch (Exception e) {
            System.out.println("para from deleteProCom error");
            return "delete ProComment fail!";
        }
    }

    @RequestMapping(value = "/showProCom",method= RequestMethod.POST)
    @ResponseBody
    public String showProCom(HttpServletRequest request)
    {
        try {

            String projName = request.getParameter("projName");
            String repName = request.getParameter("repName");
            String userName = request.getParameter("userName");

            return commentService.showAllComByProID(projName, repName, userName);
        } catch (Exception e) {
            e.printStackTrace();
            return "error showProComment";
        }
    }
}
