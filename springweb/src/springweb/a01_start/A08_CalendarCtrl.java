package springweb.a01_start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a02_mvc.a02_service.A05_CalenExpService;

@Controller
@RequestMapping("/calendarexp.do")
public class A08_CalendarCtrl {
	@Autowired(required=false)
	private A05_CalenExpService service;
	// http://localhost:8080/springweb/calendarexp.do?method=list 
		@GetMapping(params="method=list")
		public String list() {
			return "WEB-INF/views/a01_start/a17_callendarExp.jsp";
		}
		// ex) springweb/a01_start/A08_CalendarCtrl.java
		//  WEB-INF/views/a01_start/a17_callendarExp.jsp
		
		
		// http://localhost:8080/springweb/calendarexp.do?method=data 
		@GetMapping(params="method=data")
		public String data(Model d) {
			d.addAttribute("list", service.calenListExp());
			return "pageJsonReport";
		}
}
