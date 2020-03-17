package vo;

import java.sql.Date;

public class ArticleBean {

	private int article_num;
	private String article_subject;
	private String article_writer;
	private String article_img;
	private String classification;
	private Date expiration_date;
	private Date registration_date;
	private int auction_time;
	private int limit_price;
	private int now_price;
	
	public ArticleBean(){}
	

	public ArticleBean(int article_num, String article_subject,String article_write, String article_img, String classification,
			Date expiration_date, Date registration_date, int auction_time, int limit_price, int now_price) {
		this.article_num = article_num;
		this.article_subject = article_subject;
		this.article_writer = article_write;
		this.article_img = article_img;
		this.classification = classification;
		this.expiration_date = expiration_date;
		this.registration_date = registration_date;
		this.auction_time = auction_time;
		this.limit_price = limit_price;
		this.now_price = now_price;
	}


	public String getArticle_subject() {
		return article_subject;
	}


	public void setArticle_subject(String article_subject) {
		this.article_subject = article_subject;
	}


	public String getArticle_writer() {
		return article_writer;
	}


	public void setArticle_writer(String article_writer) {
		this.article_writer = article_writer;
	}


	public int getArticle_num() {
		return article_num;
	}


	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}




	public String getArticle_img() {
		return article_img;
	}


	public void setArticle_img(String article_img) {
		this.article_img = article_img;
	}


	public String getClassification() {
		return classification;
	}


	public void setClassification(String classification) {
		this.classification = classification;
	}


	public Date getExpiration_date() {
		return expiration_date;
	}


	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}


	public Date getRegistration_date() {
		return registration_date;
	}


	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}


	public int getAuction_time() {
		return auction_time;
	}


	public void setAuction_time(int auction_time) {
		this.auction_time = auction_time;
	}


	public int getLimit_price() {
		return limit_price;
	}


	public void setLimit_price(int limit_price) {
		this.limit_price = limit_price;
	}


	public int getNow_price() {
		return now_price;
	}


	public void setNow_price(int now_price) {
		this.now_price = now_price;
	}


	
	
}