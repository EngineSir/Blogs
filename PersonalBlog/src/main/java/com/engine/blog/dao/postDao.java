package com.engine.blog.dao;

import java.util.List;
import java.util.Map;

import com.engine.blog.entity.Post;

public interface postDao
{
	public void addPost(Post post);
	public List<Post> disPost(Map<String,Object> partam);
	public Post disBody(String id);
	public List<Post> newTopic();
	public void deletePost(String id);
	public void addReplyNum(String id);
	public void deleteReplyNum(String id);
	public void addReadNum(String id);
}
