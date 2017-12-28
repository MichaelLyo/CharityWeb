package com.tongji.charityweb.controller;

import com.tongji.charityweb.model.project.Participate;
import com.tongji.charityweb.model.project.ProjectParticipateID;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.project.ParRepository;
import com.tongji.charityweb.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ParticipateController {
    @Autowired
    ParRepository parRepository;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/createParticipate", method = RequestMethod.GET)
    public String createParticipate(String projName, String repName, String userName, HttpSession session, HttpServletRequest request, RedirectAttributes attr){
        try{

            User userInSession  = userService.getUserInSession(request.getSession());
            if(userInSession == null) {
                return "login/sessionLost";
            }

            attr.addAttribute("projName", projName);
            attr.addAttribute("repName", repName);
            attr.addAttribute("userName", userName);


            System.out.println(repName+projName+userName);
            Participate participate = new Participate(userName, repName, projName,userInSession.getUsername());
            parRepository.save(participate);
            return "redirect:/activity";
        } catch (Exception e){
            return "error";
        }
    }

    @RequestMapping(value = "/deleteParticipate", method = RequestMethod.GET)
    public String deleteParticipate(String projName, String repName, String userName,HttpSession session, HttpServletRequest request, RedirectAttributes attr){
        try{
            User userInSession  = userService.getUserInSession(session);
            if(userInSession == null)
                return "login/sessionLost";

            attr.addAttribute("projName", projName);
            attr.addAttribute("repName", repName);
            attr.addAttribute("userName", userName);

            parRepository.delete(new ProjectParticipateID(userName,repName,projName,userInSession.getUsername()));
            return "redirect:/activity";
        } catch (Exception e){
            return "error";
        }
    }
}
