package com.tongji.charityweb.repository.user;

import com.tongji.charityweb.model.user.Donate;
import com.tongji.charityweb.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public interface DonateRepository extends JpaRepository<Donate,Long> {
        public List<Donate> findByUsername(String userName);
        public Page<Donate> findAllByDonator(User donator, Pageable pageable);
}

