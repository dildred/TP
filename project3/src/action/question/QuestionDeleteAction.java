package action.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import action.Action;
import svc.question.QuestionDeleteService;
import vo.ActionForward;

public class QuestionDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;//�Խñ� ��ȣ
		int Question_num = Integer.parseInt(request.getParameter("question_num")); //���Ǳ� ��ȣ
		System.out.println(Question_num);
		
		String input = request.getParameter("input");//����ε� �ϵ� �־
		System.out.println(input);
		
		QuestionDeleteService questionService = new QuestionDeleteService();
		String passwd = questionService.getPass(Question_num);
		System.out.println(passwd);
		
		
		if(passwd.equals(input)) {
			questionService.questionDelete(Question_num);
			JSONObject result = new JSONObject();
			result.put("result", "success");
			String jsonInfo = result.toJSONString();
			request.setAttribute("jsonInfo", jsonInfo);
			
		}else {
			JSONObject result = new JSONObject();
			result.put("result","fail");
			String jsonInfo = result.toJSONString();
			request.setAttribute("jsonInfo", jsonInfo);
			
		}
		
		
		
		return forward;
	}

	
}
