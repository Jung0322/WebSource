package book.service;

import java.lang.invoke.CallSite;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;

import static book.persistence.JdbcUtil.*;
import book.domain.BookDTO;
import book.persistence.BookDAO;

public class BookSearchService {
	public List<BookDTO> search(String criteria, String keyword){
		
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		List<BookDTO> list =  dao.search(criteria,keyword);
		
		close(con);
		
		return list;
	}
}