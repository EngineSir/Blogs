package com.engine.blog.servlet;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.engine.blog.dao.blogDao;
import com.engine.blog.entity.Blog;
import com.engine.blog.util.BlogResult;
import com.engine.blog.util.BlogUtil;
@Service("blogSevice")
public class blogServiceImpl implements blogService
{
	@Resource
	private blogDao blogdao;
	public BlogResult<Object> addBlog(String attr, String type, String title, String body,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		Blog blog=new Blog();
		String blog_id=BlogUtil.createId();
		blog.setId(blog_id);
		blog.setAttr(attr);
		blog.setType(type);
		blog.setBody(body);
		blog.setTitle(title);
		System.out.println(body);
		Long time=System.currentTimeMillis();
		Timestamp times=new Timestamp(time);
		blog.setTime(times);
		blogdao.addBlog(blog);
		result.setMsg("发表博客成功");
		result.setState(0);
		result.setData(blog);
		return result;
	}
	public BlogResult<Blog> clickHref(String id,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Blog> result=new BlogResult<Blog>();
		Blog blog=blogdao.clickHref(id);
		if(blog==null){
			result.setMsg("获取失败");
			result.setState(1);
			return result;
		}
		result.setMsg("获取成功");
		result.setState(0);
		result.setData(blog);
		return result;
	}
	public BlogResult<Object> deleteBlog(String id,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		blogdao.deleteBlog(id);
		result.setMsg("删除成功");
		result.setState(0);
		return result;
	}
	public BlogResult<Object> updateBlog(String id,String title,String body,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		Blog blog=new Blog();
		blog.setId(id);
		blog.setBody(body);
		blog.setTitle(title);
		blogdao.updateBlog(blog);
		result.setMsg("修改成功");
		result.setState(0);
		return result;
	}
	public BlogResult<List<Blog>> disBlog(HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Blog>> result=new BlogResult<List<Blog>>();
		List<Blog> list=new ArrayList<Blog>();
		list=blogdao.disBlog();
		result.setData(list);
		result.setState(0);
		result.setMsg("查询成功");
		return result;
	}
	
}
