package action.declare;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.declare.BoardDeclaService;
import vo.ActionForward;
import vo.BoardDeclaBean;

public class BoardDeclaDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
								 throws Exception {

		ActionForward forward = new ActionForward();
		int decla_Num = Integer.parseInt(request.getParameter("num")); 
		
		BoardDeclaService boardDeclaDetailService = new BoardDeclaService();
		BoardDeclaBean declare = boardDeclaDetailService.getDeclare(decla_Num);
		
		request.setAttribute("declare", declare);
		
		forward.setPath("/declare/dpost.jsp");
		forward.setRedirect(false);
		
		return forward;
		
	}
	

}
