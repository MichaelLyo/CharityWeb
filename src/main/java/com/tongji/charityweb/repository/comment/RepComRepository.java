package com.tongji.charityweb.repository.comment;

import com.tongji.charityweb.model.comment.RepositoryComment;
import com.tongji.charityweb.model.comment.RepositoryCommentID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface RepComRepository extends JpaRepository<RepositoryComment,RepositoryCommentID> {
}
