package controller;

import org.apache.commons.collections4.Get;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LSL on 2017/11/13
 */

@Controller    // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with / (after Application path)
public class IndexController
{
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}

	@RequestMapping("/login")
	public ModelAndView login()
	{
		return new ModelAndView("login");
	}
	@RequestMapping("/test")
	public String test()
	{
		return "test";
	}
}
