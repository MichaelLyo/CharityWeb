package com.tongji.charityweb.model.project;

import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;
import com.tongji.charityweb.model.user.User;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "ProjectFollower")
@IdClass(ProjectFollowerID.class)
@EntityListeners(AuditingEntityListener.class)
public class ProjectFollower
{

	@Id
	@NotNull
	private String userName;

	@Id
	@NotNull
	private String repName;

	@Id
	@NotNull
	private String projName;

	@Id
	@NotNull
	private String followerName;

	@CreatedDate
	@NotNull
	private Date followDate;

	@ManyToOne(fetch=FetchType.LAZY)
	private Project project;

	public ProjectFollower(String userName, String repName, String projName, String followerName) {
		this.userName = userName;
		this.repName = repName;
		this.projName = projName;
		this.followerName = followerName;
	}

	public ProjectFollower() {
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
		if(!project.getFollowers().contains(this))
		{
			project.getFollowers().add(this);
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

	public String getFollowerName() {
		return followerName;
	}

	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}

	public Date getFollowDate() {
		return followDate;
	}

	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}
}
