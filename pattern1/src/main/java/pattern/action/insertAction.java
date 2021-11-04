package pattern.action;

import javax.servlet.http.HttpServletRequest;

public class insertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return new ActionForward("insert.jsp",false);
	}

}
