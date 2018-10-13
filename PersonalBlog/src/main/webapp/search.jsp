<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/index.css">
<link rel="stylesheet" href="styles/search.css">
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/pathvalue.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<meta charset="UTF-8">
<title>搜索</title>
<script type="text/javascript">
var page=1;
var result="";
var label="";
var len=0;
var arr=new Array();
	$(function(){
		$("#search_btn").click(search_btn);
		if(page==1){
			$("#page1").attr('disabled',true); 
			$("#page").attr('disabled',true);
		}
		$("#page").click(down);
		$("#page1").click(up);
		$("input:radio").click(clickChang);
	});
</script>
</head>
<body>
	<div class="adminlog">
		<a href="adminCode/adminCode.html" id="admin">${admin}</a>
	</div>
	<div class="d1">
		<ul id="id1">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="blogs.jsp">博客</a></li>
			<li><a href="forum.jsp">论坛</a></li>
			<li><a href="download.jsp">下载</a><li>
			<li><a href="project.jsp">项目</a></li>
			<li><a href="search.jsp" id="search">搜索</a></li>
			<li><a href="info.jsp">资讯</a></li>
		</ul>
	</div>
	
	<form action="">
	<div class="for_main">
			<p align="center" style="color:#8ca0fa"><i>站内搜索</i></p>
			<div class="search_main">
				<input checked="checked" name="type" type="radio" value="all" id="all">
				<label for="all">全部</label>
				<input type="radio" name="type" value="blogs" id="blo">
				<label for="blo">博客</label>
				<input type="radio" name="type" value="forum" id="bbs">
				<label for="bbs">论坛</label>
			<div class="search_btn">
				<input type="text" id="search_text">
				<input type="button" value="搜索" class="submit" id="search_btn">
			</div>
			</div>
		<div class="spa">
			<ul id="all_Body">
				
			</ul>
			</div>
			</div>
		<div class="page">
			<input type="button" value="下一页" title="下一页" id="page" class="page_btn">
		</div>
		<div class="page1">
			<input type="button" value="上一页" title="上一页" id="page1" class="page_btn">
		</div>
	</form>
</body>
</html>