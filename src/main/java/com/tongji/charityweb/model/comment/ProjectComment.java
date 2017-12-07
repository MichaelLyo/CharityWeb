package com.tongji.charityweb.model.comment;


import com.tongji.charityweb.model.project.Project;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@IdClass(ProjectCommentID.class)
@Table(name = "ProjectComment")
public class ProjectComment
{
	@Id
	private String projName;
	@Id
	private String repName;
	//编号
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;

	@Id
	private String userName;

	private String content;

	@CreatedDate
	private Date createdAt;

	private String pictureUrls;

	private int upvote;




	@ManyToOne(fetch=FetchType.LAZY)
	private Project project;


	public ProjectComment() {

	}
	public ProjectComment(String projName, String repName, String userName) {
		this.projName = projName;
		this.repName = repName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project){
		this.project = project;
		if(!project.getProjectComments().contains(this)){
			project.getProjectComments().add(this);
		}
	}


	public String  getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getPictureUrls() {
		return pictureUrls;
	}

	public void setPictureUrls(String pictureUrls) {
		this.pictureUrls = pictureUrls;
	}

	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
