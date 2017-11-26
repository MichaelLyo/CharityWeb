package com.tongji.charityweb.service;


import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
           user.put("id",String.valueOf(x.getId()));
           user.put("name",x.getName());
           user.put("email",x.getEmail());
           userList.add(user);
       }
       return userList;
    }

    public boolean deleteById(Long id)
    {
       try{
           userRepository.delete(id);
           return true;
       }
       catch(Exception ex)
       {
           return false;
       }
    }
}
