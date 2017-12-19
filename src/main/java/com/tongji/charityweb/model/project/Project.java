package com.tongji.charityweb.model.project;

import com.sun.istack.internal.NotNull;
import com.tongji.charityweb.model.comment.ProjectComment;
import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.comment.RepComRepository;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by LSL on 2017/11/21
 */
@Entity
@IdClass(ProjectID.class)
@Table(name = "Project")
public class Project
{
	@Id
	private String userName;

	@Id
	private String repName;

	@Id
	private String projName;

	private String context;

	private int participateNum;

	private int followerNum;

	private Date startDate;
	private Date endDate;

	private String status;

	private String projectType;

	private String descriptionPictureUrl;

	@ManyToOne(fetch=FetchType.LAZY)
	private Repository repository;


	@OneToMany(mappedBy="project")
	List<ProjectFollower>followers;


	@OneToMany(mappedBy="project")
	List<Participate>participates;


	@OneToMany(mappedBy="project")
	List<ProjectComment>projectComments;

	//constructor

	public Project() {}

	public Project(String repName, String projName, String userName) {
		this.repName = repName;
		this.projName = projName;
		this.userName =userName;
	}
	public List<Participate> getParticipates() {
		return participates;
	}

	public void addParticipate(Participate participate) {
		this.participates.add(participate);
		if(participate.getProject() != this){
			participate.setProject(this);
		}
	}

	public  boolean deleteParticipate(Participate participate){
		if(this.participates.contains(participate)){
			this.participates.remove(participate);
			return true;
		}
		return false;
	}
	public List<ProjectFollower> getFollowers() {
		return followers;
	}

	public void addFollower(ProjectFollower follower){
		this.followers.add(follower);
		if(follower.getProject() != this){
			follower.setProject(this);
		}
	}

	public boolean deleteFollower(ProjectFollower follower) {
		if(this.followers.contains(follower)){
			this.followers.remove(follower);
			return true;
		}
		return false;
	}
	public List<ProjectComment> getProjectComments() {
		return projectComments;
	}

	public void addProjectComment(ProjectComment comment){
		this.projectComments.add(comment);
		if(comment.getProject() != this){
			comment.setProject(this);
		}
	}

	public boolean deleteProjectComment(ProjectComment comment){
		if(this.projectComments.contains(comment)){
			this.projectComments.add(comment);
			return true;
		}
		return false;
	}



	public void setFollowers(List<ProjectFollower> followers) {
		this.followers = followers;
	}







	//getters

	public Repository getRepository() {
		return repository;
	}


	public String getRepositoryName() {
		return repName;
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

	public void setRepositoryName(String repName) {
		this.repName = repName;
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
		return projName;
	}

	public String getProjectType()
	{
		return projectType;
	}

	public String getStatus()
	{
		return status;
	}

	public String getUserName()
	{
		return userName;
	}

	public String getRepName()
	{
		return repName;
	}

	public String getProjName()
	{
		return projName;
	}

	//setters

	public void setContext(String context)
	{
		this.context = context;
	}

	public void setDescriptionPictureUrl(String descriptionPictureUrl)
	{
		this.descriptionPictureUrl = descriptionPictureUrl;
	}

	public void setRepository(Repository repository){
		this.repository = repository;
		if(!repository.getProjects().contains(this)){
			repository.getProjects().add(this);
		}
	}

	public void setProjectName(String projectName)
	{
		this.projName = projName;
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
