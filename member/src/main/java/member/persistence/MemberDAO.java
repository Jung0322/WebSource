package member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.domain.MemberDTO;
import member.domain.UpdateDTO;

import static member.persistence.JdbcUtil.*;

public class MemberDAO {
	private Connection con;
	
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	//login
	public MemberDTO islogin(String userid, String password) {
		MemberDTO loginDto = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select userid,name from member where userid=? and password =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				loginDto = new MemberDTO();
				loginDto.setUserid(rs.getString("userid"));
				loginDto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginDto;
	}
	
	//delete
	public boolean delete(String userid, String password) {
		boolean deleteflag = false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from member where userid=? and password =?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			int result = pstmt.executeUpdate();
			if(result>0) {
				deleteflag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteflag;
	}
	
	//비밀번호 변경
	public boolean update(UpdateDTO updateDTO) {
		boolean updateFlag = false;
		PreparedStatement pstmt = null;
		try {
			String sql = "update member set password =? where userid =? and password =? ";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, updateDTO.getNewPassword());
			pstmt.setString(2, updateDTO.getUserid());
			pstmt.setString(3, updateDTO.getCurrentPassword());
			
			int result = pstmt.executeUpdate();
			if(result>0) updateFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateFlag;
	}
}
