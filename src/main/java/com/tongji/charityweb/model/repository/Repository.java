package com.tongji.charityweb.model.repository;

import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LSL on 2017/11/21
 */
@Entity
@Table(name = "Repository")
@EntityListeners(AuditingEntityListener.class)
public class Repository
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String repositoryName;

	//@Column(nullable = false, updatable = false)
	//@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	private String descriptionPictureUrl;

	public Repository()
	{
	}

	public Repository(String repositoryName)
	{
		this.repositoryName = repositoryName;
	}

	//getters
	public Date getCreatedAt()
	{
		return createdAt;
	}

	public long getId()
	{
		return id;
	}

	public String getDescriptionPictureUrl()
	{
		return descriptionPictureUrl;
	}

	public String getRepositoryName()
	{
		return repositoryName;
	}

	//setters
	//createdAt是不可更新的，所以不设置setter

	public void setDescriptionPictureUrl(String descriptionPictureUrl)
	{
		this.descriptionPictureUrl = descriptionPictureUrl;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setRepositoryName(String repositoryName)
	{
		this.repositoryName = repositoryName;
	}
}
