function postEdtor(){
	
	var title=$("#title_opt").val().trim();
	var body=ue.getContent();
	if(title==""){
			$("#pro").html("标题为null");
	}
	if(body==""){
		$("#pro").html("内容为null");
	}
	if(title!="" && body!=""){
		$("#pro").html("");
		$.ajax({
			url:path+"/post/tourist.do",
			type:"post",
			data:{"title":title,"body":body},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					window.location.href="forum.jsp";
				}
			},
			error:function(){
				alert("发表帖子出错");
			}
		});
	}
}