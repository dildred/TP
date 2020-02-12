package vo;

import java.sql.Date;

public class MemberBean {

	private String email;
	private String pw;
	private String name;
	private String phone;
	private int black;
	private Date date;
	
	public MemberBean(){}
	public MemberBean(String email, String pw, String name, String phone, int black, Date date) {
		this.email = email;
		this.pw = pw;
		this.phone = phone;
		this.black = black;
		this.date = date;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getBlack() {
		return black;
	}
	public void setBlack(int black) {
		this.black = black;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

	
	
	
}
