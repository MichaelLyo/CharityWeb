package com.tongji.charityweb.repository.project;

import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.project.ProjectID;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Transactional
@Repository
public interface ProjectRepository  extends JpaRepository<Project,ProjectID> {
    public List<Project> findAllByRepNameAndUserName(String repName, String userName);
}
