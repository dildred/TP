package action.board;


import java.io.File;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import dao.ArticleDAO;
import svc.article.ArticleService;
import vo.ActionForward;
import vo.ArticleBean;

public class ArticleWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
								throws Exception {
		
		ActionForward forward = null;
		
		ArticleBean bean = null;
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		request.setCharacterEncoding("UTF-8");
		

			String realFolder = request.getServletContext().getRealPath("/upload");
			
			File f = new File(realFolder);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			int max = 100 * 1024 * 1024;
			MultipartRequest multi = 
						new MultipartRequest(
								request, 
								realFolder, 
								max, 
								"UTF-8", 
								new DefaultFileRenamePolicy());
			
			String thumnail = new String();
			
				File file = multi.getFile("thumnail1");
				if(file != null) {
					String name = file.getName();
					thumnail = "upload/" + name;
					
				}
			bean = new ArticleBean();
			bean.setArticle_img(thumnail);
			bean.setArticle_writer(multi.getParameter("email"));
			bean.setArticle_subject(multi.getParameter("subject"));
			bean.setLimit_price(Integer.parseInt(multi.getParameter("limit_price")));
			bean.setClassification(multi.getParameter("class_"));
			bean.setExpiration_date(Date.valueOf(multi.getParameter("exp_date")));
			bean.setAuction_time(Integer.parseInt(multi.getParameter("act_time"))); 
			
			ArticleService articleService = new ArticleService();
		
		boolean isWriteSuccess = articleService.registArticle(bean);
		 

		
		if(!isWriteSuccess){
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('');");
			out.println("history.back();");
			out.println("</script>");
			
		}else{
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/articleList.bo?pageNum=1");
			
		}
		
		return forward;
		
	}
	
	

}