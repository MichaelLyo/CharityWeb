package com.tongji.charityweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by LSL on 2017/11/15
 */
@Configuration
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter
{

	//@Override
	//public void addResourceHandlers(ResourceHandlerRegistry registry) {
	//	//registry.addResourceHandler("/**").addResourceLocations("/");
	//}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new Interceptor()).addPathPatterns("/**").excludePathPatterns("/regist","/login","/sessionLost","/","logout","search");
		super.addInterceptors(registry);
	}
}