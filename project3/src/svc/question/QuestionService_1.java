package svc.question;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QuestionDAO;
import vo.PageInfo;
import vo.QuestionBean;

import static db.JdbcUtil.*;

public class QuestionService_1 {

	// 총 게시글 수
	public int getListCount() throws Exception{
		System.out.println("서비스1");
		int listCount =0;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		listCount = questionDAO.selectListCount();
		close(con);
		
		return listCount;
		
	}
	
	//게시글 리스트
	public ArrayList<QuestionBean> getArticleList(int page, int limit) throws Exception{
		System.out.println("서비스2");
		ArrayList<QuestionBean> articleList =null;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		articleList = questionDAO.selectArticleList(page,limit);
		close(con);
		
		return articleList;
		
		
	}
	
	//게시글 저장
	
	public boolean registArticle(QuestionBean questionBean) {
		System.out.println("서비스3");
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int insertCount = questionDAO.insertArticle(questionBean);
		
		if(insertCount >0) isWriteSuccess =true;
		
		close(con); 
		
		return isWriteSuccess;
	}
	
	
	//답글 저장
	
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
	
	
	
	
	//게시글 상세보기(조회수필요없음)
	
	public QuestionBean getArticle(int num) {
		System.out.println("서비스4");
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.contentLookUp(num);
		close(con);
		
		return bean;
	}
	
	//수정할 게시글 상세 보기
	public QuestionBean getModifyArticle(int num) {
		System.out.println("서비스5");
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.contentLookUp(num);
		close(con);
		
		return bean;
		
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
	
	
	//게시글 삭제
	
	public void questionDelete(int num) {
		System.out.println("서비스6");
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		questionDAO.questionDelete(num);
		
		close(con);
	}
	
	public boolean modifyArticle(QuestionBean questionBean) {
		System.out.println("서비스7");
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
