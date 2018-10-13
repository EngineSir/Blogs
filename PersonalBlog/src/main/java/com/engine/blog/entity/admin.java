package com.engine.blog.entity;

import java.io.Serializable;

public class admin implements Serializable
{
	private String id;
	private String admin_name;
	private String admin_password;
	@Override
	public String toString()
	{
		return "admin [id=" + id + ", admin_name=" + admin_name + ", admin_password=" + admin_password + "]";
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getAdmin_name()
	{
		return admin_name;
	}
	public void setAdmin_name(String admin_name)
	{
		this.admin_name = admin_name;
	}
	public String getAdmin_password()
	{
		return admin_password;
	}
	public void setAdmin_password(String admin_password)
	{
		this.admin_password = admin_password;
	}
}
