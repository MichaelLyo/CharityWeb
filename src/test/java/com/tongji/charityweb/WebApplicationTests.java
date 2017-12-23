package com.tongji.charityweb;

import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.user.Donate;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.repository.project.ProjectRepository;
import com.tongji.charityweb.repository.repository.RepRepository;
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
	private RepRepository repRepository;


	@Autowired
	private DonateRepository donateRepository;




	@Test
	public void contextLoads() {
	}



	@Test
	public void testDatabase()
	{
		User newUser = new User("511231530@qq.com","lsl","刘书良","lsldhr666","male","member");
		userRepository.save(newUser);
//		Project newProject = new Project("MyProject","");
//		userRepository.save(newUser);
//		projectRepository.save(newProject);
//
//		Donate donate = new Donate(newUser,newProject,1000);
//		donateRepository.save(donate);
//		Repository newRep = new Repository("Hope School");
	}

	@Test
	public void testProject()
	{
		User newUser = new User("511231530@qq.com","lsl","刘书良","lsldhr666","male","member");
		userRepository.save(newUser);
		User caiyun = new User("caiyun@163.com","caiyun","彩云","caiyun","male","member");
		User cat = new User("cat@163.com","cat","猫咪","cat","male","member");
		User chunhui = new User("caiyun@163.com","chunhui","春晖","chunhui","male","member");
		userRepository.save(caiyun);
		userRepository.save(cat);
		userRepository.save(chunhui);
		Repository newRepository = new Repository("myRepo","lsl");
		repRepository.save(newRepository);
		Repository caiyunRep1 = new Repository("caiyunRep1","caiyun");
		for (int i=1; i<=10; i++) {
			Repository caiyunRep = new Repository("caiyunRep"+i,"caiyun");
			Repository catRep = new Repository("catRep"+i,"cat");
			Repository chunhuiRep = new Repository("chunhuiRep"+i,"chunhui");
			repRepository.save(caiyunRep);
			repRepository.save(catRep);
			repRepository.save(chunhuiRep);
		}
		for (int i=1; i<=5; ++i) {
			Project caiyunPro = new Project("caiyunRep1","caiyunPro"+i,"caiyun");
			projectRepository.save(caiyunPro);
		}
		repRepository.save(caiyunRep1);
		for (int i=1; i<=30; i++) {
			Project newProject = new Project("myRep","myPro"+i, "lsl");
			projectRepository.save(newProject);
		}
//		Project newProject1 = new Project("myRep","myPro1","lsl");
//		Project newProject2 = new Project("myRep","myPro2","lsl");
		repRepository.save(newRepository);
//		projectRepository.save(newProject1);
//		projectRepository.save(newProject2);

	}
}
