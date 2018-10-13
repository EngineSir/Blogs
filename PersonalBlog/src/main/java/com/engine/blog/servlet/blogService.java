package com.engine.blog.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engine.blog.entity.Blog;
import com.engine.blog.util.BlogResult;

public interface blogService
{
	public BlogResult<Object> addBlog(String attr,String type,String title,String body,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<Blog> clickHref(String id,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<Object> deleteBlog(String id,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<Object> updateBlog(String id,String title,String body,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<List<Blog>> disBlog(HttpServletRequest req,HttpServletResponse res);
}
