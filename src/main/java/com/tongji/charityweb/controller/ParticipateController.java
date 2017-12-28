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

    @RequestMapping(value = "participate", method = RequestMethod.GET)
    public String participate(HttpServletRequest request){

        try{
            User userInSession  = userService.getUserInSession(request.getSession());
            if(userInSession == null)
                return "login/sessionLost";

            String repName = request.getParameter("repName");
            String projName = request.getParameter("projName");
            String userName = request.getParameter("userName");

            Participate participate = new Participate(userName, repName, projName, userInSession.getUsername());
            parRepository.save(participate);
            return "redirect:/";
        }
        catch (Exception e){
            return "error";
        }
    }
}
