package member.action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ModifyAction implements Action {

	private String path;
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		//modifyForm.jsp에서 사용자 입력값 가져오기
		String current_password= request.getParameter("current_password");
		String new_password= request.getParameter("new_password");
		String confirm_password= request.getParameter("confirm_password");
		return null;
	}


}
