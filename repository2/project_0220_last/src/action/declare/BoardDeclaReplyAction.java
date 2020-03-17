package action.declare;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.declare.BoardDeclaService;
import vo.ActionForward;
import vo.BoardDeclaBean;

public class BoardDeclaReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
								 throws Exception {

		ActionForward forward = null;
		BoardDeclaBean boardDeclaBean = null;
		
		int decla_Num = Integer.parseInt(request.getParameter("decla_Num"));
		int decla_re_ref = Integer.parseInt(request.getParameter("decla_re_ref"));
		int decla_re_lev = Integer.parseInt(request.getParameter("decla_re_lev"));
		int decla_re_seq = Integer.parseInt(request.getParameter("decla_re_seq"));
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boardDeclaBean = new BoardDeclaBean();
		//답글 게시글 정보
		boardDeclaBean.setDecla_Num(decla_Num);
		boardDeclaBean.setDecla_re_ref(decla_re_ref);
		boardDeclaBean.setDecla_re_lev(decla_re_lev);
		boardDeclaBean.setDecla_re_seq(decla_re_seq);
		
		//답글 정보
		boardDeclaBean.setDecla_Num(decla_Num);
		boardDeclaBean.setSuspect_Email(writer);
		boardDeclaBean.setDecla_Title(title);
		boardDeclaBean.setDecla_Content(content);
		
		BoardDeclaService boardDeclaService = new BoardDeclaService();
		boolean isWriteSuccess = boardDeclaService.replyDeclare(boardDeclaBean);
		
		if(!isWriteSuccess){
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('답장실패');");
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
