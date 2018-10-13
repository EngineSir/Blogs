package com.engine.blog.entity;

import java.sql.Timestamp;

public class Blog
{
	private String id;
	private String attr;
	private String type;
	private String title;
	private String body;
	public String getAttr()
	{
		return attr;
	}
	public void setAttr(String attr)
	{
		this.attr = attr;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getBody()
	{
		return body;
	}
	public void setBody(String body)
	{
		this.body = body;
	}
	private Timestamp time;
	@Override
	public String toString()
	{
		return "Blog [id=" + id + ", attr=" + attr + ", type=" + type + ", title=" + title + ", body=" + body
		        + ", time=" + time + "]";
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public Timestamp getTime()
	{
		return time;
	}
	public void setTime(Timestamp time)
	{
		this.time = time;
	}
}
