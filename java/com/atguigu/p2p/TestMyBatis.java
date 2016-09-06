package com.atguigu.p2p;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.atguigu.p2p.entities.User;
import com.atguigu.p2p.service.UserService;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)// 表示继承了SpringJUnit4ClassRunner类
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
		User user = userService.selectByPrimaryKey(3);
		logger.info("*******>值：" + user.toString());
		logger.info("*******>Json 值：" + JSON.toJSONString(user));
	}	
	
	@Test
	public void testInsertUser()
	{
		int result = userService.insert(new User("林云"+new Random().nextInt(1000),"123456",22));
	}		
}

/**
org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.atguigu.p2p.service.UserService.selectByPrimaryKey
	at org.apache.ibatis.binding.MapperMethod$SqlCommand.<init>(MapperMethod.java:189)
	at org.apache.ibatis.binding.MapperMethod.<init>(MapperMethod.java:43)
	at org.apache.ibatis.binding.MapperProxy.cachedMapperMethod(MapperProxy.java:58)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:51)
	at com.sun.proxy.$Proxy16.selectByPrimaryKey(Unknown Source)
	at com.atguigu.p2p.TestMyBatis.test1(TestMyBatis.java:28)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:44)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:41)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)
	at org.springframework.test.context.junit4.statements.RunBeforeTestMethodCallbacks.evaluate(RunBeforeTestMethodCallbacks.java:74)
	at org.springframework.test.context.junit4.statements.RunAfterTestMethodCallbacks.evaluate(RunAfterTestMethodCallbacks.java:83)
	at org.springframework.test.context.junit4.statements.SpringRepeat.evaluate(SpringRepeat.java:72)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:232)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:89)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:71)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:292)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:175)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:675)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)


 */
