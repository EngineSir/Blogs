function keepBlog(){
	var id=getId();
	var body=ue.getContent();
	var title=$("#title_opt").val();
	if(id!=""){
		$.ajax({
			url:path+"/admin/update.do",
			type:"post",
			data:{"id":id,"title":title,"body":body},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					window.location.href="adminCode.html";
				}
			},
			error:function(){
				alert("修改失败");
			}
		});
	}
}
function getContent(){
	var id=getId();
	if(id!=""){
		$.ajax({
			url:path+"/admin/clickHref.do",
			type:"post",
			data:{"id":id},
			dataType:"json",
			success:function(result){
				var data=result.data;
				var title=data.title;
				var body=data.body;
				$("#title_opt").val(title);
				ue.setContent(body);
				
			},
			error:function(){
				alert("查询失败");
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