package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LogoutAction implements Action {

	private String path;
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		//세션 해제
		HttpSession session = request.getSession();
		session.removeAttribute("loginDto");
		//session.invalidate();
		
		return new ActionForward(path,true);
	}

}
