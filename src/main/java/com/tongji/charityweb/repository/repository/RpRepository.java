package com.tongji.charityweb.repository.repository;

import com.tongji.charityweb.model.repository.RepositoryProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LSL on 2017/11/24
 */
@Transactional
@Repository
public interface RpRepository extends JpaRepository<RepositoryProject,Long>
{
}
