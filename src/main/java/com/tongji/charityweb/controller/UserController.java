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
    @Autowired
    private UserRepository userRepository;


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
            //model.addAttribute("username",userInSession.getUsername());
            //model.addAttribute("email", userInSession.getEmail());
            //model.addAttribute("description", userInSession.getDescription());
            //model.addAttribute("introduction", userInSession.getIntroduction());
            //model.addAttribute("sex", userInSession.getSex());
            //model.addAttribute("address",userInSession.getAddress());
            //model.addAttribute("phone", userInSession.getPhone());
            model.addAttribute("thisUser", userInSession);
            return "management/userInfo";
        }
    }

}