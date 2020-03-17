package action.declare;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.declare.BoardDeclaService;
import vo.ActionForward;
import vo.BoardDeclaBean;
import vo.BoardPageInfo;

public class ListDeclareAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
								 throws Exception {
		
		ActionForward forward = null;
		ArrayList<BoardDeclaBean> declaList = new ArrayList<BoardDeclaBean>();
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardDeclaService boardDeclaService = new BoardDeclaService();
		declaList = boardDeclaService.getListDeclaration(page, limit);
		int listCount = boardDeclaService.getListCount();
		
		//총 페이지 수
		int maxPage = (int)( (double)listCount/limit + 0.95 );
		
		BoardPageInfo bpageInfo = new BoardPageInfo();
		bpageInfo.setPage(page);
		bpageInfo.setMaxPage(maxPage);
		bpageInfo.setListCount(listCount);
		
		request.setAttribute("bpageInfo", bpageInfo);
		request.setAttribute("declaList", declaList);

		forward = new ActionForward();
		forward.setPath("/declare/dboard.jsp");
		forward.setRedirect(false);
		
		return forward;
		
	}
	
}
