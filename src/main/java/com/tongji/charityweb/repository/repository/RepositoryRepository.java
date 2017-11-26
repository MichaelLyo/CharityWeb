package com.tongji.charityweb.repository.repository;

import com.tongji.charityweb.model.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by LSL on 2017/11/24
 */
@Transactional
@org.springframework.stereotype.Repository
public interface RepositoryRepository extends JpaRepository<Repository,Long>
{
}
