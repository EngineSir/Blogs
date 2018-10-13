package dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.engine.blog.dao.replyDao;
import com.engine.blog.entity.Reply;

public class reply_test
{
	@Test
	public void addReply(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		replyDao dao=ac.getBean("replyDao",replyDao.class);
		Reply reply=new Reply();
		reply.setId("111");
		reply.setPost_id("1111");
		reply.setRead_num(10);
		reply.setRep_body("llll");
		reply.setRep_num(10);
		Long time=System.currentTimeMillis();
		Timestamp times=new Timestamp(time);
		reply.setTime(times);
		dao.addReply(reply);
		System.out.println(reply);
	}
	@Test
	public void disReply(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		replyDao dao=ac.getBean("replyDao",replyDao.class);
		List<Reply> list=dao.disReply("b04a272a0961482983273bef397c2043");
		for(Reply r:list){
			System.out.println(r);
		}
	}
	
	@Test
	public void deleteReply(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		replyDao dao=ac.getBean("replyDao",replyDao.class);
		dao.deleteReply("9daa4243b1cd4d62bad866f4e95bac2e");
	}
}
