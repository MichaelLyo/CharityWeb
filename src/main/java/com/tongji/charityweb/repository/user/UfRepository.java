package com.tongji.charityweb.repository.user;

import com.tongji.charityweb.model.user.UserFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LSL on 2017/11/24
 */
@Transactional
@Repository
public interface UfRepository extends JpaRepository<UserFollower,Long>
{
}
