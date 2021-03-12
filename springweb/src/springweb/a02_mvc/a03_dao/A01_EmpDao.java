package springweb.a02_mvc.a03_dao;

import java.util.ArrayList;
import java.util.HashMap;

import springweb.z02_vo.Dept;
import springweb.z02_vo.Emp;
import springweb.z02_vo.Emp2;

// springweb.a02_mvc.a03_dao.A01_EmpDao : namespace 
// emplist : id
// ArrayList<emp> : resultMap 
// emplist(Emp sch) : resultType 

public interface A01_EmpDao {
	// 여기에 있는 구성요소 하나하나가 EmpMapper.xml에 있는 구성요소와 연동하여 
	// mybatis 프레임워크에서 실제 객체를 생성해준다. 
	// springweb.a02_mvc.a03_dao.A01_EmpDao
	public ArrayList<Emp> emplist(Emp sch);
	/*
	 * -- ex) dao, mapper 연습예제 
-- ex1) SELECT count(*) FROM emp;
-- ex2) SELECT * FROM EMP WHERE empno = #{empno};
-- ex3) select empno from emp where sal between #{start} AND #{end};
	 */
	// springweb.a02_mvc.a03_dao.A01_EmpDao
	public int totCnt();
	public Emp getEmp(int empno);
	
	public ArrayList<Emp> searchEmp1(Emp2 sch);
	public ArrayList<Integer> searchEmp2(Emp2 sch);
	public ArrayList<Integer> searchEmp3(HashMap<String, Integer> hm);
	
//	-- ex1) select * from dept where deptno=#{deptno} 
//	-- ex2) SELECT deptno, max(sal) sal FROM emp GROUP BY deptno
//	-- ex3) SELECT * FROM emp WHERE job = #{job} 
//	-- ex4) SELECT max(sal) FROM emp WHERE deptno = #{deptno}
	public Dept getDept(int deptno);
	public ArrayList<Emp> maxSal();
	public ArrayList<Emp> getEmpByJob(String job);
	public int getMaxSal(int deptno);
	
}
