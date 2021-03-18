package springweb.a02_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a02_mvc.a02_service.A01_EmpService;
import springweb.a02_mvc.a02_service.A02_DeptService;
import springweb.a02_mvc.a02_service.A03_AjaxService;
import springweb.z02_vo.Dept;
import springweb.z02_vo.Emp;

@Controller
public class A03_AjaxController {
	@Autowired(required=false)
	private A01_EmpService service;
	
	@Autowired(required=false)
	private A02_DeptService deptService;
	
	@Autowired(required=false)
	private A03_AjaxService ajaxService;
	
	// 기본화면 호출 
	//  http://localhost:8080/springweb/ajaxEmpForm.do
	@GetMapping("ajaxEmpForm.do")
	public String ajaxForm() {
		return "WEB-INF/views/a03_ajax/a01_empAjax.jsp";
	}
	
	
	// json 데이터 가져오기 http://localhost:8080/springweb/jsonEmp.do
	@RequestMapping("jsonEmp.do")
	public String ajaxStart(Emp sch, Model d) {
		d.addAttribute("emp",service.emplist(sch));
		return "pageJsonReport";
	}
	/*
	 ex) dept 기준 ajax 처리 
	   WEB-INF/views/a03_ajax/a02_deptAjax.jsp
	 */
	// http://localhost:8080/springweb/ajaxDeptForm.do
	@GetMapping("ajaxDeptForm.do")
	public String ajaxDeptForm() {
		return "WEB-INF/views/a03_ajax/a02_deptAjax.jsp";
	}
	
	
	// 기본 4.0 요청 방식 : RequestMapping(value="jsonDept.do", method=RequestMethod.POST)
	// PostMapping 5.0이후 post방식 url 호출할 때. 
	@PostMapping("jsonDept.do")
	public String ajaxDept(Dept sch,Model d) {
		d.addAttribute("dept",deptService.deptList(sch));
		return "pageJsonReport";
	}
	
	@GetMapping("isMemberForm.do")
	public String isMemberForm() {
		return "WEB-INF/views/a03_ajax/a03_regMember.jsp";
	}
	
	// isMember.do?id=##
	// isMemer.do ==> id를 공백으로 처리 
	@RequestMapping("isMember.do")
	public String isMember(@RequestParam(value="id",defaultValue="") String id,Model d) {
		d.addAttribute("mem",ajaxService.isMember(id));
		return "pageJsonReport";
	}
}
