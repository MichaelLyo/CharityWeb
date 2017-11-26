package com.tongji.charityweb.model.repository;

import com.tongji.charityweb.model.project.Project;

import javax.persistence.*;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "RepositoryProject")
public class RepositoryProject
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade= CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private Repository repository;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@PrimaryKeyJoinColumn
	private Project project;

	public RepositoryProject()
	{
	}

	public RepositoryProject(Repository repository, Project project)
	{
		this.repository = repository;
		this.project = project;
	}

	public long getId()
	{
		return id;
	}

	public Repository getRepository()
	{
		return repository;
	}

	public Project getProject()
	{
		return project;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setRepository(Repository repository)
	{
		this.repository = repository;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}
}
