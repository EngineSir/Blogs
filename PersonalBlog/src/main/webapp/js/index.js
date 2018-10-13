function disBlog(){
	$.ajax({
		url:path+"/admin/disBlog.do",
		type:"post",
		dataType:"json",
		success:function(result){
			console.log(11);
			if(result.state==0){
				var data=result.data;
			
				for(var i=0;i<data.length;i++){
					var title=data[i].title;
					var id=data[i].id;
					
					createLi(title,id);
				}
			}
		},
		error:function(){
			alert("显示失败");
		}
	});
}
function createLi(title,id){
	var sli="";
	sli+="<li><a href='disblog.jsp?id="+id+"'>"+title+"</a></li>";
	$sli=$(sli);
	$(".disBlog").append($sli);
}
function disPost(){
	$.ajax({
		url:path+"/post/newTopic.do",
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.state==0){
				var data=result.data;
				for(var i=0;i<data.length;i++){
					var title=data[i].title;
					var id=data[i].id;
					createPostLi(title,id);
				}
			}
		},
		error:function(){
			alert("显示失败");
		}
	});
}
function createPostLi(title,id){
	var sli="";
	sli+="<li><a href='dispost.html?id="+id+"'>"+title+"</a>";
	$sli=$(sli);
	$(".disPost").append($sli);
}