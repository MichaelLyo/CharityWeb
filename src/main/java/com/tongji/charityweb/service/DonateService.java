package com.tongji.charityweb.service;

import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.user.Donate;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.user.DonateRepository;
import com.tongji.charityweb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	public void newDonate(User donor, Project project,int amount)
	{
		if(donor!=null && project!=null)
		{
			Donate newDonate = new Donate(donor.getUsername(), project.getProjectName(),project.getRepName(),amount);
			donor.addDonate(newDonate);
			userRepository.save(donor);
		}

	}

}
