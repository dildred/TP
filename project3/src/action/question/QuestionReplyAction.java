package action.question;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionService;
import vo.ActionForward;
import vo.QuestionBean;

public class QuestionReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		QuestionBean questionBean = null;
		
		int question_num = Integer.parseInt(request.getParameter("question_num")); //답글 게시글 번호
		int re_ref = Integer.parseInt(request.getParameter("re_ref"));
		int re_lev = Integer.parseInt(request.getParameter("re_lev"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		
		String Email = request.getParameter("Emal"); //답글 작성자
		String title = request.getParameter("title"); //답글 제목
		String comment = request.getParameter("comment"); //답글 내용
		
		
		
		questionBean = new QuestionBean();
		//답글 게시글 정보
		questionBean.setQuestion_num(question_num);
		questionBean.setRe_ref(re_ref);
		questionBean.setRe_lev(re_lev);
		questionBean.setRe_step(re_step);
		
		//답글 정보
		questionBean.setQuestion_Email(Email);
		questionBean.setQuestion_title(title);
		questionBean.setQuestion_comment(comment);
		
		QuestionService questionService = new QuestionService();
		boolean isWriteSuccess = questionService.replyArticle(questionBean);
		
		if(!isWriteSuccess){
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('답장실패');");
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
