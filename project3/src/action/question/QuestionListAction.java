package action.question;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionService;
import vo.ActionForward;
import vo.PageInfo;
import vo.QuestionBean;

public class QuestionListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
									throws Exception {
	
		AjaxAction ajax = null;
		ActionForward forward = null;
		ArrayList<QuestionBean> articleList =new ArrayList<QuestionBean>();
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		
		QuestionService questionService = new QuestionService();
		articleList = questionService.getArticleList(page,limit);
		int listCount = questionService.getListCount();
		
		//총 페이지 수
		int maxPage = (int)((double) listCount/limit + 0.95);
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setListCount(listCount);
		
		if("ajax".equals(request.getParameter("Handler"))) {//비동기 요청일때
			
			ajax = new AjaxAction();
			String jsonInfo = ajax.jsonList(articleList, pageInfo);
			request.setAttribute("jsonInfo", jsonInfo);
			
			return forward;
		}
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		
		forward = new ActionForward();
		forward.setPath("/question/question.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

	
	
}//Question리슨액션 끗
