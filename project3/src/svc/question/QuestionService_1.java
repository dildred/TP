package svc.question;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QuestionDAO;
import vo.PageInfo;
import vo.QuestionBean;

import static db.JdbcUtil.*;

public class QuestionService_1 {

	// �� �Խñ� ��
	public int getListCount() throws Exception{
		System.out.println("����1");
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
		System.out.println("����2");
		ArrayList<QuestionBean> articleList =null;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		articleList = questionDAO.selectArticleList(page,limit);
		close(con);
		
		return articleList;
		
		
	}
	
	//�Խñ� ����
	
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
	
	
	//��� ����
	
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
	
	
	
	
	//�Խñ� �󼼺���(��ȸ���ʿ����)
	
	public QuestionBean getArticle(int num) {
		System.out.println("����4");
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.contentLookUp(num);
		close(con);
		
		return bean;
	}
	
	//������ �Խñ� �� ����
	public QuestionBean getModifyArticle(int num) {
		System.out.println("����5");
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.contentLookUp(num);
		close(con);
		
		return bean;
		
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
	
	
	//�Խñ� ����
	
	public void questionDelete(int num) {
		System.out.println("����6");
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		questionDAO.questionDelete(num);
		
		close(con);
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
