package springweb.z01_exp;
// springweb.z01_exp.A02_MemberController
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jspexp.a03_database.A04_MemberDao;

@Controller 
public class A02_MemberController {
	@RequestMapping("/mlist.do")
	public String memberList(@RequestParam(value="id",defaultValue="") String id,
							@RequestParam(value="name", defaultValue="") String name, Model d) {
		A04_MemberDao dao = new A04_MemberDao();
		d.addAttribute("mlist",dao.memberList(id, name));
		return "WEB-INF/views/z01_exp/a04_memberList.jsp";
	}
}
