package action.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionDetailService;
import vo.ActionForward;
import vo.QuestionBean;

public class QuestionDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		QuestionDetailService questionDetailService = new QuestionDetailService();
		
		QuestionBean article = questionDetailService.getArticle(num);
		System.out.println(num);
		
		request.setAttribute("article", article);
		
		forward.setPath("/question/questionDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

	
}
