package com.tongji.charityweb.service;

import com.tongji.charityweb.model.comment.ProjectComment;
import com.tongji.charityweb.model.comment.ProjectCommentID;
import com.tongji.charityweb.model.comment.RepositoryComment;
import com.tongji.charityweb.model.comment.RepositoryCommentID;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.project.ProjectID;
import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.repository.RepositoryID;
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

    public boolean createRepComment(String repName,String userName, String content) {
        try {
            Repository repository = repRepository.findOne(new RepositoryID(repName, userName));

            Date createDate = new Date();
            RepositoryComment newRepCom = new RepositoryComment( repName, userName);
            newRepCom.setContent(content);

            repository.addComment(newRepCom);

            repRepository.save(repository);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRepComment(String repName,String userName, int num) {
        try {
            repComRepository.delete(new RepositoryCommentID(num, repName, userName));
            return true;
        } catch  (Exception e) {
            return false;
        }
    }

    public String showAllComByRepName(String repName, String userName)
    {
        try {
            List<RepositoryComment> repositoryCommentList;
            Repository repository = repRepository.findOne(new RepositoryID(userName,repName));
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

    public boolean createProComment(String projName, String repName, String userName, String content) {
        try {
            Project project = projectRepository.findOne(new ProjectID(projName, repName, userName));

            ProjectComment newProCom = new ProjectComment(projName, repName, userName);
            newProCom.setContent(content);

            project.addProjectComment(newProCom);
            projectRepository.save(project);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteProComment(String projName, String repName, String userName,int num) {
        try {
            projectCommentRepository.delete( new ProjectCommentID(projName, repName, userName, num));
            return true;
        } catch  (Exception e) {
            return false;
        }
    }

    public String showAllComByProID(String projName, String repName, String userName)
    {
        try {
            List<ProjectComment> projectCommentList;
            Project project = projectRepository.findOne(new ProjectID(projName, repName, userName));
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
