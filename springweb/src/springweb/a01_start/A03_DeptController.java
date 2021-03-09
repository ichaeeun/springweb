package springweb.a01_start;
// springweb.a01_start.A03_DeptController
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jspexp.a03_database.A02_DeptDao;
import jspexp.z01_vo.Dept;

@Controller 
public class A03_DeptController {

	// ex)  http://localhost:8080/springweb/deptList.do
		//  부서정보조회 
		@RequestMapping("deptList.do")
		public String deptList(Dept sch, Model d) {
			A02_DeptDao dao = new A02_DeptDao();
			if(sch.getDname()==null) sch.setDname("");
			if(sch.getLoc()==null) sch.setLoc("");
			d.addAttribute("deptlist", dao.deptList(sch));
			return "WEB-INF/views/a01_start/a09_deptList.jsp";
		}
}
