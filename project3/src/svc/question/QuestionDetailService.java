package svc.question;

import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.close;

import java.sql.Connection;

import dao.QuestionDAO;
import vo.QuestionBean;

public class QuestionDetailService {

	
	  public QuestionBean getArticle(int question_num) throws Exception{
	 
	  QuestionBean article = null; Connection con = getConnection(); QuestionDAO
	  questionDAO = QuestionDAO.getInstance(); questionDAO.setConnection(con);
	  
	  article = questionDAO.questionDetail(question_num);
	  
	  close(con); return article; 
	  }
	 
	
	/*
	 * public QuestionBean getArticle(int num) {
	 * 
	 * Connection con = getConnection(); QuestionDAO questionDAO
	 * =QuestionDAO.getInstance(); questionDAO.setConnection(con); QuestionBean bean
	 * = questionDAO.questionDetail(num); close(con);
	 * 
	 * return bean; }
	 */
}
