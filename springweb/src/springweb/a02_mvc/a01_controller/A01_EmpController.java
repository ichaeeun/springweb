package springweb.a02_mvc.a01_controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a02_mvc.a02_service.A01_EmpService;
import springweb.z02_vo.Dept;
import springweb.z02_vo.Emp;
import springweb.z03_vo.EmpDept;

@Controller 
public class A01_EmpController {
	@Autowired(required=false)
	private A01_EmpService service;
	// http://localhost:8080/springweb/empList2.do
	@RequestMapping("/empList2.do")
	public String empList2(@ModelAttribute("sch") Emp sch, Model d)	{
		System.out.println("데이터건수: "+service.emplist(sch).size());
		d.addAttribute("emplist",service.emplist(sch));
		return "WEB-INF/views/a02_mvc/a01_empList.jsp";
	}
	
	// RequestMapping("/insEmpForm.do")
	@GetMapping("/insEmpForm.do") //5.0 이후 지원 
	public String insEmpForm(@ModelAttribute("ins") Emp ins) {
		return "WEB-INF/views/a02_mvc/a01_empInsertForm.jsp";
	}
	
//	RequestMapping("/insertEmp.do")
	@PostMapping("/insertEmp.do") // 5.0이후 post방식 전송 명시 처리 
	public String insertEmp(@ModelAttribute("ins") Emp ins) {
		// ex) 직책을 선택했을 때, 다음 화면에 모델어트리뷰트에서 선언한 
		//		여러 option중에서 getJob을 통해서 특정한 직책을 선택해준다. 
		
		System.out.println("##등록처리: "+ins.getEname());
		service.empInsert(ins);
		ins=null;
		return "WEB-INF/views/a02_mvc/a01_empInsertForm.jsp";
	}
	
	
	// http://localhost:8080/springweb/empDeptList.do
	@RequestMapping("/empDeptList.do")
	public String empDeptList(@ModelAttribute("sch") EmpDept sch, Model d) {
		d.addAttribute("empDeptList",service.schEDGList(sch));
		return "WEB-INF/views/a02_mvc/a03_empDeptList.jsp";
	}
	
	/*
	 EmpController를 처리하는 모든 url매핑된 메서드의 view단은 아래의 
	 모델 어트리뷰트를 공유한다. 
	 */
	@ModelAttribute("jobs")	// 화면에 select option으로 리스트 데이터 
	public ArrayList<String> getJobs(){
		return service.getJobs();
	}
	@ModelAttribute("depts")
	public ArrayList<Dept> getDepts(){
		return service.getDepts();
	}
	@ModelAttribute("mgrs")
	public ArrayList<Emp> getMgrs(){
		return service.getMgrs();
	}
	
	// json 데이터 가져오기 http://localhost:8080/springweb/loadData.do
		@RequestMapping("loadData.do")
		public String loadData(Model d) {
			d.addAttribute("tasks",service.loadData());
			d.addAttribute("links",service.loadLink());
			return "pageJsonReport";
		}
	
	//  http://localhost:8080/springweb/loadDataForm.do
		@GetMapping("loadDataForm.do")
		public String ajaxForm() {
			return "WEB-INF/gantt/samples/01_initialization/02_load_json.jsp";
		}
}
