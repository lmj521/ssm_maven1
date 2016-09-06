package com.ssm.maven.test;



import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.ssm.maven.entity.User;
import com.ssm.maven.serviceimp.UserServiceImpl;


public class Test1 {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");


	@Test
	public void testConnection() throws SQLException
	{
	
		DataSource bean = applicationContext.getBean(DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
		connection.close();
	}	

}
