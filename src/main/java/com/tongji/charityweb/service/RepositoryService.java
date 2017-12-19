package com.tongji.charityweb.service;

import ch.qos.logback.classic.turbo.TurboFilter;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.project.ProjectID;
import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.repository.RepositoryID;
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
    ProjectRepository projectRepository;

    @Autowired
    RepComRepository repComRepository;

    @Autowired
    UserRepository userRepository;




    public boolean createRepository( String repName, String description, User user)
    {
        try {

            Date createDate = new Date();
            Repository newRep = new Repository(repName, user.getUsername());
            newRep.setDescription(description);

            user.addRepository(newRep);
            userRepository.save(user);
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
            RepositoryID repositoryID = new RepositoryID(userName, repName);
            repRepository.delete(repositoryID);
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
