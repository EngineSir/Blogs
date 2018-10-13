package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.engine.blog.dao.searchDao;
import com.engine.blog.entity.Blog;

public class search_test
{
	@Test
	public void search(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		searchDao dao=ac.getBean("searchDao",searchDao.class);
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("title", "%c++%");
		List<Blog> list=dao.findLikeBlog(param);
		for(Blog b:list){
			System.out.println(b);
		}
		String t="jjj";
		t="%"+t+"%";
		System.out.println(t);
	}
}
