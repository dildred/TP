package action.board;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import action.Action;
import svc.article.ArticleService;
import vo.ActionForward;
import vo.ArticleBean;
import vo.PageInfo;

public class ArticleListAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
								throws Exception {
		AjaxAction ajax = null;
		ActionForward forward = null;
		ArrayList<ArticleBean> articleList = new ArrayList<ArticleBean>();
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ArticleService articleService = new ArticleService();
		articleList = articleService.getArticleList(page, limit);
		int listCount = articleService.getListCount();
		
		 
		int maxPage = (int)( (double)listCount/limit + 0.95 );
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page); 
		pageInfo.setMaxPage(maxPage);
		pageInfo.setListCount(listCount);
		
		if( "ajax".equals( request.getParameter("Handler") ) ){ 
			
			ajax = new AjaxAction();
			String jsonInfo = ajax.jsonList(articleList, pageInfo);
			request.setAttribute("jsonInfo", jsonInfo);
			
			return forward;
		}
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		forward = new ActionForward();
		forward.setPath("Auction/Auction_board.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
	

	
	
}