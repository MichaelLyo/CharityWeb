package com.tongji.gongyi.service;


import com.tongji.gongyi.model.User;
import com.tongji.gongyi.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    public  List<HashMap<String,String>> showAllUser()
    {
        List<User> userDaoList =  (List<User>) userDao.findAll();
        ArrayList<HashMap<String,String>> userList = new ArrayList<>();
       for(User x :userDaoList)
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
           User user = new User(id);
           userDao.delete(user);
           return true;
       }
       catch(Exception ex)
       {
           return false;
       }
    }
}
