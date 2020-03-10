package action.question;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionReplyService;
import vo.ActionForward;
import vo.QuestionBean;

public class QuestionReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		QuestionBean questionBean = null;
		
		int question_num = Integer.parseInt(request.getParameter("question_num")); //��� �Խñ� ��ȣ
		int re_ref = Integer.parseInt(request.getParameter("re_ref"));
		int re_lev = Integer.parseInt(request.getParameter("re_lev"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		
		String Email = request.getParameter("Emal"); //아이디
		String title = request.getParameter("title"); //제목
		String comment = request.getParameter("comment"); // 내용
		
		
		
		questionBean = new QuestionBean();
		
		questionBean.setQuestion_num(question_num);
		questionBean.setRe_ref(re_ref);
		questionBean.setRe_lev(re_lev);
		questionBean.setRe_step(re_step);
		
		
		questionBean.setQuestion_Email(Email);
		questionBean.setQuestion_title(title);
		questionBean.setQuestion_comment(comment);
		
		QuestionReplyService questionService = new QuestionReplyService();
		boolean isWriteSuccess = questionService.replyArticle(questionBean);
		
		if(!isWriteSuccess){
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
			
		}else{
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("questionList.do");
			
		}
		
		return forward;

	
	}
	
}
