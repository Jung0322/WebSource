/**
 * mock_data.json 파일 요청 후 보여주기
 */
$(function() {
	$("button").click(function() {

		$.getJSON({
			url: "/data/MOCK_DATA.json",
			success: function(data) {
				let resText = "<ul>";
				$(data).each(function(idx, item) {
					resText += "<li>id :" + item.id + "</li>";
					resText += "<li>name :" + item.name + "</li>";
					resText += "<li>email :" + item.email + "</li>";
					resText += "<li>gender :" + item.gender + "</li>";
				})
				resText += "</ul>";
				$("#contents").html(resText);
			},
			error: function(xhr, textStatus, error) {
				$("#contents").html("데이터 없음");
			}
		})
	})
})