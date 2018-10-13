package com.engine.blog.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.aop.target.SimpleBeanTargetSource;
import org.springframework.stereotype.Service;

import com.engine.blog.dao.adminDao;
import com.engine.blog.entity.admin;
import com.engine.blog.util.BlogUtil;
@Service("adminService")
public class adminServletImpl implements adminServlet
{
	@Resource
	private adminDao adminDao;
	public void checkLogin(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		String name=req.getParameter("admin");
		String password=req.getParameter("pass");
		
		admin user=adminDao.findByName(name);
		String pwd=BlogUtil.md5(password);
		if(user==null){
			req.setAttribute("adminerror", "账号错误");
			res.sendRedirect("adminCode/adminLogin.html");
		}else if(!user.getAdmin_password().equals(pwd)){
			req.setAttribute("pwderror", "密码错误");
			res.sendRedirect("adminCode/adminLogin.html");
		}else{
			HttpSession session=req.getSession();
			session.setAttribute("admin", name);
			System.out.println(session);
			res.sendRedirect("adminCode/adminCode.html");
			
		}
	}
	public void updateAdmin(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		HttpSession session=req.getSession();
		String adminNick=(String)session.getAttribute("admin");
		String nick=req.getParameter("nick");
		String pwd=req.getParameter("sure_pwd");
		String sure_pwd=BlogUtil.md5(pwd);
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("adminNick", adminNick);
		param.put("nick", nick);
		param.put("sure_pwd", sure_pwd);
		adminDao.updateAdmin(param);
		session.setAttribute("admin", nick);
		System.out.println(session);
		res.sendRedirect("adminCode/adminCode.html");
	}
	public void signOut(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		HttpSession session=req.getSession();
		String admin=(String)session.getAttribute("admin");
		if(admin!=null){
			//System.out.println(session.getAttribute("admin")+"  "+session);
			session.removeAttribute("admin");
			
			res.sendRedirect("index.jsp");
		}
		
	}

}
