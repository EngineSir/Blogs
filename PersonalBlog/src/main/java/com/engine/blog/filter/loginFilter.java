package com.engine.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * 过滤器
 */
public class loginFilter implements Filter
{

	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	        throws IOException, ServletException
	{
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		String [] path={
				"/dispost.html",
				"/post.html",
				"/adminLogin.html"
		};
		String currPath=request.getServletPath();
		int num=currPath.lastIndexOf("/");
		String Paths=currPath.substring(num);
		
		for(String s:path){
			if(s.equals(Paths)){
				chain.doFilter(request, response);
				return;
			}
		}
		HttpSession session=request.getSession();
		String admin=(String)session.getAttribute("admin");
		if(admin==null){
			
			response.sendRedirect("adminLogin.html");
		}else{
			chain.doFilter(request, response);
		}
		
	}
	public void init(FilterConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub
	
	}

}
