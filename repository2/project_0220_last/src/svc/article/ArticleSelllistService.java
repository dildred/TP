package svc.article;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ArticleDAO;
import vo.ArticleBean;

public class ArticleSelllistService {

	public ArrayList<ArticleBean> getArticlelist(String email, int page, int limit) {

		Connection con = getConnection();
		ArticleDAO articleDAO = ArticleDAO.getInstance();
		articleDAO.setConnection(con);
		ArrayList<ArticleBean> abean = articleDAO.getArticleList(email,page,limit);
		close(con);
		
		return abean;
	}

}
