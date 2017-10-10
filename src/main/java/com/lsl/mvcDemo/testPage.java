package com.lsl.mvcDemo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

@Controller
/**
 * Created by lsl .
 */
public class testPage {

	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("hello world");
		return "success";
	}

	@ResponseBody
	@RequestMapping(value="/body/{x}", method = RequestMethod.GET)
	public bodytest getBody(@PathVariable("x") String x){
		System.out.println("URI Part 1 : " + x);
		bodytest bt = new bodytest();
		bt.a = x;
		bt.b = "123";
		System.out.println("this is body page");
		return bt;
	}

	public class bodytest
	{
		public  String a;
		public String b;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(Model model)
	{
		model.addAttribute("message", "hello Spring MVC Framework");

		System.out.println("hello message!");
		System.out.println(model);
		return "hello";
	}

	@RequestMapping(value = "/testModel",method = RequestMethod.GET)
	public ModelAndView testModelAndView(){
		String viewName = "hello";//视图名
		ModelAndView modelAndView = new ModelAndView(viewName);

		modelAndView.addObject("time", "My time");
		modelAndView.addObject("name","ModelAndView");
		modelAndView.addObject("message","model and view useful?");
		return modelAndView;
	}

	@RequestMapping("/form")
	public String form(){
		System.out.println("hello form");
		System.out.println("just for test");
		return "form";
	}

	@RequestMapping(value = "/user.do", method=RequestMethod.POST)
	public String registerUser(Model model,String name,Integer age){
		String userInfo = "Hello from the outside";
		model.addAttribute("message", userInfo);
		model.addAttribute("name", name);
		model.addAttribute("age", age);

		System.out.println("name:"+name + "   age:"+age);
		return "userInfo";
	}

    /*
    *
    @RequestMapping(value = "/user/{userId}/roles/{roleId}", method = RequestMethod.GET)
    public String getLogin(@PathVariable("userId") String userId,
                           @PathVariable("roleId") String roleId) {

        System.out.println("User Id : " + userId);
        System.out.println("Role Id : " + roleId);
        return "success";
    }
    @RequestMapping(value="/product/{productId}",method = RequestMethod.GET)
    public String getProduct(@PathVariable("productId") String productId){
        System.out.println("Product Id : " + productId);
        return "success";
    }
    * */
}