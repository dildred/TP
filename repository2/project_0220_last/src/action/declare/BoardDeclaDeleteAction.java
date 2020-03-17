package action.declare;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import action.Action;
import svc.declare.BoardDeclaService;
import vo.ActionForward;

public class BoardDeclaDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
								 throws Exception {

		ActionForward forward = null;
		int decla_Num = Integer.parseInt(request.getParameter("decla_Num"));
		System.out.println(decla_Num);
		
		//입력한 자기 이메일 주소
		String input = request.getParameter("input");
		System.out.println(input);
		
		//현재 자신의 이메일 주소
		BoardDeclaService boardservice = new BoardDeclaService();
		String suspect_Email = boardservice.getSuspectEmailPass(decla_Num);
		System.out.println(suspect_Email);
		
		if(suspect_Email.equals(input)){
			boardservice.declaBoardDelete(decla_Num);
		}
		
		return forward;
	}
	
	

}
