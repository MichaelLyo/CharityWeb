package com.tongji.charityweb.model.project;

import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;
import com.tongji.charityweb.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "ProjectFollower")
public class ProjectFollower
{
	@Id
	private long id;


	@NotNull
	private String folleredID;


	@NotNull
	private String followerID;

	public ProjectFollower(long id, String folleredID, String followerID) {
		this.id = id;
		this.folleredID = folleredID;
		this.followerID = followerID;
	}

	public ProjectFollower() {
	}


	public long	 getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFolleredID() {
		return folleredID;
	}

	public void setFolleredID(String folleredID) {
		this.folleredID = folleredID;
	}

	public String getFollowerID() {
		return followerID;
	}

	public void setFollowerID(String followerID) {
		this.followerID = followerID;
	}





}
