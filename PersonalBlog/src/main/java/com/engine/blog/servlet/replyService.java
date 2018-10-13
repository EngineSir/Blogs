package com.engine.blog.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engine.blog.entity.Reply;
import com.engine.blog.util.BlogResult;

public interface replyService
{
	public BlogResult<Object> addReply(String body,String postId,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<List<Reply>> disReply(String postId,HttpServletRequest req,HttpServletResponse res);
	public BlogResult<Object> deleteReply(String id,String postId,HttpServletRequest req,HttpServletResponse res);
}
