package com.tongji.charityweb.repository.project;

import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.project.ProjectID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProjectRepository  extends JpaRepository<Project,ProjectID> {
    public List<Project> findAllByRepNameAndUserName(String repName, String userName);
    public Page<Project> findAllByRepNameAndUserName(String repName, String userName, Pageable pageable);
    public List<Project> findByUserName(String userName);
    public List<Project> findByProjNameLike(String projName);
    public Project findByProjName(String projName);
    public Project findTopByOrderByFollowerNumDesc();

    public Project findTopByOrderByFollowerNum();
    public Page<Project> findAllByUserName(String username, Pageable pageable);
}
