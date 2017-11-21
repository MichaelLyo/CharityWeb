package com.tongji.charityweb.model;

import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LSL on 2017/11/21
 */
@Entity
@Table(name = "Project")
public class Project
{
	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String projectName;

	@NotNull

	private String ownerID;

	private String context;

	private int participateNum;

	private int followerNum;

	private Date startDate;
	private Date endDate;

	private String status;

	private String projectType;

	private String descriptionPictureUrl;
}
