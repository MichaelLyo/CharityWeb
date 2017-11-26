package com.tongji.charityweb.model.project;

import com.sun.istack.internal.NotNull;
import com.tongji.charityweb.model.user.User;


import javax.persistence.*;
import java.util.Date;

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
	private String projectName;

	//外码约束。在数据库中表现为owner_id。
	//CascadeType设置级联删除
	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private User owner;

	private String context;

	private int participateNum;

	private int followerNum;

	private Date startDate;
	private Date endDate;

	private String status;

	private String projectType;

	private String descriptionPictureUrl;


	//constructor
	public Project(String projectName, User owner)
	{
		this.projectName = projectName;
		this.owner = owner;
	}

	//getters
	public User getOwner()
	{
		return owner;
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

	public int getParticipateNum()
	{
		return participateNum;
	}

	public long getId()
	{
		return id;
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


	//setters
	public void setOwner(User owner)
	{
		this.owner = owner;
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
