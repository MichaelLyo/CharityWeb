package com.tongji.charityweb.model.comment;

import com.tongji.charityweb.model.repository.Repository;

import javax.persistence.*;

/**
 * Created by LSL on 2017/11/24
 */
@Entity
@Table(name = "RepositoryComment")
public class RepositoryComment
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
	private Comment comment;


	//编号
	private int num;

	public RepositoryComment()
	{
	}

	public RepositoryComment(Repository repository, Comment comment, int num)
	{
		this.repository = repository;
		this.comment = comment;
		this.num = num;
	}

	public long getId()
	{
		return id;
	}

	public Repository getRepository()
	{
		return repository;
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

	public void setRepository(Repository repository)
	{
		this.repository = repository;
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
