package action.question;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.question.AjaxAction;
import svc.question.QuestionSearchService;
import vo.ActionForward;
import vo.PageInfo;
import vo.QuestionBean;

public class QuestionSearchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;

		String choice = request.getParameter("choice"); //�˻� ����
		String input = request.getParameter("input"); //�˻� ����
		
		QuestionSearchService questionService = new QuestionSearchService();
		ArrayList<QuestionBean> articleList = questionService.questionSearch(choice, input);
		
		PageInfo pageInfo = questionService.searchPageInfo(choice, input);//������ ���� ��ü
		int listCount = pageInfo.getListCount(); //�˻� ����Ʈ ��
		int page = 1; //ù ������
		int limit = 10; //������ ���� ��
		int maxPage = (int)((double)listCount/limit +0.95); //������ ���
		
		pageInfo.setMaxPage(maxPage);//�������� �� ����
		pageInfo.setPage(page);
		
		AjaxAction ajax = new AjaxAction();
		String jsonInfo = ajax.jsonList(articleList, pageInfo);
		request.setAttribute("jsonInfo", jsonInfo);
		
		return forward;
	}

}
