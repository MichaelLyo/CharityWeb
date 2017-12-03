package com.tongji.charityweb.model.project;

import com.sun.istack.internal.NotNull;
import com.tongji.charityweb.model.comment.ProjectComment;
import com.tongji.charityweb.model.user.User;



import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by LSL on 2017/11/21
 */
@Entity
@Table(name = "Project")
public class Project
{

	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String repositoryName;

	@NotNull
	private String projectName;


	@OneToMany
	@JoinColumn(name="id")
	List<ProjectFollower>followers;


	@OneToMany
	@JoinColumn(name="id")
	List<Participate>participates;



	@OneToMany
	@JoinColumn(name="projectID",referencedColumnName = "id")
	List<ProjectComment>projectComments;

	public List<Participate> getParticipates() {
		return participates;
	}
	public List<ProjectFollower> getFollowers() {
		return followers;
	}

	public List<ProjectComment> getProjectComments() {
		return projectComments;
	}

	public void setFollowers(List<ProjectFollower> followers) {
		this.followers = followers;
	}


	private String context;

	private int participateNum;

	private int followerNum;

	private Date startDate;
	private Date endDate;

	private String status;

	private String projectType;

	private String descriptionPictureUrl;


	//constructor


	public Project(String repositoryName, String projectName) {
		this.repositoryName = repositoryName;
		this.projectName = projectName;
	}

	//getters

	public long getId() {
		return id;
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public String getDescriptionPictureUrl()
	{
		return descriptionPictureUrl;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public int getFollowerNum()
	{
		return followerNum;
	}

	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}

	public int getParticipateNum()
	{
		return participateNum;
	}

	public String getContext()
	{
		return context;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public String getProjectType()
	{
		return projectType;
	}

	public String getStatus()
	{
		return status;
	}




	public void setContext(String context)
	{
		this.context = context;
	}

	public void setDescriptionPictureUrl(String descriptionPictureUrl)
	{
		this.descriptionPictureUrl = descriptionPictureUrl;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public void setParticipateNum(int participateNum)
	{
		this.participateNum = participateNum;
	}

	public void setFollowerNum(int followerNum)
	{
		this.followerNum = followerNum;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public void setProjectType(String projectType)
	{
		this.projectType = projectType;
	}
}
