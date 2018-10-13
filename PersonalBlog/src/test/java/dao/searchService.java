package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.engine.blog.dao.searchDao;
import com.engine.blog.entity.Blog;
import com.engine.blog.entity.Post;

public class searchService
{
	@Test
	public void findLikeAll(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		searchDao dao=ac.getBean("searchDao",searchDao.class);
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("title", "%c%");
		List<Blog> blog=new ArrayList<Blog>();
		blog=dao.findLikeBlog(param);
		List<Post> post=new ArrayList<Post>();
		post=dao.findLikePost(param);
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("blog", blog);
		result.put("post", post);
			System.out.println(result.get("blog"));
		
	}
}
