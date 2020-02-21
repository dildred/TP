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
		System.out.println("디테일1");
		ActionForward forward = new ActionForward();
		System.out.println("디테일2");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("디테일3");
		QuestionDetailService questionDetailService = new QuestionDetailService();
		System.out.println("디테일4");
		QuestionBean article = questionDetailService.getArticle(num);
		System.out.println("디테일5");
		
		request.setAttribute("article", article);
		
		forward.setPath("/question/questionDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

	
}
