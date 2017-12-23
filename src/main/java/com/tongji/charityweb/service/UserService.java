package com.tongji.charityweb.service;


import com.tongji.charityweb.config.HttpSessionConfig;
import com.tongji.charityweb.controller.LoginController;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.model.user.UserFollower;
import com.tongji.charityweb.repository.user.UserFollowerRepository;
import com.tongji.charityweb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFollowerRepository userFollowerRepository;
    @Autowired
    private FileService fileService;

    public boolean createUser(String userName, String email, String name, String password, String sex, String rank, MultipartFile file)
    {
        try{
           User newUser = new User(userName);
           newUser.setName(name);
           newUser.setEmail(email);
           newUser.setPassword(password);
           newUser.setSex(sex);
           newUser.setRank(rank);
           userRepository.save(newUser);
           fileService.uploadUserPicture(file, newUser);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return   false;
        }
    }

    public boolean deleteUser(String userName)
    {
        try{
            userRepository.deleteByUsername(userName);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public  List<HashMap<String,String>> showAllUser()
    {
        List<User> repositoryAll =  userRepository.findAll();
        ArrayList<HashMap<String,String>> userList = new ArrayList<>();
       for(User x :repositoryAll)
       {
           HashMap<String, String>user = new HashMap<>();
           user.put("userName",x.getUsername());
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

    public void userLogin(User userToLogin,HttpSession session)
    {
        session.setAttribute(HttpSessionConfig.SESSION_USERNAME,userToLogin.getUsername());
    }
    public void userLogout(HttpSession session)
    {
        session.removeAttribute(HttpSessionConfig.SESSION_USERNAME);
    }

    public boolean createUserFollower(String userName, String followerName) {
        try {
            User user = userRepository.findByUsername(userName);
            UserFollower newUserFollower = new UserFollower(userName, followerName);
            user.addFollower(newUserFollower);
            newUserFollower.setOwner(user);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUserFollower(String userName, String followerName) {
        try {
            UserFollower userFollower = userFollowerRepository.findByUsernameAndFollowername(userName, followerName);
            User user = userRepository.findByUsername(userName);
            if(userFollower == null || user == null)
                return false;
            user.deleteFollower(userFollower);
            userRepository.save(user);
            userFollowerRepository.delete(userFollower);
            return true;
        } catch  (Exception e) {
            return false;
        }
    }

    public UserFollower findOneFollower(String username, String followername) {
        try {
            return userFollowerRepository.findByUsernameAndFollowername(username, followername);
        } catch (Exception e) {
            return null;
        }
    }

    public String showAllFollower(String userName) {
        try {
            List<UserFollower> followerList;
            User user = userRepository.findByUsername(userName);
            followerList = user.getFollowers();

            String followers = "";
            for(UserFollower x : followerList) {
                followers += x.getFollowername()+"\n";
            }
            return followers;
        } catch (Exception e) {
            return "showAllFollower error";
        }
    }


}
