package svc.question;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.QuestionDAO;
import vo.QuestionBean;

public class QuestionModifyService {
	
	//������ �Խñ� �� ����
	public QuestionBean getModifyArticle(int num) {
		System.out.println("����5");
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.questionDetail(num);
		close(con);
		
		return bean;
		
	}
	
	public boolean modifyArticle(QuestionBean questionBean) {
		System.out.println("����7");
		boolean isModifySuccess = false;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int insertCount = questionDAO.updateModifyArticle(questionBean);
		
		if(insertCount >0) isModifySuccess = true;
		
		close(con);
		
		return isModifySuccess;
	}
}
