<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<title>Engine</title>
<link rel="stylesheet" href="styles/index.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/pathvalue.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script>
	$(function(){
		disBlog();
		disPost();
	});
	
	//新版本
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
			<li><a href="search.jsp">搜索</a></li>
			<li><a href="info.jsp">资讯</a></li>
		</ul>
	</div>
	
	<div class="video">
		<div id="vi">
			<span>你的时光,我不掉队。</span>
			<video width="500" height="300" controls>
				<source src="video/goodtime.mp4" type="video/mp4">
				<object data="video/goodtime.mp4" width="500" height="345">
					<embed src="video/goodtime.mp4" width="500" height="345">
				</object>
			</video>
		</div>
	</div>
	<div class="d2">
		<div class="it">
			<p align="center">最新话题</p>
			<ul id="id3" class="disPost">
			
			</ul>
		</div>
		<div class="blog">
			<p align="center">最新博文</p>
				<ul id="id3" class="disBlog">
				
			</ul>
		</div>
	</div>
	<div class="ds">
		<p id="top"><a href="#">顶部</a></p>
</div>
<div class="copy">
	<span>© 2018 Engine</span><br>
	<span>版权所有</span><br>
	<p>
		友情链接 
		<a href="http://bbs.it-home.org/">IT论坛</a>
		-
		<a href="http://doc.d8jd.com/">文档下载中心</a>
		-
		<a href="http://www.java1234.com/">java知识分享网</a>
	</p>
	
</div>
</body>
</html>