package board.service;

import static board.persistence.JdbcUtil.*;

import java.sql.Connection;

import board.persistence.BoardDAO;

public class BoardCountUpdateService {
	public boolean readUpdate(int bno) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		boolean readFlag = dao.readCountUpdate(bno);
		
		if(readFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return readFlag;
	}
}
