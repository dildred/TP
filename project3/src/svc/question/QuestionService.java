package svc.question;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;
import vo.PageInfo;
import vo.QuestionBean;

import static db.JdbcUtil.*;

public class QuestionService {

	// 총 게시글 수
	public int getListCount() throws Exception{
		int listCount =0;
		Connection con = getConnection();
		QuestionDAO questionDAO = getConnection();
		questionDAO.setConnection(con);
		listCount = questionDAO.selectListCount();
		close(con);
		
		return listCount;
		
	}
	
	//게시글 리스트
	public ArrayList<QuestionBean> getArticleList(int page, int limit) throws Exception{
		
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
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int insertCount = questionDAO.insertArticle(questionBean);
		
		if(insertCount >0) isWriteSuccess =true;
		
		close(con); 
		
		return isWriteSuccess;
	}
	
	
	//답글 저장 필요없음
	
	//게시글 상세보기(조회수필요없음)
	
	public QuestionBean getArticle(int num) {
		
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.contentLookUP(num);
		close(con);
		
		return bean;
	}
	
	//수정할 게시글 상세 보기
	public QuestionBean getModifyArticle(int num) {
		
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.contentLookUP(num);
		close(con);
		
		return bean;
		
	}
	
	//비밀번호 필요없음
	
	//게시글 삭제
	
	public void questionDelete(int num) {
		
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		questionDAO.questionDelete(num);
		
		close(con);
	}
	
	public boolean modifyArticle(QuestionBean questionBean) {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int isertCount = boardDAO.updateModifyArticle(questionBean);
		
		if(insertCount >0) isModifySuccess = true;
		
		close(con);
		
		return isModifySuccess;
		
	}
	public ArrayList<QuestionBean> boardSearch(String choice, String input) {

		ArrayList<QuestionBean> articleList = null;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);

		if("subject".equals(choice)) articleList = questionDAO.subjectSearchList(input);
		else if("board_name".equals(choice)) articleList = questionDAO.nameSearchList(input);
		
		close(con);
		
		return articleList;
		
	}

	public PageInfo searchPageInfo(String choice, String input) {
		
		PageInfo pageInfo = null;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		
		if("subject".equals(choice)) pageInfo = questionDAO.subjectSearchCount(input);
		else if("board_name".equals(choice)) pageInfo = questionDAO.nameSearchCount(input);
		
		return pageInfo;
	}
	
	
	
}
