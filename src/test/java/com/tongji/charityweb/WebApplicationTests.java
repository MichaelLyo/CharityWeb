package com.tongji.charityweb;

import com.tongji.charityweb.model.Project;
import com.tongji.charityweb.model.User;
import com.tongji.charityweb.repository.ProjectRepository;
import com.tongji.charityweb.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests
{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}


	@Test
	public void testDbMapping()
	{
		User newUser = new User("511231530@qq.com","lsl","lsldhr666","male","member");
		Project newProject = new Project("testPro",newUser);
		//userRepository.save(newUser);//因为在外码映射的时候设置了级联，因此只需保存project即可保存user
		projectRepository.save(newProject);
	}

}
