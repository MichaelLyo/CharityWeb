package com.tongji.charityweb.service;

import com.tongji.charityweb.model.comment.ProjectComment;
import com.tongji.charityweb.model.comment.RepositoryComment;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.repository.comment.ProjectCommentRepository;
import com.tongji.charityweb.repository.comment.RepComRepository;
import com.tongji.charityweb.repository.project.ProjectRepository;
import com.tongji.charityweb.repository.repository.RepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CommentService {
    @Autowired
    RepRepository repRepository;
    @Autowired
    RepComRepository repComRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectCommentRepository projectCommentRepository;

    public boolean createRepComment(String repName, String content) {
        try {
            Date createDate = new Date();
            RepositoryComment newRepCom = new RepositoryComment();
            newRepCom.setRepositoryName(repName);
            newRepCom.setContent(content);
            repComRepository.save(newRepCom);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRepComment(long id) {
        try {
            repComRepository.delete(id);
            return true;
        } catch  (Exception e) {
            return false;
        }
    }

    public String showAllComByRepName(String repName)
    {
        try {
            List<RepositoryComment> repositoryCommentList;
            Repository repository = repRepository.findByRepositoryName(repName);
            repositoryCommentList = repository.getComments();

            String comments = "";
            for(RepositoryComment x : repositoryCommentList) {
                comments += x.getContent()+"\n";
            }
            return comments;
        } catch (Exception e) {
            return "showAllComByRepName error";
        }
    }

    public boolean createProComment(long projectID, String repositoryName, String content) {
        try {
            ProjectComment newProCom = new ProjectComment();
            newProCom.setProjectID(projectID);
            newProCom.setRepositoryName(repositoryName);
            newProCom.setContent(content);
            projectCommentRepository.save(newProCom);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProComment(long id) {
        try {
            projectCommentRepository.delete(id);
            return true;
        } catch  (Exception e) {
            return false;
        }
    }

    public String showAllComByProID(long projectID)
    {
        try {
            List<ProjectComment> projectCommentList;
            Project project = projectRepository.findOne(projectID);
            projectCommentList = project.getProjectComments();

            String comments = "";
            for(ProjectComment x : projectCommentList) {
                comments += x.getContent()+"\n";
            }
            return comments;
        } catch (Exception e) {
            return "showAllComByProID error";
        }
    }
}
