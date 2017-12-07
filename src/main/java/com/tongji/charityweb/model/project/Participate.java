package com.tongji.charityweb.model.project;

import com.tongji.charityweb.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "Participate")
@IdClass(ProjectParticipateID.class)
public class Participate {
	@Id
	private String userName;
	@Id
	private String repName;
	@Id
	private String projName;
	@Id
	private String parName;




	@ManyToOne(fetch=FetchType.LAZY)
	private Project project;


	public Participate()
	{

	}

	public Participate(String userName, String repName, String projName, String parName) {
		this.userName = userName;
		this.repName = repName;
		this.projName = projName;
		this.parName = parName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project)
	{
		this.project = project;
		if(!project.getParticipates().contains(this)){
			project.getParticipates().add(this);
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getParName() {
		return parName;
	}

	public void setParName(String parName) {
		this.parName = parName;
	}
}
