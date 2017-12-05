package com.tongji.charityweb.model.repository;

import com.sun.istack.internal.NotNull;
import com.tongji.charityweb.model.comment.RepositoryComment;
import com.tongji.charityweb.model.project.Project;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by LSL on 2017/11/21
 */
@Entity
@Table(name = "Repository")
@EntityListeners(AuditingEntityListener.class)
public class Repository implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;



	@NotNull
	private String repositoryName;

	private String username;

	@CreatedDate
	private Date createdAt;

	private String descriptionPictureUrl;


	@OneToMany
	@JoinColumn(name="repositoryName")
	private List<Project> projects;

	@OneToMany
	@JoinColumn(name = "repositoryName")
	private List<RepositoryComment>comments;


	public List<Project> getProjects() {
		return projects;
	}

	public List<RepositoryComment> getComments() {
		return comments;
	}

	public Repository()
	{
	}

	public Repository(String repositoryName,String username)
	{
		this.username=username;
		this.repositoryName = repositoryName;
	}

	//getters
	public long getId() {
		return id;
	}


	public Date getCreatedAt()
	{
		return createdAt;
	}

	public String getUsername() {
		return username;
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
	public void setId(long id) {
		this.id = id;
	}
	public void setDescriptionPictureUrl(String descriptionPictureUrl)
	{
		this.descriptionPictureUrl = descriptionPictureUrl;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public void setRepositoryName(String repositoryName)
	{
		this.repositoryName = repositoryName;
	}
}
