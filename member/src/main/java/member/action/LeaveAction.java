package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.persistence.MemberDAO;
import member.service.LeaveService;


@AllArgsConstructor
public class LeaveAction implements Action {

	private String path;
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		//사용자가 넘기는 값 가져오기
		String userid = request.getParameter("userid");
		String current_password = request.getParameter("current_password");
		
		//db 작업 서비스에게 부탁
		LeaveService service = new LeaveService();
		boolean deleteFlag = service.leave(userid, current_password);
		
		
		//결과에 따라 페이지 이동
		if(deleteFlag) {
			HttpSession session = request.getSession();
			session.removeAttribute("loginDto");
		}else {
			path="/view/leaveForm.jsp";
		}
		return new ActionForward(path,true);
	}

}
