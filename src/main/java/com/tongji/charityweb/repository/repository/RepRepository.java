package com.tongji.charityweb.repository.repository;

import com.tongji.charityweb.model.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@org.springframework.stereotype.Repository
public interface RepRepository  extends JpaRepository<Repository,String> {
    public Repository findByRepositoryName(String repName);
}
