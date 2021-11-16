package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.BoardAction;
import board.action.BoardActionFactory;
import board.action.BoardActionForward;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request 인코딩 설정(post)
		request.setCharacterEncoding("utf-8");
		
		String requestUri = request.getRequestURI();
		String contexPath = request.getContextPath();
		String cmd = requestUri.substring(contexPath.length());
		
		//cmd에 따라 action 생성
		BoardActionFactory baf = BoardActionFactory.getInstance();
		BoardAction action = baf.action(cmd);
		
		//생성된 action에게 일 시키기
		BoardActionForward af = null;
		try {
			af =	action.execute(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//리턴받은 af에 따라 이동
		if(af.isRedirect()) { // true=>sendRedirect
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
