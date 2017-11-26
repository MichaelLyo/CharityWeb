package com.tongji.charityweb.model.comment;

import com.tongji.charityweb.model.user.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LSL on 2017/11/24
 */

@Entity
@Table(name = "Comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String content;

	@ManyToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User owner;

	//@Column(nullable = false, updatable = false)
	//@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	private String pictureUrls;

	private int upvote;

	public Comment(String content, User owner, int upvote)
	{
		this.content = content;
		this.owner = owner;
		this.upvote = upvote;
	}

	public Comment()
	{
	}

	public void addUpvote()
	{
		this.upvote +=1;
	}
	//getters

	public long getId()
	{
		return id;
	}

	public String getContent()
	{
		return content;
	}

	public User getOwner()
	{
		return owner;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public String getPictureUrls()
	{
		return pictureUrls;
	}

	public int getUpvote()
	{
		return upvote;
	}

	//setters

	public void setId(long id)
	{
		this.id = id;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public void setOwner(User owner)
	{
		this.owner = owner;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public void setPictureUrls(String pictureUrls)
	{
		this.pictureUrls = pictureUrls;
	}

	public void setUpvote(int upvote)
	{
		this.upvote = upvote;
	}
}
