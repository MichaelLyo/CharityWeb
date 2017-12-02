package com.tongji.charityweb.repository.user;

import com.tongji.charityweb.model.user.Donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DonateRepository extends JpaRepository<Donate,Long> {
}
