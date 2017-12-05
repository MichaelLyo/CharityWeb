package com.tongji.charityweb.repository.project;

import com.tongji.charityweb.model.project.ProjectFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface ProFolRepository  extends JpaRepository<ProjectFollower,Long> {
    public ProjectFollower findByProjectIDAndFollowerID(String projectID, String followerID);
}
