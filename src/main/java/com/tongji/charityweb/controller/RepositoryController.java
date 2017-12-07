package com.tongji.charityweb.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;

import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RepositoryController {

    @Autowired
    RepositoryService repService;


    @RequestMapping(value = "/createRes",method = RequestMethod.POST)
    @ResponseBody
    public String createRep(HttpServletRequest request, Model model)
    {
        try {
            String userName = request.getParameter("userName");
            String repName = request.getParameter("repName");
            if( repService.createRepository(userName,repName))
                  return "create Res succeed!";
            else
                return "create fail";
        } catch (Exception e) {
            System.out.println("para from createRes error");
            return "create Res fail!";
        }
    }

    @RequestMapping(value = "/deleteRes",method = RequestMethod.POST)
    @ResponseBody
    public String deleteRep(HttpServletRequest request, Model model)
    {
        try {
            String userName = request.getParameter("userName");
            String repName = request.getParameter("repName");
            if( repService.deleteRepository(userName,repName))
                return "delete Res succeed!";
            else
                return "delete fail";
        } catch (Exception e) {
            System.out.println("para from createRes error");
            return "delete Res fail!";
        }
    }

    @RequestMapping(value = "/showRes",method= RequestMethod.POST)
    @ResponseBody
    public String showRepByUserName(HttpServletRequest request, Model model)
    {
        try {
           String userName = request.getParameter("userName");
           return repService.showAllRepByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
