package vo;

import java.sql.Date;

public class BoardDeclaBean {

	private int decla_Num;				//신고글 번호
	private String suspect_Email;		//신고자 이메일
	private String attacker_Email;		//가해자 이메일
	private String decla_Title;			//신고글 제목
	private String decla_Content;		//신고글 내용
	private String decla_Item;			//신고 기프티콘 등록번호
	private Date decla_writeDate;		//신고글 작성일자 : now()
	private int decla_re_ref;			//답글 작성 시 자식글 번호 = 부모글 번호
	private int decla_re_lev;			//부모글 기준으로 답글의 깊이
	private int decla_re_seq;			//부모글 기준으로 모든 답글의 개수
	private int decla_readCount;		//조회수
	
	public BoardDeclaBean(){}
	public BoardDeclaBean(int decla_Num,
						  int decla_parentNO,
						  String attacker_Email,
						  String decla_Title,
						  String decla_Content,
						  String decla_Item,
						  int decla_re_ref,
						  int decla_re_lev,
						  int decla_re_seq,
						  int decla_readCount){
		
		this.decla_Num = decla_Num;
		this.suspect_Email = suspect_Email;
		this.attacker_Email = attacker_Email;
		this.decla_Title = decla_Title;
		this.decla_Content = decla_Content;
		this.decla_Item = decla_Item;
		this.decla_re_ref = decla_re_ref;
		this.decla_re_lev = decla_re_lev;
		this.decla_re_seq = decla_re_seq;
		this.decla_readCount = decla_readCount;
	}
	
	public int getDecla_Num() {
		return decla_Num;
	}
	public void setDecla_Num(int decla_Num) {
		this.decla_Num = decla_Num;
	}
	public String getSuspect_Email() {
		return suspect_Email;
	}
	public void setSuspect_Email(String suspect_Email) {
		this.suspect_Email = suspect_Email;
	}
	public String getAttacker_Email() {
		return attacker_Email;
	}
	public void setAttacker_Email(String attacker_Email) {
		this.attacker_Email = attacker_Email;
	}
	public String getDecla_Title() {
		return decla_Title;
	}
	public void setDecla_Title(String decla_Title) {
		this.decla_Title = decla_Title;
	}
	public String getDecla_Content() {
		return decla_Content;
	}
	public void setDecla_Content(String decla_Content) {
		this.decla_Content = decla_Content;
	}
	public String getDecla_Item() {
		return decla_Item;
	}
	public void setDecla_Item(String decla_Item) {
		this.decla_Item = decla_Item;
	}
	public Date getDecla_writeDate() {
		return decla_writeDate;
	}
	public void setDecla_writeDate(Date decla_writeDate) {
		this.decla_writeDate = decla_writeDate;
	}
	public int getDecla_re_ref() {
		return decla_re_ref;
	}
	public void setDecla_re_ref(int decla_re_ref) {
		this.decla_re_ref = decla_re_ref;
	}
	public int getDecla_re_lev() {
		return decla_re_lev;
	}
	public void setDecla_re_lev(int decla_re_lev) {
		this.decla_re_lev = decla_re_lev;
	}
	public int getDecla_re_seq() {
		return decla_re_seq;
	}
	public void setDecla_re_seq(int decla_re_seq) {
		this.decla_re_seq = decla_re_seq;
	}
	public int getDecla_readCount() {
		return decla_readCount;
	}
	public void setDecla_readCount(int decla_readCount) {
		this.decla_readCount = decla_readCount;
	}
	


	
}
