package com.tongji.charityweb.config;


import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by LSL on 2017/11/30
 */

@EnableRedisHttpSession
public class HttpSessionConfig
{
	public final static String SESSION_USERNAME = "username";
}
