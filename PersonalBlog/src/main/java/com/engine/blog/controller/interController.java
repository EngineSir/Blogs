package com.engine.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.engine.blog.entity.Blog;
import com.engine.blog.servlet.interService;
import com.engine.blog.util.BlogResult;

@Controller
@RequestMapping("/admin")
public class interController
{
	@Resource
	private interService interservice;
	@RequestMapping("/inter.do")
	@ResponseBody
	public BlogResult<List<Blog>> execute(String blogId,int page,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Blog>> result=interservice.queryInter(blogId,page,req,res);
		return result;
	}
}
