package springweb.a02_mvc.a01_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A07_ChattingController {
	
	// 채팅초기화면 구현 
	// http://localhost:8080/springweb/chatting.do 
	@RequestMapping("/chatting.do")
	public String chatting() {
		return "WEB-INF/views/a02_mvc/a06_chatting.jsp";
	}
}
