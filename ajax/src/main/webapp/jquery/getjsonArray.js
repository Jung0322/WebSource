/**
 * sendForm.html 
 */
$(function(){
   $("#get").click(function(){
      
      let userid = $("#userid").val();
      let age = $("#age").val();
      
      $.get({
         url:"sendForm.jsp",
         data:{
            userid:userid,
            age:age
            
         },
         success:function(data){
            alert(data);
         }
         
         
      })
      
   })
   $("post").click(function(){
      
      
      
   })
   
   
   
})


//body가 로드가 되면
/*window.onload = function() {
   document.getElementById("get").onclick = function() {
      //보낼 데이터 가져오기
      let userid = document.getElementById("userid").value;
      let age = document.getElementById("age").value;

      //데이터 전송(비동기)

      let xhr = new XMLHttpRequest();
      xhr.open("get","sendForm.jsp?userid="+userid+"&age="+age);
      xhr.send();


   }
   document.getElementById("post").onclick = function() {
      let userid = document.getElementById("userid").value;
      let age = document.getElementById("age").value;

      //데이터 전송(비동기)

      let xhr = new XMLHttpRequest();
      xhr.open("post","sendForm.jsp");
      //데이터 전송시 기본값
      xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
      xhr.send("userid="+userid+"&age="+age);
   }
}*/