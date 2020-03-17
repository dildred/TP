package dao;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.Date;
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

	public MemberBean memberinfo(String email){
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
	
			MemberBean mbean = null;
			
			try {
				con = getConnection();
	
				String sql = "SELECT * FROM user WHERE email=?";
	
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
	
				if (rs.next()) 
				{	
					mbean = new MemberBean();
					mbean.setEmail(rs.getString("email"));
					mbean.setPw(rs.getString("pw"));
					mbean.setName(rs.getString("name"));
					mbean.setPhone(rs.getString("phone"));
					mbean.setDate(new Date(System.currentTimeMillis()));
				
				}
				
				} catch (Exception e) {
				System.out.println("getMember() method error " + e);
			} finally {
				close(pstmt);
			}
	
			return mbean;
		}
	
	public void memberUpdate(MemberBean member){
			
			try {
				sql = "UPDATE user SET "
					+ " pw=?, name=?, phone=? where email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getPw());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getPhone());
				pstmt.setString(4, member.getEmail());
				
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("memberInsert() err : "+e);
			} finally {
				close(pstmt);
			}
			
		}
	
		// member CHECK
		public String memberCheck(MemberBean member) {

			String result = "err";
			
			try {
				sql = "SELECT pw FROM user WHERE email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getEmail());
				rs = pstmt.executeQuery();
				
				// id check
				if(rs.next()){
					// pw check
					if( rs.getString(1).equals(member.getPw()) ){
						result = member.getEmail();
					}
				}
				
			} catch (Exception e) {
				System.out.println("memberCheck() err : "+e);
			} finally {
				close(rs);
				close(pstmt);
			}
			return result;
		}

		public String emailcheck(String email) {
			
			String result = "available";
			
			try {
				sql = "SELECT * FROM user WHERE email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				
				// id check
				if(rs.next()) result = "notavailable";
				
			} catch (Exception e) {
				System.out.println("emailcheck() err : "+e);
			} finally {
				close(rs);
				close(pstmt);
			}
			return result;
		}
	
	
	
	
	
	
	
	
	
}
