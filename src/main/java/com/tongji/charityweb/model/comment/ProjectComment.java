package com.tongji.charityweb.model.comment;

import com.tongji.charityweb.model.project.Project;
import javax.persistence.*;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "ProjectComment")
public class ProjectComment
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade= CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private Project project;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private Comment comment;


	private int num;

	public ProjectComment(Project project, Comment comment, int num)
	{
		this.project = project;
		//this.comment = comment;
		this.num = num;
	}

	public ProjectComment()
	{
	}

	public long getId()
	{
		return id;
	}

	public Project getProject()
	{
		return project;
	}

	public Comment getComment()
	{
		return comment;
	}

	public int getNum()
	{
		return num;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}

	public void setComment(Comment comment)
	{
		this.comment = comment;
	}

	public void setNum(int num)
	{
		this.num = num;
	}
}
