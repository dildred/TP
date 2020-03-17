package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberBean member = new MemberBean();
		member.setEmail(email);
		member.setPw(pw);
		
		MemberLoginService service = new MemberLoginService();
		String result = service.memberJoin(member);
		
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();

		
		if("err".equals(result)){
			forward.setRedirect(false);		
			forward.setPath("member/login.jsp");
			request.setAttribute("email", result);
			
		}
		else {
			forward.setRedirect(false);	
			forward.setPath("index.jsp");
		session.setAttribute("email", result);
		request.setAttribute("email", result);
		forward.setPath("index.jsp");
		}
		
		return forward;
	}
	
	

}
