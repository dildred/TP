package svc.question;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QuestionDAO;
import vo.PageInfo;
import vo.QuestionBean;

public class QuestionSearchService {

	
	//게시글 검색
	
	public ArrayList<QuestionBean> questionSearch(String choice, String input) {

		ArrayList<QuestionBean> articleList = null;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);

		if("title".equals(choice)) articleList = questionDAO.titleSearchList(input);
		else if("question_Email".equals(choice)) articleList = questionDAO.titleSearchList(input);
		
		close(con);
		
		return articleList;
		
	}

	public PageInfo searchPageInfo(String choice, String input) {
		
		PageInfo pageInfo = null;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		
		if("title".equals(choice)) pageInfo = questionDAO.subjectSearchCount(input);
		else if("question_Eamil".equals(choice)) pageInfo = questionDAO.nameSearchCount(input);
		
		return pageInfo;
	}
	
}
