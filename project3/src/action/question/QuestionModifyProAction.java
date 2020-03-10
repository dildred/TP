package action.question;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionModifyService;
import svc.question.QuestionService_1;
import vo.ActionForward;
import vo.QuestionBean;

public class QuestionModifyProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		QuestionBean questionBean = null;
		
		int num = Integer.parseInt(request.getParameter("question_num"));
		String Email = request.getParameter("Email");
		String title = request.getParameter("title");
		String comment = request.getParameter("comment");
		
		questionBean = new QuestionBean();
		questionBean.setQuestion_num(num);
		questionBean.setQuestion_Email(Email);
		questionBean.setQuestion_title(title);
		questionBean.setQuestion_comment(comment);
		
		QuestionModifyService quesionService = new QuestionModifyService();
		boolean isModifySuccess = quesionService.modifyArticle(questionBean);
		
		if(!isModifySuccess) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('수정실패');");
			out.println("history.back();");
			out.println("</script>");
		}else{
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("questionList.bo");
			
		}
		
		return forward;
	}

	
}
