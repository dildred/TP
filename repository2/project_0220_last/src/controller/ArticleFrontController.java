package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.board.ArticleDetailAction;
import action.board.ArticleInfoAction;
import action.board.ArticleListAction;
import action.board.ArticleSelllistAction;
import action.board.ArticleWriteAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class ArticleFrontController extends javax.servlet.http.HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/articleWrite.bo")) {
			action = new ArticleWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/articleWrite.bo err : " + e);
			}

		} else if (command.equals("/articleList.bo")) {
			action = new ArticleListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/articleList.bo err : " + e);
			}
		} else if (command.equals("/articleModify.bo")) {
			action = new ArticleInfoAction();
			try {
				forward = action.execute(request, response);
				System.out.println("forward");
			} catch (Exception e) {
				System.out.println("/articleModify.bo err : " + e);
			}
		} else if(command.equals("/articleDetail.bo")){

			action = new ArticleDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/ArticleDetail.bo err : "+e);
			}
			
		}  else if(command.equals("/articleSelllistAction.bo")){
			
			action = new ArticleSelllistAction(); 
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("login.mem"+e);
			}
		}

		if (forward != null) {

			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		} else {
			response.getWriter().print(request.getAttribute("json"));
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}