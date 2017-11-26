package com.tongji.charityweb.model.user;

import javax.persistence.*;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "UserFollower")
public class UserFollower
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private User user;

	@ManyToOne(cascade= CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private User follower;

	public UserFollower(User user, User follower)
	{
		this.user = user;
		this.follower = follower;
	}

	public UserFollower()
	{
	}

	public long getId()
	{
		return id;
	}

	public User getUser()
	{
		return user;
	}

	public User getFollower()
	{
		return follower;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public void setFollower(User follower)
	{
		this.follower = follower;
	}
}
