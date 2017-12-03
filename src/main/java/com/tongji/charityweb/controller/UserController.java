package com.tongji.charityweb.controller;

import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.user.UserRepository;
import com.tongji.charityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String DisplayUserInfo(HttpSession session, Model model)
    {
        User userInSession = userService.getUserInSession(session);
        if(userInSession == null)
        {
            //登录失效
            return "login/sessionLost";
         }
        else
        {
            model.addAttribute("thisUser", userInSession);
            return "management/userInfo";
        }
    }

    @RequestMapping(value = "/createUserFol",method = RequestMethod.POST)
    @ResponseBody
    public String createUserFol(HttpServletRequest request)
    {
        try {
            String username = request.getParameter("username");
            String followername = request.getParameter("followername");
            if (userService.createUserFollower(username, followername))
                return "create UserFollower succeed!";
            else
                return "create fail";
        } catch (Exception e) {
            System.out.println("para from createUserFol error");
            return "create UserFollower fail!";
        }
    }

    @RequestMapping(value = "/deleteUserFol",method = RequestMethod.POST)
    @ResponseBody
    public String deleteUserFol(HttpServletRequest request)
    {
        try {
            String username = request.getParameter("username");
            String followername = request.getParameter("followername");
            if (userService.deleteUserFollower(username, followername))
                return "delete UserFollower succeed!";
            else
                return "delete fail";
        } catch (Exception e) {
            System.out.println("para from deleteUserFol error");
            return "delete UserFollower fail!";
        }
    }

    @RequestMapping(value = "/showUserFol",method= RequestMethod.POST)
    @ResponseBody
    public String showUserFol(HttpServletRequest request)
    {
        try {
            String username = request.getParameter("username");
            return userService.showAllFollower(username);
        } catch (Exception e) {
            e.printStackTrace();
            return "error showUserFol";
        }
    }

}