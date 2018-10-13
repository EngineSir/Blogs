package com.engine.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engine.blog.entity.admin;
import com.engine.blog.util.BlogResult;

public interface adminServlet
{
	public void  checkLogin(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException, Exception;
	public void updateAdmin(HttpServletRequest req,HttpServletResponse res) throws Exception;
	public void signOut(HttpServletRequest req,HttpServletResponse res) throws IOException;
}
