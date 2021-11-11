/**
 * getxmlArray.js에서 메뉴 4 클릭시 동작
 */
$(function(){
	$(".container div:last-child").click(function(){
		$.get({
			url: "/data/schoolArray.xml",
			success:function(data){
				let output = "<ul>";
				
				// .each(function(idx)) / each(function()) / each(function(idx,item))
				$(data).find("subject").each(function(){
					output += "<li>title : "+$(this).find("title").text()+"</li>";
					output += "<li>time : "+$(this).find("time").text()+"</li>";
					output += "<li>teacher : "+$(this).find("teacher").text()+"</li>";
				})
				output+="</ul>";
				
				$("#contents").html(output);
			},
			error:function(xhr,textStatus,error){
				$("#contents").html("데이터 없음");
			}
		})
	})
})



