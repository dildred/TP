package action.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class QuestionWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("/question/questionWrite.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}
	
	

}
