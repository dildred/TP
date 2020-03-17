package action.declare;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.declare.BoardDeclaService;
import vo.ActionForward;
import vo.BoardDeclaBean;

public class BoardDeclaWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
								 throws Exception {
		
		ActionForward forward = null;
		BoardDeclaBean boardDeclaBean = null;
		
		String suspect_Email = request.getParameter("suspect_Email");
		String attacker_Email = request.getParameter("attacker_Email");
		String decla_Title = request.getParameter("decla_Title");
		String decla_Content = request.getParameter("decla_Content");
		String decla_Item = request.getParameter("decla_Item");
		
		boardDeclaBean = new BoardDeclaBean();
		boardDeclaBean.setSuspect_Email(suspect_Email);
		boardDeclaBean.setAttacker_Email(attacker_Email);
		boardDeclaBean.setDecla_Title(decla_Title);
		boardDeclaBean.setDecla_Content(decla_Content);
		boardDeclaBean.setDecla_Item(decla_Item);
		
		BoardDeclaService boardDeclaService = new BoardDeclaService();
		boolean isWriteSuccess = boardDeclaService.registDeclare(boardDeclaBean);
		
		if(!isWriteSuccess){
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('등록실패');");
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
