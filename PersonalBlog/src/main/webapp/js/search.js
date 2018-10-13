//点击搜索按钮
function search_btn(){
	arr.length=0;
	label=$("input:radio:checked").val();
	var title=$("#search_text").val().trim();
	if(title==""){
		$("#all_Body").empty();
		createEnd("搜索内容不能为空");
	}
	if(label!="" & title!=""){
		if(label=="blogs"){
			ajaxBlog(title);
		}
		if(label=="forum"){
			ajaxPost(title);
		}
		if(label=="all"){
			ajaxAll(title);
		}
		
	}
}
//切换分类搜索栏,锁定搜索页
function clickChang(){
	var varb=$("input:radio:checked").val();
	if(varb!=label){
		$("#page").attr('disabled',true);
		$("#page1").attr('disabled',true);
	}
	if(label=="all" & label==varb){
		if(page!=1){
			$("#page1").attr('disabled',false);
		}
		disAllPage();
	}
	if(label==varb & (label=="blogs" || label=="forum")){
		if(page!=1){
			$("#page1").attr('disabled',false);
		}
		disPage();
	}
	
}
//全部   ajax
function ajaxAll(title){
	page=1;
	$.ajax({
		url:path+"/search/all.do",
		type:"post",
		data:{"title":title},
		dataType:"json",
		success:function(r){
			var data=r.data;
			var post=data.post;
			var blog=data.blog;
			len=blog.length;
			copyArr(post,blog);
			if(r.state==0){
				disAllPage(len);
			}
		},
		error:function(){
			alert("查询失败");
		}
	});
}
//全局数组复制
function copyArr(post,blog){
	for(var i=0;i<blog.length;i++){
		arr[i]=blog[i];
	}
	var l=blog.length;
	for(var i=0;i<post.length;i++){
		arr[l+i]=post[i];
	}
}
//显示全部 的页面
function disAllPage(len){
	$("#all_Body").empty();
	var j=(page-1)*3+3;
	if(arr.length==0){
		createEnd("没有该内容");
		return;
	}
	for(var i=(page-1)*3;i<j;i++){
		var title=arr[i].title;
		var body=arr[i].body;
		var id=arr[i].id;
		if(i<len){
			createBlogLi(title,body,id);
		}else{
			createPostLi(title,body,id);
		}
		if((i+1)==arr.length){
			$("#page").attr('disabled',true); 
			break;
		}
		if((i+1)==1){
			$("#page1").attr('disabled',true); 
		}
		$("#page").attr('disabled',false); 
	}
}
function createEnd(body){
	var sli="";
	sli+="<span id='sllip'>"+body+"</span>";
	sli+="</li><br><br>";
	$sli=$(sli);
	$("#all_Body").append($sli);
}


//显示博客 的页面
function ajaxBlog(title){
	page=1;
	$.ajax({
		url:path+"/search/blog.do",
		type:"post",
		data:{"title":title},
		dataType:"json",
		success:function(r){
			result=r;
			if(result.state==0){
				disPage();
			}
		},
		error:function(){
			alert("查询失败");
		}
	});
}
//显示论坛 的页面
function disPage(){
	$("#all_Body").empty();
	var label=$("input:radio:checked").val();
	var data=result.data;
	var j=(page-1)*3+3;
	for(var i=(page-1)*3;i<j;i++){
		if(label=="blogs"){
			var title=data[i].title;
			var body=data[i].body;
			var id=data[i].id;
			createBlogLi(title,body,id);
		}
		if(label=="forum"){
			var title=data[i].title;
			var body=data[i].body;
			var id=data[i].id;
			createPostLi(title,body,id);
		}
		if((i+1)==data.length){
			$("#page").attr('disabled',true); 
			break;
		}
		if((i+1)==1){
			$("#page1").attr('disabled',true); 
		}
		$("#page").attr('disabled',false); 
	}
	if(data.length==0){
		$("#page").attr('disabled',true); 
	}
}
//论坛 ajax
function ajaxPost(title){
	page=1;
	$.ajax({
		url:path+"/search/post.do",
		type:"post",
		data:{"title":title},
		dataType:"json",
		success:function(r){
			result=r;
			if(result.state==0){
				disPage();
			}
		},
		error:function(){
			alert("查询失败");
		}
	});
}
//创建博客 li
function createBlogLi(title,body,id){
	var sli="";
	sli+="<li><a href='disblog.jsp?id="+id+"'>"+title+"</a><br>";
	sli+="<span id='sllip'>"+body+"</span>";
	sli+="</li><br><br>";
	$sli=$(sli);
	$("#all_Body").append($sli);
}
//论坛 li
function createPostLi(title,body,id){
	var sli="";
	sli+="<li><a href='dispost.html?id="+id+"'>"+title+"</a><br>";
	sli+="<span id='sllip'>"+body+"</span>";
	sli+="</li><br><br>";
	$sli=$(sli);
	$("#all_Body").append($sli);
}

//下一页
function down(){
	$("#page1").attr('disabled',false); 
	page+=1;
	if(label=="all"){
		disAllPage(len);	
	}else{
		disPage();
	}
	
}
//上一页
function up(){
	$("#page").attr('disabled',false); 
	page-=1;
	if(page==1){
		$("#page1").attr('disabled',true); 
	}
	if(label=="all"){
		disAllPage(len);	
	}else{
		disPage();
	}
}
