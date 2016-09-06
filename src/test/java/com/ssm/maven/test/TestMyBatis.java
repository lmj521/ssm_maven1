package com.ssm.maven.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ssm.maven.entity.User;
import com.ssm.maven.service.UserService;

import java.util.Random;



@RunWith(SpringJUnit4ClassRunner.class)// 表示继承了SpringJUnit4ClassRunner�?
@ContextConfiguration(locations ={"classpath:/spring/applicationContext.xml"})
//@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class TestMyBatis extends AbstractJUnit4SpringContextTests
{
	private static Logger logger = Logger.getLogger(TestMyBatis.class);

	@Autowired
	private UserService userService = null;

	@Test
	public void testSelectByPrimaryKey()
	{
		User user = userService.selectByPrimaryKey(1);
		System.out.println(user.toString());
	}	
	
	
}


