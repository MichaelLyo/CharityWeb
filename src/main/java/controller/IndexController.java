package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LSL on 2017/11/13
 */

//@Controller    // This means that this class is a Controller
@RestController
@RequestMapping(path="/") // This means URL's start with / (after Application path)
public class IndexController
{
	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}

	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
}
