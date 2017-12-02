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
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/userInfo")
    public String DisplayUserInfo(HttpServletRequest request, Model model)
    {
        User userInSession = userService.getUserInSession(request.getSession());
        if(userInSession == null)
        {
            //登录失效
            return "login/sessionLost";
        }
        else
        {
            model.addAttribute("thisUser",userInSession);
            return "management/userInfo";
        }
    }

}