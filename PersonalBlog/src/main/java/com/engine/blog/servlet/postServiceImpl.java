package com.engine.blog.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.engine.blog.dao.postDao;
import com.engine.blog.dao.replyDao;
import com.engine.blog.entity.Post;
import com.engine.blog.util.BlogResult;
import com.engine.blog.util.BlogUtil;
@Service("postService")
public class postServiceImpl implements postService
{
	@Resource
	private postDao postdao;
	@Resource
	private replyDao replydao;
	public BlogResult<Object> addPost(String title,String body,HttpServletRequest req,HttpServletResponse res){
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		Post post=new Post();
		String id=BlogUtil.createId();
		post.setId(id);
		post.setBody(body);
		post.setTitle(title);
		Long time=System.currentTimeMillis();
		Timestamp times=new Timestamp(time);
		post.setTime(times);
		post.setRead_num(0);
		post.setRep_num(0);
		postdao.addPost(post);
		result.setData(post);
		result.setMsg("发帖成功");
		result.setState(0);
		return result;
	}
	public BlogResult<List<Post>> disPost(int page,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Post>> result=new BlogResult<List<Post>>();
		int begin=(page-1)*10;
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("begin", begin);
		List<Post> post=new ArrayList<Post>();
		post=postdao.disPost(param);
		result.setData(post);
		result.setMsg("获取成功");
		result.setState(0);
		return result;
	}
	public BlogResult<Object> disBody(String id,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>(); 		
		Post post=postdao.disBody(id);
		postdao.addReadNum(id);
		result.setData(post);
		result.setMsg("获取成功");
		result.setState(0);
		return result;
	}
	public BlogResult<List<Post>> newTopic(HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Post>> result=new BlogResult<List<Post>>();
		List<Post> list=new ArrayList<Post>();
		list=postdao.newTopic();
		result.setData(list);
		result.setMsg("查询成功");
		result.setState(0);
		return result;
	}
	public BlogResult<Object> deletePost(String id,HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		HttpSession session=req.getSession();
		String admin=(String)session.getAttribute("admin");
		if(admin!=null){
			postdao.deletePost(id);
			replydao.deleteAllReply(id);
			result.setMsg("删除成功");
			result.setState(0);
		}
		else{
			result.setMsg("您无该权限");
			result.setState(2);
		}
		
		return result;
	}
}