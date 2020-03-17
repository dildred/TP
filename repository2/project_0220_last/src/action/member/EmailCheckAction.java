package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import action.Action;
import svc.member.EmailCheckService;
import vo.ActionForward;

public class EmailCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String email = request.getParameter("email");
		
		EmailCheckService emailservice = new EmailCheckService();
		String result = emailservice.emailcheck(email);

		if("notavailable".equals(result)){
			
			JSONObject json = new JSONObject();
			json.put("result", result);
			request.setAttribute("json", json.toJSONString());
			
		}else if("available".equals(result)){
			
			JSONObject json = new JSONObject();
			json.put("result", result);
			json.put("id", email);
			request.setAttribute("json", json.toJSONString());
			
		}
		return null;
		
	}
	
	

}
