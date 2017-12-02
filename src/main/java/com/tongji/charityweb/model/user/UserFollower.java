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
	private long userFollowerID;

	private String username;

	private String followername;

	public long getUserFollowerID() {
		return userFollowerID;
	}

	public void setUserFollowerID(long userFollowerID) {
		this.userFollowerID = userFollowerID;
	}

	public String getUsername() {
		return username;
	}

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
