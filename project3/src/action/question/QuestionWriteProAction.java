package action.question;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionService;
import vo.ActionForward;
import vo.QuestionBean;

public class QuestionWriteProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
						throws Exception {
		ActionForward forward = null;
		QuestionBean questionBean = null;
		
		String Email = request.getParameter("Email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		questionBean = new QuestionBean();
		questionBean.setQuestion_Email(Email);
		questionBean.setQuestion_title(subject);
		questionBean.setQuestion_comment(content);
		
		QuestionService questionService = new QuestionService();
		boolean isWriteSuccess = questionService.registArticle(questionBean);
		
		if(!isWriteSuccess) {
			response.setContentType("text/html);charset=utf-8");
			PrintWriter out =response.getWriter();
			
			out.print("<script>");
			out.print("alert('µî·Ï½ÇÆÐ');");
			out.print("history.back()");
			out.print("</script>");
			
			
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("questionList.do");
			
		}
		
		return forward;
	}

	
}//QuestionWriteProAction ²ý
