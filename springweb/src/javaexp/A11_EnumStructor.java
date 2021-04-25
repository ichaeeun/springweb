package javaexp;
/*
 # enum의 구성요소 설정 
 1. 생성자 선언 
 	enum 이름{
 		변수명("할당할데이터"),...
 		
 		할당할 필드값;
 		
 		이름(초기값){
 			필드값
 		}
 	}
 
 2. 기능메서드 선언 
 	enum 이름{
 		변수명,......
 		메서드명(){
 		
 		}
 	}
 */
enum Family{
	FATHER("아빠"),MOTHER("엄마"), SON("아들"), DAUGHTER("딸");
	private String kor;
	Family(String kor){
		this.kor=kor;
	}
	
	public String getKor() {
		return kor;
	}
}
// ex) Emp 에서 enum 변수를 선언하고 사원번호와 사원이름을 enum으로 연결하여 출력되게 하세요. 
enum Emp2{
	CLERK(1000),FORD(2000),JOHN(3000);
	private String ename;
	private int empno;
	Emp2(int empno){
		this.empno=empno;
	}
	public int getEmpno() {
		return empno;
	}
}
public class A11_EnumStructor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Family cur = Family.MOTHER;
		System.out.println(cur+": "+cur.getKor());
		
		Emp2 cur2 = Emp2.CLERK;
		System.out.println(cur2+":"+cur2.getEmpno());
		
	}

}
