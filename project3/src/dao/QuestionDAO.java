package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import vo.PageInfo;
import vo.QuestionBean;

public class QuestionDAO {

	Connection con;
	private static QuestionDAO questionDAO;
	
	private QuestionDAO(){}
	
	public static QuestionDAO getInstance() {
		if(questionDAO ==null) {
			questionDAO = new QuestionDAO();
			
		}
		return questionDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	//글의 개수 구하기
	public int selectListCount() {
		int listCount =0;
		
		try {
			pstmt =con.prepareStatement("SELECT count(*) FROM board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("selectListCount() err : " +e);
		}
		return listCount;
	}
	
	// 글 등록
	
	public int insertArticle(QuestionBean questionBean) {
		int num =0;
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement("select max(question_num) FROM question");
			rs=pstmt.executeQuery();
			
			if(rs.next()) num =rs.getInt(1)+1;
			else num =1;
			
			sql ="INSERT INTO question (question_num, "
								+"question_Email, "
								+"question_title, "
								+"question_context, "
								+"question_comment, "
								+"re_ref, re_lev, re_step, "
								+"question_date) "
					+"VALUES(?,?,?,?,?,?,?,?,now())";			
			
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, questionBean.getQuestion_Email()); 
			pstmt.setString(3, questionBean.getQuestion_title()); 
			pstmt.setString(4, questionBean.getQuestion_context()); 
			pstmt.setString(5, questionBean.getQuestion_comment()); 
			pstmt.setInt(6, num); 
			pstmt.setInt(7, 0); 
			pstmt.setInt(8, 0); 
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insertArticle err : " +e);
		}finally {
			close(pstmt); //import static db.JdbcUtil.*; 왜 이거 임포트 못하고 일일히 작성해야하냐 불편
			close(rs);
		}
		return insertCount;
	}
	
	//답글등록
		public int insertReplyArticle(QuestionBean questionBean) {
			
			int num = 0;
			int insertCount = 0;
			
			int re_ref = questionBean.getRe_ref();
			int re_lev = questionBean.getRe_lev();
			int re_step = questionBean.getRe_step();
			
			try {
				pstmt = con.prepareStatement("SELECT max(question_num) FROM question");
				rs = pstmt.executeQuery();
				
				if(rs.next()) num = rs.getInt(1)+1;
				else num = 1;
				
				sql = "UPDATE question SET re_step=re_step+1 WHERE re_ref=? and re_step>?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, re_ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				
				re_step += 1;
				re_lev += 1;
				
				sql = "INSERT INTO question(QUESTION_NUM, "
						  + "QUESTION_EMAIL, "
						  + "QUESTION_TITLE, "
						  + "QUESTION_CONTEXT, "
						  + "QUESTION_COMMENT, "
						  + "RE_REF, RE_LEV, RE_STEP, "
						  + "QUESTION_DATE) "
					+ "VALUES(?,?,?,?,?,?,?,?,now())";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num); 
				pstmt.setString(2, questionBean.getQuestion_Email()); 
				pstmt.setString(3, questionBean.getQuestion_title()); 
				pstmt.setString(4, questionBean.getQuestion_context());
				pstmt.setString(5, questionBean.getQuestion_comment()); 
				pstmt.setInt(6, re_ref); 
				pstmt.setInt(7, re_lev); 
				pstmt.setInt(8, re_step);
				insertCount = pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("insertReplyArticle err : "+e);
			} finally {
				close(pstmt);
				close(rs);
			}
			return insertCount;
		}
	
	
	
	
	public ArrayList<QuestionBean> selectArticleList(int page, int limit){
		
		sql = "SELECT * "
			+ "FROM question "
			+ "ORDER BY re_ref desc, re_step asc "
			+ "LIMIT ?,10";
				
		ArrayList<QuestionBean> articleList = new ArrayList<QuestionBean>();
		QuestionBean question =null;
		int startrow = (page -1)*10;//읽기 시작할 번호
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				question = new QuestionBean();
				question.setQuestion_num(rs.getInt("question_num"));
				question.setQuestion_Email(rs.getString("question_Email"));
				question.setQuestion_title(rs.getString("question_title"));
				question.setQuestion_context(rs.getString("question_context"));
				question.setQuestion_comment(rs.getString("question_comment"));
				question.setRe_ref(rs.getInt("re_ref"));
				question.setRe_lev(rs.getInt("re_lev"));
				question.setRe_step(rs.getInt("re_step"));
				question.setQuestion_date(rs.getDate("question_date"));
				
				articleList.add(question);
				
			}
			
			if(articleList.isEmpty()) articleList =null;
			
		} catch (Exception e) {
			System.out.println("selectArticleList err : " +e);
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return articleList;
		
		
	}//selectArticleList 끗
	
	//조회수 증가 안함.

	// 게시글 상세보기
	
	public QuestionBean contentLookUp(int num) {
		QuestionBean question = new QuestionBean();
		try {
			sql ="SELECT * FROM question WHERE question_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				question.setQuestion_num(rs.getInt("question_num"));
				question.setQuestion_Email(rs.getString("question_Email"));
				question.setQuestion_title(rs.getString("question_title"));
				question.setQuestion_context(rs.getString("question_context"));
				question.setQuestion_comment(rs.getString("question_comment"));
				question.setRe_ref(rs.getInt("re_ref"));
				question.setRe_lev(rs.getInt("re_lev"));
				question.setRe_step(rs.getInt("re_step"));
				question.setQuestion_date(rs.getDate("question_date"));
				
			}
			
		} catch (Exception e) {
			System.out.println("contentLookUp err : " + e );
		}finally {
			close(rs);
			close(pstmt);
		}
		return question;
		
	}//contentLookUp 끗
	
	//비번 함
	public String getPass(int num) {
		String passwd = null;
		try {
			sql = "SELECT question_pass FROM question WHERE question_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) passwd = rs.getString("question_pass");
				
		} catch (Exception e) {
			System.out.println("getPass(int num) err"+e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return passwd;
	}
	
	//게시글 삭제
	public void questionDelete(int num) {
		try {
			sql = "delete from question where question_num =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("boardDelete(int num) err"+e);
		} finally {
			close(pstmt);
		}
	}
		
	public int updateModifyArticle (QuestionBean questionBean) {
		int insertCount = 0;
		
		try {
			sql = "update question set question_Email =?, question_title=?, question_context=?, question_comment=? where question_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, questionBean.getQuestion_Email());
			pstmt.setString(2, questionBean.getQuestion_title()); 
			pstmt.setString(3, questionBean.getQuestion_context()); 
			pstmt.setString(4, questionBean.getQuestion_comment()); 
			pstmt.setInt(5, questionBean.getQuestion_num()); 
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("updateModifyArticle err : "+e);
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	//제목 기준으로 게시글 검색
	
	public ArrayList<QuestionBean> titleSearchList(String input){
		
		ArrayList<QuestionBean> articleList = new ArrayList<QuestionBean>();
		QuestionBean article= null;
		try {
			sql = "select question_num, question_Email, question_title, question_context, question_comment, re_ref, re_lev, re_step "
				+ "FROM question "
				+ "WHERE question_Email like ? "
				+ "ORDER BY question_num desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" +input+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				article= new QuestionBean();
				
				article.setQuestion_num(rs.getInt("question_num"));
				article.setQuestion_Email(rs.getString("question_Email"));
				article.setQuestion_title(rs.getString("question_title"));
				article.setQuestion_context(rs.getString("question_context"));
				article.setQuestion_comment(rs.getString("question_comment"));
				article.setRe_ref(rs.getInt("re_ref"));
				article.setRe_lev(rs.getInt("re_lev"));
				article.setRe_step(rs.getInt("re_step"));
				article.setQuestion_date(rs.getDate("question_date"));
				
				articleList.add(article);
			}
			
		} catch (Exception e) {
			System.out.println("nameSearchList err : " +e);
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	
	public PageInfo subjectSearchCount(String input) {
		PageInfo pageInfo = new PageInfo();
		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM question WHERE question_title like ? ");
			pstmt.setString(1, "%"+input+"%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) pageInfo.setListCount(rs.getInt(1));
			
		} catch (Exception e) {
			System.out.println("subjectSearchCount err : " +e);
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return pageInfo;
	}
	
	public PageInfo nameSearchCount(String input) {
		PageInfo pageInfo = new PageInfo();
		try {
			pstmt = con.prepareStatement("select count(*) from question where question_Email like ? ");
			pstmt.setString(1, "%" + input + "%");
			rs = pstmt.executeQuery();
			
			
		} catch (Exception e) {
			System.out.println("nameSearchCount(String input) err : "+e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return pageInfo;
	}
	
	
}//DAO 끗
