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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User owner;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userFollowerID;

	private String username;

	private String followername;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner)
	{
		this.owner = owner;
		if(!owner.getFollowers().contains(this)){
			owner.getFollowers().add(this);
		}
	}

	public long getUserFollowerID() {
		return userFollowerID;
	}

	public void setUserFollowerID(long userFollowerID) {
		this.userFollowerID = userFollowerID;
	}

	public String getUsername() {
		return username;
	}

	public UserFollower() {}

	public UserFollower(String username, String followername) {
		this.username = username;
		this.followername = followername;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getFollowername() {
		return followername;
	}

	public void setFollowername(String followername) {
		this.followername = followername;
	}
}
