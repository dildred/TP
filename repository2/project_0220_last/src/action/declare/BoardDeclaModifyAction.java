package action.declare;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.declare.BoardDeclaService;
import vo.ActionForward;
import vo.BoardDeclaBean;

public class BoardDeclaModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
								 throws Exception {

		ActionForward forward = null;
		BoardDeclaBean boardDeclaBean = null;

		int num = Integer.parseInt(request.getParameter("decla_Num"));
		String suspect_Email = request.getParameter("suspect_Email");
		String decla_Title = request.getParameter("decla_Title");
		String decla_Content = request.getParameter("decla_Content");
		
		boardDeclaBean = new BoardDeclaBean();
		boardDeclaBean.setDecla_Num(num);
		boardDeclaBean.setSuspect_Email(suspect_Email);
		boardDeclaBean.setDecla_Title(decla_Title);
		boardDeclaBean.setDecla_Content(decla_Content);
	
		BoardDeclaService boardDeclaService = new BoardDeclaService();
		boolean isModifySuccess = boardDeclaService.modifyDeclare(boardDeclaBean);
		
		if(!isModifySuccess){
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('수정실패');");
			out.println("history.back();");
			out.println("</script>");
			
		}else{
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("dboardList.brd");
			
		}
		
		return forward;
	}
	
	

}
