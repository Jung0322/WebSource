/**
 * 
 */
let last_div = document.querySelector(".container div:last-child")
   .addEventListener('click', makeRequest);

let xhr = new XMLHttpRequest();
function makeRequest() {
   xhr.onreadystatechange = getJson;
   xhr.open("get", "/data/data.json");
   xhr.send(null);

}
//서버가 응답하는 경우 호출
function getJson() {
   //서버가 보내준 데이터를 contents 영역에 보여주기
   let contents = document.querySelector("#contents");
   if (xhr.readyState==4) {

      if (xhr.status == 200) {
         let response = JSON.parse(xhr.responseText);
         let resText = "<ul><li>version :" + response.version + "</li>";
         resText += "<li>codename :" + response.codename + "</li></ul>";

         contents.innerHTML = resText;
      } else {
         contents.innerHTML=  "가져온 데이터없음";
      }


   }
}