package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberLoginService {

	public String memberJoin(MemberBean member) {
		
		Connection con = getConnection();
		MemberDAO memberdao = MemberDAO.getInstance();
		memberdao.setConnection(con);
		String email = memberdao.memberCheck(member);
		close(con);
		
		return email;
	}

}
