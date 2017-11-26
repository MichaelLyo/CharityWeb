package com.tongji.charityweb.model.repository;

import com.tongji.charityweb.model.user.User;

import javax.persistence.*;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "RepositoryUser")
public class RepositoryUser
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade= CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private Repository repository;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private User user;

	public RepositoryUser(Repository repository, User user)
	{
		this.repository = repository;
		this.user = user;
	}

	public RepositoryUser()
	{
	}

	public long getId()
	{
		return id;
	}

	public Repository getRepository()
	{
		return repository;
	}

	public User getUser()
	{
		return user;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setRepository(Repository repository)
	{
		this.repository = repository;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
}
