/**
 * joinform.jsp 회원가입 유효성 검증
 */

$(function() {
   $("#joinform").validate({
      rules: {
         userid: {
            required: true,
            validId: true
         },
         password: {
            required: true,
            validPwd: true
         },
         confirm_password: {
            required: true,
            validPwd: true,
            equalTo: "#password"
         },
         name: {
            required: true
         },
         gender: {
            required: true
         },
         email: {
            required: true,
            email:true
         },
      },
      messages: {
         userid: {
            required: "아이디를 입력해주세요"
         },
         password: {
            required: "비밀번호를 입력해주세요"
         },
         confirm_password: {
            required: "비밀번호를 확인해주세요",
            equalTo: "비밀번호가 같지 않습니다"
         },
         name: {
            required: "이름을 입력해주세요"
         },
         gender: {
            required: "성별을 선택해주세요"
         },
         email: {
            required: "이메일을 입력해주세요",
            email:"이메일 주소를 확인해주세요"
         },
      },
      errorPlacement: function(error, element) {
         $(element).closest("form").find("small[id='" + element.attr("id") + "']").append(error);
      }
   })
})

//사용자 규칙 추가
$.validator.addMethod("validId", function(value) {
   let regId = /^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z\d]{6,12}$/;
   return regId.test(value); // true or false
}, "아이디는 영대소문자,숫자의 조합으로 6~12자리로 만들어야합니다")


$.validator.addMethod("validPwd", function(value) {
   let regPwd = /^(?=.*[A-Za-z])(?=.*[\d])(?=.*[!@#])[A-Za-z\d!@#]{8,15}$/;
   return regPwd.test(value); // true or false
}, "비밀번호는 영대소문자,숫자,특수문자의 조합으로 8~15자리로 만들어야합니다")



