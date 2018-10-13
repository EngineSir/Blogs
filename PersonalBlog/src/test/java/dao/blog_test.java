package dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.aop.target.SimpleBeanTargetSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.engine.blog.dao.blogDao;
import com.engine.blog.entity.Blog;

public class blog_test
{
	@Test
	public void Blog(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		blogDao dao=ac.getBean("blogDao",blogDao.class);
		Blog blog=new Blog();
		blog.setId("111");
		blog.setAttr("咳咳咳");
		blog.setBody("shcksnkcn");
		blog.setTitle("nskjnck");
		blog.setType("java");
		Long date= System.currentTimeMillis();
		Timestamp time=new Timestamp(date);
		blog.setTime(time);
		dao.addBlog(blog);
		System.out.println(blog);
	}
	@Test
	public void clickHref(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		blogDao dao=ac.getBean("blogDao",blogDao.class);
		Blog blog=dao.clickHref("4be398aef8da4b76863e01dfa5b315c8");
		System.out.println(blog);
	}
	@Test
	public void updateBlog(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		blogDao dao=ac.getBean("blogDao",blogDao.class);
		Blog blog=new Blog();
		blog.setId("c4bf0fb4dadd4423b072616cf5c48a4b");
		blog.setTitle("html,c++");
		blog.setBody("javascript");
		dao.updateBlog(blog);
	}
	@Test
	public void disBlog(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		blogDao dao=ac.getBean("blogDao",blogDao.class);
		List<Blog> list=new ArrayList<Blog>();
		list=dao.disBlog();
		for(Blog b:list){
			System.out.println(b);
		}
	}
}
