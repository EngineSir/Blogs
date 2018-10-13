package com.engine.blog.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engine.blog.entity.Blog;
import com.engine.blog.util.BlogResult;

public interface interService
{
	public BlogResult<List<Blog>> queryInter(String type,int page,HttpServletRequest req,HttpServletResponse res);
}
