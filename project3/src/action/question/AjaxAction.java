package action.question;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import vo.QuestionBean;
import vo.PageInfo;

public class AjaxAction {

	public String jsonList(ArrayList<QuestionBean> articleList, PageInfo pageInfo){
		
		JSONObject totalObject = new JSONObject();
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = null;
		
		for(int i=0; i<articleList.size(); i++){
			memberInfo = new JSONObject();
			
			memberInfo.put("num", articleList.get(i).getQuestion_num());
			memberInfo.put("title", articleList.get(i).getQuestion_title());
			memberInfo.put("Email", articleList.get(i).getQuestion_Email());
			memberInfo.put("context", articleList.get(i).getQuestion_context());
			memberInfo.put("comment", articleList.get(i).getQuestion_comment());
			memberInfo.put("re_ref", articleList.get(i).getRe_ref());
			memberInfo.put("re_lev", articleList.get(i).getRe_lev());
			memberInfo.put("re_step", articleList.get(i).getRe_step());
			memberInfo.put("date", articleList.get(i).getQuestion_date().toString());
			
			membersArray.add(memberInfo);
		}
		if(pageInfo != null){
			JSONObject pageInformation = new JSONObject();
			pageInformation.put("endpage", pageInfo.getEndPage());
			pageInformation.put("listcount", pageInfo.getListCount());
			pageInformation.put("maxpage", pageInfo.getMaxPage());
			pageInformation.put("page", pageInfo.getPage());
			pageInformation.put("startpage", pageInfo.getStartPage());
			
			totalObject.put("pageInfo", pageInformation);
		}
		totalObject.put("members", membersArray);
		
		String jsonInfo = totalObject.toJSONString();

		return jsonInfo;
	}
	
	
	//다시보자 이건 모르겠따 ;
	
}

