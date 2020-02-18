package action.question;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.question.AjaxAction;
import svc.question.QuestionService;
import vo.ActionForward;
import vo.PageInfo;
import vo.QuestionBean;

public class QuestionSearchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;

		String choice = request.getParameter("choice"); //검색 기준
		String input = request.getParameter("input"); //검색 내용
		
		QuestionService questionService = new QuestionService();
		ArrayList<QuestionBean> articleList = questionService.questionSearch(choice, input);
		
		PageInfo pageInfo = questionService.searchPageInfo(choice, input);//페이지 정보 객체
		int listCount = pageInfo.getListCount(); //검색 리스트 수
		int page = 1; //첫 페이지
		int limit = 10; //페이지 제한 수
		int maxPage = (int)((double)listCount/limit +0.95); //페이지 계산
		
		pageInfo.setMaxPage(maxPage);//총페이지 수 저장
		pageInfo.setPage(page);
		
		AjaxAction ajax = new AjaxAction();
		String jsonInfo = ajax.jsonList(articleList, pageInfo);
		request.setAttribute("jsonInfo", jsonInfo);
		
		return forward;
	}

}
