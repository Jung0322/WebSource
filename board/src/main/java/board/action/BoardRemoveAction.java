package board.action;

import java.net.PasswordAuthentication;

import javax.servlet.http.HttpServletRequest;

import board.service.BoardRemoveService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardRemoveAction implements BoardAction {
	
	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		int bno =   Integer.parseInt(request.getParameter("bno"));
		String Password = request.getParameter("password");
		
		BoardRemoveService service =new BoardRemoveService();
		boolean removeFlag = service.remove(bno, Password);
		if(!removeFlag) {
			path = "/view/qna_board_pwdCheck.jsp?bno="+bno;
		}
		
		
		return new BoardActionForward(path,true);
	}

}
