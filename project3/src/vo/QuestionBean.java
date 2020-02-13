package vo;

import java.sql.Date;

public class QuestionBean {

	private int question_num;
	private String question_Email;
	private String question_title;
	private String question_context;
	private String question_comment;
	private int re_ref;
	private int re_lev;
	private int re_step;
	private Date question_date;
	
	public QuestionBean(){}
	public QuestionBean(int question_num,
						String question_Email,
						String question_title,
						String question_context,
						String question_comment,
						int re_ref,
						int re_lev,
						int re_step,
						Date question_date) {
		this.question_num =question_num;
		this.question_Email =question_Email;
		this.question_title =question_title;
		this.question_context =question_context;
		this.question_comment =question_comment;
		this.re_ref =re_ref;
		this.re_lev =re_lev;
		this.re_step=re_step;
		this.question_date =question_date;
		
	}
	
	
	
	
	
	public int getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
	}
	public String getQuestion_Email() {
		return question_Email;
	}
	public void setQuestion_Email(String question_Email) {
		this.question_Email = question_Email;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}
	public String getQuestion_context() {
		return question_context;
	}
	public void setQuestion_context(String question_context) {
		this.question_context = question_context;
	}
	public String getQuestion_comment() {
		return question_comment;
	}
	public void setQuestion_comment(String question_comment) {
		this.question_comment = question_comment;
	}
	public int getRe_ref() {
		return re_ref;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public int getRe_lev() {
		return re_lev;
	}
	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public Date getQuestion_date() {
		return question_date;
	}
	public void setQuestion_date(Date board_date) {
		this.question_date = board_date;
	}
	
	
	
	
}
