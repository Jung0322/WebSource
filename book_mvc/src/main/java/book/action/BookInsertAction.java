package book.action;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookInsertService;
import lombok.AllArgsConstructor;
@AllArgsConstructor

public class BookInsertAction implements BookAction {
	
	private String path;

	@Override
	public BookActionForward excute(HttpServletRequest request) throws Exception {
		// insert.jsp에서 넘긴 값 가져오기
		BookDTO dto = new BookDTO();
		dto.setCode(request.getParameter("code"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		// service에게 db 작업 요청
		
		BookInsertService service = new BookInsertService();
		boolean InsertFlag =  service.bookInsert(dto);
		
		//결정에 따라서 페이지 이동
		if(!InsertFlag) {
			path="/index.jsp?tab=insert";
		}
		return new BookActionForward(path,true) ;
	}

	

}
