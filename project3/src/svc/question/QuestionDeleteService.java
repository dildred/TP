package svc.question;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.QuestionDAO;

public class QuestionDeleteService {

	//게시글 삭제
	
		public void questionDelete(int num) {
			System.out.println("서비스6");
			Connection con = getConnection();
			QuestionDAO questionDAO =QuestionDAO.getInstance();
			questionDAO.setConnection(con);
			questionDAO.questionDelete(num);
			
			close(con);
		}
		//게시글 비밀번호
		
		public String getPass(int num) {
		
				Connection con = getConnection();
				QuestionDAO questionDAO = QuestionDAO.getInstance();
				questionDAO.setConnection(con);
				String passwd = questionDAO.getPass(num);
				
				close(con);
				
				return passwd;
			}
}
