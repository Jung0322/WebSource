package board.service;

import static board.persistence.JdbcUtil.*;

import java.sql.Connection;
import javax.servlet.RequestDispatcher;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

public class BoardReplyService {
	public boolean reply(BoardDTO dto) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);

		dao.replyUpdate(dto);
		commit(con);
		
		boolean insertFlag = dao.replyInsert(dto);
		if (insertFlag) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);
		return insertFlag;

	}
}
