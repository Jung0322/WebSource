package board.service;

import java.sql.Connection;
import java.util.List;
import static board.persistence.JdbcUtil.*;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

public class BoardListService {
	public List<BoardDTO> all(){
		Connection con = getConnection();
		BoardDAO dao =  new BoardDAO(con);
		
		List<BoardDTO> list = dao.getList();
		
		close(con);
		
		return list;
	}
}
