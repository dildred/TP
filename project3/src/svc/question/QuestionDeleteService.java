package svc.question;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.QuestionDAO;

public class QuestionDeleteService {

	//�Խñ� ����
	
		public void questionDelete(int num) {
			System.out.println("����6");
			Connection con = getConnection();
			QuestionDAO questionDAO =QuestionDAO.getInstance();
			questionDAO.setConnection(con);
			questionDAO.questionDelete(num);
			
			close(con);
		}
		//�Խñ� ��й�ȣ
		
		public String getPass(int num) {
		
				Connection con = getConnection();
				QuestionDAO questionDAO = QuestionDAO.getInstance();
				questionDAO.setConnection(con);
				String passwd = questionDAO.getPass(num);
				
				close(con);
				
				return passwd;
			}
}
