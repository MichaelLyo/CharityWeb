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
    public String editInfo(HttpServletRequest request,@RequestParam("file") MultipartFile file) {
        try {

            String sex = request.getParameter("sex");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String introduction = request.getParameter("introduction");
            String description = request.getParameter("description");
            //MultipartFile file = (MultipartFile) request.getAttribute("file");
            //System.out.println(fileService.uploadUserPicture(file));

            System.out.println(sex);
            user = userService.getUserInSession(request.getSession());

            if (user == null)
            {
                return "redirect:/sessionLost";
            }

            String uploadInfo = fileService.uploadUserPicture(file,user);
            if(uploadInfo.contains("upload failed,"))
            {
                //上传失败前端要干啥？
            }
            else
            {
                user.setHpPictureUrl(uploadInfo);
            }

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
        return "redirect:/userInfo";
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
