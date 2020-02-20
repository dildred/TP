package svc.question;

import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.close;

import java.sql.Connection;

import dao.QuestionDAO;
import vo.QuestionBean;

public class QuestionDetailService {

		public QuestionBean getArticle(int question_num) throws Exception{
			
			QuestionBean article =null;
			Connection con = getConnection();
			QuestionDAO questionDAO = QuestionDAO.getInstance();
			questionDAO.setConnection(con);
			
			article = questionDAO.contentLookUp(question_num);
			
			close(con);
			return article;
		}
}
