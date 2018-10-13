<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/disblog.js"></script>
<script type="text/javascript" src="js/pathvalue.js"></script>
<title>精彩博文</title>
<style>
div{
	/*border:1px solid blue;*/
	position:absolute;
	padding:20px auto;
	overflow:hide;
}
	.da{
	position:absolute;
		left:150px;
		width:900px;
		height:1200px;
		background:url(image/blogback.png);
		border:3px inset  #c0c0c0;
	}
	.border_main{
		top:100px;
		font-size:20px;
		color:#004080;
		padding:20px;
	}
	#title{
	text-align:center;
	}
	.time{
	position:absolute;
		font-size:10px;
		top:75px;
		left:700px;
	}
	.att{
	position:absolute;
	font-size:23px;
	top:65px;
	left:20px;
	color:#004080;
	}
</style>
<script type="text/javascript">
	$(function(){
		Getquest();
	});
</script>
</head>
<body>
	<div class="da">
			<h2 id="title"></h2>
			<a class="att"><span id="att"></span></a>
			<a class="time">最后更新于<span id="data"></span></a>
		<div class="border_main">
		</div> 
	</div>
</body>
</html>