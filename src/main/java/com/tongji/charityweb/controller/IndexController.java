package com.tongji.charityweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }
    @RequestMapping(value = "me",method = RequestMethod.GET)
    public String me()
    {
        return "index";
    }
    @RequestMapping(value = "caiyun")
    public String caiyun(){
        return "action/caiyun-index";
    }
    @RequestMapping(value = "chunhui")
    public String chunhui(){
        return "action/chunhui-index";
    }
    @RequestMapping(value = "cat")
    public String cat(){
        return "action/cat-index";
    }
    @RequestMapping(value = "login")
    public String login(){
        return "login/login";
    }
    @RequestMapping(value = "regist")
    public String regist(){ return "login/regist"; }
    @RequestMapping(value = "activity")
    public String activity(){
        return "action/activity";
    }
    @RequestMapping(value = "userInfo")
    public String userInfo(){
        return "management/userInfo";
    }
    @RequestMapping(value = "hotspot")
    public String hotspot(){
        return "hotspot/hotspot-index";
    }
    @RequestMapping(value = "participate")
    public String participate(){
        return "participate/participate-index";
    }
    @RequestMapping(value = "donate")
    public String donate(){
        return "action/donate";
    }
    @RequestMapping(value = "editInfo")
    public String editInfo(){
        return "login/editInfo";
    }
    @RequestMapping(value = "addRepository")
    public String addRepository(){
        return "management/addRepository";
    }
    @RequestMapping(value = "addProject")
    public String addProject(){
        return "management/addProject";
    }
}
