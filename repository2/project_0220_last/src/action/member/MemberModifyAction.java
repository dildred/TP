package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberModifyService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberModifyAction implements Action {

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String email = request.getParameter("email");
		
		MemberModifyService membermodifyservice = new MemberModifyService();
		MemberBean mbean = membermodifyservice.memberModify(email); 
		
		request.setAttribute("member",mbean);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("member/member_update.jsp");
		
		return forward;
	}
	
	

}
