package com.engine.blog.servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engine.blog.entity.Blog;
import com.engine.blog.entity.Post;
import com.engine.blog.util.BlogResult;

public interface searchService
{
	public BlogResult<List<Blog>> findLikeBlog(String title,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<List<Post>> findLikePost(String title,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<Map<String,Object>> findLikeAll(String title,HttpServletRequest req,HttpServletResponse res);
}
