package com.tongji.charityweb.service;

import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.comment.RepComRepository;
import com.tongji.charityweb.repository.project.ProjectRepository;
import com.tongji.charityweb.repository.repository.RepRepository;
import com.tongji.charityweb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RepositoryService {
    @Autowired
    RepRepository repRepository;

    @Autowired
    RepComRepository repComRepository;

    @Autowired
    UserRepository userRepository;

    public boolean createRepository(String userName, String repName)
    {
        try {
            Date createDate = new Date();
            Repository newRep = new Repository();
            newRep.setRepositoryName(repName);
            newRep.setUsername(userName);
            repRepository.save(newRep);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRepository(String userName,String repName)
    {
        try
        {
            repRepository.delete(repName);
            return true;
        }
        catch  (Exception e)
        {
            return false;
        }
    }

    public String showAllRepByUserName(String userName)
    {
        try
        {
            List<Repository> repositoryList;
            User user = userRepository.findByUsername(userName);
            repositoryList = user.getRepositories();

            String result = "";

            for(Repository x : repositoryList)
            {
                result += x.getRepositoryName()+"\n";
            }
            return result;
        }
        catch (Exception e)
        {
            return "showAllRepByUserName error";
        }
    }
}
