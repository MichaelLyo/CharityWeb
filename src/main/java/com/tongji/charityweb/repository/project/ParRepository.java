package com.tongji.charityweb.repository.project;

import com.tongji.charityweb.model.project.Participate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface ParRepository  extends JpaRepository<Participate,Long> {
}
