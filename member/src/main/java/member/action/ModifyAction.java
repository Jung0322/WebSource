package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.domain.UpdateDTO;
import member.service.ModifyService;

@AllArgsConstructor
public class ModifyAction implements Action {

	private String path;
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		//modifyForm.jsp에서 사용자 입력값 가져오기
		
		HttpSession session = request.getSession();
		MemberDTO loginDto =  (MemberDTO) session.getAttribute("loginDto");
		String userid = loginDto.getUserid(); 
		
		String current_password= request.getParameter("current_password");
		String new_password= request.getParameter("new_password");
		String confirm_password= request.getParameter("confirm_password");
		UpdateDTO updateDTO = new UpdateDTO(userid,current_password,new_password,confirm_password);
		
		if(updateDTO.passwordEqualTo(new_password)) {
			//db작업
			ModifyService service = new ModifyService();
			Boolean modifyFlag =  service.modify(updateDTO);
			if(modifyFlag) {
				session.removeAttribute("loginDto");
			
			}else {
				path = "/view/modifyForm.jsp";
			}
			//성공 : commit, 현재 세션 해제, 로그인 페이지로 이동
			//실패시 : rollback, 비밀번호 변경 페이지로 이동
		} else {
			//비밀 변경 페이지로 이동
			path = "/view/modifyForm.jsp";
		}
		
		return new ActionForward(path,true);
	}


}
