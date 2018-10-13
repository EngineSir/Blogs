package com.engine.blog.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.engine.blog.dao.interfacesDao;
import com.engine.blog.entity.Blog;
import com.engine.blog.util.BlogResult;

@Service("interService")
public class interServiceImpl implements interService
{
	@Resource
	private interfacesDao dao;
	public BlogResult<List<Blog>> queryInter(String type,int page,HttpServletRequest req,HttpServletResponse res)
	{
		res.setHeader("Access-Control-Allow-Origin", "*");
		BlogResult<List<Blog>> result=new BlogResult<List<Blog>>();
		List<Blog> list=new ArrayList<Blog>();
		int begin=(page-1)*3;
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("type", type);
		param.put("begin", begin);
		list=dao.disInter(param);
		result.setData(list);
		result.setMsg("查询页面成功");
		result.setState(0);
		return result;
	}
	
}
