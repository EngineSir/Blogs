package dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.engine.blog.dao.adminDao;
import com.engine.blog.entity.admin;

public class admin_test
{
	@Test
	public void login(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		adminDao dao=ac.getBean("adminDao",adminDao.class);
		admin use=dao.findByName("Engine");
		System.out.println(use);
	}
}
