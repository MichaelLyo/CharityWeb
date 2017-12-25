package com.tongji.charityweb.controller;

import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.user.UserRepository;
import com.tongji.charityweb.service.FileService;
import com.tongji.charityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    private User user;

    /* regist */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(HttpServletRequest request, Model model) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");

            User SameName = userRepository.findByUsername(username);
            if(SameName != null) {
                model.addAttribute("span1", true);
                return "login/regist";
            }
            if (password.equals(password2)) {
                user = new User("", username,username, password, "", "user");
                userRepository.save(user);
                userService.userLogin(user,request.getSession());
                return "redirect:/editInfo";
            } else {
                model.addAttribute("span2", true);
                return "login/regist";
            }
        } catch (Exception ex) {
            return "Error";
        }
    }

    /* login */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){
        //System.out.println("login method: post");
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
            str = "redirect:/";
        }else {
            model.addAttribute("span", true);
            str = "login/login";
        }
        return str;
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpSession session)
    {
        userService.userLogout(session);
        return "redirect:/";
    }

}
