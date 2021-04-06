package springweb.a02_mvc.a02_service;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import springweb.z02_vo.Mail;

@Service 
public class A06_MailService {
	// 메일 모듈 호출(컨테이너에 등록된 객체 로딩) 
	@Autowired(required=false)
	private JavaMailSender sender;
	
	public void sendMail(Mail email) throws MessagingException {
		// 1. 멀티미디어형 메일 데이터 전송 
		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true,"utf-8");

		// 2. 제목 설정 
		msg.setSubject(email.getSubject());
		
		// 3. 수신자 설정 
		msg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));
		// 4. 내용 설정 
		// msg.setText(email.getContent());
		helper.setText(email.getContent(), true);
		
		// 5. 발송 처리 
		sender.send(msg);
	}
}
