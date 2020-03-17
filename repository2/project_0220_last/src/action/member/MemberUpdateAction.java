package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.MemberSignupService;
import svc.member.MemberUpdateService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		
		MemberBean member = new MemberBean();
		member.setEmail(email);
		member.setPw(pw);
		member.setName(name);
		member.setPhone(phone);
		
		MemberUpdateService service = new MemberUpdateService();
		service.memberUpdate(member);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("index.jsp");
		
		return forward;
	}
	
	

}
