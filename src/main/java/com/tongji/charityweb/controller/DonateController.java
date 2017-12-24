package com.tongji.charityweb.controller;

import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.user.Donate;
import com.tongji.charityweb.model.user.User;
import com.tongji.charityweb.service.DonateService;
import com.tongji.charityweb.service.ProjectService;
import com.tongji.charityweb.service.RepositoryService;
import com.tongji.charityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LSL on 2017/12/24
 */
@Controller
public class DonateController
{
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	private DonateService donateService;
	//donate相关
	@RequestMapping(value = "donate",method = RequestMethod.GET)
	public String donate(String projName, String repName, String userName, Model model)
	{
		Project project = projectService.findOneProject(projName,repName,userName);
		model.addAttribute("project", project);
		return "action/donate";
	}
	@RequestMapping(value = "donate",method = RequestMethod.POST)
	public String donate(String projName, String repName, String userName, HttpServletRequest request, Model model)
	{
		User user = userService.getUserInSession(request.getSession());
		Project project = projectService.findOneProject(projName,repName,userName);
		if (user == null)
		{
			return "redirect:/login";
		}
		int amount = 10;
		if (request.getParameter("amount")!=null)
		{
			//amount=Integer.getInteger();
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		else {
			System.out.println("amount is null");
		}
		donateService.newDonate(user,project,amount);
		model.addAttribute("project", project);
		return "action/activity";
	}

	@RequestMapping(value = "mgtDonate",method = RequestMethod.GET)
	public String mgtDonate(HttpServletRequest request,Model model)
	{
		User userInSession = userService.getUserInSession(request.getSession());
		if(userInSession!=null)
		{
			List<Donate> donates = donateService.getDonateRecordsByUser(userInSession);
			model.addAttribute("donates", donates);
			model.addAttribute("user", userInSession);
			return "management/mgtDonate";
		}
		else {
			return "redirect:/sessionLost";
		}
	}
}
