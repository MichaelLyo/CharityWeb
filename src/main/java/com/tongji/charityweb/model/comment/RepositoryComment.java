package com.tongji.charityweb.model.comment;

import com.tongji.charityweb.model.repository.Repository;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Struct;
import java.util.Date;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@IdClass(RepositoryCommentID.class)
@Table(name = "RepositoryComment")
@EntityListeners(AuditingEntityListener.class)
public class RepositoryComment
{

	// columns
	@Id
	private int num;

	@Id
	private String repName;

	@Id
	private String userName;

	private String commenterName;

	private String content;

	@CreatedDate
	private Date createdDate;

	private String pictureUrls;

	private int upvote;



	@ManyToOne(fetch=FetchType.LAZY)
	private Repository repository;


	public RepositoryComment()
	{
	}
	public RepositoryComment(String repName, String userName) {
		this.repName = repName;
		this.userName = userName;
	}


	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository){
		this.repository = repository;
		if(!repository.getProjects().contains(this)){
			repository.getComments().add(this);
		}
	}

	public String getCommenterName() {
		return commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPictureUrls() {
		return pictureUrls;
	}

	public void setPictureUrls(String pictureUrls) {
		this.pictureUrls = pictureUrls;
	}

	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}

}
