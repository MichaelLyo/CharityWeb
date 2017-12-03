package com.tongji.charityweb.repository.user;

import com.tongji.charityweb.model.user.UserFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserFollowerRepository  extends JpaRepository<UserFollower, Long> {
}
