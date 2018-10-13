function editBlog(){
	var attr=$("#select_opt").val();
	var type=$("#select_body").val();
	var title=$("#title_opt").val();
	var body=ue.getContent();
	var flog=false;
	if(attr==""){
		$("#idt").html("博客声明null");
	}
	if(type==""){
		$("#idt").html("博客类型null");
	}
	if(title==""){
		$("#idt").html("博客标题null");
	}
	if(body==""){
		$("#idt").html("博客内容null");
	}
	if(attr!="" && type!="" && title!="" && body!=""){
		$("#idt").html("");
		flog=true;
	}
	if(flog){
		$.ajax({
			url:path+"/admin/editor.do",
			type:"post",
			data:{"attr":attr,"type":type,"title":title,"body":body},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					
					window.location.href="adminCode.html";
				}
			},
			error:function(){
				alert("发表博客失败");
			}
		});
	}
	
}