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

import java.util.Date;

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

		// 三个社团用户
		User caiyun = new User("caiyun@tongji.edu.cn","彩云支南","同济大学彩云支南协会","caiyun","male","member");
		User cat = new User("cat@tongji.edu.cn","宠物之家","猫咪同盟","cat","male","member");
		User chunhui = new User("caiyun@tongji.edu.cn","春晖之声","同济大学春晖社团","chunhui","male","member");
		userRepository.save(caiyun);
		userRepository.save(cat);
		userRepository.save(chunhui);

		Repository newRepository = new Repository("myRepo","lsl");
		repRepository.save(newRepository);

		// 三个社团的库
		Repository caiyunRep = new Repository("云南支教团","彩云支南");
		Repository catRep = new Repository("猫咪同盟","宠物之家");
		Repository chunhuiRep = new Repository("爱心屋活动","春晖之声");
		repRepository.save(caiyunRep);
		repRepository.save(catRep);
		repRepository.save(chunhuiRep);

		// 为了展示分页而设置的很多社团库
		for (int i=2; i<=11; i++) {
			Repository caiyunRep1 = new Repository("彩云活动库"+i,"彩云支南");
			Repository catRep1 = new Repository("猫咪活动库"+i,"宠物之家");
			Repository chunhuiRep1 = new Repository("春晖活动库"+i,"春晖之声");
			repRepository.save(caiyunRep1);
			repRepository.save(catRep1);
			repRepository.save(chunhuiRep1);
		}

		// 首页最上面的三个活动
		Project caiyunPro = new Project("云南支教团","我们与河西的一次约定","彩云支南");
		caiyunPro.setDescriptionPictureUrl("assets/img/caiyun-topnav.jpg");
		caiyunPro.setStatus("进行中");
		caiyunPro.setContext("2015年的夏天，怀着丝丝忐忑而激动的心情，同济大学彩云支南协会河西三队的我们，如期前往了云南省大理白族自治州鹤庆县黄坪镇河西村小，赴，同他们，第三次夏天的约定。");
		projectRepository.save(caiyunPro);
		Project catPro = new Project("猫咪同盟","同济大学猫咪同盟","宠物之家");
		catPro.setDescriptionPictureUrl("assets/img/cat-topnav.jpg");
		catPro.setStatus("进行中");
		catPro.setContext("新一年的领养活动要来啦~由猫咪同盟和@二月猫爱猫驿站-上海 合作的领养日义卖活动正在准备进行中，届时欢迎前来领养小宝贝们~~");
		projectRepository.save(catPro);
		Project chunhuiPro = new Project("爱心屋活动","四季春晖·爱在黔行","春晖之声");
		chunhuiPro.setDescriptionPictureUrl("assets/img/chunhui-topnav.jpg");
		chunhuiPro.setStatus("进行中");
		chunhuiPro.setContext("同济志愿者们带领此高中的小小志愿者们来到社区爱心屋开展活动。他们十分开朗，在接受了大哥哥大姐姐指导后，他们也悉心地教社区年龄更小的孩子们折纸，辅导他们课业，大家亲密无间地交流、沟通。");
		projectRepository.save(chunhuiPro);
		// 首页在参与的那个图片活动
		Project pro = new Project("云南支教团","To Protect Humanity","彩云支南");
		pro.setDescriptionPictureUrl("assets/img/action.jpg");
		pro.setStatus("进行中");
		pro.setContext("Nam nec tellus a odio tincidunt auctor a ornare odio.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.");
		projectRepository.save(pro);

		// 为了展示分页而设置的很多社团活动
		for (int i=1; i<=7; ++i) {
			Project caiyunPro1 = new Project("彩云活动库2","彩云活动"+i,"彩云支南");
			projectRepository.save(caiyunPro1);
		}

		//热点和在参与页面的很多活动
		for (int i=1; i<=30; i++) {
			Project newProject = new Project("myRepo","myPro"+i, "lsl");
			projectRepository.save(newProject);
		}

	}
}
