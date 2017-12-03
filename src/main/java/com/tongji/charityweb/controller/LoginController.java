package com.tongji.charityweb.controller;

import com.tongji.charityweb.config.HttpSessionConfig;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.user.UserRepository;
import com.tongji.charityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    private User user;

    /* regist */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(HttpServletRequest request, Model model) {
        Boolean span1, span2;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");

            User SameName = userRepository.findByUsername(username);
            if(SameName != null) {
                span1 = true;
                model.addAttribute("span1", span1);
                return "login/regist";
            }
            if (password.equals(password2)) {
                user = new User("", username,username, password, "", "user");
                userRepository.save(user);
                userService.userLogin(user,request.getSession());
                return "management/editInfo";
            } else {
                span2 = true;
                model.addAttribute("span2", span2);
                return "login/regist";
            }
        } catch (Exception ex) {
            return "Error";
        }
    }

    /* editInfo */
    @RequestMapping(value = "editInfo",method = RequestMethod.POST)
    public String editInfo(HttpServletRequest request, Model model) {
        System.out.println("edit POST");
        try {

            String sex = request.getParameter("sex");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String introduction = request.getParameter("introduction");
            String description = request.getParameter("description");
            System.out.println(sex);
            System.out.println(address);
            System.out.println(phone);
            user = userService.getUserInSession(request.getSession());
            user.setSex(sex);
            user.setAddress(address);
            user.setPhone(phone);
            user.setEmail(email);
            user.setIntroduction(introduction);
            user.setDescription(description);
            userRepository.save(user);
        } catch (Exception ex) {
            return "error";
        }
        return "management/userInfo";
    }

    /* login */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){
        //System.out.println("login method: post");
        boolean span;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            user = userRepository.findByUsernameAndPassword(username, password);
        } catch (Exception ex) {
            return "error";
        }
        String str = "";
        if (user != null){
            userService.userLogin(user,request.getSession());
            str = "index";
        }else {
            span = true;
            model.addAttribute("span", span);
            str = "login/login";
        }
        return str;
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpSession session)
    {
        userService.userLogout(session);
        return "index";
    }

}
