package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.MemberSignupService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberSignupAction implements Action {

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
		member.setBlack(1);
		
		MemberSignupService service = new MemberSignupService();
		service.memberSignup(member);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("index.jsp");
		
		return forward;
	}
	
	

}
