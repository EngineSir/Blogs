function dispost(){
	if(page==1){
		$("#page1").attr('disabled',true); 
	}
	$.ajax({
		url:path+"/post/dispost.do",
		type:"post",
		data:{"page":page},
		dataType:"json",
		success:function(result){
			var data=result.data;
			if(result.state==0){
				$("#str").empty();
				for(var i=0;i<data.length;i++){
					var title=data[i].title;
					var id=data[i].id;
					var rep_num=data[i].rep_num;
					var read_num=data[i].read_num;
					var time=new Date();
					time.setTime(data[i].time);
					var times=time.toLocaleDateString();
					createTr(id,title,rep_num,read_num,times);
				}
				if(data.length==0){
					$("#page").attr('disabled',true); 
					var sth="";
					sth+="<th>";
					sth+="没有更多内容";
					sth+="</th>";
					sth+="<th></th>";
					sth+="<th></th>"
					sth+="<th></th>"
					var $th=$(sth);
					$("#str").append($th);
				}
			}
		},
		error:function(){
			alert("显示失败");
		}
	});
}
function createTr(id,title,rep_num,read_num,time){
	var str="";
	str+="<tr>";
	str+="<td>";
	str+="<a href='dispost.html?id="+id+"'>"+title+"</a>";
	str+="</td>";
	str+="<td>"+rep_num+"</td>";
	str+="<td>"+read_num+"</td>";
	str+="<td>"+time+"</td>";
	str+="</tr>";
	var $st=$(str);
	$("#str").append($st);
}
function down(){
	$("#page1").attr('disabled',false); 
	page+=1;
	dispost();
}
function up(){
	$("#page").attr('disabled',false); 
	page-=1;
	dispost();
}