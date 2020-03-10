package svc.question;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.QuestionDAO;
import vo.QuestionBean;

public class QuestionWriteService {

	//게시글 쓰기
	
	public boolean registArticle(QuestionBean questionBean) {
		System.out.println("����3");
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int insertCount = questionDAO.insertArticle(questionBean);
		
		if(insertCount >0) isWriteSuccess =true;
		
		close(con); 
		
		return isWriteSuccess;
	}
	
}
