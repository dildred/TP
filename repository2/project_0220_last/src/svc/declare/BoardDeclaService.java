package svc.declare;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDeclaDAO;
import vo.BoardDeclaBean;

public class BoardDeclaService {
	
	//총 게시글 수
	public int getListCount() throws Exception{
		
		int listCount = 0;
		Connection con = getConnection();
		BoardDeclaDAO declaDAO = BoardDeclaDAO.getInstance();
		declaDAO.setConnection(con);
		listCount = declaDAO.selectListCount();
		close(con);
		
		return listCount;
	}
	
	//게시글 리스트
	public ArrayList<BoardDeclaBean> getListDeclaration(int page, int limit) throws Exception {
		
		ArrayList<BoardDeclaBean> declaList = null;
		Connection con = getConnection();
		BoardDeclaDAO declaDAO = BoardDeclaDAO.getInstance();
		declaDAO.setConnection(con);
		declaList = declaDAO.selectDeclaList(page, limit);
		close(con);
		return declaList;
	}
	
	//게시글 저장
	public boolean registDeclare(BoardDeclaBean boardDeclaBean) {
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		BoardDeclaDAO declaDAO = BoardDeclaDAO.getInstance();
		declaDAO.setConnection(con);
		int insertCount = declaDAO.insertDeclare(boardDeclaBean);
		
		if(insertCount > 0) isWriteSuccess = true;
		
		close(con);
		
		return isWriteSuccess;
	}
	
	//답글 저장
	public boolean replyDeclare(BoardDeclaBean boardDeclaBean) {
		
		boolean isReplySuccess = false;
		Connection con = getConnection();
		BoardDeclaDAO declaDAO = BoardDeclaDAO.getInstance();
		declaDAO.setConnection(con);
		int insertCount = declaDAO.insertReplyDeclare(boardDeclaBean);
		
		if(insertCount > 0) isReplySuccess = true;
		
		close(con);
		
		return isReplySuccess;
	}
	
	//게시글 상세보기
	public BoardDeclaBean getDeclare(int num) {
		
		Connection con = getConnection();
		BoardDeclaDAO declaDAO = BoardDeclaDAO.getInstance();
		declaDAO.setConnection(con);
		BoardDeclaBean bean = declaDAO.declaContentLookup(num);
		declaDAO.readCountAdd(num);
		close(con);
		
		return bean;
	}
	
	//수정할 게시글 상세보기
	public BoardDeclaBean getModifyDeclare(int num) {
		
		Connection con = getConnection();
		BoardDeclaDAO declaDAO = BoardDeclaDAO.getInstance();
		declaDAO.setConnection(con);
		BoardDeclaBean bean = declaDAO.declaContentLookup(num);
		close(con);
		
		return bean;
	}
	
	//게시글 이메일 비교
	public String getSuspectEmailPass(int num) {
		
		Connection con = getConnection();
		BoardDeclaDAO declaDAO = BoardDeclaDAO.getInstance();
		declaDAO.setConnection(con);
		String suspectEmail = declaDAO.getSuspectEmailPass(num);
		
		close(con);
		
		return suspectEmail;
	}
	
	//게시글 삭제
	public void declaBoardDelete(int num) {
		
		Connection con = getConnection();
		BoardDeclaDAO declaDAO = BoardDeclaDAO.getInstance();
		declaDAO.setConnection(con);
		declaDAO.declaBoardDelete(num);
		
		close(con);
	}
	
	//게시글 수정
	public boolean modifyDeclare(BoardDeclaBean boardDeclaBean) {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDeclaDAO declaDAO = BoardDeclaDAO.getInstance();
		declaDAO.setConnection(con);
		int insertCount = declaDAO.updateModifyDeclare(boardDeclaBean);
		
		if(insertCount > 0) isModifySuccess = true;
		
		close(con);
		
		return isModifySuccess;
	}
}
