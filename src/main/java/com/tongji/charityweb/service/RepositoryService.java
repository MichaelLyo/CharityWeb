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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.channels.MulticastChannel;
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

    @Autowired
    FileService fileService;




    public boolean createRepository(String repName, String description, User user, MultipartFile file)
    {
        try {

            Date createDate = new Date();
            Repository newRep = new Repository(repName, user.getUsername());
            newRep.setDescription(description);
            user.addRepository(newRep);

            String uploadInfo =  fileService.uploadRepositoryPicture(file, newRep);;
            if(uploadInfo.contains("upload failed,"))
            {
                //上传失败前端要干啥？
            }
            else
            {
                newRep.setDescriptionPictureUrl(uploadInfo);
            }
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

    public Repository findOneRepository(String repName, String userName) {
        try {
            return repRepository.findOne(new RepositoryID(userName, repName));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Project> findAllProjectsInRep(String repName, String userName) {
        try {
            return projectRepository.findAllByRepNameAndUserName(repName,userName);
        } catch (Exception e)  {
            e.printStackTrace();
            return null;
        }
    }

    public Page<Repository> getRepPageByUserName(String userName, int page, int size) {
        try {
            Pageable pageable = new PageRequest(page, size);
            return repRepository.findAllByUserName(userName, pageable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Repository> findRepositoryLike(String toSearch)
    {
        return repRepository.findByRepNameLike(toSearch);
    }
}
