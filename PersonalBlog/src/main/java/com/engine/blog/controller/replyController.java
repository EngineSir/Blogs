package com.engine.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.engine.blog.entity.Reply;
import com.engine.blog.servlet.replyService;
import com.engine.blog.util.BlogResult;

@Controller
@RequestMapping("/reply")
public class replyController
{
	@Resource
	private replyService replyservice;
	@RequestMapping("/replyinfo.do")
	@ResponseBody
	public BlogResult<Object> execute(String body,String postId,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		result=replyservice.addReply(body, postId,req,res);
		return result;
	}
	@RequestMapping("/disreply.do")
	@ResponseBody
	public BlogResult<List<Reply>> executeDisReply(String postId,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Reply>> result=new BlogResult<List<Reply>>();
		result=replyservice.disReply(postId,req,res);
		return result;
	}
	@RequestMapping("/delete.do")
	@ResponseBody
	public BlogResult<Object> executeDelete(String id,String postId,HttpServletRequest req,HttpServletResponse res){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<Object> result=new BlogResult<Object>();
		result=replyservice.deleteReply(id,postId,req,res);
		return result;
	}
}
