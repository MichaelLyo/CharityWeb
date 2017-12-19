package com.tongji.charityweb.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;

import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.service.RepositoryService;
import com.tongji.charityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mobile.DeviceDelegatingViewResolverAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.multi.MultiFileChooserUI;

@Controller
public class RepositoryController {

    @Autowired
    RepositoryService repService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/createRep",method = RequestMethod.POST)
    public String createRep(HttpServletRequest request, Model model, MultipartRequest mulRequest)
    {
        try {
            User userInSession  = userService.getUserInSession(request.getSession());
            String repName = request.getParameter("repName");
            String description = request.getParameter("description");
            MultipartFile file = mulRequest.getFile("photo");
            if( repService.createRepository(repName,description,userInSession))
                  return "redirect:/showRes";
            else
                  return "error";
        } catch (Exception e) {
            System.out.println("para from createRes error");
            return "";
        }
    }

    @RequestMapping(value = "/deleteRes",method = RequestMethod.POST)
    @ResponseBody
    public String deleteRep(HttpServletRequest request, Model model)
    {
        try {
            String userName = request.getParameter("userName");
            String repName = request.getParameter("repName");
            if( repService.deleteRepository(userName,repName))
                return "delete Res succeed!";
            else
                return "delete fail";
        } catch (Exception e) {
            System.out.println("para from createRes error");
            return "delete Res fail!";
        }
    }

    @RequestMapping(value = "/showRes",method= {RequestMethod.POST,RequestMethod.GET})
    public String showRepByUser(HttpServletRequest request, Model model)
    {
        try {
            User userInSession = userService.getUserInSession(request.getSession());
            if(userInSession == null) {
                return "login/sessionLost";
            }
            model.addAttribute("repositorylist",userInSession.getRepositories());
            model.addAttribute("user",userInSession);
            return "management/mgtRepository";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
