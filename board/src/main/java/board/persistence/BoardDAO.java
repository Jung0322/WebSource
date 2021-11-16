package board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.domain.BoardDTO;

import static board.persistence.JdbcUtil.*;
public class BoardDAO {
	private Connection con;
	public BoardDAO(Connection con) {
		this.con = con;
	}
	
	public boolean insert(BoardDTO dto) {
		boolean insertFlag = false;
		PreparedStatement pstmt = null;
		try {
			String sql ="insert into board(bno,title,content,password,attach,name,re_ref,re_lev,re_seq) values(board_seq.nextval,?,?,?,?,?,board_seq.currval,0,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getAttach());
			pstmt.setString(5, dto.getName());
			int result = pstmt.executeUpdate();
			if(result>0) {
				insertFlag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertFlag;
	}
	
	//전체 목록
	public List<BoardDTO> getList(){
		List<BoardDTO> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			String sql="select bno,title,name,regdate,readcount from board order by bno desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	// 게시글 읽기
	public BoardDTO getRow(int bno) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		BoardDTO dto = new BoardDTO();
		try {
			String sql = "select bno,name, title, content, attach from board where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return dto;
	}
	
	//조회수 업데이트
	public boolean readCountUpdate(int bno) {
		String sql = "update board set readcount = readcount+1 where bno=?";
		boolean updateFlag = false;
		PreparedStatement pstmt =null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			int result = pstmt.executeUpdate();
			if(result>0) {
				updateFlag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateFlag;
	}
}
