package springweb.a01_start;
// springweb.a01_start.A04_MemberController
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jspexp.a03_database.A04_MemberDao;
import jspexp.z01_vo.Member;

@Controller 
public class A04_MemberController {
	@RequestMapping("/mem.do")
	public String mem(Member mem, Model d) {
		A04_MemberDao dao = new A04_MemberDao();
		if(mem.getId()==null) mem.setId("");
		if(mem.getName()==null) mem.setName("");
		d.addAttribute("mem", dao.memberList(mem.getId(), mem.getName()));
		return "WEB-INF/views/a01_start/a10_memList.jsp";
	}
}
