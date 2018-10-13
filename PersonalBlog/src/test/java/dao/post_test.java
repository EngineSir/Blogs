package dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.engine.blog.dao.postDao;
import com.engine.blog.entity.Post;

public class post_test
{
	@Test
	public void post(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		postDao dao=ac.getBean("postDao",postDao.class);
		Post post=new Post();
		post.setId("222");
		post.setBody("ccccc");
		post.setTitle("lll");
		Long time=System.currentTimeMillis();
		Timestamp times=new Timestamp(time);
		post.setTime(times);
		post.setRead_num(0);
		post.setRep_num(0);
		dao.addPost(post);
		System.out.println(post);
		
	}
	@Test
	public void disPost(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		postDao dao=ac.getBean("postDao",postDao.class);
		List<Post> post=new ArrayList<Post>();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("begin", 0);
		post=dao.disPost(param);
		for(Post p:post){
			System.out.println(p);
		}
	}
	@Test
	public void disBody(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		postDao dao=ac.getBean("postDao",postDao.class);
		Post post=dao.disBody("d522ec6fb1604e2db73e05b97fbbd328");
		System.out.println(post);
	}
}
