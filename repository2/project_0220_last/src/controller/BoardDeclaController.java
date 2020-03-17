package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.declare.BoardDeclaDeleteAction;
import action.declare.BoardDeclaDetailAction;
import action.declare.BoardDeclaModifyAction;
import action.declare.BoardDeclaReplyAction;
import action.declare.BoardDeclaWriteAction;
import action.declare.ListDeclareAction;
import vo.ActionForward;

@WebServlet("*.brd")
public class BoardDeclaController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						 throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
						  throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		//게시글 목록 불러오기
		if(command.equals("/dboardList.brd")){
			
			action = new ListDeclareAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("dboardList.brd ERROR : " + e);
			}
		}
		//게시글 작성하기
		else if(command.equals("/boardDeclaWrite.brd")){
			
			action = new BoardDeclaWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/boardDeclaWrite.brd err : "+e);
			}
		}
		//게시글 상세보기
		else if(command.equals("/boardDeclaDetail.brd")){

			action = new BoardDeclaDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/boardDeclaDetail.brd err : "+e);
			}
		}
		//게시글 삭제
		else if(command.equals("/dboardDeclaDelete.brd")){

			action = new BoardDeclaDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/dboardDeclaDelete.brd err : "+e);
			}
		}
		//게시글 답글 달기
		else if(command.equals("/boardDeclaReply.brd")){
			action = new BoardDeclaReplyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/boardDeclaReply.brd err : "+e);
			}
		}
		//게시글 업데이트(수정)
		else if(command.equals("/boardDeclaModify.brd")){
			
			action = new BoardDeclaModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/boardDeclaModify.brd err : "+e);
			}
		}
		
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	
	
	
	
}
