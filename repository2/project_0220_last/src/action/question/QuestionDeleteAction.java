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
		
		ActionForward forward = null;
		int question_num = Integer.parseInt(request.getParameter("question_num")); //문의글 번호
		System.out.println(question_num);
		
		String input = request.getParameter("input");//입력한 비밀번호
		System.out.println(input);
		
		QuestionDeleteService questionDeleteService = new QuestionDeleteService();
		String passwd = questionDeleteService.getPass(question_num); //게시글 비밀번호
		System.out.println(passwd);
		
		if("ajax".equals(request.getParameter("Handler") ) ) { //비동기 요청일때
			
		}
		
		//ajax로 요청받음
		if(passwd.equals(input)) {
			System.out.println("딜리트1");
			questionDeleteService.questionDelete(question_num);
			System.out.println("딜리트2");
			JSONObject result = new JSONObject();
			System.out.println("딜리트3");
			result.put("result", "success");
			System.out.println("딜리트4");
			String jsonInfo = result.toJSONString();
			System.out.println("딜리트5");
			request.setAttribute("jsonInfo", jsonInfo);
			System.out.println("딜리트6");
			
		}else {
			System.out.println("딜리트7");
			JSONObject result = new JSONObject();
			System.out.println("딜리트8");
			result.put("result","fail");
			System.out.println("딜리트9");
			String jsonInfo = result.toJSONString();
			System.out.println("딜리트10");
			request.setAttribute("jsonInfo", jsonInfo);
			System.out.println("딜리트11");
			
		}
		
		
		
		return forward;
	}

	
}
