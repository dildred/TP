package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.member.EmailCheckAction;
import action.member.MemberInfoAction;
import action.member.MemberLoginAction;
import action.member.MemberModifyAction;
import action.member.MemberSignupAction;
import action.member.MemberUpdateAction;
import vo.ActionForward;

@WebServlet("*.mem")
public class MemberController extends javax.servlet.http.HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		// 회원가입 
		if(command.equals("/signup.mem")){
			
			action = new MemberSignupAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("signup.mem"+e);
			}
		
		// 회원정보 조회
		}else if(command.equals("/mypage.mem")){
			
			action = new MemberInfoAction();   
			try{
				forward = action.execute(request, response);
			} catch (Exception e){
				System.out.println("mypage.mem"+e);
			}
		// 회원 정보 수정페이지 요청
		}else if(command.equals("/membermodify.mem")){

			action = new MemberModifyAction();
			try{
				forward = action.execute(request, response);
			} catch (Exception e){
				System.out.println("membermodify.mem"+e);
			}
		// 회원 정보 수정
		}else if(command.equals("/memberupdate.mem")){
			
			action = new MemberUpdateAction();
			try{
				forward = action.execute(request, response);
			} catch (Exception e){
				System.out.println("membermodify.mem"+e);
			}
		// 이메일 유효성 체크
		}else if(command.equals("/emailcheck.mem")){

			action = new EmailCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("emailcheck"+e);
			}
		//로그인
		}else if(command.equals("/login.mem")){
			
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("login.mem"+e);
			}
		}
		
		if(forward != null){
			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}else{
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
