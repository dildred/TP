package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberModifyService {
	
	

	public MemberBean memberModify(String email) {
		
		Connection con = getConnection(); //DB연결 객체 가져옴
		MemberDAO memberdao = MemberDAO.getInstance(); //쿼리구문 실행 DAO객체를 생성
		memberdao.setConnection(con); //DAO에 DB연결 객체를 넣어줌
		MemberBean bean = memberdao.memberinfo(email); //DB에 회원정보를 저장할 정보를 DAO에 넣어줌
		close(con); //DB연결 객체 자원해제
		
		return bean;
	}
	
	
	
}
