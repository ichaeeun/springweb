package springweb.a01_start;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jspexp.a03_database.A01_Dao;
import jspexp.z01_vo.Dept;
import jspexp.z01_vo.Emp;

// springweb.a01_start.A02_EmpController
@Controller 
public class A02_EmpController {
	
	@Autowired(required=false)
	private B01_EmpService service;
	
	// spring에서는 가능한한 container에서 객체가 생성되어 메모리가 로딩된 
	// 상태에서 객체를 활용하기 때문에, 
	// autowiring에 의해서 메모리 할당으로 객체를 활용할 수 있다. 
	// 컨테이너 메모리에 할당된 객체는 new XXXX()을 사용할 수 없다. 
	@Autowired(required=false)
	private A01_Dao dao;
	
	@Value("${user2}")		// ${user} => ichaeeun 
	private String user;	// 공통으로 설정된 변수가 할당된다. 
	@Value("${pass}")
	private String pass; 
	
	// 공통 모델 어트리뷰트 선언 
	@ModelAttribute("deptList")
	public ArrayList<Dept> getDlist(){
		return dao.deptList();
	}
	
	@ModelAttribute("mgrList")
	public ArrayList<Emp> mgrList(){
		return dao.mgrList();
	}
	
	
	// emp검색 수정 처리 
	//  http://localhost:8080/springweb/empList.do
	@RequestMapping("empList.do")
	public String empList(@ModelAttribute("sch") Emp sch, Model d) {
		// 객체생성 없이 호출 처리됨 
		service.call();
		System.out.println("사용자계정");
		System.out.println("계정명: "+user);
		System.out.println("패스워드: "+pass);
		// DAO 객체 생성 부분 삭제 
	//	A01_Dao dao = new A01_Dao();
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		d.addAttribute("emplist",dao.empList(sch));
		
		
		return "WEB-INF/views/a01_start/a08_empList.jsp";
		
	}
}

/*
SELECT DISTINCT m.empno, m.ename 
FROM emp2 e, emp2 m 
WHERE e.mgr = m.empno;
-- 관리자 mgr의 실제 이름 정보 

1. dao 추가 작성 
2. modelattribute 
3. 검색 내용 추가 : 관리자 
	<select name="mgr">
		<option value="0">관리자</option> 
		<option value="7566">JONES</option> 
		<option value="7782">CLARK</option> 
4. 검색리스트 출력 처리 
	조회 리스트 sql 변경 
	
 */






