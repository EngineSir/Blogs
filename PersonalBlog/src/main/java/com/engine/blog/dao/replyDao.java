package com.engine.blog.dao;

import java.util.List;

import com.engine.blog.entity.Reply;

public interface replyDao
{
	public void addReply(Reply reply);
	public List<Reply> disReply(String postId);
	public void deleteReply(String id);
	public void deleteAllReply(String postId);
}
