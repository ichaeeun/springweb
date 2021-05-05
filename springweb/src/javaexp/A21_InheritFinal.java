package javaexp;

public class A21_InheritFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
final class Son02{
	public void call() {
		System.out.println("메서드1");
	}
}
// Son02가 final 클래스이기 때문에 상속을 받지 못한다. 
// class GrandSon extends Son02{ // final class 상속 불가 
	
// }
class Son03{
	public  void call01() {
		System.out.println("일반 메서드");
	}
	public final void call02() {
		System.out.println("final 메서드");
	}
}
class GrandSon extends Son03{
	public void call01() { // 메서드 재정의 가능 
		super.call01();
		System.out.println("추가한 내용");
	}
//	public void call02() { // final 메서드는 하위 클래스에서 override 불가 
		
//	}
}