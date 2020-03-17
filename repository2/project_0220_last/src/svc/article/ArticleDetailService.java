package svc.article;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ArticleDAO;
import vo.ArticleBean;

public class ArticleDetailService {

	public ArticleBean getArticle(int num) {

		Connection con = getConnection();
		ArticleDAO articleDAO = ArticleDAO.getInstance();
		articleDAO.setConnection(con);
		ArticleBean bean = articleDAO.articleDetail(num);
		close(con);
		
		return bean;
	}

}
