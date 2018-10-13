package com.engine.blog.servlet;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.engine.blog.dao.postDao;
import com.engine.blog.dao.replyDao;
import com.engine.blog.entity.Reply;
import com.engine.blog.util.BlogResult;
import com.engine.blog.util.BlogUtil;

@Service("replyservice")
public class replyServiceImpl implements replyService
{
	@Resource
	private replyDao replydao;
	@Resource
	private postDao postdao;
	public BlogResult<Object> addReply(String body, String postId,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		Reply reply=new Reply();
		String id=BlogUtil.createId();
		reply.setId(id);
		reply.setPost_id(postId);
		reply.setRead_num(0);
		reply.setRep_num(0);
		reply.setRep_body(body);
		Long time=System.currentTimeMillis();
		Timestamp times=new Timestamp(time);
		reply.setTime(times);
		replydao.addReply(reply);
		postdao.addReplyNum(postId);
		//System.out.println("kkk");
		result.setData(reply);
		result.setMsg("回复成功");
		result.setState(0);
		return result;
	}
	public BlogResult<List<Reply>> disReply(String postId,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Reply>> result=new BlogResult<List<Reply>>();
		List<Reply> list=new ArrayList<Reply>();
		list=replydao.disReply(postId);
		result.setData(list);
		result.setState(0);
		result.setMsg("获取成功");
		return result;
	}
	public BlogResult<Object> deleteReply(String id,String postId,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		HttpSession session=req.getSession();
		String admin=(String)session.getAttribute("admin");
		if(admin!=null){
			replydao.deleteReply(id);
			postdao.deleteReplyNum(postId);
			result.setMsg("删除成功");
			result.setState(0);
		}else{
			result.setMsg("没有该权限");
			result.setState(1);
		}
		
		return result;
	}
	
}
