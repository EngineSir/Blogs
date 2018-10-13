package com.engine.blog.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.engine.blog.entity.Blog;
import com.engine.blog.entity.Post;
import com.engine.blog.servlet.searchService;
import com.engine.blog.util.BlogResult;

@Controller
@RequestMapping("/search")
public class searchController
{
	@Resource
	private searchService searchservice;
	@RequestMapping("/blog.do")
	@ResponseBody
	public BlogResult<List<Blog>> executeSearchBlog(String title,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Blog>> result=new BlogResult<List<Blog>>();
		result=searchservice.findLikeBlog(title,req,res);
		return result;
	}
	
	@RequestMapping("/post.do")
	@ResponseBody
	public BlogResult<List<Post>> executeSearchPost(String title,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Post>> result=new BlogResult<List<Post>>();
		result=searchservice.findLikePost(title,req,res);
		return result;
	}
	
	@RequestMapping("/all.do")
	@ResponseBody
	public BlogResult<Map<String,Object>> executeAll(String title,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Map<String,Object>> result=new BlogResult<Map<String,Object>>();
		result=searchservice.findLikeAll(title,req,res);
		return result;
	}
	
}
