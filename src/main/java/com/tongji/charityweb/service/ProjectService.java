package com.tongji.charityweb.service;

import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.project.ProjectFollower;
import com.tongji.charityweb.repository.project.ProFolRepository;
import com.tongji.charityweb.repository.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProFolRepository proFolRepository;

    public boolean createProFollower(String projectID, String followerID) {
        try {
            ProjectFollower newProFollower = new ProjectFollower();
            newProFollower.setProjectID(projectID);
            newProFollower.setFollowerID(followerID);
            proFolRepository.save(newProFollower);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProFollower(String projectID, String followerID) {
        try {
            proFolRepository.delete(proFolRepository.findByProjectIDAndFollowerID(projectID, followerID));
            return true;
        } catch  (Exception e) {
            return false;
        }
    }

    public String showAllProFollower(String projectID) {
        try {
            List<ProjectFollower> followerList;
            Project project = projectRepository.findOne(Long.valueOf(projectID));
            followerList = project.getFollowers();

            String followers = "";
            for(ProjectFollower x : followerList) {
                followers += x.getFollowerID()+"\n";
            }
            return followers;
        } catch (Exception e) {
            return "showAllProFollower error";
        }
    }
}
