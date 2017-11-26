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
	private long id;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private User donor;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private Project project;

	//@Column(nullable=false,columnDefinition="INT default 0")
	private int amount;

	//@Column(nullable = false, updatable = false)
	//@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	public Donate(User donor, Project project, int amount)
	{
		this.donor = donor;
		this.project = project;
		this.amount = amount;
	}

	public Donate()
	{
	}

	public long getId()
	{
		return id;
	}

	public User getDonor()
	{
		return donor;
	}

	public Project getProject()
	{
		return project;
	}

	public int getAmount()
	{
		return amount;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setDonor(User donor)
	{
		this.donor = donor;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}
}
