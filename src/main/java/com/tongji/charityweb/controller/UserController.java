package com.tongji.charityweb.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.model.user.UserFollower;
import com.tongji.charityweb.repository.user.UserFollowerRepository;
import com.tongji.charityweb.repository.user.UserRepository;
import com.tongji.charityweb.service.RepositoryService;
import com.tongji.charityweb.service.UserService;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/createUser",method ={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String createUser(HttpServletRequest request, Model model)
    {
        try {
            String userName = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String rank = request.getParameter("rank");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            System.out.println("username"+userName);
            if(userService.createUser(userName, email, name, password, sex, rank))
                return "create user succeed";
            return "create user error";
        }
        catch  (Exception e){
            return "create user error";
        }
    }

    @RequestMapping(value = "/deleteUser",method ={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteUser(HttpServletRequest request, Model model)
    {
        try{
            String userName = request.getParameter("username");
            userService.deleteUser(userName);
            return "delete succeed";
        }
        catch (Exception e){
            return "delete fail";
        }
    }

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String DisplayUserInfo(HttpSession session, Model model, String username)
    {
        User userInSession = userService.getUserInSession(session);
        if(userInSession == null) {
            //登录失效
            return "login/sessionLost";
        }
        if (username == null || username.equals(userInSession.getUsername())) {
            model.addAttribute("thisUser", userInSession);
            model.addAttribute("button", 1);
            return "management/userInfo";
        }
        else {
            User user = userRepository.findOne(username);
            model.addAttribute("thisUser", user);

            UserFollower userFollower = userService.findOneFollower(username, userInSession.getUsername());
            if (userFollower == null)
                model.addAttribute("button",2);
            else
                model.addAttribute("button",3);
            return "management/userInfo";
        }
    }

    @RequestMapping(value = "/createUserFol",method = RequestMethod.GET)
    public String createUserFol(String username, HttpSession session)
    {
        try {
            String followername = userService.getUserInSession(session).getUsername();
            if (userService.createUserFollower(username, followername))
                return "redirect:/userInfo?username="+username;
            else
                return "create fail";
        } catch (Exception e) {
            System.out.println("para from createUserFol error");
            return "create UserFollower fail!";
        }
    }

    @RequestMapping(value = "/deleteUserFol",method = RequestMethod.GET)
    public String deleteUserFol(String username, HttpSession session)
    {
        try {
            String followername = userService.getUserInSession(session).getUsername();
            if (userService.deleteUserFollower(username, followername))
                return "redirect:/userInfo?username="+username;
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