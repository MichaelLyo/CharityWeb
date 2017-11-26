package com.tongji.charityweb.model.project;

import com.tongji.charityweb.model.user.User;

import javax.persistence.*;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "Participate")
public class Participate
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private User user;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private Project project;


	//constructors
	Participate()
	{

	}

	public Participate(User user, Project project)
	{
		this.user = user;
		this.project = project;
	}

	//getters
	public User getUser()
	{
		return user;
	}

	public Project getProject()
	{
		return project;
	}

	//setters
	public void setProject(Project project)
	{
		this.project = project;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
}
