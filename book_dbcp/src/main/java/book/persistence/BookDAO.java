package book.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import book.domain.BookDTO;

import static book.persistence.JdbcUtil.*;

public class BookDAO {
	private Connection con;
	
	public BookDAO(Connection con) {
		this.con= con;
	}
	
	//insert
	public boolean insert(BookDTO insertDto) {
		String sql = "insert into BookTBL values(?,?,?,?)";
		boolean insertFlag = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, insertDto.getCode());
			pstmt.setString(2, insertDto.getTitle());
			pstmt.setString(3, insertDto.getWriter());
			pstmt.setInt(4, insertDto.getPrice());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				insertFlag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertFlag;
	}
	//delete
	public boolean detele(String code) {
		boolean deleteFlag = false;
		PreparedStatement pstmt= null;
		try {
			String sql = "delete from BookTBL where code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			int result = pstmt.executeUpdate();
			if(result>0) {
				deleteFlag =true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteFlag;
	}
	
	//update
	public boolean update(String code, int price) {
		boolean updateFlag = false;
		PreparedStatement pstmt= null;
		try {
			String sql = "update BookTBL set price = ? where code= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, code);
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
	
	//select
	public List<BookDTO> list(){
		List<BookDTO> booklist = new ArrayList<BookDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		
		try {
			String sql = "select * from BookTBL";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setPrice(rs.getInt("price"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				booklist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return booklist;
	}
	
	// 검색
	public List<BookDTO> search(String criteria,String keyword){
		List<BookDTO> list = new ArrayList<BookDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from bookTBL where "+criteria+"=?"; 
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookDTO dto =  new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setPrice(rs.getInt("price"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				list.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
}
