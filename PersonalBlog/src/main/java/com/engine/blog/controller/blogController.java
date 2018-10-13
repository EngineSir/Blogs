package com.engine.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.engine.blog.entity.Blog;
import com.engine.blog.servlet.blogService;
import com.engine.blog.util.BlogResult;

@Controller
@RequestMapping("/admin")
public class blogController
{
	@Resource
	private blogService blogService;
	@RequestMapping("/editor.do")
	@ResponseBody
	public BlogResult<Object> execute(String attr, String type, String title, String body,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		result=blogService.addBlog(attr, type, title, body,req,res);
		return result;
	}
	@RequestMapping("/clickHref.do")
	@ResponseBody
	public BlogResult<Blog> executeHref(String id,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Blog> result=blogService.clickHref(id,req,res);
		return result;
	}
	@RequestMapping("/delete.do")
	@ResponseBody
	public BlogResult<Object> executeDelete(String id,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		result=blogService.deleteBlog(id,req,res);
		return result;
	}
	@RequestMapping("update.do")
	@ResponseBody
	public BlogResult<Object> executeUpdate(String id,String title,String body,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		result=blogService.updateBlog(id, title, body,req,res);
		return result;
	}
	
	@RequestMapping("/disBlog.do")
	@ResponseBody
	public BlogResult<List<Blog>> executeDisBlog(HttpServletRequest req,HttpServletResponse res){
		//解决ajax跨域问题
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Blog>> result=new BlogResult<List<Blog>>();
		result=blogService.disBlog(req,res);
		return result;
	}
}
