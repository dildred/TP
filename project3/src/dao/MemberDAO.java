package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.MemberBean;

public class MemberDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	private static MemberDAO boardDAO;
	
	private MemberDAO(){}
	
	public static MemberDAO getInstance(){
		if(boardDAO == null){
			boardDAO = new MemberDAO();
		}
		return boardDAO;
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public void memberInsert(MemberBean member){
		
		try {
			sql = "INSERT INTO user(email, pw, phone, name, black, date) "
				+ "VALUES(?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setInt(5, member.getBlack());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("memberInsert() err : "+e);
		} finally {
			close(pstmt);
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
