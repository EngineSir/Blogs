package com.engine.blog.dao;

import java.util.List;

import com.engine.blog.entity.Blog;

public interface blogDao
{
	public void addBlog(Blog blog);
	public Blog clickHref(String id);
	public void deleteBlog(String id);
	public void updateBlog(Blog blog);
	public List<Blog> disBlog();
}
