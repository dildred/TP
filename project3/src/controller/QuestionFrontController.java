package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.question.QuestionListAction;
import action.question.QuestionWriteProAction;
import vo.ActionForward;

@WebServlet("*.do")
public class QuestionFrontController extends javax.servlet.http.HttpServlet{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/questionWritePro.do")) {
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
		}
		
		if(forward != null) {
			
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				System.out.println("����ġ ����");
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}else {
			String jsonInfo = (String)request.getAttribute("jsonInfo");
			response.getWriter().print(jsonInfo);
			System.out.println(jsonInfo);
		}
		
		
		
		
	}//doProcess ��

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	
}//QuestionForntController ��