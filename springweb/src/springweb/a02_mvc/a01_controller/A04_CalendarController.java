package springweb.a02_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a02_mvc.a02_service.A04_CalenService;
import springweb.z02_vo.Calendar;

@Controller 
@RequestMapping("calendar.do")
public class A04_CalendarController {
	@Autowired(required=false)
	private A04_CalenService service;
	// http://localhost:8080/springweb/calendar.do?method=list 
	@GetMapping(params="method=list")
	public String list() {
		return "WEB-INF/views/a03_ajax/a04_fullcalendar.jsp";
	}
	// ex) springweb/a01_start/A08_CalendarCtrl.java
	//  WEB-INF/views/a01_start/a17_callendarExp.jsp
	
	// http://localhost:8080/springweb/calendar.do?method=data 
	@GetMapping(params="method=data")
	public String data(Model d) {
		d.addAttribute("list",service.calenList());
		return "pageJsonReport";
	}
	// http://localhost:8080/springweb/calendar.do?method=insert 
	@GetMapping(params="method=insert")
	public String insertCalendar(Calendar ins) {
		service.insertCalendar(ins);
		return "WEB-INF/views/a03_ajax/a04_fullcalendar.jsp";
	}
}
