package com.tongji.charityweb.model.project;

import com.tongji.charityweb.model.user.User;

import javax.persistence.*;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "ProjectFollower")
public class ProjectFollower
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade= CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private User follower;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private Project project;

	public ProjectFollower(User follower, Project project)
	{
		this.follower = follower;
		this.project = project;
	}

	public ProjectFollower()
	{
	}

	public long getId()
	{
		return id;
	}

	public User getFollower()
	{
		return follower;
	}

	public Project getProject()
	{
		return project;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setFollower(User follower)
	{
		this.follower = follower;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}
}
