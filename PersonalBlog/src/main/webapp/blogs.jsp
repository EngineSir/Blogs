<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/index.css">
<link rel="stylesheet" href="adminCode/blogs.css">
<link rel="stylesheet" href="styles/blogs.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/blog.js"></script>
<script type="text/javascript" src="js/pathvalue.js"></script>
<meta charset="UTF-8">
<title>博客</title>
<script>
var page=1;
var blogId="0";
	$(function(){
		ajaxV("0",1);
	$("#all").on("click","li",function(){
		$("#all span").removeClass("checked");
		$(this).find("span").addClass("checked");
	});	
	var sli=new Array();
	sli[0]="<li><a id='web'><img src='image/web.png' width='25' height='25'/><span id='web1'>&nbspweb前端&nbsp</span></a></li>";
	sli[1]="<li><a id='java'><img src='image/java.png' width='25' height='25'/><span id='web1'>&nbspjava</span></a></li>";
	sli[2]="<li><a id='spring'><img src='image/spring.png' width='25' height='25'/><span id='web1'>&nbspspring</span></a></li>";
	sli[3]="<li><a id='mvc'><img src='image/mvc.png' width='25' height='25'/><span id='web1'>&nbspspring mvc</span></a></li>";
	sli[4]="<li><a id='batis'><img src='image/mybatis.png' width='25' height='25'/><span id='web1'>&nbspmybatis</span></a></li>";
	sli[5]="<li><a id='linux'><img src='image/linux.jpg' width='25' height='25'/><span id='web1'>&nbsplinux</span></a></li>";
	sli[6]="<li><a id='db'><img src='image/db.png' width='25' height='25'/><span id='web1'>&nbsp数据库</span></a></li>";
	sli[7]="<li><a id='ds'><img src='image/ds.jpg' width='25' height='25'/><span id='web1'>&nbsp数据结构</span></a></li>";
	for(var i=0;i<8;i++){
		var $li=$(sli[i]);
		$li.data("blogId",''+i+'');
		$("#all").append($li);
	}
	$("#all").on("click","li",disBlog);
	$("#page1").click(up);
	$("#page").click(down);
	});
	function delete_btn(){
		alert("是否确定删除");
	}
</script>
</head>
<body>
<div class="adminlog">
		<a href="adminCode/adminCode.html" id="admin">${admin}</a>
	</div>
	<div class="d1">
		<ul id="id1">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="blogs.jsp" id="blog">博客</a></li>
			<li><a href="forum.jsp">论坛</a></li>
			<li><a href="download.jsp">下载</a><li>
			<li><a href="project.jsp">项目</a></li>
			<li><a href="search.jsp">搜索</a></li>
			<li><a href="info.jsp">资讯</a></li>
		</ul>
	</div>
	<div class="col">
		<ul id="all">		
		</ul>
	</div>
	<div class="blog_main">
		<ul id="blog_body">	
		</ul>
		<div class="page">
			<input type="button" value="下一页" title="下一页" id="page">
		</div>
		<div class="page1">
			<input type="button" value="上一页" title="上一页" id="page1">
		</div>	
		</div>
</body>
</html>