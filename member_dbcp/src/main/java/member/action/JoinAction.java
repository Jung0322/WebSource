package member.action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import member.service.JoinService;

@AllArgsConstructor
public class JoinAction implements Action {

	String path;
	
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("confirm_password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender"); 
		String email = request.getParameter("email"); 
		
		JoinService service = new JoinService();
		boolean insertFlag =service.register(userid, password, name, gender, email);
		
		if(!insertFlag) {
			path="/view/joinForm.jsp";
		}
		
		
		return new ActionForward(path,true);
	}

}
