package action.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;

import svc.article.ArticleSelllistService;
import svc.article.ArticleService;
import vo.ActionForward;
import vo.ArticleBean;
import vo.PageInfo;


public class ArticleSelllistAction implements Action{

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
	    
	    
	    ArticleSelllistService articleSelllistService = new ArticleSelllistService();

	    ArticleService articleService = new ArticleService();
	    ArrayList<ArticleBean> articlebean = articleSelllistService.getArticlelist(email,page,limit);
	    int listCount = articleService.getMemListCount(email); 
		 
		int maxPage = (int)( (double)listCount/limit + 0.95 );
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page); 
		pageInfo.setMaxPage(maxPage);
		pageInfo.setListCount(listCount);
	    
	    
	    

		request.setAttribute("articlebean",articlebean);
		request.setAttribute("pageInfo", pageInfo);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("member/member_selllist.jsp?email="+email);
		
		return forward;
	}

	
}
