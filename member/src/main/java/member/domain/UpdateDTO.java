package member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDTO {
	private String userid;
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	
	public boolean passwordEqualTo(String confirmPssword) {
		return this.newPassword.equals(confirmPssword);
	}
}
