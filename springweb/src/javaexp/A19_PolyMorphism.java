package javaexp;

import java.util.ArrayList;

public class A19_PolyMorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 다형성
 1. 상속관계에 있으면 상위 클래스를 참조변수로 하여 
 	여러가지 하위객체가 만들어 지는 것을 말한다. 
 */
		// 상위클래스 참조변수1 = new 하위 클래스 생성자(); 
		// 상위클래스 참조변수2 = new 하위 클래스 생성자(); 
		Vehicle v1 = new Car();
		Vehicle v2 = new Truck();
		// 같은 메서드명이라도 overriding에 의해서 여러가지 
		// 기능 처리를 할 수 있다. 
		v1.driving();
		v2.driving();
		ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
		vlist.add(new Car());
		vlist.add(new Truck());
		vlist.add(new Car());
		vlist.add(new Truck());
		System.out.println("# 다형성 처리된 리스트 내용");
		for(Vehicle v:vlist) {
			v.driving();
		}
		ArrayList<Worker> wlist = new ArrayList<Worker>();
		wlist.add(new PoliceMan());
		wlist.add(new WebProgrammer());
		wlist.add(new PoliceMan());
		wlist.add(new Musician());
		System.out.println("#Worker의 다형성 처리");
		for(Worker w:wlist) {
			w.working();
		}
	}
}
abstract class Vehicle{
	String kind = "탈것";
	Vehicle(String kind){
		this.kind =kind;
	}
	void driving() {
		System.out.println(kind+"을 속도 50km/h로 운행한다");
	}
	abstract void speedUp();
	// 추상메서드가 되면 하위에서 해당 메서드는 반드시 
	// 재정의(overriding)을 하여야 한다. 
	// 상위 보다 하위에서 생성하여 재정으 ㅣ된 것이 중요할 떄는 
	// 추상 메서드로 선언한다. 
}
// 상속관계에서 생성자 구조는 위와같이 Default생성자가 선언되어 있을 때 
class Car extends Vehicle{
	Car(){ // 하위에서도 default로 생성된다. 
		super("자동차"); // 1. 상위에 있는 생성자대로 호출하여야 한다. 
	}
	void driving() {
		//메서드 오버라이딩: 상위에 재정의된 내용을 구현 
	//	kind = "자동차";
		super.driving();
		// super을 통해서 상위에 정의된 멤버(구성요소)를 호출 
		System.out.println("사람 4명을 태우고 속도를 "+"100km/h로 높여 운행한다. ");
	}

	@Override
	void speedUp() {
		// TODO Auto-generated method stub
		
	}
}
class Truck extends Vehicle{
	Truck(){ // 하위에서도 default로 생성된다. 
		super("트럭"); // 1. 상위에 있는 생성자대로 호출하여야 한다. 
	}
	void driving() {
		//메서드 오버라이딩: 상위에 재정의된 내용을 구현 
		kind = "트럭";
		super.driving();
		// super을 통해서 상위에 정의된 멤버(구성요소)를 호출 
		System.out.println("짐 2.5ton을 싣고, 속도를 "+"60km/h로 높여 운행한다. ");
	}
	@Override
	void speedUp() {
		// TODO Auto-generated method stub
		
	}
}

class Worker{
	String kind;
	Worker(String kind){
		this.kind = kind;
	}
	void working() {
		System.out.println(kind+"가 일을 열심히 합니다!!");
	}
}
class PoliceMan extends Worker{
	PoliceMan() {
		super("경찰");
		// TODO Auto-generated constructor stub
	}

	void working() {
		//String kind="경찰";
		System.out.println(kind+"이 치안을 유지합니다.");
	}
}
class WebProgrammer extends Worker{
	WebProgrammer() {
		super("개발자");
		// TODO Auto-generated constructor stub
	}

	void working() {
		//String kind="웹프로그래머";
		System.out.println(kind+"가 개발합니다.");
	}
}
class Musician extends Worker{
	Musician() {
		super("음악가");
		// TODO Auto-generated constructor stub
	}

	void working() {
	//	String kind="음악가";
		System.out.println(kind+"가 음악을 작곡합니다.");
	}
}