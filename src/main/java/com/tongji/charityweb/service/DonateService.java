package com.tongji.charityweb.service;

import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.user.Donate;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.project.ProjectRepository;
import com.tongji.charityweb.repository.user.DonateRepository;
import com.tongji.charityweb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by LSL on 2017/12/21
 */
@Component
public class DonateService
{
	@Autowired
	private DonateRepository donateRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectRepository projectRepository;

	public void newDonate(User donor, Project project,int amount)
	{
		if(donor!=null && project!=null)
		{
			Donate newDonate = new Donate(project.getUserName(), project.getProjectName(),project.getRepName(),amount);
			project.setDonateAmount(project.getDonateAmount()+amount);
			donor.addDonate(newDonate);
			try {
				userRepository.save(donor);
				projectRepository.save(project);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public Page<Donate> getDonateRecordsByUser(User user,int page,int size)
	{
		if (user!=null) {
			Pageable pageable = new PageRequest(page,size);
			try {
				return donateRepository.findAllByDonator(user,pageable);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

 }
