package action.question;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.question.AjaxAction;
import svc.question.QuestionListService;
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
		System.out.println("리스트앸1");
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		System.out.println("리스트앸2");
		QuestionListService questionService = new QuestionListService();
		articleList = questionService.getArticleList(page,limit);
		int listCount = questionService.getListCount();
		System.out.println("리스트앸3");
		
		int maxPage = (int)( (double)listCount/limit + 0.95);
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setListCount(listCount);
		
		if( "ajax".equals( request.getParameter("Handler") ) ){ //비동기 요청일때
			
			ajax = new AjaxAction();
			String jsonInfo = ajax.jsonList(articleList, pageInfo);
			request.setAttribute("jsonInfo", jsonInfo);
			
			return forward;
		}
		
		System.out.println("리스트앸4");
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		System.out.println("리스트앸5");
		
		forward = new ActionForward();
		forward.setPath("/question/question.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

	
	
}//Question 끗
