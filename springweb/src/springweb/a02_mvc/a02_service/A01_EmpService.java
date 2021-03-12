package springweb.a02_mvc.a02_service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a02_mvc.a03_dao.A01_EmpDao;
import springweb.z02_vo.Emp;

@Service 
public class A01_EmpService {
	@Autowired(required=false)
	private A01_EmpDao dao;
	public ArrayList<Emp> emplist(Emp sch){
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		System.out.println("##데이터건수: "+dao.totCnt());
		System.out.println("##emp객체: "+dao.getEmp(7369).getEname());
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		hm.put("start",1000);
		hm.put("end",3000);
		System.out.println("### 검색된 사원 번호 ###");
		for(int empno:dao.searchEmp3(hm)) {
			System.out.println(empno);
		}
		System.out.println("##부서 번호 검색: "+dao.getDept(10).getDname());
		System.out.println("##부서별 최대 연봉##");
		for(Emp e:dao.maxSal()) {
			System.out.println(e.getDeptno()+":"+e.getSal());
		}
		for(Emp e:dao.getEmpByJob("SALESMAN")) {
			System.out.println("job검색: "+e.getEname()+", "+e.getJob());
		}
		System.out.println("##부서별 최대 연봉: "+dao.getMaxSal(30));
		return dao.emplist(sch);
	} 
}
	