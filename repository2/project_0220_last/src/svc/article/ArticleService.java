package svc.article;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ArticleDAO;
import vo.ArticleBean;
import vo.PageInfo;

import static db.JdbcUtil.*;

public class ArticleService {
	

	public int getListCount() throws Exception{
		
		int listCount = 0;
		Connection con = getConnection();
		ArticleDAO articleDAO = ArticleDAO.getInstance();
		articleDAO.setConnection(con);
		listCount = articleDAO.selectListCount();
		close(con);
		
		return listCount;
	} 
	
	public int getMemListCount(String email) throws Exception{
		
		int listCount = 0;
		Connection con = getConnection();
		ArticleDAO articleDAO = ArticleDAO.getInstance();
		articleDAO.setConnection(con);
		listCount = articleDAO.selectMemListCount(email);
		close(con);
		
		return listCount;
	} 
	
	public ArrayList<ArticleBean> getArticleList(int page, int limit) throws Exception {
		
		ArrayList<ArticleBean> articleList = null;
		Connection con = getConnection();
		ArticleDAO articleDAO = ArticleDAO.getInstance();
		articleDAO.setConnection(con);
		articleList = articleDAO.selectArticleList(page, limit);
		close(con);
		
		return articleList;
	}
	
	
	public boolean registArticle(ArticleBean articleBean) {
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		ArticleDAO articleDAO = ArticleDAO.getInstance();
		articleDAO.setConnection(con);
		int insertCount = articleDAO.insertArticle(articleBean);
		
		if(insertCount > 0) isWriteSuccess = true;
		
		close(con);
		
		return isWriteSuccess;
	}
	
	
	
}