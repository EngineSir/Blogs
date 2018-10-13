package com.engine.blog.entity;

import java.sql.Timestamp;

public class Reply
{
	private String id;
	private String post_id;
	private int rep_num;
	private int read_num;
	private Timestamp time ;
	private String rep_body;
	@Override
	public String toString()
	{
		return "Reply [id=" + id + ", post_id=" + post_id + ", rep_num=" + rep_num + ", read_num=" + read_num
		        + ", time=" + time + ", rep_body=" + rep_body + "]";
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getPost_id()
	{
		return post_id;
	}
	public void setPost_id(String post_id)
	{
		this.post_id = post_id;
	}
	public int getRep_num()
	{
		return rep_num;
	}
	public void setRep_num(int rep_num)
	{
		this.rep_num = rep_num;
	}
	public int getRead_num()
	{
		return read_num;
	}
	public void setRead_num(int read_num)
	{
		this.read_num = read_num;
	}
	public Timestamp getTime()
	{
		return time;
	}
	public void setTime(Timestamp time)
	{
		this.time = time;
	}
	public String getRep_body()
	{
		return rep_body;
	}
	public void setRep_body(String rep_body)
	{
		this.rep_body = rep_body;
	}
}
