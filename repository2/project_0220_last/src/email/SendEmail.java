package email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	//이메일 인증 메서드
	public int sendEmail(String to, String authNum) {
		ImforEmail imfor = new ImforEmail();
		
		final String user = imfor.getUser();//보내는 사람 이메일
		final String password = imfor.getPassword();//보내는 사람 이메일 비밀번호
		
		String subject = "Muse 이메일 인증"; //제목
		String content = "인증번호 [" + authNum + "]"; //내용
		
		Properties p = new Properties(); // 정보를 담을 객체

		p.put("mail.smtp.host", "smtp.naver.com"); // 네이버 SMTP

		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP 서버에 접속하기 위한 정보들

		try {
			Session ses = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(user, password);
	            }
	        });

			ses.setDebug(true);

			MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
			msg.setSubject(subject); // 제목

			msg.setFrom(new InternetAddress(user)); // 보내는 사람

			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람

			msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩

			Transport.send(msg); // 전송
			
			return 1;
		} catch (Exception e) {
			System.out.println("sendEmail()메서드에서 에러 : " + e);
			return 0;
		}
	}
	
	public String randomNum() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			int n = (int)(Math.random() * 10);
			sb.append(n);
		}
		return sb.toString();
	}
}
