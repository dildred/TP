package action.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionModifyService;
import svc.question.QuestionService_1;
import vo.ActionForward;
import vo.QuestionBean;

public class QuestionModifyAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int num = Integer.parseInt(request.getParameter("question_num")); //수정할 글번호
		
		QuestionModifyService questionService = new QuestionModifyService();
		QuestionBean article = questionService.getModifyArticle(num);//수정할 게시글정보
		
		request.setAttribute("article", article);

		forward = new ActionForward();
		forward.setPath("/question/modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

	
}
