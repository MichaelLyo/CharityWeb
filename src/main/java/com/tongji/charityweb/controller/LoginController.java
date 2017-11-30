package com.tongji.charityweb.controller;

import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    private User user;

    /* regist */
    @RequestMapping(value = "/regist.do", method = RequestMethod.POST)
    public String regist(HttpServletRequest request, Model model) {
        Boolean span1, span2;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            User SameName = userRepository.findByName(username);
            if(SameName != null) {
                span1 = true;
                model.addAttribute("span1", span1);
                return "login/regist";
            }
            if (password.equals(password2)) {
                user = new User("", username, password, "", "user");
                userRepository.save(user);
                return "login/editInfo";
            } else {
                span2 = true;
                model.addAttribute("span2", span2);
                return "login/regist";
            }
        } catch (Exception ex) {
            return "Error regist";
        }
    }

    /* editInfo */
    @RequestMapping(value = "/editInfo.do", method = RequestMethod.POST)
    public String editInfo(HttpServletRequest request) {
        try {
            String sex = request.getParameter("sex");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String introduction = request.getParameter("introduction");
            String description = request.getParameter("description");
            user = userRepository.findOne(user.getId());
            user.setSex(sex);
            user.setAddress(address);
            user.setPhone(phone);
            user.setEmail(email);
            user.setIntroduction(introduction);
            user.setDescription(description);
            userRepository.save(user);
        } catch (Exception ex) {
            return "Error edit info";
        }
        return "index";
    }

    /* login */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){
        boolean span;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            user = userRepository.findByNameAndPassword(username, password);
        } catch (Exception ex) {
            return "Error login";
        }
        String str = "";
        if (user != null){
            str = "index";
        }else {
            span = true;
            model.addAttribute("span", span);
            str = "login/login";
        }
        return str;
    }

}
