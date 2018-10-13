package com.engine.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.engine.blog.entity.Post;
import com.engine.blog.servlet.postService;
import com.engine.blog.util.BlogResult;

@Controller
@RequestMapping("/post")
public class postController
{
	@Resource
	private postService postservice;
	@RequestMapping("/tourist.do")
	@ResponseBody
	public BlogResult<Object> execute(String title,String body,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		result=postservice.addPost(title, body,req,res);
		
		return result;
	}
	@RequestMapping("/dispost.do")
	@ResponseBody
	public BlogResult<List<Post>> exeuteDisPost(int page,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Post>> result=new BlogResult<List<Post>>();
		result=postservice.disPost(page,req,res);
		return result;
	}
	@RequestMapping("disbody.do")
	@ResponseBody
	public BlogResult<Object> executeBody(String id,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		result=postservice.disBody(id,req,res);
		return result;
	}
	
	@RequestMapping("/newTopic.do")
	@ResponseBody
	public BlogResult<List<Post>> executeNewTopic(HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Post>> result=new BlogResult<List<Post>>();
		result=postservice.newTopic(req,res);
		return result;
	}
	@RequestMapping("/delete_post.do")
	@ResponseBody
	public BlogResult<Object> executeDeletePost(String id,HttpServletRequest req,HttpServletResponse res) throws IOException{
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		result=postservice.deletePost(id,req,res);
		return result;
	}
}
