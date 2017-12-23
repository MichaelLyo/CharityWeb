package com.tongji.charityweb.model.repository;

import com.sun.istack.internal.NotNull;
import com.tongji.charityweb.model.comment.RepositoryComment;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.user.User;
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
@IdClass(RepositoryID.class)
@EntityListeners(AuditingEntityListener.class)
public class Repository implements Serializable
{
	@Id
	private String repName;

    @Id
	private String userName;


	@CreatedDate
	private Date createdAt;



	private String descriptionPictureUrl;

	private String description;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="repository")
	private List<Project> projects;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="repository")
	private List<RepositoryComment>comments;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;

	public List<Project> getProjects() {
		return projects;
	}


	public void addProject(Project project){
		this.projects.add(project);
		if(project.getRepository() != this){
			project.setRepository(this);
		}
	}

	public boolean deleteProject(Project project){
		if(this.projects.contains(project)){
			this.projects.remove(project);
			return true;
		}
		return false;
	}

	public List<RepositoryComment> getComments() {
		return comments;
	}

	public void addComment(RepositoryComment comment){
		this.comments.add(comment);
		if(comment.getRepository() != this){
			comment.setRepository(this);
		}
	}

	public boolean deleteComment(RepositoryComment comment){
		if(this.comments.contains(comment)){
			this.comments.remove(comment);
			return true;
		}
		return false;
	}

	public Repository()
	{
	}

	public Repository(String repositoryName, String username)
	{
		this.repName = repositoryName;
		this.userName=username;
	}

	//getters
	public User getUser() {
		return user;
	}

	public String getUsername() {
		return userName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}


	public String getDescriptionPictureUrl()
	{
		return descriptionPictureUrl;
	}

	public String getRepositoryName()
	{
		return repName;
	}

	public String getUserName()
	{
		return userName;
	}

	public String getRepName()
	{
		return repName;
	}
	//setters
	//createdAt是不可更新的，所以不设置setter

	public void setUsername(String username) {
		this.userName = username;
	}

	public void setUser(User user) {
		this.user = user;
		if(!user.getRepositories().contains(this)){
			user.getRepositories().add(this);
		}
	}

	public void setDescriptionPictureUrl(String descriptionPictureUrl)
	{
		this.descriptionPictureUrl = descriptionPictureUrl;
	}

	public void setRepositoryName(String repositoryName)
	{
		this.repName = repositoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
