package springweb.z03_vo;
// springweb.z03_vo.EmpGrade
public class EmpGrade {
	private int empno;
	private String ename;
	private int sal;
	private int grade;
	public EmpGrade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpGrade(int empno, String ename, int sal, int grade) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.grade = grade;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
