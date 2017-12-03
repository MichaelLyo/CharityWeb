package com.tongji.charityweb.model.comment;

import com.tongji.charityweb.model.repository.Repository;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "RepositoryComment")
public class RepositoryComment
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String repositoryName;

	private String content;

	@CreatedDate
	private Date createdAt;

	private String pictureUrls;

	private int upvote;

	//编号
	private int num;

	public RepositoryComment(String content, Date createdAt, String pictureUrls, int upvote, int num) {
		this.content = content;
		this.createdAt = createdAt;
		this.pictureUrls = pictureUrls;
		this.upvote = upvote;
		this.num = num;
	}



	public RepositoryComment()
	{
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
}
