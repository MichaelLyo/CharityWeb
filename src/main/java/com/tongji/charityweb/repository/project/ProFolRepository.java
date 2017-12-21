package com.tongji.charityweb.repository.project;

import com.tongji.charityweb.model.project.ProjectFollower;
import com.tongji.charityweb.model.project.ProjectFollowerID;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Max;
import java.util.List;


@Transactional
@Repository
public interface ProFolRepository  extends JpaRepository<ProjectFollower,ProjectFollowerID> {
    List<ProjectFollower> findByFollowerName(String followerName);
}
