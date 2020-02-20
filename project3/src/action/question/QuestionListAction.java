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
	
		
		ActionForward forward = null;
		ArrayList<QuestionBean> articleList =new ArrayList<QuestionBean>();
		int page = 1;
		int limit = 10;
		System.out.println(1);
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		System.out.println(2);
		QuestionService questionService = new QuestionService();
		articleList = questionService.getArticleList(page,limit);
		int listCount = questionService.getListCount();
		System.out.println(3);
		//ÃÑ ÆäÀÌÁö ¼ö
		int maxPage = (int)( (double)listCount/limit + 0.95);
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setListCount(listCount);
		
		System.out.println(4);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		System.out.println(5);
		
		forward = new ActionForward();
		forward.setPath("/question/myquestion.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

	
	
}//Question¸®½¼¾×¼Ç ²ý
