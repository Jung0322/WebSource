/**
 * dataset.html - 서버에서 dataset.xml 데이터 요청 후 보여주기
 */
window.onload = function () {
    //문서가 실행 되었을 때 실행할 코드
	$.get({
		url:"/data/dataset.xml",
		success:function(data){
			let output = "<ul>";
			
			$(data).find("record").each(function(){
				output += "<li>id : "+$(this).find("id").text()+"</li>";
				output += "<li>name : "+$(this).find("name").text()+"</li>";
				output += "<li>email : "+$(this).find("email").text()+"</li>";
				output += "<li>gender : "+$(this).find("gender").text()+"</li>";
			})
			output+="</ul>";
			
			$("#contents").html(output);
		},
		error:function(xhr,textStatus,error){
			$("#contents").html("데이터 없음");
		}
	})
}