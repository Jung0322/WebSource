package member.service;

import static member.persistence.JdbcUtil.*;

import java.sql.Connection;

import member.persistence.MemberDAO;

public class JoinService {
	public boolean register(String userid, String password, String name, String gender, String email) {
		Connection con = getConnection();
		
		MemberDAO dao = new MemberDAO(con);
		boolean insertFlag = dao.insert(userid, password, name, gender, email);
		
		if(insertFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		 
		close(con);
		return insertFlag;
	}
}
