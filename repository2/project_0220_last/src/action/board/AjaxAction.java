package action.board;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import vo.ArticleBean;
import vo.PageInfo;

public class AjaxAction {

	public String jsonList(ArrayList<ArticleBean> articleList, PageInfo pageInfo){
		
		JSONObject totalObject = new JSONObject();
		JSONArray articlesArray = new JSONArray();
		JSONObject articleInfo = null;
		
		for(int i=0; i<articleList.size(); i++){
			articleInfo = new JSONObject();
			
			articleInfo.put("article_num", articleList.get(i).getArticle_num());
			articleInfo.put("article_subject", articleList.get(i).getArticle_subject());
			articleInfo.put("article_writer", articleList.get(i).getArticle_writer());
			articleInfo.put("article_img", articleList.get(i).getArticle_img());
			articleInfo.put("class_", articleList.get(i).getClassification());
			articleInfo.put("exp_date", articleList.get(i).getExpiration_date());
			articleInfo.put("act_time", articleList.get(i).getAuction_time());
			articleInfo.put("now_price", articleList.get(i).getNow_price());
			articleInfo.put("Regist_date", articleList.get(i).getRegistration_date());
			
			articlesArray.add(articleInfo);
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
		totalObject.put("articles", articlesArray);
		
		String jsonInfo = totalObject.toJSONString();

		return jsonInfo;
	}
	
	
	
}
