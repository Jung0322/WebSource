package pattern.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

   public MemberDTO(String userid, String password) {
		this.userid = userid;
		this.password=password;
	}
private String userid;
   private String password;
   private String name;
   private String gender;
   private String email;
   private String changePassowrd;
   

}
