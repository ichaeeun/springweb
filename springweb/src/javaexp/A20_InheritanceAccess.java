package javaexp;

public class A20_InheritanceAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Father01{
	private String name = "홍길동";
	int age = 25; 
	protected String loc = "서울 신림동";
}
class Son01 extends Father01{
	public void call() {
		System.out.println("## 상속 관계에서 필드의 접근 ##");
	//	System.out.println("이름: "+name); // private 직접 접근 불가 
		System.out.println("나이: "+age); // 같은 패키지에 있으므로 접근 가능 
		System.out.println("사는곳: "+loc); // 상속관계 이므로 접근 가능 
		
	}
}