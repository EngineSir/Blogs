package com.engine.blog.dao;

import java.util.List;
import java.util.Map;

import com.engine.blog.entity.Blog;
import com.engine.blog.entity.Post;

public interface searchDao
{
	public List<Blog> findLikeBlog(Map param);
	public List<Post> findLikePost(Map param);

}
