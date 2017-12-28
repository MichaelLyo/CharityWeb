package com.tongji.charityweb.controller;

import com.tongji.charityweb.model.project.Participate;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.project.ParRepository;
import com.tongji.charityweb.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ParticipateController {
    @Autowired
    ParRepository parRepository;
    @Autowired
    UserService userService;

    @RequestMapping(value = "myParticipate", method = {RequestMethod.GET,RequestMethod.POST})
    public String myParticipate(String projName,String repName, String userName ){

        try{
//            User userInSession  = userService.getUserInSession(request.getSession());
//            if(userInSession == null)
//                return "login/sessionLost";


            System.out.println(repName+projName+userName);
            Participate participate = new Participate(userName, repName, projName,"sjw");
            parRepository.save(participate);
            return "redirect:/";
        }
        catch (Exception e){
            return "error";
        }
    }
}
