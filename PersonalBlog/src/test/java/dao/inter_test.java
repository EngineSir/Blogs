package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.engine.blog.dao.interfacesDao;
import com.engine.blog.entity.Blog;

public class inter_test
{
	@Test
	public void inter(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		interfacesDao dao=ac.getBean("interfacesDao",interfacesDao.class);
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("type", "3");
		param.put("page", 1);
		List<Blog> list=dao.disInter(param);
		System.out.println(list);
		System.out.println(list.size());
	}
}
