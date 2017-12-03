package com.tongji.charityweb.service;


import com.tongji.charityweb.config.HttpSessionConfig;
import com.tongji.charityweb.controller.LoginController;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public  List<HashMap<String,String>> showAllUser()
    {
        List<User> repositoryAll =  userRepository.findAll();
        ArrayList<HashMap<String,String>> userList = new ArrayList<>();
       for(User x :repositoryAll)
       {
           HashMap<String, String>user = new HashMap<>();
           user.put("userName",x.getUserName());
           user.put("email",x.getEmail());
           userList.add(user);
       }
       return userList;
    }

    public boolean deleteByUserName(String userName)
    {
       try{
           userRepository.delete(userName);
           return true;
       }
       catch(Exception ex)
       {
           return false;
       }
    }

    public User getUserInSession(HttpSession session)
    {
        String username = (String) session.getAttribute(HttpSessionConfig.SESSION_USERNAME);
        User userInSession = userRepository.findByUsername(username);
        return userInSession;
    }
}
