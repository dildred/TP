package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.question.QuestionDeleteAction;
import action.question.QuestionListAction;
import action.question.QuestionModifyAction;
import action.question.QuestionModifyProAction;
import action.question.QuestionReplyAction;
import action.question.QuestionSearchAction;
import action.question.QuestionWriteAction;
import action.question.QuestionWriteProAction;
import vo.ActionForward;

@WebServlet("*.do")
public class QuestionFrontController extends javax.servlet.http.HttpServlet{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/questionWrite.do")) {
			
			action = new QuestionWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/questionWritePro.do err : " +e);
			}
			
		}else if(command.equals("/questionWritePro.do")) {
			
			action = new QuestionWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/questionWritePro.do err : " +e);
			}
			
		}else if(command.equals("/questionList.do")) {
			
			action = new QuestionListAction();
			try {
				forward = action.execute(request, response);
				System.out.println("forward");
			} catch (Exception e) {
				System.out.println("/questionList.do err :" +e);
			}
		}else if(command.equals("/questionModify.do")) {
			action = new QuestionModifyAction();
			try {
				forward = action.execute(request, response);
				System.out.println("forward");
			} catch (Exception e) {
				System.out.println("/questionModify.do err : " + e);
			}
		}else if(command.equals("/questionDetail.do" )) {
			try {
				forward = action.execute(request, response);
				System.out.println();
			} catch (Exception e) {
				System.out.println("/questionDetail.do err : " + e);
			}
		}else if(command.equals("/questionDelete.do")) {
			action = new QuestionDeleteAction();
			try {
				forward =action.execute(request, response);
				System.out.println("forward");
			} catch (Exception e) {
				System.out.println("/questionDelete.do err : " +e);
			}
		}else if(command.equals("/questionReply.do")) {
			action = new QuestionReplyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/questionReply.do err : " +e);
			}
		}else if(command.equals("/questionModifyPro.do")){
			
			action = new QuestionModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/questionModifyPro.do err : "+e);
			}
			
		}else if(command.equals("/questionSearch.do")){
			
			action = new QuestionSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/questionSearch.do err : "+e);
			}
			
		}
		
		
		
		
		if(forward != null) {
			
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				System.out.println("µð½ºÆÐÄ¡ ¿À·ù");
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}else {
			String jsonInfo = (String)request.getAttribute("jsonInfo");
			response.getWriter().print(jsonInfo);
			System.out.println(jsonInfo);
		}
		
		
		
		
	}//doProcess ²ý

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	
}//QuestionForntController ²ý
