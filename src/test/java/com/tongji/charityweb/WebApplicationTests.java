package com.tongji.charityweb;

import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.user.Donate;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.project.ProjectRepository;
import com.tongji.charityweb.repository.user.DonateRepository;
import com.tongji.charityweb.repository.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaAuditing
public class WebApplicationTests
{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;


	@Autowired
	private DonateRepository donateRepository;




	@Test
	public void contextLoads() {
	}



	@Test
	public void testDbMapping()
	{
		User newUser = new User("511231530@qq.com","lsl","刘书良","lsldhr666","male","member");
		userRepository.save(newUser);
	}

	@Test
	public void testDatabase()
	{
		User newUser = new User("511231530@qq.com","lsl","刘书良","lsldhr666","male","member");
//		Project newProject = new Project("MyProject","");
//		userRepository.save(newUser);
//		projectRepository.save(newProject);
//
//		Donate donate = new Donate(newUser,newProject,1000);
//		donateRepository.save(donate);
//		Repository newRep = new Repository("Hope School");
	}

}
