package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberInfoService;
import vo.ActionForward;
import vo.MemberBean;

public class ArticleInfoAction implements Action{

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		MemberInfoService memberInfoService = new MemberInfoService();
		MemberBean mbean = memberInfoService.getMember(email);
		
		request.setAttribute("member",mbean);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("Auction/articleWrite.jsp");
		
		return forward;
	}

	
}
