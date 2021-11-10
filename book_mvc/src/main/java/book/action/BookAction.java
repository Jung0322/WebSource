package book.action;

import javax.servlet.http.HttpServletRequest;

public interface BookAction {
	public BookActionForward excute(HttpServletRequest request) throws Exception;
}
