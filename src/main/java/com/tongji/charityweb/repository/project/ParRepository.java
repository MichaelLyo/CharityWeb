package com.tongji.charityweb.repository.project;

import com.tongji.charityweb.model.project.Participate;
import com.tongji.charityweb.model.project.ProjectParticipateID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface ParRepository  extends JpaRepository<Participate,ProjectParticipateID> {
public List<Participate> findByParName(String parName);
}
