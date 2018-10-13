package com.engine.blog.entity;

import java.sql.Timestamp;

public class Post
{
	private String id;
	private String title;
	private String body;
	private Timestamp time;
	private Integer rep_num;
	private Integer read_num;
	

	public Integer getRep_num()
	{
		return rep_num;
	}
	public void setRep_num(Integer rep_num)
	{
		this.rep_num = rep_num;
	}
	public Integer getRead_num()
	{
		return read_num;
	}
	public void setRead_num(Integer read_num)
	{
		this.read_num = read_num;
	}
	@Override
	public String toString()
	{
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", time=" + time + ", rep_num=" + rep_num
		        + ", read_num=" + read_num + "]";
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
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
	public Timestamp getTime()
	{
		return time;
	}
	public void setTime(Timestamp time)
	{
		this.time = time;
	}
	
}
