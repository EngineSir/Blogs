function Getquest(){
			var url=location.href;
			var start=url.indexOf("=");
			var id=url.substr(start+1);
			if(id!=""){
				$.ajax({
					url:path+"/admin/clickHref.do",
					type:"post",
					data:{"id":id},
					dataType:"json",
					success:function(result){
						data=result.data;
						title=data.title;
						body=data.body;
						console.log(body);
						time=new Date();
						time.setTime(data.time);
						$("#title").html(title);
						$(".border_main").html(body);
						$("#data").html(time.toLocaleDateString()+" "+time.toLocaleTimeString());
						$("#att").html(data.blog_attr);
						
					},
					error:function(){
						alert("查询失败");
					}
				});
			}
		}