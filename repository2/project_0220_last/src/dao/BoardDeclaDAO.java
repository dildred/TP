package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import vo.BoardDeclaBean;

public class BoardDeclaDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
			
	private static BoardDeclaDAO declaDao;
	private BoardDeclaDAO(){}
			
	public static BoardDeclaDAO getInstance(){
		if(declaDao == null){
			declaDao = new BoardDeclaDAO();
		}
		return declaDao;
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	//글의 개수 구하기
	public int selectListCount(){
		int listCount = 0;
		
		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM d_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("selectListCount() error"+e);
		} 
		return listCount;
	}
	
	//게시글 등록
	public int insertDeclare(BoardDeclaBean boardDeclaBean) {
		
		int num = 0;
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement("SELECT max(decla_Num) FROM d_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) num = rs.getInt(1)+1;
			else num = 1;
			
			sql = "INSERT INTO d_board(decla_Num, "
								    + "suspect_Email, "
								    + "attacker_Email, "
								    + "decla_Title, "
								    + "decla_Content, "
								    + "decla_Item, "
								    + "decla_writeDate, "
								    + "decla_re_ref, "
								    + "decla_re_lev, "
								    + "decla_re_seq) "
				+ "VALUES (?,?,?,?,?,?,now(),?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, boardDeclaBean.getSuspect_Email());
			pstmt.setString(3, boardDeclaBean.getAttacker_Email());
			pstmt.setString(4, boardDeclaBean.getDecla_Title());
			pstmt.setString(5, boardDeclaBean.getDecla_Content());
			pstmt.setString(6, boardDeclaBean.getDecla_Item());
			pstmt.setInt(7, num);
			pstmt.setInt(8, boardDeclaBean.getDecla_re_lev());
			pstmt.setInt(9, boardDeclaBean.getDecla_re_seq());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insertDeclare(BoardDeclaBean boardDeclaBean) err : "+e);
		} finally {
			close(pstmt);
			close(rs);
		}	
		return insertCount;
	}
	
	//답글등록
	public int insertReplyDeclare(BoardDeclaBean boardDeclaBean) {
		
		int num = 0;
		int insertCount = 0;
		
		int decla_re_ref = boardDeclaBean.getDecla_re_ref();
		int decla_re_lev = boardDeclaBean.getDecla_re_lev();
		int decla_re_seq = boardDeclaBean.getDecla_re_seq();
		
		try {
			pstmt = con.prepareStatement("SELECT max(decla_Num) FROM d_board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) num = rs.getInt(1)+1;
			else num = 1;
			
			sql = "UPDATE d_board SET decla_re_seq=decla_re_seq+1 " 
			    + "WHERE decla_re_ref=? and decla_re_seq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, decla_re_ref);
			pstmt.setInt(2, decla_re_seq);
			pstmt.executeUpdate();
			
			decla_re_seq += 1;
			decla_re_lev += 1;
			
			sql = "INSERT INTO d_board(decla_Num, "
								    + "suspect_Email, "
								    + "decla_Title, "
								    + "decla_Content, "
								    + "decla_writeDate, "
								    + "decla_re_ref, "
								    + "decla_re_lev, "
								    + "decla_re_seq) "
			    + "VALUES (?,?,?,?,now(),?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, boardDeclaBean.getSuspect_Email());
			pstmt.setString(3, boardDeclaBean.getDecla_Title());
			pstmt.setString(4, boardDeclaBean.getDecla_Content());
			pstmt.setInt(5, decla_re_ref);
			pstmt.setInt(6, decla_re_lev);
			pstmt.setInt(7, decla_re_seq);
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insertReplyDeclare(BoardDeclaBean boardDeclaBean) err : "+e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return insertCount;
	}

	//글 목록 보기
	public ArrayList<BoardDeclaBean> selectDeclaList(int page, int limit){
		
		sql = "SELECT * "
		    + "FROM d_board "
		    + "ORDER BY decla_re_ref desc, decla_re_seq asc "
		    + "LIMIT ?,10";
		ArrayList<BoardDeclaBean> declareList = new ArrayList<BoardDeclaBean>();
		BoardDeclaBean declaBoard = null;
		int startrow = (page-1)*10; //읽기 시작할 row번호
				
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				declaBoard = new BoardDeclaBean();
				declaBoard.setDecla_Num(rs.getInt("decla_Num"));
				declaBoard.setSuspect_Email(rs.getString("suspect_Email"));
				declaBoard.setAttacker_Email(rs.getString("attacker_Email"));
				declaBoard.setDecla_Title(rs.getString("decla_Title"));
				declaBoard.setDecla_Content(rs.getString("decla_Content"));
				declaBoard.setDecla_writeDate(rs.getDate("decla_writeDate"));
				declaBoard.setDecla_re_ref(rs.getInt("decla_re_ref"));
				declaBoard.setDecla_re_lev(rs.getInt("decla_re_lev"));
				declaBoard.setDecla_re_seq(rs.getInt("decla_re_seq"));
				declaBoard.setDecla_readCount(rs.getInt("decla_readCount"));
				
				declareList.add(declaBoard);
			}
			
			if(declareList.isEmpty()) declareList = null;
			
		} catch (Exception e) {
			System.out.println("selectDeclaList(int page, int limit) error"+e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return declareList;
	}
	
	//조회수 증가
	public void readCountAdd(int num){ 
		System.out.println(num);
		try {
			sql = "UPDATE d_board SET decla_readcount = decla_readcount+1 where decla_Num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("readCountAdd() err : ");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}
	
	//게시글 상세보기
	public BoardDeclaBean declaContentLookup(int num){
		BoardDeclaBean declaBoard = new BoardDeclaBean();
		try {
			sql = "SELECT * FROM d_board WHERE decla_Num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				declaBoard = new BoardDeclaBean();
				declaBoard.setDecla_Num(rs.getInt("decla_Num"));
				declaBoard.setSuspect_Email(rs.getString("suspect_Email"));
				declaBoard.setAttacker_Email(rs.getString("attacker_Email"));
				declaBoard.setDecla_Title(rs.getString("decla_Title"));
				declaBoard.setDecla_Content(rs.getString("decla_Content"));
				declaBoard.setDecla_Item(rs.getString("decla_Item"));
				declaBoard.setDecla_writeDate(rs.getDate("decla_writeDate"));
			}	
		} catch (Exception e) {
			System.out.println("declaContentLookup() err");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return declaBoard;
	}
	
	//게시글 이메일 비교
	public String getSuspectEmailPass(int num){
		String suspect_Email = null;
		try {
			sql = "SELECT suspect_Email FROM d_board WHERE decla_Num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) suspect_Email = rs.getString("suspect_Email");
				
		} catch (Exception e) {
			System.out.println("getSuspectEmailPass(int num) err"+e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return suspect_Email;
	}
	
	//게시글 삭제
	public void declaBoardDelete(int num) {
		
		try {
			sql = "DELETE FROM d_board WHERE decla_Num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("declaBoardDelete(int num) err"+e);
		} finally {
			close(pstmt);
		}
	}
	
	//게시글 업데이트
	public int updateModifyDeclare(BoardDeclaBean boardDeclaBean) {
		int insertCount = 0;
		
		try {
			sql = "UPDATE d_board SET decla_Title=?, decla_Content=?, WHERE decla_Num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDeclaBean.getDecla_Title());
			pstmt.setString(2, boardDeclaBean.getDecla_Content());
			pstmt.setInt(3, boardDeclaBean.getDecla_Num());
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("updateModifyDeclare(BoardDeclaBean boardDeclaBean) err : "+e);
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
}
