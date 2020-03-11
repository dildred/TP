package action.question;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionWriteService;
import vo.ActionForward;
import vo.QuestionBean;

public class QuestionWriteProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
						throws Exception {
		ActionForward forward = null;
		QuestionBean questionBean = null;
		
		String Email = request.getParameter("Email");
		String title = request.getParameter("title");
		String comment = request.getParameter("comment");
		String context = request.getParameter("context");
		
		questionBean = new QuestionBean();
		questionBean.setQuestion_Email(Email);
		questionBean.setQuestion_title(title);
		questionBean.setQuestion_context(context);
		questionBean.setQuestion_comment(comment);
		
		QuestionWriteService questionService = new QuestionWriteService();
		boolean isWriteSuccess = questionService.registArticle(questionBean);
		
		if(!isWriteSuccess) {
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			
			out.print("<script>");
			out.print("alert('등록실패');");
			out.print("history.back()");
			out.print("</script>");
			
			
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("questionList.do");
			
		}
		
		return forward;
	}

	
}//QuestionWriteProAction 끗
