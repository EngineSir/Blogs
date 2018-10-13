package com.engine.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engine.blog.entity.Post;
import com.engine.blog.util.BlogResult;

public interface postService
{
	public BlogResult<Object> addPost(String title,String body,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<List<Post>> disPost(int page,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<Object> disBody(String id,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<List<Post>> newTopic(HttpServletRequest req,HttpServletResponse res);
	public BlogResult<Object> deletePost(String id,HttpServletRequest req,HttpServletResponse res) throws IOException;
}
