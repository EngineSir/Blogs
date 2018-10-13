package com.engine.blog.dao;

import java.util.Map;

import com.engine.blog.entity.admin;

public interface adminDao
{
	public admin findByName(String name);
	public void updateAdmin(Map<String,Object> parm);
}
