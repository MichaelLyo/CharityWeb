package com.tongji.charityweb.model.user;

import com.tongji.charityweb.model.project.Project;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "Donate")
@EntityListeners(AuditingEntityListener.class)
public class Donate
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donateID;

	private String username;

	private long projectID;

	//@Column(nullable=false,columnDefinition="INT default 0")
	private int amount;

	//@Column(nullable = false, updatable = false)
	//@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	public Donate()
	{
	}
	public Donate(String username, long projectID, int amount)
	{
		this.username=username;
		this.projectID=projectID;
		this.amount = amount;
	}



	public long getId()
	{
		return donateID;
	}

	public int getAmount()
	{
		return amount;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}


	public Long getDonateID() {
		return donateID;
	}


	public String getUsername() {
		return username;
	}



	public long getProjectID() {
		return projectID;
	}


	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public void setDonateID(long donateID)
	{
		this.donateID= donateID;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
}
