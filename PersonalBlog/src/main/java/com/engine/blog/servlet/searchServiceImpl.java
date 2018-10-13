package com.engine.blog.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.engine.blog.dao.searchDao;
import com.engine.blog.entity.Blog;
import com.engine.blog.entity.Post;
import com.engine.blog.util.BlogResult;
@Service("searchservice")
public class searchServiceImpl implements searchService
{
	@Resource
	private searchDao searchdao;
	public BlogResult<List<Blog>> findLikeBlog(String title,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Blog>> result=new BlogResult<List<Blog>>();
		Map<String,Object> param=new HashMap<String,Object>();
		title="%"+title+"%";
		//int begin=(page-1)*3;
		param.put("title", title);
		//param.put("begin", begin);
		List<Blog> listBlog=new ArrayList<Blog>();
			listBlog=searchdao.findLikeBlog(param);
			result.setData(listBlog);
			result.setMsg("查询成功");
			result.setState(0);
			return result;
	}
	
	public BlogResult<List<Post>> findLikePost(String title,HttpServletRequest req,HttpServletResponse res){
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Post>> result=new BlogResult<List<Post>>();
		Map<String,Object> param=new HashMap<String,Object>();
		title="%"+title+"%";
		//int begin=(page-1)*3;
		param.put("title", title);
		//param.put("begin", begin);
		List<Post> listPost=new ArrayList<Post>();
		listPost=searchdao.findLikePost(param);
		result.setData(listPost);
		result.setMsg("查询成功");
		result.setState(0);
		return result;
	}

	public BlogResult<Map<String, Object>> findLikeAll(String title,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		List<Post> post=new ArrayList<Post>();
		List<Blog> blog=new ArrayList<Blog>();
		
		Map<String,Object> param=new HashMap<String,Object>();
		title="%"+title+"%";
		param.put("title", title);
		
		blog=searchdao.findLikeBlog(param);
		post=searchdao.findLikePost(param);
		
		BlogResult<Map<String,Object>> result=new BlogResult<Map<String,Object>>();
		Map<String,Object> MBlogPost=new HashMap<String,Object>();
		MBlogPost.put("blog", blog);
		MBlogPost.put("post", post);
		result.setData(MBlogPost);
		return result;
	}
}
