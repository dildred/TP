package svc.question;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.QuestionDAO;
import vo.QuestionBean;

public class QuestionReplyService {
	
	//답글달기
	
	public boolean replyArticle(QuestionBean questionBean) {
		
		boolean isReplySuccess=false;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int insertCount = questionDAO.insertReplyArticle(questionBean);
		
		if(insertCount > 0) isReplySuccess = true;
		
		close(con);
		
		return isReplySuccess;
	}

}
