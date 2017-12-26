package com.tongji.charityweb.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tongji.charityweb.model.user.Donate;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.model.user.UserFollower;
import com.tongji.charityweb.repository.user.DonateRepository;
import com.tongji.charityweb.repository.user.UserFollowerRepository;
import com.tongji.charityweb.repository.user.UserRepository;
import com.tongji.charityweb.service.FileService;
import com.tongji.charityweb.service.RepositoryService;
import com.tongji.charityweb.service.UserService;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.dom4j.dom.DOMAttributeNodeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Autowired
    private DonateRepository donateRepository;
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/createUser",method ={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String createUser(HttpServletRequest request, Model model, MultipartHttpServletRequest mulRequest)
    {
        try {
            String userName = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String rank = request.getParameter("rank");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            MultipartFile file = mulRequest.getFile("file");

            if(userService.createUser(userName, email, name, password, sex, rank,file)){
                return "create user succeed";
            }
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
            //获取当前捐款总额
            List<Donate> donates = donateRepository.findByUsername(userInSession.getUsername());
            int donateAmount = 0;
            for(Donate donate:donates){
                donateAmount+=donate.getAmount();
            }
            model.addAttribute("thisUser", userInSession);
            model.addAttribute("button", 1);
            model.addAttribute("donateAmount",donateAmount);
            return "management/userInfo";
        }
        else {
            User user = userRepository.findOne(username);
            List<Donate> donates = donateRepository.findByUsername(user.getUsername());
            int donateAmount = 0;
            for(Donate donate:donates){
                donateAmount+=donate.getAmount();
            }
            model.addAttribute("donateAmount",donateAmount);
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
    public String createUserFol(String username, HttpSession session, RedirectAttributes attr)
    {
        try {
            User user = userService.getUserInSession(session);
            if(user == null)
                return "login/sessionLost";
            String followername = user.getUsername();
            attr.addAttribute("username", username);
            if (userService.createUserFollower(username, followername))
                return "redirect:/userInfo";
            else
                return "create fail";
        } catch (Exception e) {
            System.out.println("para from createUserFol error");
            return "create UserFollower fail!";
        }
    }

    @RequestMapping(value = "/deleteUserFol",method = RequestMethod.GET)
    public String deleteUserFol(String username, HttpSession session, RedirectAttributes attr)
    {
        try {
            User user = userService.getUserInSession(session);
            if(user == null)
                return "login/sessionLost";
            String followername = user.getUsername();
            attr.addAttribute("username", username);
            if (userService.deleteUserFollower(username, followername))
                return "redirect:/userInfo";
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

    /* editInfo */
    @RequestMapping(value = "editInfo",method = RequestMethod.GET)
    public String editInfo(HttpServletRequest request,Model model){
        User user = userService.getUserInSession(request.getSession());
        System.out.println("here");
        model.addAttribute("user", user);
        return "management/editInfoPro";
    }
    @RequestMapping(value = "editInfo",method = RequestMethod.POST)
    public String editInfo(HttpServletRequest request,@RequestParam("photo") MultipartFile file) {
        try {

            String sex = request.getParameter("sex");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String introduction = request.getParameter("introduction");
            String description = request.getParameter("description");
            String nickname = request.getParameter("nickname");
            System.out.println(fileService.uploadUserPicture(file, userService.getUserInSession(request.getSession())));

            System.out.println(sex);
            User user = userService.getUserInSession(request.getSession());

            if (user == null)
            {

                return "redirect:/sessionLost";
            }

            String uploadInfo = fileService.uploadUserPicture(file,user);
            if(uploadInfo.contains("upload failed,"))
            {
                //上传失败
            }
            else
            {
                user.setHpPictureUrl(uploadInfo);
            }
            user.setNickname(nickname);
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
}