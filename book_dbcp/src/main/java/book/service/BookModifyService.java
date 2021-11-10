package book.service;

import book.persistence.BookDAO;
import static book.persistence.JdbcUtil.*;

import java.sql.Connection;
import java.sql.SQLException;

public class BookModifyService {
	public boolean bookUpdate(String code, int price) {
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		boolean modifyFlag = dao.update(code, price);
		
		if(modifyFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return modifyFlag;
	
	}
}
