package javaexp;

public class A10_Enum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 열거형 타입 
 1. 제한된 수의 일이나 사건에 대하여 숫자로 표현 
 	ex) 1은 병역 의무가 없다
 		1은 누구 ? 남자 혹은 여자를 의미하는 단어가 아니라 숫자가 출력된다. 
 2. 각 숫자에 대하여 부여된 의미를 개발자가 숙지 ==> 일이나 사건에 대한 경우의 수가 많다면 
 										   개발자 관점에서 불편 
 3. 제한된 사건에 대하여 숫자 대신에 상수를 정의해서 부여 
 4. 위에 문제와 효과적인 처리를 위해서 java5부터 열거 타입을 제공 
 5. 기본 형식 
 	1) 열거 타입 : 서로 연관된 사건들을 모아 상수로 정의한 java.lang.Enum 클래스의 자식 클래스 
 	2) 선언 
 		enum 열거타입이름 {상수목록} 
 		ex) enum Gender{MALE,FEMALE} 
 			출력 FEMALE은 병역 의무가 없다.
 6. enum의 속성 
 	1) name() : 해당 데이터로 연결된 값 
 	2) ordinal(): index의 순서값 
 	3) .values() : enum 형식을 Enum 배열형태로 변환 처리 
 */
		System.out.println(Gender.FEMALE+"은 병역 의무가 없다!");
		System.out.println(Emp.FORD+"는 "+Job.SALESMAN+"직책을 가지고 있다!");
		// Enum 배열로 할당 
		Tea[] teaArray = Tea.values();
		for(Tea tea:teaArray) {
			String stname = tea.name();
			int num = tea.ordinal();
			System.out.println(num+" : "+stname);
		}
		Emp [] empArray = Emp.values();
		for(Emp emp:empArray) {
			String ename=emp.name();
			int no = emp.ordinal();
			System.out.println(no+1+"번째 사원: "+ename);
		}
	}
}
enum Tea{
	COFFEE,BLACK_TEA,GREEN_TEA
}

enum Gender{MALE,FEMALE}
// ex) 사원 job의 종류를 열거형으로 대문자로 선언하고 
//		@@@는 @@@직책을 가지고 있다를 출력 처리하세요 
enum Job{SALESMAN,CEO,CLERK,MANAGER,ANALYST}
// ex) 사원 3명의 이름을 Emp로 열거형으로 지정하고, @@번째 사원 @@@를 출력하세요
enum Emp{FORD,JOHN,HONG}
