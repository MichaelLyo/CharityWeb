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
	private String projectID;


	@NotNull
	private String followerID;

	public ProjectFollower(long id, String projectID, String followerID) {
		this.id = id;
		this.projectID = projectID;
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

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String folleredID) {
		this.projectID = folleredID;
	}

	public String getFollowerID() {
		return followerID;
	}

	public void setFollowerID(String followerID) {
		this.followerID = followerID;
	}





}
