package javaexp;

import javaexp.z01_vo.Person;
import javaexp.z01_vo.Product;

public class A13_Clone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 객체의 메모리 할당과 복사처리 
 1. 객체는 참조변수로 할당하면 동일한 메모리를 사용하게 된다. 
 
 */
		int []intArr1 = {1,2,3,4,5};
		System.out.println("# intArr1의 데이터 #");
		for(int num:intArr1) {
			System.out.print(num+",");
		}
		// 참조변수를 다른 변수에 할당하면 해당 heap영역의 객체는 
		// 동일한 객체를 사용하게 된다. 
		int []intArr2 = intArr1;
		// clone() 메서드를 통한 객체 생성 
		int [] intArr3 = intArr1.clone();
		
		System.out.println("# intArr2의 데이터 #");
		for(int num:intArr2) {
			System.out.print(num+",");
		}
		System.out.println("# intArr2의 변경 후, intArr1의 데이터 #");
		intArr2[0] = 50; // intArr1에 영향을 미쳐서 데이터가 변경됨 
		for(int num:intArr1) {
			System.out.print(num+",");
		}
		System.out.println("# clone()이 처리되는 객체 intArr3 #");
		// intArr3은 intArr2의 변경에 영향을 받지 않는 
		// 새로운 메모리로 할당하여 사용이 가능하다. 
		for(int num:intArr3) {
			System.out.print(num+",");
		}
		// ex) javaexp.z01_vo 하위에 Person 클래스를 
		// 선언하고, 이름/나이/사는 곳을 설정하여, 
		// p01 객체를 만들었을 때, p02 참조변수만 할당한 것과 
		// .clone()으로 p03 객체를 만들 것의 차이점을 
		// p01 속성값을 변경함으로 확인하세요 
		Person p1 = new Person("홍길동",25,"서울 신림동");
		Person p2 = p1; 
		
		try {
			Person p3 = p1.clone();
			p2.setName("마길동");
			System.out.println("p1의 주소:"+p1+":"+p1.getName());
			System.out.println("p2의 주소:"+p2+":"+p2.getName());
			System.out.println("p3의 주소:"+p3+":"+p3.getName());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Product prod1 = new Product("사과",3000,2);
		Product prod2 = prod1;
		Product prod3 = prod1.clone();
		prod1.setName("오렌지");
		System.out.println("prod1.getName():"+prod1.getName());
		System.out.println("prod2.getName():"+prod2.getName());
		System.out.println("prod3.getName():"+prod3.getName());
	}

}
