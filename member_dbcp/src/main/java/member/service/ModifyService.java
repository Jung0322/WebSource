package member.service;

import static member.persistence.JdbcUtil.close;
import static member.persistence.JdbcUtil.getConnection;

import java.sql.Connection;

import member.domain.UpdateDTO;
import member.persistence.MemberDAO;
import static member.persistence.JdbcUtil.*;

public class ModifyService {
	public boolean modify(UpdateDTO dto) {
		Connection con =getConnection();
	    MemberDAO dao = new MemberDAO(con);
	    
	    boolean updateFlag =  dao.update(dto);
	    
	    if(updateFlag) {
	    	commit(con);
	    }else {
			rollback(con);
		}
	    
		return updateFlag;
	}


}
