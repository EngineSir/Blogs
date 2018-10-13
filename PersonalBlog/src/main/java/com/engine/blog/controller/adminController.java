package com.engine.blog.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.engine.blog.servlet.adminServlet;

@Controller
public class adminController
{
	@Resource
	private adminServlet adminServlet;
	@RequestMapping("/login.do")
	@ResponseBody
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		//res.setHeader("Access-Control-Allow-Origin", "*");
		adminServlet.checkLogin(req,res);	
	}
	@RequestMapping("/updateAdmin.do")
	public void executeUpdateAdmin(HttpServletRequest req,HttpServletResponse res) throws Exception{
		//res.setHeader("Access-Control-Allow-Origin", "*");
		adminServlet.updateAdmin(req,res);
	}
	@RequestMapping("/signOut.do")
	public void executesignOut(HttpServletRequest req,HttpServletResponse res) throws IOException{
		//res.setHeader("Access-Control-Allow-Origin", "*");
		adminServlet.signOut(req,res);
	}
}
