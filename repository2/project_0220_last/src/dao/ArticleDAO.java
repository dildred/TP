package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import javax.sql.DataSource;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import vo.ArticleBean;
import vo.PageInfo;

public class ArticleDAO {

	Connection con;
	private static ArticleDAO articleDAO;
	
	public ArticleDAO(){}
	
	public static ArticleDAO getInstance(){
		if(articleDAO == null){
			articleDAO = new ArticleDAO();
		}
		return articleDAO;
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	
	public int selectListCount(){
		int listCount = 0; 
		
		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM article");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("selectListCount() error"+e);
		} 
		return listCount;
	}

	
	public int insertArticle(ArticleBean articleBean) {
		
		int num = 0;
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement("SELECT max(article_num) FROM article");
			rs = pstmt.executeQuery();
			
			if(rs.next()) num = rs.getInt(1)+1;
			else num = 1;
			
			sql = "INSERT INTO article(article_num, "
								  + "article_subject, "
								  + "article_writer, "
								  + "article_img, "
								  + "expiration_date, "
								  + "registration_date,"
								  + "auction_time, "
								  + "limit_price, "
								  + "now_price, "
								  + "classification) "
				+ "VALUES(?,?,?,?,?,now(),?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num); //article_num
			pstmt.setString(2, articleBean.getArticle_subject()); 
			pstmt.setString(3, articleBean.getArticle_writer()); 
			pstmt.setString(4, articleBean.getArticle_img()); 
			pstmt.setDate(5, articleBean.getExpiration_date()); 
			pstmt.setInt(6, articleBean.getAuction_time());
			pstmt.setInt(7, articleBean.getLimit_price()); 
			pstmt.setInt(8, 0); 
			pstmt.setString(9, articleBean.getClassification()); 
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insertArticle(ArticleBean articleBean) err : "+e);
		} finally {
			close(pstmt);
			close(rs);
		}	
		return insertCount;
	}
	
	

	public ArrayList<ArticleBean> selectArticleList(int page, int limit){
		
		sql = "SELECT * "
		    + "FROM article "
		    + "order by article_num desc limit ?,?";
		ArrayList<ArticleBean> articleList = new ArrayList<ArticleBean>();
		ArticleBean article = null;
		int startrow = (page-1)*10; 
				
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, 9);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				article = new ArticleBean();
				article.setArticle_num(rs.getInt("article_num"));
				article.setArticle_subject(rs.getString("article_subject"));
				article.setArticle_writer(rs.getString("article_writer"));
				article.setArticle_img(rs.getString("article_img"));
				article.setExpiration_date(rs.getDate("expiration_date"));
				article.setRegistration_date(rs.getDate("registration_date"));
				article.setAuction_time(rs.getInt("auction_time"));
				article.setClassification(rs.getString("classification"));
				
				articleList.add(article);
			}
			
			if(articleList.isEmpty()) articleList = null;
			
		} catch (Exception e) {
			System.out.println("selectArticleList(int page, int limit) error"+e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}

	public ArticleBean articleDetail(int num) {
		
		ArticleBean bean = new ArticleBean();
		
		try {
			sql = "select * from article where article_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean.setArticle_num(rs.getInt("article_num"));
				bean.setArticle_writer(rs.getString("article_writer"));
				bean.setArticle_subject(rs.getString("article_subject"));
				bean.setArticle_img(rs.getString("article_img"));
				bean.setClassification(rs.getString("classification"));
				bean.setExpiration_date(rs.getDate("expiration_date"));
				bean.setRegistration_date(rs.getDate("registration_date"));
				bean.setAuction_time(rs.getInt("auction_time"));
				bean.setLimit_price(rs.getInt("limit_price"));
				bean.setNow_price(rs.getInt("now_price"));
				
			}	
			
		} catch (SQLException e) {
			System.out.println("articleDetail error : " + e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return bean;
	}
	
	public ArrayList<ArticleBean> getArticleList(String email, int page, int limit) {
		ArrayList<ArticleBean> abean = new ArrayList<ArticleBean>();
		ArticleBean abn = null;
		 try {
		        

	         String sql = "SELECT * FROM article WHERE article_writer=? ";

	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, email);

	         rs = pstmt.executeQuery();
	         System.out.println(rs);
	         while (rs.next()) {
	            abn = new ArticleBean();
	            abn.setArticle_num(rs.getInt("article_num"));
	            abn.setArticle_subject(rs.getString("article_subject"));
	            abn.setArticle_writer(rs.getString("article_writer"));
	            abn.setArticle_img(rs.getString("article_img"));
	            abn.setExpiration_date(rs.getDate("expiration_date"));
	            abn.setRegistration_date(rs.getDate("registration_date"));
	            abn.setAuction_time(rs.getInt("auction_time"));
	            abn.setClassification(rs.getString("classification"));
				
				abean.add(abn);
				
	         }
		}catch (SQLException e) {
		System.out.println("getArticleList error : " + e);
		}finally {
		close(rs);
		close(pstmt);
		}
		
		
		return abean;
	}


	//회원 판매 리스트 수
		public int selectMemListCount(String email){
			int listCount = 0; 
			
			try {
				pstmt = con.prepareStatement("SELECT count(*) FROM article WHERE article_writer=?");
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					listCount = rs.getInt(1);
				}
			} catch (Exception e) {
				System.out.println("selectListCount() error"+e);
			} 
			return listCount;
		}




	
	
}