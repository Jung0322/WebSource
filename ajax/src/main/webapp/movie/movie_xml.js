$(function() {
   init();

   $(":button").click(function() {
      let url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
      url += $("#txtYear").val() + $("#selMon").val() + $("#selDay").val();
      console.log(url);

      $.get({
         url: url,
         success: function(data) {
            console.log(data);

            if ($(data).find("dailyBoxOffice").text() == "") {
               alert("데이터가 없습니다.");
            } else {
               let resData = "";
               $(data).find("dailyBoxOffice").each(function() {
                  
                  resData += $(this).find("rank").text() + "위";
                  
                  //증감표시를 위해 변수 선언후 if문
                  let rankInten = $(this).find("rankInten").text();
                  // + - 0 증감표시를 위한 if문
                  if (rankInten > 0) resData += "( △ ";
                  else if (rankInten < 0) resData += "( ▼ ";
                  else resData += "( ";

                  resData += rankInten + " )";
                  
                  //영화코드
                  let movieCd = $(this).find("movieCd").text();
                  //영화이름
                  let movieNm = $(this).find("movieNm").text();
                  
                  
                  resData += "<a href='#' onclick='javascript:show("+movieCd+")'>"+movieNm+"</a><br>";
               })
                  $("#msg").html(resData); //불러온 데이터들을 표시해주는 곳
            }//else end
         } //success end
      }) // $get end
   })// button click function end
})//$function()) end

function show(movieCd){
   let url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.xml?key=f5eef3421c602c6cb7ea224104795888&movieCd=";
   url+=movieCd;
   console.log(url);
   
   $.get({
      
      url:url,
      success:function(data){
         console.log(data);
         let movieNm = $(data).find("movieNm").text();
         let movieNmEn = $(data).find("movieNmEn").text();
         let showTm = $(data).find("showTm").text();
         let directorNm = $(data).find("director").find("peopleNmEn").text();
         let peopleNm = "";
         let length = $(data).find("actor").find("peopleNm").length;
         $(data).find("actor").each(function(idx){
               if(idx==length-1){
               }else{
               peopleNm += $(this).find("peopleNm").text()+", ";
                  
               }
         })
         
         let resData = "<ul>";
         resData += "<li>영화제목(국문) :"+movieNm+"</li>";
         resData += "<li>영화제목(영문) :"+movieNmEn+"</li>";
         resData += "<li>상영시간 :"+showTm+"분</li>";
         resData += "<li>감독 :"+directorNm+"</li>";
         resData += "<li>배우 :"+peopleNm+"</li></ul>";
         
         $(".box3").html(resData);
         
      }
      
      
   })
   
   
   
   
   
}//show() end
function init() {
   let newDate = new Date();
   let year = newDate.getFullYear();
   let month = newDate.getMonth() + 1;
   let day = newDate.getDate() - 1;

   $("#txtYear").val(year);

   if (month < 10) {
      month = "0" + month;
   }
   if (day < 10) {
      day = "0" + day;
   }
   $("#selMon").val(month);
   $("#selDay").val(day);
}