package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Product;

public class A01_DI_Start2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_start/container2.xml");

// ex) Product.java 물건명 가격 갯수 
//		container2.xml에 선언하고 해당 객체를 호출하여 출력하세요 
		Product p01 = ctx.getBean("p01", Product.class);
		System.out.println(p01.getName());
		System.out.println(p01.getPrice());
		System.out.println(p01.getCnt());
	}
}
