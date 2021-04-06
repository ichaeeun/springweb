package springweb.a02_mvc.a01_controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a02_mvc.a02_service.A06_MailService;
import springweb.z02_vo.Mail;

@Controller 
@RequestMapping("mail.do")
public class A05_MailController {
	@Autowired(required=false)
	private A06_MailService service;
	// http://localhost:8080/springweb/mail.do?method=init
	@RequestMapping(params="method=init")
	public String init() {
		return "WEB-INF/views/a02_mvc/a04_mail.jsp";
	}
	
	@RequestMapping(params="method=send")
	public String send(Mail send) throws MessagingException {
		System.out.println(send.getSubject());
		service.sendMail(send);
		// 메일 전송은 service단에서 처리 
		return "WEB-INF/views/a02_mvc/a04_mail.jsp";
	}
}
