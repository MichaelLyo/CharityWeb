package com.tongji.charityweb.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LSL on 2017/12/23
 */
//@Component
public class Interceptor implements HandlerInterceptor
{
	//@Autowired
	//private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean flag =true;
		String username = (String)request.getSession().getAttribute(HttpSessionConfig.SESSION_USERNAME);
		if(null==username){
			//System.out.println("intercepted!");
			response.sendRedirect("sessionLost");
			flag = false;
		}else{
			flag = true;
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
}

