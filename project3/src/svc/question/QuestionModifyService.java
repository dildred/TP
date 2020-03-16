package svc.question;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import dao.QuestionDAO;
import vo.QuestionBean;

public class QuestionModifyService {
	
	//수정할 게시글 보기
	public QuestionBean getModifyArticle(int num) {
		
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.questionDetail(num);
		close(con);
		
		return bean;
		
	}
	
	public boolean modifyArticle(QuestionBean questionBean) {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int insertCount = questionDAO.updateModifyArticle(questionBean);
		
		if(insertCount >0) isModifySuccess = true;
		
		close(con);
		
		return isModifySuccess;
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
