package svc.question;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QuestionDAO;
import vo.QuestionBean;




public class QuestionListService {
	// �� �Խñ� ��
	public int getListCount() throws Exception{
		System.out.println("리스트1");
		int listCount =0;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		listCount = questionDAO.selectListCount();
		close(con);
		
		return listCount;
		
	}
	
	//�Խñ� ����Ʈ
	public ArrayList<QuestionBean> getArticleList(int page, int limit) throws Exception{
		System.out.println("리스트2");
		ArrayList<QuestionBean> articleList =null;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		articleList = questionDAO.selectArticleList(page,limit);
		close(con);
		
		return articleList;
		
		
	}
}
