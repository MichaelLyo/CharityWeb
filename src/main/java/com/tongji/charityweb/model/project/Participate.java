package com.tongji.charityweb.model.project;

import com.tongji.charityweb.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "Participate")
public class Participate {
	// columns
	@Id
	private long id;


	@NotNull
	private String userID;


	@NotNull
	private String parID;


	public Participate(long id, String userID, String parID) {
		this.userID = userID;
		this.parID = parID;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getParID() {
		return parID;
	}

	public void setParID(String parID) {
		this.parID = parID;
	}

	public Participate()
	{

	}

}
