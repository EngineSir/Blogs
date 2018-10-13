<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/index.css">
<link rel="stylesheet" href="styles/forum.css">
<script type="text/javascript" src="js/forum.js"></script>
<script type="text/javascript" src="js/pathvalue.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<meta charset="UTF-8">
<title>论坛</title>
<script>
		var page=1;
		$(function(){
			dispost();
			$("#page").click(down);
			$("#page1").click(up);
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
			<li><a href="forum.jsp" id="forum">论坛</a></li>
			<li><a href="download.jsp">下载</a><li>
			<li><a href="project.jsp">项目</a></li>
			<li><a href="search.jsp">搜索</a></li>
			<li><a href="info.jsp">资讯</a></li>
		</ul>
	</div>
	
	<div class="main">
		<div class="post">
			<a href="post.html"><span>发帖</span></a>
		</div>
		<div class="for_main">
		<table  cellspacing="0" border="1" cellpadding="0" >
			<thead>
				<tr bgcolor="#004080" id="th">
					<td  width="500" height="60">主题</td>
					<td width="80">回复</td>
					<td width="150">阅读量</td>
					<td width="200">最后更新时间</td>
				</tr>
			</thead>
			<tbody class="tbo" id="str">
					
			</tbody>
		</table>
		</div>
		<div class="post1">
			<a href="post.html"><span>发帖</span></a>
		</div>
		<div class="page">
			<input type="button" value="下一页" title="下一页" id="page">
		</div>
		<div class="page1">
			<input type="button" value="上一页" title="上一页" id="page1">
		</div>
	</div>
</body>
</html>