function disBlog(){
	page=1;
	$("#page").attr('disabled',false); 
	 blogId=$(this).data("blogId");
	if(blogId!=""){
		ajaxV(blogId,page);
	}
}
function ajaxV(blogId,page){
	if(page==1){
		$("#page1").attr('disabled',true);
	}
	$.ajax({
		url:path+"/admin/inter.do",
		type:"post",
		data:{"blogId":blogId,"page":page},
		dataType:"json",
		success:function(result){
			var data=result.data;
			$("#blog_body").empty();
			if(result.state==0){
				for(var i=0;i<data.length;i++){
					var title=data[i].title;
					var body=data[i].body;
					var Id=data[i].id;
					createLi(title,body,Id);
				}
				if(data.length==0){
					//没有内容，不能点击下一页
					$("#page").attr('disabled',true); 
					var sli="";
					sli+="<li><a href='disblog.jsp'></a><br>";
					sli+="<span id='sllip'>没有更多内容了</span>";
					sli+="</li><br><br>";
					var $li=$(sli);
					$("#blog_body").append($li);
				}
			}
		},
		error:function(){
			alert("获取失败");
		}
	});
}
function createLi(title,body,blogId){
	var sli="";
	sli+="<li><a href='disblog.jsp?id="+blogId+"'>"+title+"</a><br>";
	sli+="<span id='sllip'>"+body+"</span>";
	sli+="</li><br><br>";
	var $li=$(sli);
	$li.data("blogId",blogId);
	$("#blog_body").append($li);
}
function up(){
	
	if(page>1){
		page-=1;
		ajaxV(blogId,page);
		$("#page").attr('disabled',false); 
	}
		if(page==1){
			$("#page1").attr('disabled',true); 
		}

}
function down(){
	$("#page1").attr('disabled',false); 
	page+=1;
	ajaxV(blogId,page);
}