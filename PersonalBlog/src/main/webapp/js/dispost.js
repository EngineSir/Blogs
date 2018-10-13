function disPostBody(){
	var id=getId();
	if(id!=""){
		$.ajax({
			url:path+"/post/disbody.do",
			type:"post",
			data:{"id":id},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					var data=result.data;
					var title=data.title;
					var body=data.body;
					var time=new Date();
					time.setTime(data.time);
					$("#title").html(title);
					$(".border_main").html(body);
					$("#pub_time").html(time.toLocaleDateString()+" "+time.toLocaleTimeString());
				}
			},
			error:function(){
				alert("显示失败");
			}
		});
	}
}
function getId(){
	var url=location.href;
	var start=url.indexOf("=");
	var id=url.substr(start+1);
	return id;
}

function relyInfo(){
	
	var url=location.href;
	var start=url.indexOf("=");
	var postId=url.substr(start+1);
	var body=ue.getContent();
	ue.setContent("");
	if(body!=""){
		$.ajax({
			url:path+"/reply/replyinfo.do",
			type:"post",
			data:{"body":body,"postId":postId},
			dataType:"json",
			success:function(result){
				if(result.state==0){	
					var data=result.data;
					var body=data.rep_body;
					var id=data.id;
					var time=new Date();
					time.setTime(data.time);
					time=time.toLocaleDateString()+" "+time.toLocaleTimeString();
					createReply(body,time,id);
				}
			},
			error:function(){
				alert("回复失败");
			}
		});
	}else{
		alert("回复内容不能为空");
	}
}

function createReply(body,time,id){
	var str="";
	str+="<tbody>";
	str+="<tr>";
	str+="<td>"+body+"</td>";
	str+="</tr>";
	str+="<tr>";
	str+="<td><br><br></td>";
	str+="</tr>";
	str+="<tr>";
	str+="<td>";
	str+="<ul id='rep'>";
	str+="<li>";
	str+="<span>回复于:</span>";
	str+="<span id='time'>"+time+"</span>";
	str+="<a>&nbsp&nbsp&nbsp&nbsp";
	str+="<input type='button' value='删除' title='删除该回复' id='delete_btn'>";
	str+="</a>";
	str+="</li>";
	str+="</ul>";
	str+="</td>";
	str+="</tr>";
	str+="<tr>";
	str+="<td colspan='2'><hr></td>";
	str+="</tr>";
	str+="</tbody>";
	$str=$(str);
	$($str).data("id",id);
	$(".partition").append($str);

}

function disReply(){
	var url=location.href;
	var start=url.indexOf("=");
	var postId=url.substr(start+1);
	$.ajax({
		url:path+"/reply/disreply.do",
		type:"post",
		data:{"postId":postId},
		dataType:"json",
		success:function(result){
			if(result.state==0){
				var data=result.data;
				for(var i=0;i<data.length;i++){
					var body=data[i].rep_body;
					var id=data[i].id;
					var time=new Date();
					time.setTime(data[i].time);
					time=time.toLocaleDateString()+" "+time.toLocaleTimeString();
					createReply(body,time,id);
					
				}
			}
		},
		error:function(){
			alert("显示回复出错");
		}
	});
}
function delete_btn(){
	var $body=$(this).parents("tbody");
	var id=$body.data("id");
	var postId=getId();
	if(id!=null){
		$.ajax({
			url:path+"/reply/delete.do",
			type:"post",
			data:{"id":id,"postId":postId},
			dataType:"json",
			success:function(result){
				
				if(result.state==0){
					$body.remove();
				}
				if(result.state==1){
					alert("您没有该权限");
				}
			},
			error:function(){
				alert("删除失败");
			}
		});
	}
}
function delete_post(){
	var id=getId();
	if(id!=""){
		$.ajax({
			url:path+"/post/delete_post.do",
			type:"post",
			data:{"id":id},
			dataType:"json",
			success:function(result){
				if(result.state==2){
					alert("您没有该权限");
				}if(result.state==0){
					window.location.href="forum.jsp";
				}
			},
			error:function(){
				alert("删除失败");
			}
		});
	}
}