package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.article.ArticleDetailService;
import vo.ActionForward;
import vo.ArticleBean;

public class ArticleDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		int num = Integer.parseInt(request.getParameter("article_num")); 
		ArticleDetailService articleDetailService = new ArticleDetailService();
		ArticleBean article = articleDetailService.getArticle(num); 
		
		
		request.setAttribute("article", article);
		forward.setPath("/Auction/article_detail.jsp?article_num="+num+"");
		forward.setRedirect(false); 
		
		return forward;
	}
	
	
	
}
